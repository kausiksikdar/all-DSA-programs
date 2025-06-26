public class single_element_in_a_sorted_array {
    static int singleElement(int[] arr){
        int n=arr.length;
        int st=1,end=n-2;
        if(n==1) return arr[n-1];
        if (arr[0]!=arr[1]) return arr[0];
        if (arr[n-1]!=arr[n-2]) return arr[n-1];
        while (st<=end){
            int mid=st+(end-st)/2;
            if(arr[mid]!=arr[mid-1] && arr[mid]!=arr[mid+1]) return arr[mid];
            if(mid%2==0){
                if(arr[mid]==arr[mid+1]) st=mid+1;
                if (arr[mid]==arr[mid-1]) end=mid-1;
            }
            if (mid%2==1){
                if(arr[mid]==arr[mid+1]) end=mid-1;
                if (arr[mid]==arr[mid-1]) st=mid+1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] arr={1,1,2,3,3,4,4,5,5};
        System.out.println(singleElement(arr));
    }
}
