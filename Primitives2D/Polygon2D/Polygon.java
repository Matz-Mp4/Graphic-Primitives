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

public class Polygon implements PrimitiveGr2D {
  private DoublyLinkedList data;

  // Lines attributes
  private PointGr sp, ep; // starting point and ending point
  private PointGr aux;
  private PointGr lp; // last point
  private int thickness;
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


  public void changeColor(Color newColor){
    setColorPolygon(newColor);
  }

  public int getThickness() {
    return thickness;
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

  private void iniatilize() {
    data = new DoublyLinkedList();
    thickness = 2;
    colorPolygon = Color.black;
  }

  public void drawByClick(Graphics g) {
    if (g != null) {
      LineGr lineGr = new LineGr(aux, ep);
      lineGr.setThickness(getThickness());
      lineGr.draw(g);
      lastPoint();
      data.add(lineGr, "Polygon");
    }
  }

  public void erase(Graphics g) {
    Node aux = data.getBegin();
    while (aux != null) {
      LineGr line = (LineGr) aux.getItem();
      line.setLineColor(GuiUtils.getBackground());
      line.draw(g);
      line.setLineColor(GuiUtils.getForeground());
      aux = aux.getNext();
    }
  }

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
}
