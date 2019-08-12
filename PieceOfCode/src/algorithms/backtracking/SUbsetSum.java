package algorithms.backtracking;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Given an array of integers and a sum, the task is to print all subsets of given array with sum equal to given sum.
 *
 * Examples:
 *
 * Input : arr[] = {2, 3, 5, 6, 8, 10}
 *         sum = 10
 * Output : 5 2 3
 *          2 8
 *          10
 *
 * Input : arr[] = {1, 2, 3, 4, 5}
 *         sum = 10
 * Output : 4 3 2 1
 *          5 3 2
 *          5 4 1
 */


public class SUbsetSum {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int  t = Integer.parseInt(br.readLine());

        while ( t-- > 0 ){
            int n = Integer.parseInt(br.readLine().trim());

            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");

            int[] a = new int[n];

            for (int i=0; i<n; i++){
                a[i] = Integer.parseInt(strs[i]);
            }

            int k = Integer.parseInt(br.readLine());

            for (int i=0; i<k; i++){
                int target = Integer.parseInt(br.readLine());

                getAllSolutions(a, n, target);
//                System.out.println();
            }

        }

    }

    private static void getAllSolutions(int[] a, int n, int target) {

        ArrayList<ArrayList<Integer>> solutions = new ArrayList<>();

        int sum = 0;

        for (int k=0; k<n; k++){
            solveUtil(k, a, n, target, new ArrayList<>(), sum, solutions);

        }


        //print all solutions

        for (ArrayList<Integer> list : solutions){
            System.out.println(list);
        }


    }

    private static void solveUtil(int i, int[] a, int n, int target, ArrayList<Integer> list, int sum, ArrayList<ArrayList<Integer>> solutions) {

        sum+=a[i];
        list.add(a[i]);

        if (sum ==  target)
        {

            ArrayList<Integer> tempList = new ArrayList<>(list);

            solutions.add(tempList);
            return;
        }

        if (sum>target)
            return;


        while (i+1<n){
            solveUtil(++i, a, n, target, list, sum, solutions);

            //backtrack

            int num = list.remove(list.size()-1);

//            sum-=num;
        }


    }


}
