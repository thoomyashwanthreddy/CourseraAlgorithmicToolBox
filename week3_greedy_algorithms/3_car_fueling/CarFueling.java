import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[][] stops) {
		int N = stops.length;
        long[] dp = new long[N + 1];
        dp[0] = tank;
        for (int i = 0; i < N; ++i)
            for (int t = i; t >= 0; --t)
                if (dp[t] >= stops[i][0])
                    dp[t+1] = Math.max(dp[t+1], dp[t] + (long) stops[i][1]);

        for (int i = 0; i <= N; ++i)
            if (dp[i] >= dist) return i;
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i][i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
