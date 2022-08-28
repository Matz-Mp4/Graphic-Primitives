package Gui.Panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import Gui.GuiUtils;
import Primitives2D.Circle2D.CircleGr;
import Primitives2D.Line2D.Line;
import Primitives2D.Line2D.LineGr;
import Primitives2D.Point2D.Point;
import Primitives2D.Point2D.PointGr;
import Primitives2D.Polygon2D.PolygonalLineGr;
import Primitives2D.Rectangle2D.RectangleGr;

/**
 * Class that handles the drawings panel and is where they are made
 * Temporarily adjust events and use state machine to set circle and line
 * buttons
 */
public class DrawPanel extends JPanel implements MouseListener, MouseMotionListener {

  private Point pTemp, pTemp2;
  private CircleGr circleGr;
  private Line line;
  private LineGr lineGr;
  private PolygonalLineGr polygonalLineGr;
  private RectangleGr rectangleGr;
  private boolean needPoint = false;
  private boolean firstTime = true;
  private int xTemp;
  private int yTemp;
  private JComboBox<String> selector;

  private void initialize() {
    setBackground(GuiUtils.getBackground());
    setForeground(GuiUtils.getForeground());
    addMouseListener(this);
    addMouseMotionListener(this);
    circleGr = new CircleGr(0, 0, 70);
    lineGr = new LineGr(0, 0, 0, 0);
    polygonalLineGr = new PolygonalLineGr();
  }

  public DrawPanel() {
    initialize();

  }

  public JComboBox<String> getSelector() {
    return selector;
  }

  public void setSelector(JComboBox<String> selector) {
    this.selector = selector;
  }

  @Override
  /**
   * Paint lines and circles when the window opens
   */
  public void paintComponent(Graphics g) {

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
    doubleClick(e.getClickCount());
  }

  private void draw(int x, int y, Graphics g) {
    String option = selector.getSelectedItem() + "";
    switch (option) {
      case "Circle":
        if (changeLineState()) {
          circleGr.setRadiusByDistance(new PointGr(xTemp, yTemp), new PointGr(x, y));
          needPoint = true;
          circleGr.setX(xTemp);
          circleGr.setY(yTemp);
          circleGr.draw(g);
        } else {
          xTemp = x;
          yTemp = y;
        }
        break;
      case "Line":
        if (changeLineState()) {
          xTemp = x;
          yTemp = y;
          needPoint = true;
          lineGr.setP1(new PointGr(xTemp, yTemp));
        }
        lineGr.setP2(new PointGr(x, y));
        lineGr.draw(g);
        break;
      case "Polygonal Line":
        if (firstTime == true) {
          polygonalLineGr.setPointA(x, y);
          firstTime = false;
        }
        polygonalLineGr.setPointB(x, y);
        polygonalLineGr.draw(g);
        break;
      case "Rectangle":
        if(changeLineState()) {
          pTemp = new Point(x, y);
          needPoint = true;
        }
        pTemp2 = new Point(x, y);
        rectangleGr = new RectangleGr(pTemp, pTemp2);
        rectangleGr.draw(g);
        break;
      case "None":
        break;
      default:
        break;
    }
  }

  private void doubleClick(int amountClicks){
    if(amountClicks == 2){ 
      String option = selector.getSelectedItem().toString();
      switch(option){
        case "Polygonal Line":
        firstTime = true;
        break;

        case "Polygonal":
        break;
      }
    }
  }

  /**
   * Change the state of line button. It's necessary because to draw a line it
   * requires that the user press the mouse 2 times
   * 
   * @return boolean
   */
  private boolean changeLineState() {
    needPoint = !needPoint;
    return needPoint;
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
