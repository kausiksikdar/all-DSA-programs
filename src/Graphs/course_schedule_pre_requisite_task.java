package Graphs;

import java.util.*;

public class course_schedule_pre_requisite_task {
    static List<List<Integer>> createGraph(int courses, int[][] prerequisites)
    {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<courses;i++)
            adj.add(new ArrayList<>());

        for(int i=0;i<prerequisites.length;i++)
        {
            int after = prerequisites[i][0];
            int before = prerequisites[i][1];

            adj.get(before).add(after);
        }
        return adj;
    }

    static boolean isPossible(int courses, List<List<Integer>> adj)
    {
        List<Integer> topoSort = new ArrayList<>();
        int[] inDeg = new int[courses];

        for(int i=0;i<courses;i++)
        {
            for(int j=0;j<adj.get(i).size();j++)
            {
                inDeg[adj.get(i).get(j)]++;
            }
        }

        Queue<Integer> holder = new LinkedList<>();
        for(int i=0;i<courses;i++)
        {
            if(inDeg[i] == 0)
            {
                holder.add(i);
            }
        }

        while(!holder.isEmpty())
        {
            int node = holder.poll();
            topoSort.add(node);

            for(int i=0;i<adj.get(node).size();i++)
            {
                inDeg[adj.get(node).get(i)]--;

                if(inDeg[adj.get(node).get(i)] == 0)
                {
                    holder.add(adj.get(node).get(i));
                }
            }
        }

        return topoSort.size() == courses;
    }
    public static void main(String[] args) {
        int[][] prerequisites = {
                {1,0},
                {2,1},
                {3,1},
                {4,2},
                {5,1}
        };
        int courses = 6;
        List<List<Integer>> adj = createGraph(courses, prerequisites);
        System.out.println(isPossible(courses,adj));
    }
}
