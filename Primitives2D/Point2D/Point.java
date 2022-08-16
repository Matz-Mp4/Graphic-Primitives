package Primitives2D.Point2D;
/**
 * Representacao de ponto matematico
 * 
 * @author julio
 *
 */


public class Point {
  private double x;
  private double y;

  /**
   * 
   */
  public Point() {
    setX(0);
    setY(0);
  }

  public Point(Point p) {
    setX(p.getX());
    setY(p.getY());
  }

  /**
   * @param x
   * @param y
   */
  public Point(double x, double y) {
    setX(x);
    setY(y);
  }

  /**
   * @return the x
   */
  public double getX() {
    return x;
  }

  /**
   * @param x the x to set
   */
  public void setX(double x) {
    this.x = x;
  }

  /**
   * @return the y
   */
  public double getY() {
    return y;
  }

  /**
   * @param y the y to set
   */
  public void setY(double y) {
    this.y = y;
  }

  public double calculateDistance(Point p) {

    double d = Math.sqrt(Math.pow(p.getY() - getY(), 2) + Math.pow(p.getX() - getX(), 2));

    return (d);

  }

  @Override
  public String toString() {
    return "Ponto [" + getX() + ", " + getY() + "]";
  }
}
