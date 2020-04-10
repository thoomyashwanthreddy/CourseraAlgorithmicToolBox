import java.util.*;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {
      int len_numbers = (exp.length() + 1)/2;
      long[][] min = new long[len_numbers][len_numbers];
      long[][] max = new long[len_numbers][len_numbers];
      for(int i=0; i<exp.length(); i+=2) { 
		  long num = Long.valueOf(String.valueOf(exp.charAt(i)));
		  min[i/2][i/2] = num; //because every even number is a digit
		  max[i/2][i/2] = num;
      }
      for(int s=1; s<len_numbers; s++) {
    	  for(int i=0; i<len_numbers-s; i++) {
    		  int j = i+s;
    		  //System.out.println(s+" "+i+" "+j);
    		  long[] values = MinAndMax(exp,min,max,i,j);
    		  min[i][j] = values[0];
    		  max[i][j] = values[1];
    	  }
      }
      /*for (int i=0; i<len_numbers; i++) {
    	  System.out.println(Arrays.toString(max[i]));
      }*/
      return max[0][len_numbers-1];
    }
    private static long[] MinAndMax(String exp, long[][] min, long[][] max, int i, int j) {
    	long[] values = new long[2];
    	long minValue = +999;
    	long maxValue = -999;
    	for (int k=i; k<j; k++) {
    		char eval_op = exp.charAt(2*k+1); //To get the operator between the k and kth number
    		long a = eval(max[i][k], max[k+1][j], eval_op);
    		long b = eval(max[i][k], min[k+1][j], eval_op);
    		long c = eval(min[i][k], max[k+1][j], eval_op);
    		long d = eval(min[i][k], min[k+1][j], eval_op);
    		
    		long[] temp = new long[]{minValue, maxValue, a, b, c, d};
    		long[] retValue = calcMinMax(temp);
    		minValue = retValue[0];
    		maxValue = retValue[1];
    	}
    	values[0] = minValue;
    	values[1] = maxValue;
    	return values;
    }
    private static long[] calcMinMax(long[] temp) {
    	long minValue = temp[0];
    	long maxValue = temp[1];
    	for (int i=2; i<temp.length; i++) {
    		if (temp[i] > maxValue) {
    			maxValue = temp[i];
    		}
    		else if (temp[i] < minValue) {
    			minValue = temp[i];
    		}
    	}
    	long[] retValue = new long[2];
    	retValue[0] = minValue;
    	retValue[1] = maxValue;
    	return retValue;
    }
    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}