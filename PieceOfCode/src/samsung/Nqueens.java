package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


/**
 * Input:
 * 2
 * 1
 * 4
 * Output:
 * [1 ]
 * [2 4 1 3 ] [3 1 4 2 ]
 */


public class Nqueens {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0){

            int n = Integer.parseInt(br.readLine().trim());

            solveNQueen(n);
        }
    }

    private static void solveNQueen(int N) {


        ArrayList<ArrayList<Integer>> solutions = new ArrayList<>();


        ArrayList<Integer> sol = new ArrayList<>();

        solveNQUtil(0, N, sol, solutions);

        for (ArrayList<Integer> list : solutions)
            System.out.println(list);


        System.out.println();
    }

    private static void solveNQUtil(int row, int N, ArrayList<Integer> sol, ArrayList<ArrayList<Integer>> solutions) {


        if (row == N){
            solutions.add(new ArrayList<>(sol));
        }
        else
        {
            for (int col=0; col<N; col++){

                sol.add(col);

                if (isValid(sol))
                    solveNQUtil(row+1, N,  sol, solutions);

                sol.remove(sol.size()-1);
            }
        }


    }

    private static boolean isValid(ArrayList<Integer> sol) {

        int row = sol.size()-1;

        for (int i=0; i<row; i++){
            int diff = Math.abs(sol.get(row) -  sol.get(i));

            if ( diff == 0 || diff == row - i )
                return false;

        }

        return true;

    }

}
