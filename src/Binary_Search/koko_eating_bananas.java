package Binary_Search;

public class koko_eating_bananas {
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
    static int kokoEatingBananas(int[] A, int hours){
        int n=A.length;
        int st=sumOFAllElements(A)/hours,end=findMax(A),ans=0,mid,totalTime=0;
        if(st==0) st=1;
        while(st<=end){
            mid=st+(end-st)/2;
            for(int i=0;i<n;i++){
                totalTime+=A[i]/mid;
                if(A[i]%mid!=0){
                    totalTime++;
                }
            }
            if(totalTime>hours) st=mid+1;
            else {
                ans=mid;
                end=mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] piles={3,6,11,7};
        int h=8;
        System.out.println(kokoEatingBananas(piles,h));
    }
}
