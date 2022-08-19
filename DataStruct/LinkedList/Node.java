package DataStruct.LinkedList;

public class Node {

  private Object item;
  private Node next;
  private Node prev;
  private long id;

  public Node(Object item) {
    initialize(item);
    setId(0);
  }

   public Node(Object item, long id) {
    initialize(item);
    setId(id);
  }

  private void initialize(Object item) {
    setItem(item);
    setNext(null);
    setPrev(null);

  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Object getItem() {
    return item;
  }

  public void setItem(Object item) {
    this.item = item;
  }

  public Node getNext() {
    return next;
  }

  public void setNext(Node next) {
    this.next = next;
  }

  public Node getPrev() {
    return prev;
  }

  public void setPrev(Node prev) {
    this.prev = prev;
  }
}
