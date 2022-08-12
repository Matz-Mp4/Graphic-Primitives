package containers;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Circle2D.CircleGr;
import Line2D.LineGr;
import Point2D.Point;

/**
 * Class that handles the drawings panel and is where they are made
 * Temporarily adjust events and use state machine to set circle and line
 * buttons
 */
public class DrawPanel extends JPanel implements MouseListener, MouseMotionListener {

  private final static Color BACKGROUND = Color.white;
  private final static Color FOREGROUND = Color.black;
  private final CircleGr circleGr = new CircleGr(0,0,70);
  private final LineGr lineGr = new LineGr(0,0,0,0);
  private boolean needPoint;
  private int xLine;
  private int yLine;
  private Type type = new Type();

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
    switch(type.getTypeButton()){
      case CIRCLE: 
        circleGr.setX(x); circleGr.setY(y); 
        circleGr.drawCircle(g);
        break;
      case LINE:
        if(changeLineState()){
          xLine = x;
          yLine = y;
          needPoint = true;
          lineGr.setP1(new Point(xLine, yLine));
        }
        lineGr.setP2(new Point(x, y));
        lineGr.drawLine(g);
        break;
      case FREE:
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

  public Type getTypeButton(){
    return type;
  }
}

class Type{
  private TypeButton type = TypeButton.LINE;

  public TypeButton getTypeButton(){
    return type;
  }

  public void setType(TypeButton value){
    type = value;
  }
}

enum TypeButton {
  LINE,
  CIRCLE,
  FREE
}