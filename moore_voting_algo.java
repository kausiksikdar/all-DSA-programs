public class moore_voting_algo {
    static int winner(int[] arr){
        int candidate=arr[0],count=0;
        for(int i=0;i<arr.length;i++){
            if(count==0) candidate=arr[i];
            if(candidate!=arr[i]){
                count--;
            }
            else count++;
        }
        count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==candidate) count++;
        }
        //Check-point to check whoever is winning is actually winner or not
        if(count>=arr.length/2) return candidate;
        return -1;
    }
    public static void main(String[] args) {
        int[] votes={3,3,3,3,3,3,2,2,2,2,1};
        System.out.println(winner(votes));
    }
}
