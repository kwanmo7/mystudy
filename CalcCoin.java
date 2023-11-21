import java.util.*;

public class Hello
{
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    int total = scan.nextInt();
    int iCoinCnt = 0;
    int coinlist[] = { 500, 100, 50 , 10 };
    for( int coin : coinlist )
    {
      iCoinCnt += (total/coin);
      total %= coin;
    }
    System.out.println("result = " + iCoinCnt );
  }
}