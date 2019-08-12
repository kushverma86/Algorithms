package algorithms.heaps;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * Given an input stream of n integers, find the kth largest element for each element in the stream.
 *
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains two lines. The first line of each test case contains two space separated integers k and n . Then in the next line are n space separated values of the array.
 *
 * Output:
 * For each test case, in a new line, print the space separated values denoting the kth largest element at each insertion, if the kth largest element at a particular insertion in the stream doesn't exist print -1.
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= K <= n
 * 1 <= n <= 106
 * 1 <= stream[] <= 105
 *
 * Example:
 * Input:
 * 2
 * 4 6
 * 1 2 3 4 5 6
 * 1 2
 * 3 4
 *
 * Output:
 * -1 -1 -1 1 2 3
 * 3 4
 */

public class KthLargest {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while(t-->0){

            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");

            int k = Integer.parseInt(strs[0]);
            int n = Integer.parseInt(strs[1]);

            int[] a = new  int[n];

            line = br.readLine();

            strs = line.trim().split("\\s+");

            for (int i=0; i<n; i++)
            {
                a[i] = Integer.parseInt(strs[i]);
            }

            kthLargest(a, n, k);



        }

    }

    private static void kthLargest(int[] a, int n, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();

        int count = 0;

        for(Integer num: a){


            minHeap.add(num);
            count++;

            if(minHeap.size()>k)
                minHeap.poll();

            if(count<k)
                sb.append(-1+" ");
            else
            {
                sb.append(minHeap.peek()+" ");
            }
        }

        System.out.println(sb);
    }



}
