package Binary_Search;

public class book_allocation {
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
    static int bookAllocation(int[] A, int targetStudents){
       int n=A.length,st=findMax(A),end=sumOFAllElements(A),ans=0;
       if(targetStudents>n) return -1;
       while (st<=end){
           int mid=st+(end-st)/2;
           int cnt=1,page=0;
           for (int i=0;i<n;i++){
               page+=A[i];
               if(page>mid){
                   cnt++;
                   page=A[i];
               }
           }
           if(cnt<=targetStudents){
               ans=mid;
               end=mid-1;
           }
           else st=mid+1;
       }
       return ans;
    }
    public static void main(String[] args) {
        int[] A={12,34,67,90};
        int targetStudents=2;
        System.out.println(bookAllocation(A,targetStudents));
    }
}
