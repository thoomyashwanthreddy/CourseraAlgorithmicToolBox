import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        //write you code here
    	// This is just the knapsack problem with all the values being equal
        /*int result = 0;
        for (int i = 0; i < w.length; i++) {
          if (result + w[i] <= W) {
            result += w[i];
          }
        }*/
        int[][] optimal = new int[w.length+1][W+1];
        for(int i=0; i<=w.length; i++) {
        	optimal[i][0] = 0;
        }
        for(int j=0; j<=W; j++) {
        	optimal[0][j] = 0;
        }
        for(int i=1; i<=w.length; i++) {
        	for(int j=1; j<=W; j++) {
        		optimal[i][j] = optimal[i-1][j];
        		if (w[i-1] <= j) {
        			int val = optimal[i-1][j-w[i-1]] + w[i-1];
        			if (optimal[i][j] < val){
        				optimal[i][j] = val;
        			}
        		}
        	}
        	//System.out.println(Arrays.toString(optimal[i]));
        }
        
        return optimal[w.length][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}
