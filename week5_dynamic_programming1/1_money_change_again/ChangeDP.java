import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int money) {
        //write your code here
       int[] coins = {1,3,4};
		int numCoins = 0; 
		int[] minNumCoins = new int[money+1]; 
		for (int m=1; m<=money; m++) {
			for (int c:coins) {
				if (m >= c) {
					numCoins = calcMinNumCoins(m, c, minNumCoins);
					if ((numCoins < minNumCoins[m]) || (minNumCoins[m]==0)){
						minNumCoins[m] = numCoins;
					}
				}
			}
		}
		//System.out.println(Arrays.toString(minNumCoins));
		return minNumCoins[money];
	}
	private static int calcMinNumCoins(int money, int coin, int[] minNumCoins) {
		return (minNumCoins[money-coin] + 1);
	}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int money = scanner.nextInt();
        System.out.println(getChange(money));

    }
}

