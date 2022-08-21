package DataStruct.LinkedList;

import java.util.Random;

public class DoublyLinkedList {
  private int length;
  private Node begin, end;
  private Random randomId = new Random(System.currentTimeMillis());

  public DoublyLinkedList() {
    setBegin(null);
    setEnd(null);
    setLength(0);
  }

  public void add(Object item) {
    Node temp = new Node(item, randomId.nextLong());
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

  public void removeBegin() {
    Node begin = getBegin(), next;
    if (getLength() != 0) {

      setLength(getLength() - 1);
      setBegin(begin.getNext());
      if (begin.getNext() == null) {
        end = null;
      } else {
        next = begin.getNext();
        next.setPre(null);
      }
      begin = null;
    }
  }

  public void removeEnd() {
    Node end = getEnd(), pre;
    if (getLength() != 0) {

      setLength(getLength() - 1);
      setEnd(end.getPre());
      // Se tem apenas um elemento
      if (end.getNext() == null) {
        end = null;
      } else {
        pre = end.getPre();
        pre.setNext(null);
      }
      end = null;
    }
  }

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

}
