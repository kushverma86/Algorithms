package algorithms.Greedy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Given an array A[ ] denoting heights of N towers and a positive integer K, modify the heights of each tower either by increasing or decreasing them by K only once and then find out the minimum difference of the heights of shortest and longest towers.
 *
 * Example
 *
 * Input  : A[] = {1, 15, 10}, k = 6
 * Output : 5
 * Explanation : We change 1 to 6, 15 to
 * 9 and 10 to 4. Maximum difference is 5
 * (between 4 and 9). We can't get a lower
 * difference.
 *
 * Input
 * The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. The first line of each test case contains a positive integer K. The second line of each test case contains a positive integer N, denoting number of towers. The third line of the test cases contains N integers denoting the heights of N towers.
 *
 * Output
 * For each test case in new line print out the minimum difference of heights possible.
 *
 * Constraints
 * 1 <= T <= 100
 * 0 <   K <= 30
 * 0 <   N <= 30
 * 0 <= A[i] <= 500
 *
 *
 * Examples
 * Input
 * 3
 * 2
 * 4
 * 1 5 8 10
 * 3
 * 5
 * 3 9 12 16 20
 * 4
 * 6
 * 100 150 200 250 300 400
 *
 * Output
 * 5
 * 11
 * 292
 */

public class MinimizeHeights {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while ( t-- > 0){

            int k = Integer.parseInt(br.readLine().trim());

            int n = Integer.parseInt(br.readLine().trim());

            int[] a = new int[n];

            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");

            for (int i=0; i<n; i++){
                a[i] = Integer.parseInt(strs[i]);
            }

            System.out.println(minimizeHeights(a, n, k));
        }
    }

    private static int minimizeHeights(int[] a, int n, int k) {

        if (n==1)
            return 0;

        Arrays.sort(a);

        int ans = a[n-1] - a[0];
        int small = a[0] + k;
        int big = a[n-1] - k;

        if (small>big){
            int temp = small;
            small = big;
            big = temp;
        }

        for (int i=1; i<n-1; i++){
            int add = a[i] + k;
            int sub = a[i] - k;

            if (sub>=small || add<= big)
                continue;

            if (big - sub <= add - small)
                small = sub;
            else
                big = add;

        }

        return Math.min(ans, big-small);

    }

}
