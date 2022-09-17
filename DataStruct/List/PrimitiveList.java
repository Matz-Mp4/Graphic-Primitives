package DataStruct.List;

import DataStruct.LinkedList.DoublyLinkedList;
import DataStruct.LinkedList.Node;
import Primitives2D.Drawable;
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

  public void delete(Node item, Graphics g){
    boolean find = false;
    int i = 0;
    DoublyLinkedList aux = null;
    while(i < MAX && find == false){
      if(array[i].getType().equals(item.getType())){
        find = true;
        aux = array[i];
      }
      i++;
    }
    if(find){
      Drawable drawable = (Drawable) item.getItem();
      drawable.erase(g);
      aux.remove(item.getId());
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
    array[i].add(item, type);
  }

  public Node select(Point p){

    double i = -2, j = -2;
    Node item = null;
    double x = p.getX() , y = p.getY();
    while(i <= 2 && item == null){
       p.setX(x + i);
      while(j <= 2 && item== null){
        p.setY(y + j);

        item = findObject(p);
        j++;
      }
      j = -2;
      i++;
    }
    
    return item;
  }

  public Node findObject(Point P){
   
    int i = 0;
    boolean find = false;
    Node whatWeWant = null;

    while((i < MAX) && find == false){
        Node aux = array[i].getBegin();
        while((aux != null) && (!find)){
            switch(array[i].getType()){
                case "Circle":
                CircleGr itemCircle = (CircleGr) aux.getItem();
                find = itemCircle.belongs(P);
                break;
                case "Line":
                LineGr itemLine = (LineGr) aux.getItem();
                find = itemLine.belongs(P);
                break;
                case "Rectangle":
                RectangleGr itemRect = (RectangleGr) aux.getItem();
                find = itemRect.belongs(P);
                break;
                case "Polygonal Line":
                PolygonalLineGr itemPolygonalLineGr = (PolygonalLineGr) aux.getItem();
                find = itemPolygonalLineGr.belongs(P);
                break;
                case "Polygon":
                Polygon itemPolygon = (Polygon) aux.getItem();
                find = itemPolygon.belongs(P);
                break;
            }
            if(find){
              whatWeWant = aux;
              System.out.println("Achou");
            }
            aux = aux.getNext();
        }
        i++;
    }

    return whatWeWant;
}

}
