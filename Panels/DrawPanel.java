package Panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import Primitives2D.Circle2D.CircleGr;
import Primitives2D.Line2D.LineGr;
import Primitives2D.Point2D.PointGr;

/**
 * Class that handles the drawings panel and is where they are made
 * Temporarily adjust events and use state machine to set circle and line
 * buttons
 */
public class DrawPanel extends JPanel implements MouseListener, MouseMotionListener {

  private final static Color BACKGROUND = Color.white;
  private final static Color FOREGROUND = Color.black;
  private CircleGr circleGr;
  private LineGr lineGr;
  private boolean needPoint;
  private int xLine;
  private int yLine;
  private JComboBox selector;


  private void initialize() {
    setBackground(BACKGROUND);
    setForeground(FOREGROUND);
    addMouseListener(this);
    addMouseMotionListener(this);
    circleGr = new CircleGr(0, 0, 70);
    lineGr = new LineGr(0, 0, 0, 0);
  }

  public DrawPanel() {
    initialize();
  }

  public JComboBox getSelector() {
    return selector;
  }

  public void setSelector(JComboBox selector) {
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
    // TODO Auto-generated method stub

  }

  @Override
  public void mouseMoved(MouseEvent e) {
    // TODO Auto-generated method stub

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

  }

  private void draw(int x, int y, Graphics g) {
    String option = selector.getSelectedItem() + "";
    switch (option) {
      case "Circle":
        circleGr.setX(x);
        circleGr.setY(y);
        circleGr.draw(g);
        break;
      case "Line":
        if (changeLineState()) {
          xLine = x;
          yLine = y;
          needPoint = true;
          lineGr.setP1(new PointGr(xLine, yLine));
        }
        lineGr.setP2(new PointGr(x, y));
        lineGr.draw(g);
        break;
      case "None":
        break;
      default:
        break;
    }
  }

  /**
   * Change the state of line button. It's necessary because to draw a line it
   * requires that the user press the mouse 2 times
   * 
   * @return boolean
   */
  public boolean changeLineState() {
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

