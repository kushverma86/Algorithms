package algorithms.backtracking.mcoloring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Given an undirected graph and an integer M.
 * The task is to determine if the graph can be colored
 * with at most M colors such that no two adjacent vertices of the graph
 * are colored with the same color.
 * Here coloring of a graph means assignment of colors to all vertices.
 * Print 1 if it is possible to colour vertices and 0 otherwise.
 *
 *
 * Vertex are 1-based (vertext number starts with 1, not 0).
 *
 * Input:
 * The first line of input contains an integer T denoting the number of test cases.
 * Then T test cases follow. Each test case consists of four lines.
 * The first line of each test case contains an integer N
 * denoting the number of vertices.
 * The second line of each test case contains an integer M
 * denoting the number of colors available.
 * The third line of each test case contains an integer E denoting the number of edges
 * available. The fourth line of each test case contains E pairs
 * of space separated integers denoting the edges between vertices.
 *
 * Output:
 * Print the desired output.
 *
 * Constraints:
 * 1 <= T <= 30
 * 1 <= N <= 50
 * 1 <= E <= N*(N-1)
 * 1 <= M <= N
 *
 * Example:
 * Input :
 * 2
 * 4
 * 3
 * 5
 * 1 2 2 3 3 4 4 1 1 3
 * 3
 * 2
 * 3
 * 1 2 2 3 1 3
 *
 * Output:
 * 1
 * 0
 */

public class GraphColoring {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while ( t-- > 0){

            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());


            int E = Integer.parseInt(br.readLine());

            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");

            int k=0;

            ArrayList<Edge> edges = new ArrayList<>();

            while (k<E){
                edges.add(new Edge(Integer.parseInt(strs[k++]), Integer.parseInt(strs[k++])));
            }

            Graph graph = new Graph(N, edges);



        }
    }
}

class Edge{
    int u;
    int v;

    Edge(int u, int v){
        this.u = u;
        this.v = v;
    }
}

class Graph{

    HashMap<Integer, Node > mapper;

    Graph(int N, ArrayList<Edge> edges)
    {

        mapper  = new HashMap<Integer, Node>();
        init(edges);
    }

    private void init(ArrayList<Edge> edges) {

        for (Edge edge : edges){

            if (mapper.get(edge.u) == null)
            {
                mapper.put(edge.u, new Node(edge.u));
            }


            if (mapper.get(edge.v) == null)
            {
                mapper.put(edge.v, new Node(edge.v));
            }



            mapper.get(edge.u).childs.add(mapper.get(edge.v));
            mapper.get(edge.v).childs.add(mapper.get(edge.u));

        }

        
    }
}

class Node{
    int data;
    ArrayList<Node> childs;

    Node(int i){
        data = i;
        childs =  new ArrayList<>();
    }

}
