public class square_root_optimized {
    static int squareRoot(int num){
        if(num<=1) return num;
        int ans=0;
        int start=0,end=num/2;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(mid*mid==num) return mid;
            else if(mid*mid<num) {
                ans = mid;
                start=mid+1;
            }
            else end = mid-1;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(squareRoot(80));
    }
}
