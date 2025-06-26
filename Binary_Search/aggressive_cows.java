package Binary_Search;

public class aggressive_cows {
    static int aggressiveCows(int[] A, int cows){
        int n=A.length;
        int st=1,end=A[n-1]-A[0],mid,ans=st,count=1;
        while(st<=end){
            mid=st+(end-st)/2;
            int pos=A[0];
            for(int i=0;i<n;i++){
                if(pos+mid<=A[i]){
                    count++;
                    pos=A[i];
                }
            }
            if(count<cows){
                end=mid-1;
            }
            else{
                ans=mid;
                st=mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] stalls={1,2,4,8,9};
        int cows=3;
        System.out.println(aggressiveCows(stalls,cows));
    }
}
