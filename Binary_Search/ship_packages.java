package Binary_Search;

public class ship_packages {
    static int findMax(int[] A){
        int max=-1;
        for(int i=0;i<A.length;i++){
            max=Math.max(A[i],max);
        }
        return max;
    }
    static int sumOFAllElements(int[] A){
        int sum=0;
        for(int i=0;i<A.length;i++){
            sum+=A[i];
        }
        return sum;
    }
    static int shipPackages(int[] A, int days){
        int n=A.length;
        int st=findMax(A), end=sumOFAllElements(A),mid,ans=0,day,weights;
        while(st<=end){
            mid=st+(end-st)/2;
            day=1;
            weights=0;
            for(int i=0;i<n;i++){
                weights+=A[i];
                if(weights>mid){
                    day++;
                    weights=A[i];
                }
            }
            if(day<=days) {
                ans=mid;
                end=mid-1;
            }
            else st=mid+1;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] weights={1,2,3,4,5,6,7,8,9,10};
        int days=5;
        System.out.println(shipPackages(weights,days));
    }
}
