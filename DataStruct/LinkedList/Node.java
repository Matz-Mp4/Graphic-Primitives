package DataStruct.LinkedList;

public class Node {

  private Object item;
  private Node next;
  private Node pre;
  private long id;
  private String type;

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
    setPre(null);

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

  public Node getPre() {
    return pre;
  }

  public void setPre(Node pre) {
    this.pre = pre;
  }

  public void setType(String type){
    this.type = type;
  }

  public String getType(){
    return this.type;
  }

}
