package Primitives2D.Polygon2D;

import java.awt.Graphics;

import DataStruct.LinkedList.DoublyLinkedList;
import Primitives2D.Line2D.LineGr;
import Primitives2D.Point2D.PointGr;

public class PolygonalLineGr {

  private DoublyLinkedList data;
  private LineGr lineGr;
  private PointGr A;
  private PointGr B;

  public PolygonalLineGr(){
   }

  public void draw(Graphics g) {
    if (g != null) {
      lineGr = new LineGr(A, B);
      lineGr.draw(g);
      lastPoint();
      // data.push(lineGr);
    }
  }

  public void erase(Graphics g) {

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

}
