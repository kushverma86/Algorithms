package samsung.binomialCoeff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Find nCr for given n and r.
 *
 * Input:
 * First line contains number of test cases T. T testcases follow. Each testcase contains 1 line of input containing 2 integers n and r separated by a space.
 *
 * Output:
 * For each testcase, in a new line, find the nCr. Modulus your output to 109+7.
 *
 * Constraints:
 * 1 <= T <= 50
 * 1<= n <= 103
 * 1<= r <=800
 *
 * Example:
 * Input:
 * 2
 * 3 2
 * 4 2
 * Output:
 * 3
 * 6
 */

public class BinomialCoefficient {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-->0){
            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");

            int n = Integer.parseInt(strs[0]);
            int r = Integer.parseInt(strs[1]);

            System.out.println(binCoeff(n,r));

        }

    }

    private static long binCoeff(int n, int r) {

        long[][] lookup = new long[n+1][r+1];

        binCoeffUtil(n, r, lookup);


        return lookup[n][r];
    }

    private static void binCoeffUtil(int n, int r, long[][] lookup) {

        if (lookup[n][r]>0 || n<r)
            return;

        if (n==r || r == 0){
            lookup[n][r] = 1;
        }
        else
        {
            binCoeffUtil(n-1, r-1, lookup);
            binCoeffUtil(n-1, r, lookup);

            lookup[n][r] = lookup[n-1][r-1] + lookup[n-1][r];
        }

    }

}
