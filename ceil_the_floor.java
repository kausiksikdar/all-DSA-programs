public class ceil_the_floor {
    static void display(int[] arr){
        for (int i : arr){
            System.out.print(i+" ");
        }
    }
    static int[] ceilTheFloor(int[] arr, int target){
        int[] ans=new int[2];
        int n= arr.length;
        if(target<arr[0]) ans[0]=-1;
        if(target>arr[n-1]) ans[1]=-1;
        int st=0,end=n-1;
        while (st<=end){
            int mid=st+(end-st)/2;
            if(arr[mid]<=target){
              ans[0]=arr[mid];
              st=mid+1;
            }
            if(arr[mid]>=target){
                ans[1]=arr[mid];
                end=mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr={3,4,7,8,8,10};
        int target=5;
        display(ceilTheFloor(arr, target));
    }
}
