package Binary_Search;

public class Minimize_Max_Distance_to_Gas_Station {
    static double totalGasStations(double dist, int[] arr){
        int n=arr.length;
        int cnt=0;
        for (int i=1;i<n;i++){
            double numberBetween=(int) ((arr[i]-arr[i-1])/dist);
            if (arr[i]-arr[i-1]==dist*numberBetween){
                numberBetween--;
            }
            cnt+= (int) numberBetween;
        }
        return cnt;
    }
    static double gasStation(int[] arr, int n, int k){
        double low=0,high=0;
        for (int i=1;i<n;i++)
        {
            high=Math.max(high,arr[i]-arr[i-1]);
        }
        double diff=1e-6;
        while (high-low>diff){
            double mid=low+(high-low)/2;
            int totalGasStations= (int) totalGasStations(mid,arr);
            if (totalGasStations>k){
                low=mid;
            }
            else {
                high=mid;
            }
        }
        return high;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        int k=6;
        int n=arr.length;
        System.out.println(gasStation(arr,n,k));
    }
}
