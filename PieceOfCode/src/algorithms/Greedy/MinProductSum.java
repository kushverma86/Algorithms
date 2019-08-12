package algorithms.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class MinProductSum {
    public static void main (String[] args)throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            int n = Integer.parseInt(br.readLine().trim());

            int[] a = new int[n];
            int[] b = new int[n];

            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");

            for(int i=0; i<n; i++){
                a[i] = Integer.parseInt(strs[i]);
            }



            line = br.readLine();
            strs = line.trim().split("\\s+");

            for(int i=0; i<n; i++){
                b[i] = Integer.parseInt(strs[i]);
            }

            System.out.println(minSumProduct(a, b, n));
        }
    }

    public static int minSumProduct(int[] a, int[] b, int n){

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<n; i++){
            minHeap.add(a[i]);
            maxHeap.add(b[i]);
        }

        int sum = 0;

        while(!minHeap.isEmpty()){
            sum+= minHeap.poll()*maxHeap.poll();
        }


        return sum;
    }


}
