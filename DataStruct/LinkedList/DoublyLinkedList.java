package DataStruct.LinkedList;

import java.util.Random;

/**
 * Class that holds the data throught the application
 * @version 1.0.1
 */
public class DoublyLinkedList {
  private int length;
  private Node begin, end;
  private Random randomId = new Random(System.currentTimeMillis());
  private String type;
  
  public DoublyLinkedList() {
    setBegin(null);
    setEnd(null);
    setLength(0);
  }

  /**
   * Adds a item (primitive 2D) with a string relating it type
   * @param item
   * @param type
   */
  public void add(Object item, String type) {
    Node temp = new Node(item, randomId.nextLong());
    temp.setType(type);
    Node pre = getEnd();
    temp.setNext(null);
    temp.setPre(getEnd());

    if (getLength() == 0) {
      setBegin(temp);
    } else {
      pre.setNext(temp);
    }
    setEnd(temp);
    setLength(getLength() + 1);
  }

  public void empty() {
    Node temp, aux;
    if (getLength() != 0) {
      temp = getBegin();
      aux = temp.getNext();

      do {
        temp = null;
        temp = aux;
      } while (temp != null);
      setLength(0);
    }
  }

  public Boolean isEmpty() {
    Boolean empty = false;
    if (getLength() == 0) {
      empty = true;
    }

    return empty;
  }

  @Override
  public String toString() {
    Node apont;
    String s = "\nList = {";
    int i;
    if (getLength() == 0) {
      s += "List is Empty!";

    } else {
      apont = getBegin();
      i = 1;
      do {
        s += String.valueOf(apont.getItem()) + " => ID: " + apont.getId() + "\n";
        apont = apont.getNext();
      } while (apont != null);
    }
    s += " }";

    return s;
  }

  /**
   * Find a Node given and id
   * @param id
   * @return
   */
  public Node find(long id) {
    Node ap = null;

    if (getLength() > 0) {
      ap = getBegin();
      while ((ap.getId() != id) && (ap.getNext() != null)) {
        ap = ap.getNext();
      }
    }

    if (ap.getId() != id) {
      ap = null;
    }

    return ap;
  }

  /**
   * Removes from the list the first Node
   */
  public void removeBegin() {
    Node begin = getBegin(), next;
    if (getLength() != 0) {
      setLength(getLength() - 1);
      if (begin.getNext() == null) {
        setEnd(null);
      } else {
        next = begin.getNext();
        next.setPre(null);
      }
      setBegin(begin.getNext());
      begin = null;
    }
  }

  /**
   * Removes from the list the last Node
   */
  public void removeEnd() {
    Node end = getEnd(), pre;
    if (getLength() != 0) {
      setLength(getLength() - 1);
      
      // Se tem apenas um elemento
      if (end.getPre() == null) {
        setBegin(null);
      } else {
        pre = end.getPre();
        pre.setNext(null);
      }
      setEnd(end.getPre());
      end = null;
    }
  }

  /**
   * Remove from the list given an id
   * @param id
   */
  public void remove(long id) {
    Node ap, pre, next;

    if (getLength() > 0) {
      ap = find(id);

      if (ap == getBegin()) {
        removeBegin();
      } else if (ap == getEnd()) {
        removeEnd();
      } else {
        setLength(getLength() - 1);
        pre = ap.getPre();
        next = ap.getNext();

        pre.setNext(next);
        next.setPre(pre);
        ap = null;

      }

    }
  }

  public int getLength() {
    return length;
  }


  public void setLength(int length) {
    this.length = length;
  }

  public Node getBegin() {
    return begin;
  }

  public void setBegin(Node begin) {
    this.begin = begin;
  }

  public Node getEnd() {
    return end;
  }

  public void setEnd(Node end) {
    this.end = end;
  }

  public String getType(){
    return type;
  }

  public void SetType(String type){
    this.type = type;
  }

}
