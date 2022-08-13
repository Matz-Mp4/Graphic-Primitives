package Panels;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Primitives2D.GraphicPrimitive2D;
import Primitives2D.Circle2D.CircleGr;
import Primitives2D.Circle2D.SuperCircleGr;
import Primitives2D.Line2D.LineGr;
import Primitives2D.Line2D.SuperLineGr;




/**
 * Class that handles the drawings panel and is where they are made
 * Temporarily adjust events and use state machine to set circle and line
 * buttons
 */
public class DrawPanel extends JPanel implements MouseListener, MouseMotionListener {

  private final static Color BACKGROUND = Color.white;
  private final static Color FOREGROUND = Color.black;
  private JButton circle;
  private JButton line;
  private boolean circleOrNot = false;
  private boolean needLine = false;
  private int xLine;
  private int yLine;

  private void initialize() {
    setBackground(BACKGROUND);
    setForeground(FOREGROUND);
    addMouseListener(this);
    addMouseMotionListener(this);
  }

  public DrawPanel() {
    initialize();
  }

  @Override
  /**
   * Paint lines and circles when the window opens
   */
  public void paintComponent(Graphics g) {
    /*
     * LineGr l1 = new LineGr(0, 300, 800, 300);
     * l1.setLineColor(GuiUtils.generateRandomColor());
     * l1.drawLine(g);
     * 
     * LineGr l2 = new LineGr(800, 600, 0, 0);
     * l2.setLineColor(GuiUtils.generateRandomColor());
     * l2.drawLine(g);
     * 
     * LineGr l3 = new LineGr(400, 0, 400, 600);
     * l3.setLineColor(GuiUtils.generateRandomColor());
     * l3.drawLine(g);
     * 
     * LineGr l4 = new LineGr(800, 0, 0, 600);
     * l4.setLineColor(GuiUtils.generateRandomColor());
     * l4.drawLine(g);
     */
    // CircleGr circle1 = new CircleGr(100, 100, 80);
    // circle1.drawCircle(g);
    //
    // CircleGr circle2 = new CircleGr(300, 250, 300);
    // circle2.drawCircle(g);

    GraphicPrimitive2D circle3 = new CircleGr(200, 170, 30);
    circle3.draw(g);

    // CircleGr circle4 = new CircleGr(0, 400, 1000);
    // circle4.drawCircle(g);

    GraphicPrimitive2D circle5 = new CircleGr(0, 300, 750);
    circle5.draw(g);

  }

  /**
   * Sets the circle
   * 
   * @param button
   */
  public void setCircle(JButton button) {
    circle = button;
  }

  /**
   * Sets the line
   * 
   * @param button
   */
  public void setLine(JButton button) {
    line = button;
  }

  /**
   * Sets the events of both line and circle
   */
  public void setEvents() {

    circle.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        circleOrNot = true;
      }
    });

    line.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        circleOrNot = false;
      }
    });
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

    if (circleOrNot) {
      GraphicPrimitive2D circle1 = new CircleGr(new SuperCircleGr(x, y, 70));
      circle1.draw(g);
    } else if (!circleOrNot) {
      if (changeLineState()) {
        xLine = x;
        yLine = y;
        needLine = true;
      }
      GraphicPrimitive2D l4 = new LineGr(new SuperLineGr(xLine, yLine, x, y));
      l4.draw(g);

    }
  }

  /**
   * Change the state of line button. It's necessary because to draw a line it
   * requires that the user press the mouse 2 times
   * 
   * @return boolean
   */
  public boolean changeLineState() {
    needLine = !needLine;
    return needLine;
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
