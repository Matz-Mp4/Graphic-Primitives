package Primitives2D.Circle2D;

import java.awt.Color;
import java.awt.Graphics;

import Primitives2D.Point2D.PointGr;

/**
 * Class that deals with the graphic design of a circle. Inherit from circle
 */
public class SuperCircleGr extends Circle {

  private Color circleColor = Color.BLACK; // Default color
  private String circleName = "Generic Name";
  private Color circleNameColor = Color.BLACK;

  /**
   * Constructs a circle at position x, y and with attributes
   * 
   * @param x      coordenate x
   * @param y      coordenate y
   * @param radius radius of circle
   */
  public SuperCircleGr(int x, int y, int radius) {
    super((double) x, (double) y, (double) radius);

  }

  /**
   * Constructs a circle at position x, y and with attributes
   * 
   * @param x           coordenate x
   * @param y           coordenate y
   * @param circleColor circleColor from the circle to be built
   * @param radius      radius of circle
   */
  public SuperCircleGr(int x, int y, int radius, Color circleColor) {
    super((double) x, (double) y, (double) radius);
    this.circleColor = circleColor;
  }

  /**
   * Constructs a circle at position x, y and with attributes
   * 
   * @param x      coordenate x
   * @param y      coordenate y
   * @param name   name from the circle to be built
   * @param radius radius of circle
   */
  public SuperCircleGr(int x, int y, int radius, String name) {
    super((double) x, (double) y, (double) radius);
    this.circleName = name;
  }

  public SuperCircleGr(int x, int y, int radius, Color circleColor, String name) {
    super((double) x, (double) y, (double) radius);
    this.circleColor = circleColor;
    this.circleName = name;
  }

  public SuperCircleGr(SuperCircleGr circle) {

    super(circle);
  }

  /**
   * Take the radius of the circle and convert it to radian
   * 
   * @param radius
   * @return
   */
  public double convertToRadian(double radius) {
    return radius * (Math.PI / 180);
  }

  /**
   * Gets the circle's color
   * 
   * @return
   */
  public Color getCircleColor() {
    return circleColor;
  }

  /**
   * Sets the circle's color
   * 
   * @param circleColor
   */
  public void setCircleColor(Color circleColor) {
    this.circleColor = circleColor;
  }

  /**
   * Gets the circle's name
   * 
   * @return
   */
  public String getCircleName() {
    return circleName;
  }

  /**
   * Sets the circle's name
   * 
   * @param circleName
   */
  public void setCircleName(String circleName) {
    this.circleName = circleName;
  }

  /**
   * Gets the circle color
   * 
   * @return
   */
  public Color getCircleNameColor() {
    return circleNameColor;
  }

  /**
   * Sets the color of the border of circle
   * 
   * @param circleNameColor
   */
  public void setCircleNameColor(Color circleNameColor) {
    this.circleNameColor = circleNameColor;
  }

  public void plotPoint(double angule, PointGr point, Graphics g, Color color) {
    double radian = convertToRadian(angule);
    double cos = Math.cos(radian);
    double sin = Math.sin(radian);
    double cordX = 0, cordY = 0;

    for (int i = 1; i <= 4; i++) {
      switch (i) {
        // 1 quadrant
        case 1:
          cordX = getX() + (cos * getRadius());
          cordY = getY() + (sin * getRadius());
          break;

        // 2 quadrant
        case 2:
          cordX = getX() - (cos * getRadius());
          cordY = getY() + (sin * getRadius());
          break;

        // 3 quadrant
        case 3:
          cordX = getX() - (cos * getRadius());
          cordY = getY() - (sin * getRadius());
          break;

        // 4 quadrant
        case 4:
          cordX = getX() + (cos * getRadius());
          cordY = getY() - (sin * getRadius());
          break;
      }

      // cordX = Math.round(cordX);
      // cordY = Math.round(cordY);
      point.setX(cordX);
      point.setY(cordY);
      point.setPointColor(color);
      point.drawPoint(g);
    }
  }

  public void setRadiusByDistance(PointGr p1, PointGr p2) {
    double dY = p2.getY() - p1.getY();
    double dX = p2.getX() - p1.getX();
    double d = Math.sqrt(Math.pow(dY, 2) + Math.pow(dX, 2));
    System.out.println("Radius = " + d);

    setRadius(d);
  }

}
