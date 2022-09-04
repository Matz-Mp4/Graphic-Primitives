package Primitives2D.Polygon2D;

import java.awt.Graphics;

import DataStruct.LinkedList.DoublyLinkedList;
import Primitives2D.Line2D.LineGr;
import Primitives2D.Point2D.PointGr;
import Primitives2D.Point2D.Point;

public class Polygon {
  private DoublyLinkedList data;

  // Lines attributes
  private PointGr sp, ep; // starting point and ending point
  private PointGr aux;
  private PointGr lp; // last point

  public Polygon(int x, int y) {
    setSP(new PointGr(x, y));
    setEP(new PointGr(x, y));
  }

  public Polygon() {
  }

  public void draw(Graphics g) {
    if (g != null) {
      LineGr lineGr = new LineGr(aux, ep);
      lineGr.draw(g);
      lastPoint();
      // data.push(lineGr);
    }
  }

  public void drawLastPoint(int x, int y, Graphics g) {
    if (g != null) {
      LineGr line = new LineGr(sp, new PointGr(x, y));
      line.draw(g);
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
