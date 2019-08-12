package samsung.uniqueBSTs;

import java.util.*;
import java.io.*;
import java.lang.*;


/**
 * Given an integer N, how many structurally unique binary search trees are there that store values 1...N?
 *
 * Input:
 * First line of input contains T denoting the number of testcases. T testcases follow. Each testcase contains a single line of input containing N.
 *
 * Ouput:
 * For each testcase, in a new line, print the answer.
 *
 * Constraints:
 * 1<=T<=15
 * 1<=N<=11
 *
 * Example:
 * Input:
 * 2
 * 2
 * 3
 * Output:
 * 2
 * 5
 *
 * Explanation:
 *
 * Testcase1:
 * for N = 2, there are 2 unique BSTs
 *      1               2
 *       \            /
 *        2         1
 *
 * Testcase2:
 * for N = 3, there are 5 possible BSTs
 *   1              3        3         2      1
 *     \           /        /           /    \      \
 *      3        2         1        1    3      2
 *     /       /                \                      \
 *    2      1               2                        3
 */


class BST{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int n =sc.nextInt();
            solution sol = new solution();
            System.out.println(sol.numTrees(n));
        }
    }
}


class solution
{
    static int numTrees(int n)
    {

        return catalanNum(n);
    }

    private static int catalanNum(int n) {

        int[] catalan = new int[n+1];
        catalan[0] = 1;
        catalan[1] = 1;

        for (int i=2;i<=n;i++){
            catalan[i] = 0;

            for (int j=0; j<i; j++){
               catalan[i]+=catalan[j]*catalan[i-j-1];
            }
        }

        return catalan[n];
    }


}