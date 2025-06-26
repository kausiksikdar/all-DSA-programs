public class last_remaining {
    /* 1,2,3,4,5,6,7,8,9
    *  r=n=9
    *  head=2 r=4 s=2 l=false
    * r=2 s=4 l=true
    * h=6 r=1 s=8 l=false */
    static int ilastRemaining(int n){
        boolean left=true;
        int head=1;
        int remaining=n;
        int step=1;
        while (remaining>1) {
            if (left || remaining % 2 != 0) head += step;
            remaining /= 2;
            step *= 2;
            left = !left;
        }
        return head;
    }
    static int lastRemaining(int n){
        return n==1?1:(n/2-lastRemaining(n/2)+1)*2;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,6,7,8,9};
        int n=A.length;
        int ans = lastRemaining(n);
        System.out.println(ans);
    }
}
