import java.util.*;

public class LCS2 {
    private static int lcs2(int[] a, int[] b) {
        //Write your code here
        return Math.min(a.length, b.length);
    }
    private static int[][] computeDistance(int[] a, int[] b) {
    	int countMatch = 0;
    	int[][] d = new int[a.length+1][b.length+1];
    	for (int i=0; i<=a.length; i++) {
    		d[i][0] = i;
    	}
    	for (int j=0; j<=b.length; j++) {
    		d[0][j] = j;
    	}
    	for (int j=1; j<=b.length; j++) {
    		for (int i=1; i<=a.length; i++) {
    			int insertion = d[i][j-1] + 1;
    			int deletion = d[i-1][j] + 1;
    			
    			int distance = Math.min(insertion, deletion);
    			if (a[i-1]==b[j-1]) {
    				int match = d[i-1][j-1];
    				distance = Math.min(distance, match);
    			}
    			/*else {
    				int mismatch = d[i-1][j-1] + 1;
    				distance = Math.min(distance, mismatch);
    			}*/
    			d[i][j] = distance;
    		}
    	}
    	return d;
    }
    private static int lcs(int[][] d, int i, int j, int countMatch) {
    	if (i==0 && j==0) {
    		return countMatch;
    	}
    	if (i>0 && d[i][j]==d[i-1][j] + 1) {
    		countMatch = lcs(d, i-1, j, countMatch);
    	}
    	else if (j>0 && d[i][j]==d[i][j-1] + 1) {
    		countMatch = lcs(d, i, j-1, countMatch);
    	}
    	else {
			countMatch += 1;
			countMatch = lcs(d, i-1, j-1, countMatch);
    	}
    	return countMatch;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        int[][] d = computeDistance(a, b);
       /* for(int i=0; i<=a.length; i++) {
        	System.out.println(Arrays.toString(d[i]));
        }*/
        int countMatch = lcs(d, a.length, b.length, 0);
        System.out.println(countMatch);
    }
}
