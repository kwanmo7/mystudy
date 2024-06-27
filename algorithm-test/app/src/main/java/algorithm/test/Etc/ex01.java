package algorithm.test.Etc;

import java.util.HashMap;
import java.util.Map;

public class ex01 {
  public static void main(String[] args) {
    // 테스트 케이스 1
    String[] a1 = {"A 1", "B 2", "C 5", "D 3"};
    String[][] b1 = {{"B", "C", "B", "C"}, {"A", "A", "A", "B"}, {"D", "D", "C", "D"}};
    int roll1 = 10;
    int money1 = 100;

    // 테스트 케이스 2
    String[] a2 = {"A 2", "B 1"};
    String[][] b2 = {{"A", "A", "A"}, {"A", "B", "B"}, {"A", "B", "B"}, {"A", "B", "B"}};
    int roll2 = 1;
    int money2 = 9;

    // 테스트 케이스 3
    String[] a3 = {"A 2", "B 1"};
    String[][] b3 = {{"A", "A", "A"}, {"A", "B", "B"}, {"A", "B", "B"}, {"A", "B", "B"}};
    int roll3 = 5;
    int money3 = 19;

    // 각 테스트 케이스 실행 및 결과 출력
    System.out.println("테스트 케이스 1 결과: " + getMaxItemCount(a1, b1, roll1, money1)); // 예상 결과: 4
    System.out.println("테스트 케이스 2 결과: " + getMaxItemCount(a2, b2, roll2, money2)); // 예상 결과: 2
    System.out.println("테스트 케이스 3 결과: " + getMaxItemCount(a3, b3, roll3, money3)); // 예상 결과: 2
  }

  private static int getMaxItemCount(String[] a, String[][] b, int roll, int money) {
    Map<String, Integer> priceMap = new HashMap<>();
    for (String element : a) {
      String[] parts = element.split(" ");
      String name = parts[0];
      int price = Integer.parseInt(parts[1]);
      priceMap.put(name, price);
    }

    int n = b.length;
    int[][] dp = new int[n + 1][money + 1];

    for (int i = 0; i < n; i++) {
      for (int m = 0; m <= money; m++) {
        if (i == 0) {
          dp[i][m] = calculateMaxSetsInShop(priceMap, b[i], m);
        } else {
          dp[i][m] = dp[i - 1][m];
          if (m >= roll) {
            dp[i][m] =
                Math.max(dp[i][m], dp[i - 1][m - roll] + calculateMaxSetsInShop(priceMap, b[i], m));
          }
        }
      }
    }

    int maxItemCount = 0;
    for (int m = 0; m <= money; m++) {
      maxItemCount = Math.max(maxItemCount, dp[n - 1][m]);
    }

    return maxItemCount;
  }

  private static int calculateMaxSetsInShop(Map<String, Integer> priceMap, String[] shopItems,
      int money) {
    Map<String, Integer> itemCounts = new HashMap<>();
    for (String item : shopItems) {
      itemCounts.put(item, itemCounts.getOrDefault(item, 0) + 1);
    }

    int maxSets = 0;
    for (Map.Entry<String, Integer> entry : itemCounts.entrySet()) {
      String item = entry.getKey();
      int count = entry.getValue();
      int price = priceMap.get(item);
      int possibleSets = count / 3;
      while (possibleSets > 0 && money >= possibleSets * price * 3) {
        money -= possibleSets * price * 3;
        maxSets += possibleSets;
        possibleSets--;
      }
    }

    return maxSets;
  }
}
