package algorithm.test.baekjoon.level19.exam04;

public class Main {
  public static void main(String[] args) {

  }

  static int[] merge(int[] arr, int p, int q, int r) {
    int i = p;
    int j = q + 1;
    int t = 0;
    int[] temp = new int[arr.length];
    while (i <= q && j <= r) {
      if (arr[i] <= arr[j]) {
        temp[t] = arr[i];
        t++;
        i++;
      } else {
        temp[t] = arr[j];
        t++;
        j++;
      }
    }
    while (i <= q) {
      temp[t] = arr[i];
      t++;
      i++;
    }
    while (j <= r) {
      temp[t] = arr[j];
      t++;
      j++;
    }
    i = p;
    t = 0;
    while (i <= r) {
      arr[i] = temp[t];
      i++;
      t++;
    }
    return arr;
  }
}
