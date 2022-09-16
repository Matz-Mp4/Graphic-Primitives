package DataStruct.List;

import DataStruct.LinkedList.DoublyLinkedList;
import DataStruct.LinkedList.Node;
import Primitives2D.Circle2D.CircleGr;
import Primitives2D.Line2D.LineGr;
import Primitives2D.Point2D.Point;
import Primitives2D.Polygon2D.Polygon;
import Primitives2D.Polygon2D.PolygonalLineGr;
import Primitives2D.Rectangle2D.RectangleGr;
import java.awt.Graphics;

public class PrimitiveList {
  private final int MAX = 5;
  private DoublyLinkedList[] array;

  public PrimitiveList() {

    initialize();
  }

  public void drawEverything(Graphics g) {
    for (int i = 0; i < MAX; i++) {
      drawLinkedList(array[i], array[i].getType(), g);
    }
  }

  private void drawLinkedList(DoublyLinkedList list, String type, Graphics g) {
    Node aux = list.getBegin();
    Object item;

    while (aux != null) {
      item = aux.getItem();
      switch (type) {
        case "Circle":
          CircleGr itemCircle = (CircleGr) item;
          itemCircle.draw(g);
          break;
        case "Line":
          LineGr itemLine = (LineGr) item;
          itemLine.draw(g);
          break;
        case "Polygonal Line":
          PolygonalLineGr itemPolygonalLine = (PolygonalLineGr) item;
          itemPolygonalLine.drawEverything(g);
          break;
        case "Polygon":
         Polygon itemPolygon = (Polygon) item;
         itemPolygon.drawEverything(g);
         break;
        case "Rectangle":
          RectangleGr itemRectangle = (RectangleGr) item;
          itemRectangle.draw(g);
          break;
      }
      aux = aux.getNext();

    }

  }

  private void initialize() {
    String types[] = { "Circle", "Line", "Polygonal Line", "Rectangle", "Polygon" };
    array = new DoublyLinkedList[MAX];
    for (int i = 0; i < MAX; i++) {
      array[i] = new DoublyLinkedList();
      array[i].SetType(types[i]);
    }
  }

  public void add(Object item, String type) {
    int i = 0;
    while (i < MAX && type.equals(array[i].getType()) == false) {
      i++;
    }
    array[i].add(item);
  }

  public Object select(Point p){

    double i = -10, j = -10;
    Object object = null;
    while(i <= 10 && object == null){
      while(j <= 10 && object == null){
        p.setX(p.getX() + i);
        p.setY(p.getY() + j);

        object = findObject(p);
        j++;
      }
      i++;
    }
    
    return object;
  }

  public Object findObject(Point P){
    Object object = null;

    for(DoublyLinkedList typeList : array){
        Node aux = typeList.getBegin();
        boolean find = false;
        while((aux != null) && (!find)){
            switch(typeList.getType()){
                case "Circle":
                CircleGr itemCircle = (CircleGr) aux.getItem();
                find = itemCircle.belongs(P);
                object = itemCircle;
                break;
                case "Line":
                LineGr itemLine = (LineGr) aux.getItem();
                find = itemLine.belongs(P);
                object = itemLine;
                break;
                case "Rectangle":
                RectangleGr itemRect = (RectangleGr) aux.getItem();
                itemRect.belongs(P);
                object = itemRect;
                break;
            }
            aux = aux.getNext();
        }
        if(find){
            System.out.println("Achou" + P.getX() + P.getY());
        }else{
            object = null;
        }
    }

    return object;
}

}
