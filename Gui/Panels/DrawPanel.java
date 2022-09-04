package Gui.Panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.*;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import DataStruct.List.PrimitiveList;
import Gui.GuiUtils;
import Primitives2D.Circle2D.CircleGr;
import Primitives2D.Line2D.Line;
import Primitives2D.Line2D.LineGr;
import Primitives2D.Point2D.Point;
import Primitives2D.Point2D.PointGr;
import Primitives2D.Polygon2D.PolygonalLineGr;
import Primitives2D.Polygon2D.Polygon;
import Primitives2D.Rectangle2D.RectangleGr;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class that handles the drawings panel and is where they are made
 * Temporarily adjust events and use state machine to set circle and line
 * buttons
 */
public class DrawPanel extends JPanel implements MouseListener, MouseMotionListener {

  private Point pTemp, pTemp2;
  private CircleGr circleGr;
  private LineGr lineGr;
  private PolygonalLineGr polygonalLineGr;
  private Polygon polygonGr;
  private RectangleGr rectangleGr;
  private boolean needPoint = true;
  private boolean firstTime = true;
  private int xTemp;
  private int yTemp;
  private JComboBox<String> selector;
  private PrimitiveList list;
  private MenuPanel menuP;

  public DrawPanel(MenuPanel menuP) {
    initialize();
    this.menuP = menuP;
    setEvent();
  }

  private void initialize() {
    setBackground(GuiUtils.getBackground());
    setForeground(GuiUtils.getForeground());
    addMouseListener(this);
    addMouseMotionListener(this);
  }

  public void setEvent() {
    menuP.getjbtnRedraw().addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        list.drawEverything(getGraphics());
      }
    });
  }

  @Override
  public void mouseDragged(MouseEvent e) {

  }

  @Override
  public void mouseMoved(MouseEvent e) {

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
          circleGr.setX(xTemp);
          circleGr.setY(yTemp);
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
        polygonalLineGr.draw(g);
        break;
      case "Polygon":
        if (firstTime == true) {
          polygonGr = new Polygon();
          list.add(polygonGr, option);
          polygonGr.setSP(new PointGr(x, y));
          firstTime = false;
        }
        polygonGr.setEP(new PointGr(x, y));
        polygonGr.draw(g);
        break;
      case "Rectangle":
        if (!changePointState()) {
          pTemp = new Point(x, y);
          // needPoint = true;
        }
        pTemp2 = new Point(x, y);
        rectangleGr = new RectangleGr(pTemp, pTemp2);
        list.add(rectangleGr, option);
        rectangleGr.draw(g);
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
    // TODO Auto-generated method stub

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
