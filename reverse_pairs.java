import java.util.ArrayList;

public class reverse_pairs {
    static void merge(int[] arr, int low, int high, int mid){
        ArrayList<Integer> temp=new ArrayList<>();
        int left=low;
        int right=mid+1;
        while (left <=mid && right<=high){
            if (arr[left]<=arr[right]){
                temp.add(arr[left]);
                left++;
            }
            else {
                temp.add(arr[right]);
                right++;
            }
        }
        while (left<=mid){
            temp.add(arr[left]);
            left++;
        }
        while (right<=high){
            temp.add(arr[right]);
            right++;
        }
        for (int i=low;i<=high;i++){
            arr[i]=temp.get(i-low);
        }
    }
    static int countPairs(int[] arr ,int low, int high, int mid){
        int cnt=0;
        int right=mid+1;
        for (int i=low;i<=mid;i++){
            while (right<=high && arr[i]>(long)2*arr[right]) right++;
            cnt+=(right-(mid+1));
        }
        return cnt;
    }
    static int mergeSort(int[] arr, int low, int high){
        int cnt=0;
        int mid=(low+high)/2;
        if (low==high){
            return cnt;
        }
        cnt+=mergeSort(arr,low,mid);
        cnt+=mergeSort(arr,mid+1,high);
        cnt+=countPairs(arr,low,high,mid);
        merge(arr,low,high,mid);
        return cnt;
    }
    static int reversePairs(int[] arr){
        int n=arr.length;
        return mergeSort(arr,0,n-1);
    }
    public static void main(String[] args) {
        int[] arr={2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        System.out.println(reversePairs(arr));
    }
}
