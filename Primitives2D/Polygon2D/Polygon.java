package Primitives2D.Polygon2D;

import java.awt.Graphics;

import DataStruct.LinkedList.DoublyLinkedList;
import DataStruct.LinkedList.Node;
import Gui.GuiUtils;
import Primitives2D.PrimitiveGr2D;
import Primitives2D.Line2D.LineGr;
import Primitives2D.Point2D.PointGr;
import Primitives2D.Point2D.Point;

import java.awt.Color;

  /**
   * Class that handles the polygon Graphical
   */
 
public class Polygon implements PrimitiveGr2D {
  private DoublyLinkedList data;

  // Lines attributes
  private PointGr sp, ep; // starting point and ending point
  private PointGr aux;
  private PointGr lp; // last point
  private int thickness = 1;
  private Color colorPolygon;

  public Color getColorPolygon() {
    return colorPolygon;
  }

  public void setColorPolygon(Color colorPolygon) {
    this.colorPolygon = colorPolygon;
    LineGr line;
    Node aux = data.getBegin();
    while (aux != null) {
      line = (LineGr) aux.getItem();
      line.setLineColor(colorPolygon);
      aux = aux.getNext();
    }
  }

  /**
   * change the color of  polygon 
   * @param Color color
   */
  public void changeColor(Color newColor) {
    setColorPolygon(newColor);
  }

  public int getThickness() {
    return thickness;
  }

  /**
   * move the polygon to a point  
   * @param Point p
   */
 
  public void translation(Point p) {
    Node aux = data.getBegin();
    LineGr line = (LineGr) aux.getItem();
    // reference point
    int dx = (int) (p.getX() - line.getP1().getX());
    int dy = (int) (p.getY() - line.getP1().getY());

    while (aux != null) {
      line = (LineGr) aux.getItem();
      line.setP1(new Point(line.getP1().getX() + dx, line.getP1().getY() + dy));
      line.setP2(new Point(line.getP2().getX() + dx, line.getP2().getY() + dy));
      aux = aux.getNext();
    }
  }

  /**
   * change the size of the polygon  
   * @param double k, Point p, 
   */
  public void scale(double k, Point p) {
    Node aux = data.getBegin();
    LineGr line = (LineGr) aux.getItem();

    while (aux != null) {
      line = (LineGr) aux.getItem();
      line.scaleLine(k, p);
      aux = aux.getNext();
    }

  }

  /**
   * rotate the polygon from reference point  
   * @param double k, Point p, 
   */
  public void rotation(Point p, double angule) {
    Node aux = data.getBegin();
    LineGr line = (LineGr) aux.getItem();

    while (aux != null) {
      line = (LineGr) aux.getItem();
      line.rotationLine(p, angule);
      aux = aux.getNext();
    }

  }

  public void setThickness(int thickness) {
    this.thickness = thickness;
  }

  public Polygon(int x, int y) {
    setSP(new PointGr(x, y));
    setEP(new PointGr(x, y));
  }

  public Polygon() {
    iniatilize();
  }

  /**
   * Verify wether a point belongs to this figure 
   * @param Point p
  */
  public boolean belongs(Point p) {
    boolean veri = false;
    Node aux = data.getBegin();
    while (aux != null && veri == false) {
      LineGr line = (LineGr) aux.getItem();
      line.setThickness(getThickness());
      veri = line.belongs(p);
      aux = aux.getNext();
    }

    return veri;
  }

  /**
   * Inicialize the application with default parameters
   */
  private void iniatilize() {
    data = new DoublyLinkedList();
    thickness = 2;
    colorPolygon = Color.black;
  }

  /**
   * Draw a line from the polygon
   * @param g
   */
  public void drawByClick(Graphics g) {
    if (g != null) {
      LineGr lineGr = new LineGr(aux, ep);
      lineGr.setThickness(getThickness());
      lineGr.draw(g);
      lastPoint();
      data.add(lineGr, "Polygon");
    }
  }

  /**
   * Erase the polygon from the screen
   * @param Graphics
   */
  public void erase(Graphics g) {
    Node aux = data.getBegin();

    Color polygonColor = getColorPolygon();
    while (aux != null) {
      LineGr line = (LineGr) aux.getItem();
      line.setLineColor(GuiUtils.getBackground());
      line.draw(g);
      line.setLineColor(polygonColor);
      aux = aux.getNext();
    }
  }

  /**
   * change the thickness of  polygon 
   * @param int value
   */
  public void changeThickness(int value) {
    setThickness(value);
  }

  public void drawLastPoint(int x, int y, Graphics g) {
    if (g != null) {
      LineGr line = new LineGr(sp, new PointGr(x, y));
      line.draw(g);
      line.setThickness(getThickness());
      data.add(line, "Polygon");
    }
  }


  public void draw(Graphics g) {
    Node aux = data.getBegin();
    while (aux != null) {
      LineGr line = (LineGr) aux.getItem();
      line.setThickness(getThickness());
      line.draw(g);
      aux = aux.getNext();
    }
  }

  //Auxiliar function tha changes the last point of polygon to be able to draw
  private void lastPoint() {
    aux = ep;
  }

  // setters
  public void setSP(PointGr p) {
    this.sp = p;
    this.aux = p;
  }

  public void setAux(PointGr p) {
    aux = p;
  }

  public void setEP(PointGr p) {
    this.ep = p;
  }

  public void setLP(PointGr p) {
    this.lp = p;
  }

  public DoublyLinkedList getList(){
    return data;
  }
}
