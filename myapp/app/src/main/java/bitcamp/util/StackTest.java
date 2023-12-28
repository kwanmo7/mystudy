package bitcamp.util;

public class StackTest {

  public static void main(String[] args) {

    Stack<String> stack = new Stack<>();

    System.out.println(stack.empty());

    stack.push(new String("aaa"));
    stack.push(new String("bbb"));
    stack.push(new String("ccc"));
    System.out.println(stack.empty());
    System.out.println(stack.peek());
    stack.pop();
    System.out.println(stack.peek());
    stack.pop();
    System.out.println(stack.peek());
    stack.pop();
    System.out.println(stack.empty());
  }
}
