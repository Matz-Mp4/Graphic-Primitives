package Gui.Panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.*;
import java.util.Scanner;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JOptionPane;

import DataStruct.JsonData.JsonFile;
import DataStruct.LinkedList.Node;
import DataStruct.List.PrimitiveList;
import Gui.GuiUtils;
import Primitives2D.Circle2D.CircleGr;
import Primitives2D.Line2D.LineGr;
import Primitives2D.Point2D.Point;
import Primitives2D.Point2D.PointGr;
import Primitives2D.Polygon2D.PolygonalLineGr;
import Primitives2D.Polygon2D.Polygon;
import Primitives2D.Rectangle2D.RectangleGr;
import Primitives2D.PrimitiveGr2D;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class that handles the drawings panel and is where they are made
 * Temporarily adjust events and use state machine to set circle and line
 * buttons
 */
public class DrawPanel extends JPanel implements MouseListener {

  private Point pTemp, pTemp2;
  private CircleGr circleGr;
  private LineGr lineGr;
  private PolygonalLineGr polygonalLineGr;
  private Polygon polygonGr;
  private RectangleGr rectangleGr;
  private boolean needPoint = true;
  private boolean firstTime = true;
  private int xTemp;
  private int xMouse;
  private int yMouse;
  private int yTemp;
  private JComboBox<String> selector;
  private PrimitiveList list;
  private MenuPanel menuP;
  private Node nodeSelected;
  private Color newColor;
  private JsonFile json;

  public DrawPanel(MenuPanel menuP, PrimitiveList list) {
    this.menuP = menuP;
    this.list = list;
    initialize();
    setEvent();
  }

  private void initialize() {
    setBackground(GuiUtils.getBackground());
    setForeground(GuiUtils.getForeground());
    addMouseListener(this);
    json = new JsonFile(list);
  }

  private void resetVariables() {
    needPoint = true;
    firstTime = true;
  }

  /**
   * Method that handles the transformations events
   * 
   * @param xMouse
   * @param yMouse
   */
  private void setTransformations(int xMouse, int yMouse) {
    String optionTrans = menuP.getSelectTrans().getSelectedItem().toString();
    if (menuP.getSelector().getSelectedItem().equals("Select") && nodeSelected != null) {
      PrimitiveGr2D itemGr = (PrimitiveGr2D) nodeSelected.getItem();
      itemGr.erase(getGraphics());
      Point p = new Point((double) xMouse, (double) yMouse);
      switch (optionTrans) {

        case "Translation":
          itemGr.translation(p);
          break;

        case "Rotation":
          itemGr.rotation(p, 10.0);
          break;

        case "Scale ++":

          itemGr.scale(1.1, p);
          break;

        case "Scale --":

          itemGr.scale(0.9, p);
          break;

        case "Reflection":
        break;

      }

      itemGr.draw(getGraphics());
    }
  }

