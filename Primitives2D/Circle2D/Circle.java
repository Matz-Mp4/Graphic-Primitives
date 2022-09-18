package Primitives2D.Circle2D;

import Primitives2D.Point2D.Point;

public class Circle {
  private double radius;
  private double x, y;
  private int thickness = 2;

  public int getThickness() {
    return thickness;
  }

  public void setThickness(int thickness) {
    this.thickness = thickness;
  }

  /**
   * Class that deals with circle with mathematics parameters
   */
  public Circle(double x, double y) {
    this.x = x;
    this.y = y;
    // Default radius
    this.radius = 10;
    this.thickness = 2;
  }

  public Circle(double x, double y, double radius) {
    this.x = x;
    this.y = y;
    this.radius = radius;
    this.thickness = 2;
  }

  public Circle(Circle circle) {
    this.x = circle.x;
    this.y = circle.y;
    this.radius = circle.radius;
    this.thickness = circle.thickness;
  }

  public double getRadius() {
    return radius;
  }

  public void setRadius(double radius) {
    this.radius = radius;
  }

  public double getX() {
    return x;
  }

  public void setX(double x) {
    this.x = x;
  }

  public double getY() {
    return y;
  }

  public void setY(double y) {
    this.y = y;
  }

  public boolean belongs(Point p) {
    boolean veri = false;

    double dx = (p.getX() - getX());
    double dy = (p.getY() - getY());

    double d = Math.sqrt(Math.pow(dy, 2) + Math.pow(dx, 2));

    if (Math.round(d) == Math.round(getRadius())) {
      veri = true;
    }
    return veri;
  }

}
