package bitcamp.util;

public class Test {

  public static void main(String[] args) {
    LinkedList<String> list = new LinkedList<>();
    list.add(new String("aaa"));
    list.add(new String("bbb"));
    list.add(new String("ccc"));
    list.add(new String("ddd"));

    System.out.println(list.remove("xxx"));
    System.out.println(list.remove("ccc"));
    System.out.println(list.remove("ddd"));
    System.out.println(list.remove("aaa"));
    System.out.println(list.remove("bbb"));
    list.add(new String("xxx"));
    list.add(new String("yyy"));
    list.add(new String("zzz"));

//    list.remove(1);
//    list.remove(1);

//    list.add(0, new String("xxxx"));
//    list.add(5, new String("yyyy"));
//    list.add(1, new String("mmmm"));
//    list.add(3, new String("ttt"));
//    list.add(7, new String("ppp"));

    String[] arr = list.toArray(new String[0]);
    for (String value : arr) {
      System.out.printf("%s ", value);
    }
    System.out.println();

  }
}
