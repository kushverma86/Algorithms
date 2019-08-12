package algorithms.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

/**   ----------Problem Statement---------------------
        Given An array of Alphabets and their frequency. Your task is to print all the given alphabets Huffman Encoding.
        Note: If two elements have same frequency, then the element which if at first will be taken on left of Binary Tree and other one to right.

        Input:
        First line consists of test cases T. First line of every test case consists of string of alphabets and second line consists of its frequencies.

        Output:
        Print the HuffmanCodes in single line, with n spaces of each alphabet's HuffmanCodes respectively. In PreOrder form of Binary Tree.

        Constraints:
        1<=T<=100
        1<=|String length|<=26

        Example:
        Input:
        1
        abcdef
        5 9 12 13 16 45
        Output:
        0 100 101 1100 1101 111

        Explanation:
        For the above test case.
        HuffmanCodes will be
        f: 0
        c: 100
        d: 101
        a: 1100
        b: 1101
        e: 111
        Print in the PreOrder of Binary Tree.
*/


public class HuffmanEncoding {

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0){
            String input = br.readLine();

            String countsString = br.readLine();

            String[] counts = countsString.trim().split("\\s+");

            char[] charArr = input.toCharArray();

            Node[] nodeArr = new Node[charArr.length];

            for (int i=0; i<charArr.length; i++){
                nodeArr[i] = new Node(null, null, charArr[i], Integer.parseInt(counts[i]));
            }

            HuffmanEncoding hf = new HuffmanEncoding();
            hf.solution(nodeArr,  charArr.length);

        }
    }

    private void solution(Node[] nodeArr, int n) {

        MinHeap heap = new MinHeap(nodeArr, n);
        heap.buildMinHeap();
        Node head;

        while (heap.heapSize > 1){

            Node left = heap.extractMin();
            Node right = heap.extractMin();

            Node mergeNode = new Node(left, right, '^',left.count+right.count);

            heap.insert(mergeNode);
        }

        head = heap.extractMin();

        LinkedHashMap<Character, String> map  = new LinkedHashMap<>();

        inorderTraversal(head, "", map);

        StringBuilder sb  = new StringBuilder();

        for (Map.Entry<Character, String> entry : map.entrySet()){

            sb.append(entry.getValue()+" ");

        }

        System.out.println(sb);

    }

    private void inorderTraversal(Node head, String path, LinkedHashMap<Character, String> map) {

        if (head == null)
            return;

        inorderTraversal(head.left, path+"0", map);
        inorderTraversal(head.right, path+"1", map);

        if (head.left == null && head.right == null)
            map.put(head.ch, path);

    }
}

class Node{

    Node left;
    Node right;
    char ch;
    int count;

    Node(Node left, Node right, char ch, int count){
        this.ch = ch;
        this.count = count;
        this.left = left;
        this.right = right;
    }


}

class MinHeap{

    Node[] minHeap;
    int heapSize;
    int capacity;

    MinHeap(Node[] a, int n){
        minHeap = a;
        this.capacity = n;
        heapSize = 0;
    }

    public void insert(Node node){

        if (heapSize+1>capacity)
            return;

        int i = heapSize;
        minHeap[heapSize] = node;
        heapSize = heapSize+1;

        while ( i>=0 && minHeap[(i-1)/2].count > minHeap[i].count )
        {
            Node temp = minHeap[i];
            minHeap[i] = minHeap[(i-1)/2];
            minHeap[(i-1)/2] = temp;

            i = (i-1)/2;
        }
    }

    public Node extractMin(){

        if (heapSize == 0)
            return null;


        Node min = minHeap[0];

        minHeap[0] = minHeap[heapSize-1];
        heapSize = heapSize -1;

        minHeapify(0);

        return min;
    }

    public void minHeapify(int i){

       int l = 2*i + 1;
       int r = 2*i +2;

       int min;

       if(l<heapSize && minHeap[l].count < minHeap[i].count){
           min = l;
       }
       else
           min = i;

       if (r<heapSize && minHeap[r].count < minHeap[min].count)
           min = r;

       if (min != i){
           Node temp = minHeap[min];
           minHeap[min] = minHeap[i];
           minHeap[i] = temp;

           minHeapify(min);
       }

    }

    public void buildMinHeap(){

        heapSize = capacity;

        for (int i = heapSize/2 -1; i>=0; i--){
            minHeapify(i);
        }

    }
}


