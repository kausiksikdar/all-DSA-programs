public class rotation {
    static int rotation(int[] arr){
        int ans=0;
        int n=arr.length;
        int st=0,end=n-1;
        while (st<=end){
            int mid=st+(end-st)/2;
            if (arr[mid]>=arr[0]){
                st=mid+1;
            }
            else {
                ans=mid;
                end=mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr={1,2};
        System.out.println(rotation(arr));
    }
}
