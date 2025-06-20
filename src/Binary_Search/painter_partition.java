package Binary_Search;

public class painter_partition {
    static int findMax(int[] A){
        int max=-1;
        for(int i=0;i<A.length;i++){
            max=Math.max(A[i],max);
        }
        return max;
    }
    static int sum(int[] A){
        int sum=0;
        for(int i=0;i<A.length;i++){
            sum+=A[i];
        }
        return sum;
    }
    static int painterPartition(int[] arr, int target){
        int n=arr.length;
        int ans=0;
        int low=findMax(arr),high=sum(arr);
        while (low<=high){
            int mid=low+(high-low)/2;
            int painterCount=1,wall=0;
            for (int i=0;i<n;i++){
                wall+=arr[i];
                if (wall>mid){
                    painterCount++;
                    wall=arr[i];
                }
            }
            if (painterCount<=target) {
                ans=mid;
                high=mid-1;
            }
           else {
                low=mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] walls={5,10,30,20,15};
        int painters=3;
        System.out.println(painterPartition(walls,painters));
    }
}
