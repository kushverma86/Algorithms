package algorithms.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * There is one meeting room in a firm. There are N meetings in the form of (S[i], F[i]) where S[i] is start time of meeting i and F[i] is finish time of meeting i.
 *
 * What is the maximum number of meetings that can be accommodated in the meeting room?
 *
 * Input:
 * The first line of input consists number of the test cases. The description of T test cases is as follows:
 * The first line consists of the size of the array, second line has the array containing the starting time of all the meetings each separated by a space, i.e., S [ i ]. And the third line has the array containing the finishing time of all the meetings each separated by a space, i.e., F [ i ].
 *
 * Output:
 * In each separate line print the order in which the meetings take place separated by a space.
 *
 * Constraints:
 * 1 ≤ T ≤ 70
 * 1 ≤ N ≤ 100
 * 1 ≤ S[ i ], F[ i ] ≤ 100000
 *
 * Example:
 * Input:
 * 2
 * 6
 * 1 3 0 5 8 5
 * 2 4 6 7 9 9
 * 8
 * 75250 50074 43659 8931 11273 27545 50879 77924
 * 112960 114515 81825 93424 54316 35533 73383 160252
 *
 * Output:
 * 1 2 4 5
 * 6 7 1
 */

public class Nmeetings {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0){
            int n = Integer.parseInt(br.readLine().trim());

            int[] S = new int[n];
            int[] E = new int[n];

            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");

            for (int i=0;i<n; i++){
                S[i] = Integer.parseInt(strs[i]);
            }


             line = br.readLine();
             strs = line.trim().split("\\s+");

            for (int i=0; i<n; i++){
                E[i] = Integer.parseInt(strs[i]);
            }


            PriorityQueue<Meeting> minHeap = new PriorityQueue<>(n, new MyComparator());

            for (int i=0; i<n; i++){
                minHeap.add(new Meeting(i+1, S[i], E[i]));
            }

            StringBuilder sb = new StringBuilder();


            Meeting mprev = minHeap.poll();
            int prevEnd = mprev.end;
            sb.append(mprev.count+" ");

            for(int i=2; i<=n; i++){
                Meeting m = minHeap.poll();
               if (m.start>= prevEnd){
                   sb.append(m.count).append(" ");
                   prevEnd = m.end;
               }
            }

            System.out.println(sb);
        }


    }

}


class Meeting{
    int count;
    int start;
    int end;

    Meeting(int count, int start, int end){
        this.count = count;
        this.start = start;
        this.end =  end;
    }

}

class MyComparator implements Comparator<Meeting> {
    public int compare(Meeting x, Meeting y)
    {

        return x.end - y.end;
    }
}
