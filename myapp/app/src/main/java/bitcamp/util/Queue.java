package bitcamp.util;

public class Queue<E> extends LinkedList<E> {

  public E offer(E value) {
    add(value);
    return value;
  }

  public E poll() {
    if (size == 0) {
      return null;
    }
    return remove(0);
  }

  public E peek() {
    if (size == 0) {
      return null;
    }
    return get(0);
  }
}
