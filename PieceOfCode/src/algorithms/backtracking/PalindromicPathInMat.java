package algorithms.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Set;

/**
 * Given a matrix containing lower alphabetical characters only, we need to count number of palindromic paths in given matrix. A path is defined as a sequence of cells starting from top-left cell and ending at bottom-right cell. We are allowed to move to right and down only from current cell.
 *
 * Input:
 * The first line of input contains a single integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines.
 * First line of each test case consist of two space separated integers R and C, denoting the number of element in a row and column respectively.
 * Second line of each test case consists of R*C space separated chars denoting the elements in the matrix in row major order.
 *
 * Output:
 * It should be single line output, Print the respective output in the respective line.
 *
 * Constraints:
 * 1<=T<=20
 * 1<=R,C<=10
 *
 * Example:
 * Input:
 * 1
 * 3 4
 * a a a b b a a a a b b a
 *
 * Output:
 * 3
 */



public class PalindromicPathInMat {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-->0){
            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");

            int m = Integer.parseInt(strs[0]);
            int n = Integer.parseInt(strs[1]);

            line = br.readLine();
            strs = line.trim().split("\\s+");
            int k=0;

            char[][] a= new char[m][n];

            for (int i=0;  i<m; i++){
                for (int j=0;  j<n; j++){
                    a[i][j] = strs[k++].charAt(0);
                }
            }

            System.out.println(palindromicPath(a, m, n));

        }

    }

    private static int palindromicPath(char[][] a, int m, int n) {

        int count = 0;
        ArrayList<Character> list = new ArrayList<>();
        return DFSUtil(0, 0, a, m, n, count, list);
    }

    private static int DFSUtil(int i, int j, char[][] a, int m, int n, int count, ArrayList<Character> list) {

        list.add(a[i][j]);

        if (i==m-1 && j==n-1){
            if(isPalindrome(list))
                return count+1;
            else
                return count;
        }



        if (isSafe(i+1, j, a, m, n))
            count=DFSUtil(i+1, j, a, m, n, count, list);

        if (isSafe(i, j+1, a, m, n))
            count=DFSUtil(i, j+1, a, m, n, count, list);

        list.remove(list.size()-1);

        return count;
    }

    private static boolean isSafe(int i, int j, char[][] a, int m, int n) {

        if (i<m && j<n)
            return true;
        else
            return false;

    }

    private static boolean isPalindrome(ArrayList<Character> list) {

        int i=0;
        int j= list.size()-1;

        while (i<j){
            if (list.get(i) != list.get(j)) {
                list.remove(list.size()-1);
                return false;
            }
                i++;
                j--;

        }

        list.remove(list.size()-1);
        return true;

    }

}
