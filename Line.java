
/**
 * REta matematica.
 *
 * @author Julio
 * @version 12/08/2020
 */
public class Line {

  // Atributos da reta
  private Dot p1, p2;

  /**
   * Constructor for objects of class Reta
   */
  public Line(int x1, int y1, int x2, int y2) {
    setP1(new Dot(x1, y1));
    setP2(new Dot(x2, y2));
  }

  public Line(double x1, double y1, double x2, double y2) {
    setP1(new Dot(x1, y1));
    setP2(new Dot(x2, y2));
  }

  public Line(Dot p1, Dot p2) {
    setP1(p1);
    setP2(p2);
  }

  public Line(Line r) {
    setP1(r.getP1());
    setP2(r.getP2());
  }

  public void setP1(Dot p) {
    this.p1 = p;
  }

  public void setP2(Dot p) {
    this.p2 = p;
  }

  public Dot getP1() {
    return this.p1;
  }

  public Dot getP2() {
    return this.p2;
  }

  // Inclinação da reta
  public double calculateInclination() {
    // m = (y2-y1)/(x2-x1)
    double m = (getP2().getY() - getP1().getY()) / (getP2().getX() - getP1().getX());
    return m;
  }

  public double calculateB() {
    // b = y1 - mx1
    double b = getP1().getY() - calculateInclination() * getP1().getX();
    return b;
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
