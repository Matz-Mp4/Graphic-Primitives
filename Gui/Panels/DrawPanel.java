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

import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

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

  public DrawPanel(MenuPanel menuP) {
    this.menuP = menuP;
    initialize();
    setEvent();
  }

  private void initialize() {
    setBackground(GuiUtils.getBackground());
    setForeground(GuiUtils.getForeground());
    addMouseListener(this);
  }

  private void resetVariables() {
    needPoint = true;
    firstTime = true;
  }

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

    menuP.getSelectTrans().addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent itemEvent) {
        /* setTransformations(); */
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
          firstTime = false;
        }
        polygonalLineGr.setPointB(x, y);
        polygonalLineGr.drawByClick(g);
        break;
      case "Polygon":
        if (firstTime == true) {
          polygonGr = new Polygon();
          list.add(polygonGr, option);
          polygonGr.setSP(new PointGr(x, y));
          firstTime = false;
        }
        polygonGr.setEP(new PointGr(x, y));
        polygonGr.drawByClick(g);
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
