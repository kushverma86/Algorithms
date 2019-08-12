package algorithms.heaps;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * Given an array of n elements, where each element is at most k away from its target position. The task is to print array in sorted form.
 *
 * Input:
 * First line consists of T test cases. First line of every test case consists of two integers N and K, denoting number of elements in array and at most k positions away from its target position respectively. Second line of every test case consists of elements of array.
 *
 * Output:
 * Single line output to print the sorted array.
 *
 * Constraints:
 * 1<=T<=100
 * 1<=N<=100
 * 1<=K<=N
 *
 * Example:
 * Input:
 * 2
 * 3 3
 * 2 1 3
 * 6 3
 * 2 6 3 12 56 8
 * Output:
 * 1 2 3
 * 2 3 6 8 12 56
 */


public class NearlySorted {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while ( t--  > 0){
            String line = br.readLine();

            String[] strs = line.trim().split("\\s+");

            int n = Integer.parseInt(strs[0]);
            int k = Integer.parseInt(strs[1]);

            int[] a = new int[n];

            line = br.readLine();
            strs = line.trim().split("\\s+");

            for (int i = 0;  i<n ; i++){
                a[i] = Integer.parseInt(strs[i]);
            }

            sortKnearlySorted(a, n, k);

            StringBuilder sb = new StringBuilder();

            for (int i=0; i<n; i++){
                sb.append(a[i]+" ");
            }

            System.out.println(sb);
        }



    }

    private static void sortKnearlySorted(int[] a, int n, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i=0; i<k; i++){
            minHeap.add(a[i]);
        }

        for (int i=0; i<n && !minHeap.isEmpty(); i++){

            a[i] = minHeap.poll();


            if(k<n){
                minHeap.add(a[k++]);
            }
        }

    }

}
