package Primitives2D.Polygon2D;

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
  }

  public void draw(Graphics g) {
    if (g != null) {
      lineGr = new LineGr(A, B);
      lineGr.setThickness(getThickness());
      lineGr.draw(g);
      lastPoint();
      data.add(lineGr, "Polygonal Line");
    }
  }

  public void drawEverything(Graphics g) {
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
