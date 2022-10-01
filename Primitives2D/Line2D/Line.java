package Primitives2D.Line2D;

import Primitives2D.Point2D.Point;

/**
 * Math line
 *
 * @author Julio
 * @version 12/08/2020
 */
public class Line {

  // Line attributes
  private Point p1, p2;
  private int thickness = 2;

  public int getThickness() {
    return thickness;
  }

  public void setThickness(int thickness) {
    this.thickness = thickness;
  }

  private boolean isVertical(){
    double res = p1.getX() - p2.getX();
    boolean veri = false;
    
    if(res == 0){
      veri = true;
    }

    return veri;
  }

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
/**
   * Verify wether a point belongs to this figure 
   * @param Point p
  */
  public boolean belongs(Point p){
    boolean veri = false;
    // y = a * x + b => a *x + b - y = 0
    
    if(isVertical() == false){
      double b = calculateB();
      double a = calculateInclination();

      double res = Math.round(a * p.getX() + b - p.getY());

      if(res == 0.0){
        veri = true;
      }
    }else{
      // x = k, where k is a constant
      //So p1.x = p2.x

      if(p.getX() == getP1().getX()){
        veri = true;
      }

      if(p.getY() == getP1().getY()){
        veri = true;
      }
    }

    return veri;
  }


  /**
   * rotate the line from reference point  
   * @param double k, Point p, 
   */
public void rotationLine(Point p, double angle){

    double radian = angle * (Math.PI / 180);
    double cos = Math.cos(radian);
    double sin = Math.cos(radian);

    /*
    Original formula
    x’= xcos(angle) -ysen(angue)
    y’= xsen(angle)+ ycos(angle)

    x’= Rcos (+)=Rcos .cos -R sen .sen y’= Rsen (+)=Rsen .cos -R sen .cos 
    
 --------------------------------
    As the original formula refers to a point, we need to add the original point that we are
    changing. Also, we multiply the disX because in the original formula there is the 'R' which is the radius
    */
    double disX = (p.getX() - getP1().getX()); //Raio da circuferencia
    double disY = (p.getY() - getP1().getY());
    setP1(new Point(disX * cos - disY * sin + getP1().getX(), disX * sin + disY * cos + getP1().getY()));

    disX = (p.getX() - getP2().getX());
    disY = (p.getY() - getP2().getY());
 
    setP2(new Point(disX * cos - disY * sin + getP2().getX(), disX * sin + disY * cos + getP2().getY()));
  }


  /**
   * move the line to a point  
   * @param Point p
   */
 
  public void translationLine(Point p){
    
    int dx =(int)( p.getX() - getP1().getX());
    int dy = (int)( p.getY() - getP1().getY());

    setP1(new Point(getP1().getX() + dx, getP1().getY() + dy));
    setP2(new Point(getP2().getX() + dx, getP2().getY() + dy));

    
  }

  /**
   * change the size of the line  
   * @param double k, Point p, 
   */
  public void scaleLine(double k, Point p) {
    setP1(new Point(getP1().getX() * k + p.getX()*(1 - k), getP1().getY() * k + p.getY()*(1 - k)));
    setP2(new Point(getP2().getX() * k + p.getX()*(1 - k), getP2().getY() * k+ p.getY()*(1 - k)));
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
