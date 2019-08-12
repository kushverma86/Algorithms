package algorithms.backtracking;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a N X N matrix (M) filled with 1, 0, 2, 3. The task is to find whether there is a path possible from source to destination, while traversing through blank cells only. You can traverse up, down, right and left.
 *
 * A value of cell 1 means Source.
 * A value of cell 2 means Destination.
 * A value of cell 3 means Blank cell.
 * A value of cell 0 means Blank Wall.
 * Note: there is only single source and single destination.
 *
 *
 *
 * Input:
 * The first line of input is an integer T denoting the no of testcases. Then T test cases follow. Each test case consists of 2 lines. The first line of each test case contains an integer N denoting the size of the square matrix. Then in the next line are N*N space separated values of the matrix (M).
 *
 * Output:
 * For each test case in a new line print 1 if the path exist from source to destination else print 0.
 *
 * Constraints:
 * 1 <= T <= 20
 * 1 <= N <= 20
 *
 * Example:
 * Input:
 * 2
 * 4
 * 3 0 0 0 0 3 3 0 0 1 0 3 0 2 3 3
 * 3
 * 0 3 2 3 0 0 1 0 0
 *
 * Output:
 * 1
 * 0
 *
 * Explanation:
 * Testcase 1: The matrix for the above given input is:
 * 3 0 0 0
 * 0 3 3 0
 * 0 1 0 3
 * 0 2 3 3
 * From the matrix we can see that there exists a path from to reach destination 2 from source 1.
 * Testcase 2: The matrix for the above given input is:
 * 0 3 2
 * 3 0 0
 * 1 0 0
 * From the matrix we can see that there does not exists any path to reach destination 2 from source 1.
 */


public class Findpath {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            int n = Integer.parseInt(br.readLine().trim());

            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");

            int k = 0;

            int[][] a= new int[n][n];

            for(int i=0; i<n;  i++){
                for(int j=0; j<n; j++){

                    a[i][j] = Integer.parseInt(strs[k++]);
                }
            }



            if (pathExist(a, n))
                System.out.println(1);
            else
                System.out.println(0);


        }


    }

    private static boolean pathExist(int[][] a, int n) {


        // find source

        int si=-1, sj=-1;

       for (int i=0; i<n; i++){
           for (int j=0; j<n; j++){
               if ( a[i][j] == 1) {
                   si = i;
                   sj = j;
                   break;
               }
           }
       }


       if (si==-1)
           return false;


       boolean[][] visited = new boolean[n][n];
        Queue<String> pointsQueue = new LinkedList<>();

        pointsQueue.add(si+"_"+sj);

        return bfsUtil(a, visited, n, pointsQueue);



    }

    private static boolean bfsUtil(int[][] a, boolean[][] visited, int n, Queue<String> pointsQueue) {

        if (pointsQueue.size() == 0)
            return false;

        String point = pointsQueue.poll();

        int x = Integer.parseInt(point.split("_")[0]);
        int y = Integer.parseInt(point.split("_")[1]);

        if (a[x][y] == 2)
            return true;

        visited[x][y] = true;

        // move all moves

        //up
        if (isSafe(x-1, y, visited, n, a))
           pointsQueue.add((x-1)+"_"+y);

        //down
        if (isSafe(x+1, y, visited, n, a))
            pointsQueue.add((x+1)+"_"+y);


        //right
         if (isSafe(x, y+1, visited, n, a))
             pointsQueue.add(x+"_"+(y+1));

        //left
        if (isSafe(x, y-1, visited, n, a))
            pointsQueue.add(x+"_"+(y-1));


        return bfsUtil(a,visited,n,pointsQueue);


    }

    private static boolean isSafe(int x, int y, boolean[][] visited, int n, int[][] a) {

        // not safe if
        // out of index, visited, 0

        if (x<0 || x>=n || y<0 || y>=n || visited[x][y] || a[x][y] == 0)
            return false;

        return true;

    }
}
