package bitcamp.util;

public class Stack<E> extends LinkedList<E> {

  public E push(E value) {
    add(value);
    return value;
  }

  public E peek() {
    return get(size() - 1);
  }

  public E pop() {
    return remove(this.size() - 1);
  }

  public boolean empty() {
    return this.size() == 0;
  }
}
