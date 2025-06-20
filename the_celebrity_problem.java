import java.util.Stack;

public class the_celebrity_problem {
    static boolean celebrityFinder(int[][] celeb) {
        Stack<Integer> st = new Stack<>();
        for (int j = 0; j < celeb.length; j++) {
            st.push(j);
        }
        while (st.size()>1) {
            int first = st.peek();
            st.pop();
            int second = st.peek();
            st.pop();
            if (celeb[first][second] == 1 && celeb[second][first] == 0) {
                st.push(second);
            } else if (celeb[first][second] == 0 && celeb[second][first] == 1) {
                st.push(first);
            }
        }
        if (st.empty()) return false;
        int celebrity=st.peek();
        int row=0,col=0;
        for (int j=0;j<celeb.length;j++){
            row+=celeb[celebrity][j];
            col+=celeb[j][celebrity];
        }
        return row==0 && col==celeb.length-1;
    }
    public static void main(String[] args) {
        int[][] celebrity={
          //     0,1,2,3,4
                {0,1,0,1,1}, //0
                {0,0,0,1,1}, //1
                {0,1,0,1,0}, //2
                {0,0,0,0,0}, //3
                {1,0,1,1,0}  //4
        };
        System.out.println(celebrityFinder(celebrity));
    }
}
