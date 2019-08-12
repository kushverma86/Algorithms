package algorithms.Greedy;

import java.util.*;

class LRU_Cache
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            Set<Integer> s = new HashSet<Integer>() ;
            int n = sc.nextInt();
            LRUCache g = new LRUCache(n);
            int q = sc.nextInt();

            while(q>0)
            {

                String c = sc.next();
                //	System.out.println(c);
                if(c.equals("GET"))
                {
                    int x = sc.nextInt();
                    System.out.print(g.get(x)+" ");
                }
                if(c.equals("SET"))
                {
                    int x = sc.nextInt();
                    int y  = sc.nextInt();
                    g.set(x,y);
                }

                q--;
                //System.out.println();
            }
            t--;
            System.out.println();
        }
    }
}

class LRUCache {

    Map<Integer,NodeLRU> map= new HashMap<>();
    int capacity;
    NodeLRU head;
    NodeLRU tail;
    int size;





    /*Inititalize an LRU cache with size N */
    public LRUCache(int N) {

        this.capacity = N;
        head = new NodeLRU(0,0);
        tail = new NodeLRU(0,0);
        head.right = tail;
        tail.left = head;
        this.size = 0;

    }

    /*Returns the value of the key x if
     present else returns -1 */
    public int get(int x) {

        NodeLRU node = map.get(x);

        if (node!=null) {
            remove(node);
            addNode(node);
            return node.val;
        }
        else
            return -1;
    }

    private void remove(NodeLRU node) {

        node.left.right = node.right;
        node.right.left = node.left;
        node.left = null;
        node.right = null;

    }

    private void addNode(NodeLRU node){
        node.right = head.right;
        head.right.left = node;
        node.left = head;
        head.right = node;
    }

    /*Sets the key x with value y in the LRU cache */
    public void set(int x, int y) {


        if (map.get(x) != null){
            remove(map.get(x));
            map.get(x).val = y;
            addNode(map.get(x));
        }
        else {

            if (size == capacity){
                int k = tail.left.key;
                remove(tail.left);
                map.remove(k);
                size--;
            }


            map.put(x, new NodeLRU(x, y));
            addNode(map.get(x));
            size++;
        }

    }
}

class NodeLRU{

    int key;
    int val;
    NodeLRU left;
    NodeLRU right;

    NodeLRU(int key, int val){
        this.key = key;
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
