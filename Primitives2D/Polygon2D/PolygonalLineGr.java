package Primitives2D.Polygon2D;

import java.awt.Graphics;

import DataStruct.LinkedList.DoublyLinkedList;
import DataStruct.LinkedList.Node;
import Primitives2D.Line2D.LineGr;
import Primitives2D.Point2D.Point;
import Primitives2D.Point2D.PointGr;

public class PolygonalLineGr {

  private DoublyLinkedList data;
  private LineGr lineGr;
  private PointGr A;
  private PointGr B;

  public PolygonalLineGr(){
    initialize();
   }

  private void initialize(){
    data = new DoublyLinkedList();
  }

  public void draw(Graphics g) {
    if (g != null) {
      lineGr = new LineGr(A, B);
      lineGr.draw(g);
      lastPoint();
      data.add(lineGr);
    }
  }

  public void drawEverything(Graphics g){
    Node aux = data.getBegin();
    while(aux != null){
      LineGr line = (LineGr) aux.getItem();
      line.draw(g);
      aux = aux.getNext();
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

  public boolean belongs(Point p){
    boolean veri = false;
    Node aux = data.getBegin();
    while(aux != null && veri == false){
      LineGr line = (LineGr) aux.getItem();
      veri = line.belongs(p);
      aux = aux.getNext();
    }

    return veri;
  }

}
