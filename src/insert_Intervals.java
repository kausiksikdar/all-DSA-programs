import java.util.ArrayList;
import java.util.List;

public class insert_Intervals {
    static int[][] insertIntervals(int[][] interval, int[]newInterval){
        List<int[]> result = new ArrayList<>();
        for(int[] slot : interval){
           if(newInterval[1]<slot[0]){
             result.add(newInterval);
              newInterval=slot;
          }
           else if (slot[1]<newInterval[0]) {
               result.add(slot);
           }
           else {
                newInterval[0]=Math.min(newInterval[0],slot[0]);
                newInterval[1]=Math.max(newInterval[1],slot[1]);
           }
        }
        result.add(newInterval);
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] interval = {{1,3},
                            {3,5},
                            {7,9}};
        int[] newInterval = {2,6};
        int[][] answer = insertIntervals(interval,newInterval);
        for(int i=0;i< answer.length;i++){
            for(int j=0;j<2;j++){
                System.out.print(answer[i][j]+" ");
            }
            System.out.println();
        }
    }
}
