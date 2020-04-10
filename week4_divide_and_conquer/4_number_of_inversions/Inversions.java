import java.util.*;

public class Inversions {
	private static long numInv = 0;
    private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        long numberOfInversions = 0;
        if (right <= left + 1) {
            return numberOfInversions;
        }
        
        int ave = (left + right) / 2;
        numberOfInversions += getNumberOfInversions(a, b, left, ave);
        numberOfInversions += getNumberOfInversions(a, b, ave, right);
        //write your code here
        return numberOfInversions;
    }
    public static int[] mergeSort(int[] a, int left, int right) {
    	int n = right-left;
    	if (n < 1) {
    		int[] retvalue = {a[right]};
    		return retvalue;
    	}
    	int m = left + (n/2);
    	int[] b = mergeSort(a, left, m);
    	int[] c = mergeSort(a, m+1, right);
    	int[] merged = merge(b, c);
    	return merged;
    }
    public static int[] merge(int[] b, int[] c) {
    	int[] d = new int[b.length + c.length];
    	int i = 0;
    	int j = 0;
    	while ((i<b.length) && (j<c.length)) {
    		int b_first = b[i];
    		int c_first = c[j];
    		if (b_first<=c_first) {
    			d[i+j] = b[i];
    			i += 1;
    		}
    		else {
    			d[i+j] = c[j];
    			j += 1;
    			numInv += (b.length - i);
    			}
    	}
    	while (i<b.length) {
    		d[i+j] = b[i];
    		i += 1;
    	}
    	while (j<c.length) {
    		d[i+j] = c[j];
    		j += 1;
    	}
    	return d;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        b = mergeSort(a, 0, n-1);
        //System.out.println(Arrays.toString(b));
        System.out.println(numInv);
    }
}