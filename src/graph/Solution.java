package graph;
class UnionFind {

    int[] parent;
    int[] rank;

    int myCount;

    public UnionFind(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++)
            parent[i] = i;
        rank = new int[size];
    }

    public void union(int x , int y)
    {
        System.out.println("calling "+ x +"," +y);
        int  n1  = find(x);
        int  n2 = find(y);
        if(n1 == n2)
            return;
        if(rank[n1] > rank[n2])
        {
            parent[n2] = n1;
            rank[n1] += rank[n2];
        }else
        {
            parent[n1] = n2;
            rank[n2] += rank[n1];
        }

        myCount --;
    }

    int find(int x){

        if(parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }
}


public class Solution {

    public static void main(String[] args) {
        int [] [] array = new int[][]{
                //{0,1}, {0,2}, {0,3}, {1,2}
                //{0,1}, {0,2}, {0,3}, {1,2}
                {0,1},{0,2},{1,2}

        };

        System.out.println( "hello" + new Solution().makeConnected(4,array));

    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1) {
            return -1;
        }

        UnionFind dsu = new UnionFind(n);
        int myCount = connections.length;
        for (int[] connection : connections) {
                dsu.union(connection[0], connection[1]);
            }

        System.out.println("myCount " + myCount);
        return myCount - 1;
    }
}