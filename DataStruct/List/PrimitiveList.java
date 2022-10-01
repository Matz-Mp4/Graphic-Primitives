package DataStruct.List;

import DataStruct.LinkedList.DoublyLinkedList;
import DataStruct.LinkedList.Node;
import Primitives2D.PrimitiveGr2D;
import Primitives2D.Circle2D.CircleGr;
import Primitives2D.Line2D.LineGr;
import Primitives2D.Point2D.Point;
import Primitives2D.Polygon2D.Polygon;
import Primitives2D.Polygon2D.PolygonalLineGr;
import Primitives2D.Rectangle2D.RectangleGr;
import java.awt.Graphics;

/**
 * Class that holds the data throught the application
 * For each primitive type, there is an linked list. 
 * The linked list is reached through an array of types
 * @version 1.0.3
 */
public class PrimitiveList {
  private final int MAX = 5;
  private DoublyLinkedList[] array;
  private String types[] = { "Circle", "Line", "Polygonal Line", "Rectangle", "Polygon" };

  public PrimitiveList() {

    initialize();
  }

  /**
   * Draw every primitive in the list
   * @param g
   */
  public void drawEverything(Graphics g) {
    for (int i = 0; i < MAX; i++) {
      drawLinkedList(array[i], array[i].getType(), g);
    }
  }

  /**
   * Delete all the data in the list
   */
  public void deleteAll(){
    for (int i = 0; i < MAX; i++) {
      array[i] = new DoublyLinkedList();
      array[i].SetType(types[i]);
    }
  }

  /**
   * Delete a primitive graphic from the list and from the screen
   * @param item
   * @param g
   */
  public void delete(Node item, Graphics g) {
    boolean find = false;
    int i = 0;
    DoublyLinkedList aux = null;

    if (item != null) {
      while (i < MAX && find == false) {
        if (array[i].getType().equals(item.getType())) {
          find = true;
          aux = array[i];
        }
        i++;
      }
      if (find == true) {
        PrimitiveGr2D PrimitiveGr2D = (PrimitiveGr2D) item.getItem();
        PrimitiveGr2D.erase(g);
        aux.remove(item.getId());
      }
    }
  }

  /**
   * Draw every primitive from the list
   * @param list
   * @param type
   * @param g
   */
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
        case "Polygon":
          Polygon itemPolygon = (Polygon) item;
          itemPolygon.draw(g);
          break;
        case "Rectangle":
          RectangleGr itemRectangle = (RectangleGr) item;
          itemRectangle.draw(g);
          break;
      }
      aux = aux.getNext();

    }

  }

  /**
   * Returns the primitives of the list in String form
   * @return String[]
   */
  public String[] getTypes(){
    return types;
  }

  /**
   * Return the array of linked list
   * @return DoublyLinkedList[]
   */
  public DoublyLinkedList[] getLinkedList(){
    return array;
  }

  /**
   * Start the primitive list 
   */
  private void initialize() {
    array = new DoublyLinkedList[MAX];
    for (int i = 0; i < MAX; i++) {
      array[i] = new DoublyLinkedList();
      array[i].SetType(types[i]);
    }
  }

  /**
   * Adds a primitive in the list
   * @param item
   * @param type
   */
  public void add(Object item, String type) {
    int i = 0;
    while (i < MAX && type.equals(array[i].getType()) == false) {
      i++;
    }
    array[i].add(item, type);
  }

  /**
   * Find the primitive given a point
   * @param p
   * @return
   */
  public Node select(Point p) {

    double i = -2, j = -2;
    Node item = null;
    double x = p.getX(), y = p.getY();
    while (i <= 2 && item == null) {
      p.setX(x + i);
      while (j <= 2 && item == null) {
        p.setY(y + j);

        item = findObject(p);
        j++;
      }
      j = -2;
      i++;
    }

    return item;
  }

  /**
   * Find the primitive through an array around the point
   * @param P
   * @return
   */
  public Node findObject(Point P) {

    int i = 0;
    boolean find = false;
    Node whatWeWant = null;

    while ((i < MAX) && find == false) {
      Node aux = array[i].getBegin();
      while ((aux != null) && (!find)) {
        switch (array[i].getType()) {
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
        if (find) {
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
