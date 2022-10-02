package Primitives2D.Circle2D;

import java.awt.Graphics;
import java.awt.Color;

import Gui.GuiUtils;
import Primitives2D.PrimitiveGr2D;
import Primitives2D.Point2D.*;

public class CircleGr extends SuperCircleGr implements PrimitiveGr2D {

  /**
   * Class that handles the Circle Graphical
   */
  public CircleGr(SuperCircleGr circle) {
    super(circle);
  }

  public CircleGr(int x, int y, int radius){
    super(x, y, radius);
  }

  public CircleGr(int x, int y, int radius, String name) {
    super(x, y, radius, name);
  }

  /**
   * draw a circle 
   * @param Graphics g
   */
  public void draw(Graphics g) {
    double angule, rowEnd;

    PointGr point = new PointGr();
    point.setDiameter(getThickness());
    // A constant to find the amount needs to loop
    double inc = 0.18 / (getRadius() / 300);

    for (angule = 0; angule <= 90; angule += inc) {
      plotPoint(angule, point, g, getCircleColor());
    }
  }

  /**
   * erase a circle 
   * @param Graphics g
   */
  public void erase(Graphics g) {
    Color circleColor = getCircleColor();
    setCircleColor(GuiUtils.getBackground());
    draw(g);
    setCircleColor(circleColor);
  }

  /**
   * change the thickness of  circle 
   * @param int value
   */
  public void changeThickness(int value) {
    setThickness(value);
  }


  /**
   * change the color of  circle 
   * @param Color color
   */
 
  public void changeColor(Color newColor) {
    setCircleColor(newColor);
  }

  /**
   * move the circle to a point  
   * @param Point p
   */
 
  public void translation(Point p) {

    setX(p.getX());
    setY(p.getY());
  }

  /**
   * change the size of the circle  
   * @param double k, Point p, 
   */
  public void scale(double k, Point p) {
    setX(getX() * k + p.getX() * (1 - k));
    setY(getY() * k + p.getY() * (1 - k));
    setRadius(getRadius() * k);

  }


  /**
   * rotate the circle from reference point  
   * @param double k, Point p, 
   */
  public void rotation(Point p, double angule) {

    double radian = angule * (Math.PI / 180);
    double cos = Math.cos(radian);
    double sin = Math.sin(radian);

    setX((getX() - p.getX()) * cos - (getY() - p.getY()) * sin  + getX());
    setY((getX() - p.getX())  * sin + (getY() - p.getY()) * cos + getY());
  }
}
