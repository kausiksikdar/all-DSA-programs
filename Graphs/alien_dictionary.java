package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class alien_dictionary {
    static ArrayList<ArrayList<Integer>> makeAdjacencyList(int K, String[] dict)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i=0;i<K;i++)
            adj.add(new ArrayList<>());

        int n = dict.length;
        for (int i=0;i<n-1;i++)
        {
            String str1 = dict[i], str2 = dict[i+1];
            int j=0,k=0;
            while (j<str1.length() && k<str2.length() && str1.charAt(j)==str2.charAt(k))
            {
                j++;
                k++;
            }

            if (j==str1.length())
                continue;

            adj.get(str1.charAt(j)-'a').add(str2.charAt(k)-'a');
        }
        return adj;
    }
    static String alienDict(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] inDeg = new int[V];
        for (int i=0;i<V;i++)
            for (int j=0;j<adj.get(i).size();j++)
                inDeg[adj.get(i).get(j)]++;

        Queue<Integer> q = new LinkedList<>();
        for (int i=0;i<V;i++)
            if (inDeg[i]==0)
                q.add(i);
       String ans = "";
        while (!q.isEmpty())
        {
            int node = q.peek();
            q.remove();
            ans+=(char)(node+'a');
            for (int i=0;i<adj.get(node).size();i++)
            {
                inDeg[adj.get(node).get(i)]--;
                if (inDeg[adj.get(node).get(i)]==0)
                    q.add(adj.get(node).get(i));
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String[] dict = {
                "baa",
                "abcd",
                "abca",
                "cab",
                "cad"
        };
        int K = 4;
        ArrayList<ArrayList<Integer>> adj = makeAdjacencyList(K,dict);
        System.out.println(alienDict(K,adj));
    }
}