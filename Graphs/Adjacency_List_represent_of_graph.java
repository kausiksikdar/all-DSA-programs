package Graphs;
import java.util.ArrayList;
import java.util.Arrays;

public class Adjacency_List_represent_of_graph {
    //un-directed weighted graph
    static void addEdge(ArrayList<ArrayList<int[]>> am, int s, int d,int weight){
        am.get(s).add(new int[]{d,weight});
        am.get(d).add(new int[]{s,weight});
    }
    public static void main(String[] args) {
        int v = 5;

        ArrayList<ArrayList<int[]>> am = new ArrayList<>(v);

        for (int j=0;j<v;j++){
            am.add(new ArrayList<>());
        }

        addEdge(am,0,1,30);
        addEdge(am,0,2,10);
        addEdge(am,0,3,34);
        addEdge(am,1,2,89);
        addEdge(am,0,4,90);

        for (int j=0;j<am.size();j++){
            System.out.print(j+" => ");
            for (int k=0;k<am.get(j).size();k++){
                System.out.print(Arrays.toString(am.get(j).get(k)) +"->");
            }
            System.out.println();
        }
    }
}