  public void setEvent() {
    menuP.getSelector().addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent itemEvent) {
        resetVariables();
      }
    });

    menuP.getjbtnRedraw().addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        list.drawEverything(getGraphics());
      }
    });

    menuP.getjbtnDelete().addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        if (menuP.getSelector().getSelectedItem().equals("Select")) {
          list.delete(nodeSelected, getGraphics());
          // list.drawEverything(getGraphics());
        }
      }
    });

    menuP.getjbtnColor().addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        if (menuP.getSelector().getSelectedItem().equals("Select") && nodeSelected != null) {
          newColor = JColorChooser.showDialog(null, "Choose a color", Color.black);

          PrimitiveGr2D itemGr = (PrimitiveGr2D) nodeSelected.getItem();
          itemGr.changeColor(newColor);
          itemGr.draw(getGraphics());
        }
      }
    });

    menuP.getJsliderThickness().addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        if (menuP.getSelector().getSelectedItem().equals("Select") && nodeSelected != null) {
          int thickness = menuP.getJsliderThickness().getValue();
          PrimitiveGr2D itemGr = (PrimitiveGr2D) nodeSelected.getItem();
          if (menuP.getJsliderThickness().getValueIsAdjusting() == true) {
            itemGr.erase(getGraphics());
            itemGr.changeThickness(thickness);
            itemGr.draw(getGraphics());
          }
        }
      }
    });

    menuP.getjbtnSave().addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        boolean veri = false;
        String fileName = "";

        try {
          fileName = JOptionPane.showInputDialog("File name :");
          if (fileName != null) {
            veri = true;
          }
        } catch (Exception ae) {
          veri = false;
        }
        if (veri == true) {
          json = new JsonFile(list);
          json.createJSON(fileName);
        }
      }
    });

    menuP.getjbtnLoad().addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (json != null) {

          JFileChooser winFile = new JFileChooser("Save/.path.txt");

          FileNameExtensionFilter filter = new FileNameExtensionFilter("Only  json file", "json"); // txtFiltro = new
          winFile.setAcceptAllFileFilterUsed(false);
          winFile.addChoosableFileFilter(filter);

          int answerFileChooser = winFile.showOpenDialog(null);

          if (answerFileChooser == JFileChooser.APPROVE_OPTION) {

            File fileSelected = winFile.getSelectedFile();
            json.getJson(fileSelected, list);
            list.drawEverything(getGraphics());

          } else {
            JOptionPane.showMessageDialog(null, "No file selected");
          }

        }
      }
    });

  }

  /**
   * If the circle button was pressed, draw a circle of radius 70
   * if the line button was pressed, it draws a semi-line given the two points
   * clicked
   */
  @Override
  public void mouseClicked(MouseEvent e) {
    int x = e.getX();
    int y = e.getY();
    Graphics g = getGraphics();

    draw(x, y, g);
    if (e.getClickCount() >= 2) {
      doubleClick(e.getClickCount(), x, y);
    }

  }

  /**
   * Change the state of line button. It's necessary because to draw a line it
   * requires that the user press the mouse 2 times
   * 
   * @return boolean
   */
  private boolean changePointState() {
    needPoint = !needPoint;
    return needPoint;
  }

  private void draw(int x, int y, Graphics g) {
    String option = menuP.getSelector().getSelectedItem() + "";

    switch (option) {
      case "Circle":
        if (changePointState()) {
          circleGr.setRadiusByDistance(new PointGr(xTemp, yTemp), new PointGr(x, y));
          needPoint = true;

          circleGr.draw(g);
        } else {
          xTemp = x;
          yTemp = y;
          // 1 is just to iniatilize radius
          circleGr = new CircleGr(xTemp, yTemp, 1);
          list.add(circleGr, option);
        }
        break;
      case "Line":
        if (!changePointState()) {
          lineGr = new LineGr(1, 1, 1, 1);
          xTemp = x;
          yTemp = y;
          // needPoint = true;
          lineGr.setP1(new PointGr(xTemp, yTemp));
          list.add(lineGr, option);
        }
        lineGr.setP2(new PointGr(x, y));
        lineGr.draw(g);

        break;
      case "Polygonal Line":
        if (firstTime == true) {
          polygonalLineGr = new PolygonalLineGr();
          list.add(polygonalLineGr, option);
          polygonalLineGr.setPointA(x, y);
        }
        polygonalLineGr.setPointB(x, y);
        if (firstTime == false) {
          polygonalLineGr.drawByClick(g);
        }
        firstTime = false;
        break;
      case "Polygon":
        if (firstTime == true) {
          polygonGr = new Polygon();
          list.add(polygonGr, option);
          polygonGr.setSP(new PointGr(x, y));
        }
        polygonGr.setEP(new PointGr(x, y));
        if (firstTime == false) {
          polygonGr.drawByClick(g);
        }
        firstTime = false;
        break;
      case "Rectangle":
        if (!changePointState()) {
          pTemp = new Point(x, y);
          // needPoint = true;
        } else {
          pTemp2 = new Point(x, y);
          rectangleGr = new RectangleGr(pTemp, pTemp2);
          list.add(rectangleGr, option);
          rectangleGr.draw(g);
        }
        break;
      case "Select":
        if (menuP.getSelectTrans().getSelectedItem().equals("None") == true) {
          nodeSelected = list.select(new Point(x, y));
        } else {
          setTransformations(x, y);
        }
        break;
      case "None":
        break;
      default:
        break;
    }
  }

  /**
   * Method that closes a polygon or change the state of application to start a
   * new polygonal line
   * 
   * @param amountClicks
   * @param x
   * @param y
   */
  private void doubleClick(int amountClicks, int x, int y) {
    if (amountClicks == 2) {
      String option = menuP.getSelector().getSelectedItem().toString();
      switch (option) {
        case "Polygonal Line":
          firstTime = true;
          break;

        case "Polygon":
          firstTime = true;
          polygonGr.drawLastPoint(x, y, getGraphics());
          break;
      }
    }
  }

  public void setList(PrimitiveList list) {
    this.list = list;
  }

  @Override
  public void mousePressed(MouseEvent e) {
  }

  @Override
  public void mouseReleased(MouseEvent e) {

  }

  @Override
  public void mouseEntered(MouseEvent e) {
    // TODO Auto-generated method stub
  }

  @Override
  public void mouseExited(MouseEvent e) {
    // TODO Auto-generated method stub

  }

}
