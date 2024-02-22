package algorithm.test.baekjoon.level19.exam04;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

  static int[] rlt = new int[2];
  static int cnt = 1;
  static int[] temp; // temp 배열을 스태틱변수에 둬야 시간초과가 뜨지않음... 원인불명

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    StringTokenizer st = new StringTokenizer(scanner.nextLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[] arr = new int[n];
    st = new StringTokenizer(scanner.nextLine(), " ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    temp = new int[arr.length];
    rlt[0] = k;
    merge_sort(arr, 0, n - 1);
    if (k >= cnt) {
      rlt[1] = -1;
    }
    System.out.println(rlt[1]);
    scanner.close();
  }

  static int[] merge_sort(int[] arr, int p, int r) {
    if (p < r) {
      int q = Math.floorDiv((p + r), 2);
      merge_sort(arr, p, q);
      merge_sort(arr, q + 1, r);
      merge(arr, p, q, r);
    }
    return arr;
  }

  static int[] merge(int[] arr, int p, int q, int r) {
    int i = p;
    int j = q + 1;
    int t = 0;
    while (i <= q && j <= r) {
      if (arr[i] <= arr[j]) {
        temp[t++] = arr[i++];
      } else {
        temp[t++] = arr[j++];
      }
    }
    while (i <= q) {
      temp[t++] = arr[i++];
    }
    while (j <= r) {
      temp[t++] = arr[j++];
    }
    i = p;
    t = 0;
    while (i <= r) {
      arr[i] = temp[t];
      if (cnt == rlt[0]) {
        rlt[1] = arr[i];
      }
      i++;
      t++;
      cnt++;
    }
    return arr;
  }
}
/*merge_sort(A[p..r]) { # A[p..r]을 오름차순 정렬한다.
    if (p < r) then {
        q <- ⌊(p + r) / 2⌋;       # q는 p, r의 중간 지점
        merge_sort(A, p, q);      # 전반부 정렬
        merge_sort(A, q + 1, r);  # 후반부 정렬
        merge(A, p, q, r);        # 병합
    }
}

# A[p..q]와 A[q+1..r]을 병합하여 A[p..r]을 오름차순 정렬된 상태로 만든다.
# A[p..q]와 A[q+1..r]은 이미 오름차순으로 정렬되어 있다.
merge(A[], p, q, r) {
    i <- p; j <- q + 1; t <- 1;
    while (i ≤ q and j ≤ r) {
        if (A[i] ≤ A[j])
        then tmp[t++] <- A[i++]; # tmp[t] <- A[i]; t++; i++;
        else tmp[t++] <- A[j++]; # tmp[t] <- A[j]; t++; j++;
    }
    while (i ≤ q)  # 왼쪽 배열 부분이 남은 경우
        tmp[t++] <- A[i++];
    while (j ≤ r)  # 오른쪽 배열 부분이 남은 경우
        tmp[t++] <- A[j++];
    i <- p; t <- 1;
    while (i ≤ r)  # 결과를 A[p..r]에 저장
        A[i++] <- tmp[t++]; 
}
 * 
 */