import java.util.LinkedList;
import java.util.Queue;

public class time_needed_to_buy_tickets {
    static int totalTime(int[] arr, int person){
          Queue<Integer> qe=new LinkedList<>();
          //Copy the array indices into qe
          for (int j=0;j< arr.length;j++){
              qe.add(j);
          }
          int time=0;
          // Traversing till arr[person] is non zero
          while (arr[person]!=0){
             arr[qe.peek()]--;
              if (arr[qe.peek()]!=0) qe.add(qe.peek());
              qe.remove();
              time++;
          }
          return time;
    }
    static int totalTime2(int[] arr, int person){
        int time=0;
        for (int j=0;j<arr.length;j=(j+1)%arr.length){
            if (arr[j]>0){
                arr[j]--;
                 time++;
            }
            if (arr[person]==0) return time;
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] arr={1,5,2,3,7};
        int person=2;
        System.out.println(totalTime(arr,person));
    }
}
