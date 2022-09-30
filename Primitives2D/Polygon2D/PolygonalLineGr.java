package Primitives2D.Polygon2D;

import java.awt.Color;
import java.awt.Graphics;

import DataStruct.LinkedList.DoublyLinkedList;
import DataStruct.LinkedList.Node;
import Gui.GuiUtils;
import Primitives2D.PrimitiveGr2D;
import Primitives2D.Line2D.LineGr;
import Primitives2D.Point2D.Point;
import Primitives2D.Point2D.PointGr;

public class PolygonalLineGr implements PrimitiveGr2D {

  private DoublyLinkedList data;
  private int thickness;
  private Color colorPolygonalLine;

  public Color getColorPolygonalLine() {
    return colorPolygonalLine;
  }

  public void setColorPolygonalLine(Color colorPolygonalLine) {
    this.colorPolygonalLine = colorPolygonalLine;
    Node aux = data.getBegin();
    while (aux != null) {
      LineGr line = (LineGr) aux.getItem();
      line.setLineColor(colorPolygonalLine);
      aux = aux.getNext();
    }
  }

  public void changeColor(Color newColor) {
    setColorPolygonalLine(newColor);
  }

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

  public void scale(double k, Point p) {
    Node aux = data.getBegin();
    LineGr line = (LineGr) aux.getItem();

    while (aux != null) {
      line = (LineGr) aux.getItem();
      line.setP1(new Point(line.getP1().getX() * k + p.getX() * (1 - k), line.getP1().getY() * k + p.getY() * (1 - k)));
      line.setP2(new Point(line.getP2().getX() * k + p.getX() * (1 - k), line.getP2().getY() * k + p.getY() * (1 - k)));

      aux = aux.getNext();
    }

  }

  public void rotation(Point p, double angule) {
    Node aux = data.getBegin();
    LineGr line = (LineGr) aux.getItem();
    double radian = angule * (Math.PI / 180);
    double cos = Math.cos(radian);
    double sin = Math.cos(radian);

    while (aux != null) {
      line = (LineGr) aux.getItem();

      line.setP1(new Point(line.getP1().getX() * cos - line.getP1().getY() * sin,
          line.getP1().getX() * sin + line.getP1().getY() * cos));

      line.setP2(new Point(line.getP2().getX() * cos - line.getP2().getY() * sin,
          line.getP2().getX() * sin + line.getP2().getY() * cos));

      aux = aux.getNext();
    }
  }

  public int getThickness() {
    return thickness;
  }

  public void setThickness(int thickness) {
    this.thickness = thickness;
  }

  private LineGr lineGr;
  private PointGr A;
  private PointGr B;

  public PolygonalLineGr() {
    initialize();
  }

  private void initialize() {
    data = new DoublyLinkedList();
    thickness = 2;
    colorPolygonalLine = Color.black;
  }

  public void drawByClick(Graphics g) {
    if (g != null) {
      lineGr = new LineGr(A, B);
      lineGr.setThickness(getThickness());
      lineGr.setLineColor(colorPolygonalLine);
      lineGr.draw(g);
      lastPoint();
      data.add(lineGr, "Polygonal Line");
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

  public void setPointA(int x, int y) {
    A = new PointGr(x, y);
  }

  public void setPointB(int x, int y) {
    B = new PointGr(x, y);
  }

  private void lastPoint() {
    A = B;
  }

  public boolean belongs(Point p) {
    boolean veri = false;
    Node aux = data.getBegin();
    while (aux != null && veri == false) {
      LineGr line = (LineGr) aux.getItem();
      veri = line.belongs(p);
      aux = aux.getNext();
    }

    return veri;
  }

}
