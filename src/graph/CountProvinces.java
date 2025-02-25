package graph;


import common.Utils;

import java.util.Arrays;
import java.util.Collections;

/*
https://leetcode.com/problems/number-of-provinces/description/
There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.

Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
 */
public class CountProvinces {

    public static int[] parent;
    public static int[] rank;
    int count =0;
    public static void main(String[] args) {
        int [] [] array = new int[][]{
                /*{1,1,0},
                {1,1,0},
                {0,0,1}*/
                {1,0,0,1},
                {0,1,1,0},
                {0,1,1,1},
                {1,0,1,1}
        };

        System.out.println( new CountProvinces().findCircleNum(array));
        System.out.println("one more");
        System.out.println( new CountProvinces().findCircleNumDFS(array));

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
        //else
        //parent[n1] = n2;
        count --;
    }

    int find(int x){

        if(parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }




    public int findCircleNum(int[][] array) {
        int total = array.length;
        count = total;
        System.out.println("total " + total);
        parent = new int[array.length];
        rank = new int[array.length];

        for(int i=0 ; i <total; i++ )
        {
            parent[i]=i;
        }
        System.out.println("priting paent");
        Utils.printArray(parent);


        for(int i=0 ; i< total ; i++)
        {
            for(int j=0 ; j< total ; j++)
            {
                if(array[i][j] == 1)
                    union(i,j);
            }
            System.out.println("loop");
        }
        System.out.println("priting paent");
        Utils.printArray(parent);
        return this.count;
    }

    public int findCircleNumDFS(int[][] edges)
    {
        int total = edges.length;
        boolean visited[] = new boolean[total];
        int connected = 0;
        for(int i=0; i < total; i++) {

            if (!visited[i]) ;
            {
                connected++;
                dfsFind(i, edges, visited);
            }
        }
         return connected;
    }

    private void dfsFind(int node, int[][] edges, boolean[] visited) {

        visited[node]= true;
        for(int k= 0 ; k <edges.length ; k++){
            if(edges[node][k] == 1 && !visited[k]) {
                //visited[k] = true;
                dfsFind(k,edges,visited);
            }
        }
    }


}
