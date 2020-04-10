import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        int[] calcOps = new int[n+1];
        for (int i=1; i<=n; i++) {
        	int minus_one = calcOps[i-1];
        	int minOps = minus_one;
        	if (i%3 == 0) {
        		int mult_three = calcOps[i/3];
        		minOps = Math.min(minOps, mult_three);
        	}
        	else if (i%2 == 0) {
        		int mult_two = calcOps[i/2];
        		minOps = Math.min(minOps, mult_two);
        	}
        	calcOps[i] = minOps + 1; 
        }
        while (n >= 1) {
            sequence.add(n);
            int min = n-1;
            if (n % 3 == 0) {
            	if (calcOps[n/3] < calcOps[min]){
            		min = n/3;
            	}
            }
            else if (n % 2 == 0) {
            	if (calcOps[n/2] < calcOps[min]){
            		min = n/2;
            	}
            }
            n = min;
        }
        Collections.reverse(sequence);
        return sequence;
    }
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
      
    }
}
