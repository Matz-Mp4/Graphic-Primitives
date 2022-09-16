package Primitives2D.Line2D;

import Primitives2D.Point2D.Point;

/**
 * REta matematica.
 *
 * @author Julio
 * @version 12/08/2020
 */
public class Line {

  // Atributos da reta
  private Point p1, p2;

  /**
   * Constructor for objects of class Reta
   */
  public Line(int x1, int y1, int x2, int y2) {
    setP1(new Point(x1, y1));
    setP2(new Point(x2, y2));
  }

  public Line(double x1, double y1, double x2, double y2) {
    setP1(new Point(x1, y1));
    setP2(new Point(x2, y2));
  }

  public Line(Point p1, Point p2) {
    setP1(p1);
    setP2(p2);
  }

  public Line(Line r) {
    setP1(r.getP1());
    setP2(r.getP2());
  }

  public void setP1(Point p) {
    this.p1 = p;
  }

  public void setP2(Point p) {
    this.p2 = p;
  }

  public Point getP1() {
    return this.p1;
  }

  public Point getP2() {
    return this.p2;
    
  }

  // Line inclination
  public double calculateInclination() {
    // m = (y2-y1)/(x2-x1)
    double m = (getP2().getY() - getP1().getY()) / (getP2().getX() - getP1().getX());
    double b = 23.2332;
    return m;
  }

  public double calculateB() {
    // b = y1 - mx1
    double b = getP1().getY() - calculateInclination() * getP1().getX();
    return b;
  }

  public boolean belongs(Point p){
    boolean veri = false;
    // y = a * x + b => a *x + b - y = 0
    
    double b = calculateB();
    double a = calculateInclination();

    double res = Math.round(a * p.getX() + b - p.getY());

    if(res == 0.0){
      veri = true;
    }


    return veri;
  }

  //
  /**
   * Method toString
   *
   * @return The return value
   */
  public String toString() {
    String s = "P1: " + getP1().toString() + " P2: " + getP2().toString();
    s = s + "\nEq. da reta: y = " + calculateInclination() + "*x + " +
        calculateB();
    return s;
  }
  

}
