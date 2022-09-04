package DataStruct.List;

import DataStruct.LinkedList.DoublyLinkedList;
import DataStruct.LinkedList.Node;
import Primitives2D.Circle2D.CircleGr;
import Primitives2D.Line2D.LineGr;
import Primitives2D.Polygon2D.PolygonalLineGr;
import Primitives2D.Rectangle2D.RectangleGr;
import java.awt.Graphics;

public class PrimitiveList {
  final int MAX = 5;
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
          itemPolygonalLine.draw(g);
          break;
        /*
         * case "Polygon":
         * item = (Polygon) item;
         * break;
         */
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

}
