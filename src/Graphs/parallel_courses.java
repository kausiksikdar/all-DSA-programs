package Graphs;
import java.util.*;
public class parallel_courses {
    //TC = O(n+2E)
    //SC = O(n^2)(crating the graph) + O(n)(BFS) = O(n^2)
    static int totalTime(int n, int[][] relations, int[] time)
    {
        //Creation of Graph
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());

        for(int[] relation:relations)
        {
            int beforeCourse = relation[0];
            int afterCourse = relation[1];

            adj.get(beforeCourse-1).add(afterCourse-1);
        }

        //Starting Topological Sort as one course is dependent on other
        int[] prevTime = new int[n]; //an array to store the previous time of any course as the time to complete each course is given so if we have only the optimal prevTime the at end we add with prevTime[course] with time[course] to get the total Time
        int[] inDeg = new int[n];

        for(int i=0;i<n;i++)
            for(int j=0;j<adj.get(i).size();j++)
                inDeg[adj.get(i).get(j)]++;

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++)
            if(inDeg[i] == 0)
                q.offer(i);

        while(!q.isEmpty())
        {
            int node = q.poll();

            for(int i=0;i<adj.get(node).size();i++)
            {
                inDeg[adj.get(node).get(i)]--;

                if(inDeg[adj.get(node).get(i)] == 0)
                    q.offer(adj.get(node).get(i));

                //updating the prevTime of those nodes who have a direct connection with current node
                prevTime[adj.get(node).get(i)] = Math.max(prevTime[adj.get(node).get(i)], prevTime[node]+time[node]);
            }
        }
        int totalTime = 0; //variable to calculate the total time needed
        for(int i=0;i<n;i++)
        {
            //taking maximum of totalTime(previously Calculated) and the total Time needed for each course(prevTime[course] + time[course])
            totalTime = Math.max(totalTime, prevTime[i]+time[i]);
        }
        return totalTime;
    }
    public static void main(String[] args) {
        int[][] relations = {{1,5},{2,5},{3,5},{3,4},{4,5}}; //relationship between courses, course u must complete before course v
        int[] time = {1,2,3,4,5}; // time needed to complete ith courses
        int n = 5; //total number of courses
        System.out.println(totalTime(n,relations,time));
    }
}
