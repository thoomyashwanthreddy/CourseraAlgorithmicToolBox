import java.util.*;

class EditDistance {
  public static int EditDistance(String s, String t) {
    //write your code here
	int[][] d = new int[s.length()+1][t.length()+1];
	for (int i=0; i<=s.length(); i++) {
		d[i][0] = i;
	}
	for (int j=0; j<=t.length(); j++) {
		d[0][j] = j;
	}
	for (int j=1; j<=t.length(); j++) {
		for (int i=1; i<=s.length(); i++) {
			int insertion = d[i][j-1] + 1;
			int deletion = d[i-1][j] + 1;
			
			int distance = Math.min(insertion, deletion);
			if (s.charAt(i-1)==t.charAt(j-1)) {
				int match = d[i-1][j-1];
				distance = Math.min(distance, match);
			}
			else {
				int mismatch = d[i-1][j-1] + 1;
				distance = Math.min(distance, mismatch);
			}
			d[i][j] = distance;
		}
	}
	//System.out.println(Arrays.toString(d[1]));
    return d[s.length()][t.length()];
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
 