public class Node {

  private Object item;
  private Node next;
  private Node prev;

  public Node(Object item) {
    inicializar(item);
  }

  private void inicializar(Object item) {
    setItem(item);
    setnext(null);
    setPrev(null);
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
