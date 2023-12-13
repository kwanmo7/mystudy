package bitcamp.util;

import java.util.Arrays;

public class ObjectRepository<E> {

  private Object[] objectRepository = new Object[3];
  private int length = 0;

  public void add(E Object) {
    if (this.length == this.objectRepository.length) {
      //System.out.println("과제를 더이상 등록할 수 없습니다.");
      int oldSize = this.objectRepository.length;
      int newSize = oldSize + (oldSize / 2);
      this.objectRepository = Arrays.copyOf(this.objectRepository, newSize);
    }
    this.objectRepository[this.length] = Object;
    this.length++;
  }

  public E remove(int index) {
    if (index < 0 || index >= this.length) {
      return null;
    }
    Object old = this.objectRepository[index];
    System.arraycopy(this.objectRepository, index + 1, this.objectRepository,
        index, this.length - (index + 1));
    this.length--;
    this.objectRepository[this.length] = null;
    return (E) old;
  }

  public Object[] toArray() {
    return Arrays.copyOf(this.objectRepository, this.length);
  }

  public E[] toArray(E[] Object) {
    if (Object.length >= this.length) {
      System.arraycopy(Object, 0, this.objectRepository, 0, this.length);
      return Object;
    }
    return (E[]) Arrays.copyOf(this.objectRepository, this.length, Object.getClass());
  }

  public E get(int index) {
    if (index < 0 || index >= this.length) {
      return null;
    }
    Object Object = this.objectRepository[index];
    return (E) Object;
  }

  public E set(int index, E Object) {
    if (index < 0 || index >= this.length) {
      return null;
    }
    Object old = this.objectRepository[index];
    this.objectRepository[index] = Object;
    return (E) old;
  }
}
