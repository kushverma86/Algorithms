package algorithms.heaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Given an input stream of N integers. The task is to insert these numbers into a new stream and find the median of the stream formed by each insertion of X to the new stream.
 *
 * Input:
 * The first line of input contains an integer N denoting the number of elements in the stream. Then the next N lines contains integer x denoting the number to be inserted into the stream.
 * Output:
 * For each element added to the stream print the floor of the new median in a new line.
 *
 * Constraints:
 * 1 <= N <= 106
 * 1 <= x <= 106
 *
 * Example:
 * Input:
 * 4
 * 5
 * 15
 * 1
 * 3
 * Output:
 * 5
 * 10
 * 5
 * 4
 *
 * Explanation:
 * Testcase 1:
 * Flow in stream : 5, 15, 1, 3
 * 5 goes to stream --> median 5 (5)
 * 15 goes to stream --> median 10 (5, 15)
 * 1 goes to stream --> median 5 (5, 15, 1)
 * 3 goes to stream --> median 4 (5, 15, 1, 3)
 */

public class MedianInStream {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());

        PriorityQueue<Integer> maxHeap_UH = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap_LH = new PriorityQueue<>();

//        StringBuilder medians = new StringBuilder();

        while(n-->0){

            int num = Integer.parseInt(br.readLine().trim());

            if (maxHeap_UH.isEmpty() || num < maxHeap_UH.peek())
            {
                //insert in upperhalf
                maxHeap_UH.add(num);
            }
            else
            {
                // insert in lower half

                minHeap_LH.add(num);

            }

            if (Math.abs(maxHeap_UH.size() - minHeap_LH.size()) > 1)
            {
                //balance

                if (maxHeap_UH.size() > minHeap_LH.size())
                {
                    int passNum = maxHeap_UH.poll();
                    minHeap_LH.add(passNum);
                }
                else
                {
                    int passNum = minHeap_LH.poll();
                    maxHeap_UH.add(passNum);
                }

            }


            //find median

            //if both algorithms.heaps are of equal size
            // then poll from both and avg is median
            //else
            //  poll from heap with large size that is the median

            if (maxHeap_UH.size() == minHeap_LH.size()){
                int n1 = maxHeap_UH.peek();
                int n2 = minHeap_LH.peek();

                System.out.println((n1+n2)/2);
//                medians.append(((n1+n2)/2)+" ");
            }
            else {
                if (maxHeap_UH.size() > minHeap_LH.size()){
                    System.out.println(maxHeap_UH.peek());
//                    medians.append(maxHeap_UH.peek()+" ");
                }
                else {
//                    medians.append(minHeap_LH.peek()+" ");
                    System.out.println(minHeap_LH.peek());
                }
            }

        }

//        System.out.println(medians);
    }

}
