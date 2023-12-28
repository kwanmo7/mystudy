package bitcamp.util;

public class Stack<E> extends LinkedList<E> {

  public boolean empty() {
    if (size == 0) {
      return true;
    }
    return false;
  }

  public E peek() {
    return get(size() - 1);
  }

  public E pop() {
    return remove(size() - 1);
  }

  public E push(E value) {
    add(value);
    return value;
  }
}
