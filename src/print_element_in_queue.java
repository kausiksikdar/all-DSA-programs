import java.util.LinkedList;
import java.util.Queue;

public class print_element_in_queue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(34);
        q.add(23);
        q.add(90);
        q.add(98);
        q.add(78);
        while (!q.isEmpty()){
            System.out.print(q.peek()+" ");
            q.remove();
        }
    }
}

