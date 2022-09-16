package Primitives2D.Circle2D;

import Primitives2D.Point2D.Point;

public class Circle {
  private double radius;
  private double x, y;

  /**
   * Class that deals with circle with mathematics parameters
   */
  public Circle(double x, double y) {
    this.x = x;
    this.y = y;
    // Default radius
    this.radius = 10;
  }

  public Circle(double x, double y, double radius) {
    this.x = x;
    this.y = y;
    this.radius = radius;
  }

  public Circle(Circle circle) {
    this.x = circle.x;
    this.y = circle.y;
    this.radius = circle.radius;
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

  public boolean belongs(Point p){
    boolean veri = false;
    // (x - x1)² + (y - y2)² = R²

    double dx = (getX() - p.getX()) * (getX() - p.getX());
    double dy = (getY() - p.getY()) * (getY() - p.getY());

    double res = Math.round(dx + dy - (getRadius() * getRadius()));

    if(res == 0.0){
      veri = true;
    }
    return veri;
  }

}
