public class put_Zeroes_AtLast {
     /* given an array, put all '0s' at last of given array without changing the relative order
     of the elements
      Input -> [1,0,2,0,3,4]
      Output ->[1,2,3,4,0,0]

      It has same logic as Bubble Sort
      */
     static void moveZeroes(int[] A){
         int n = A.length;
         for(int i=0;i<n-1;i++){
             boolean flag=false;
             for(int j=0;j<n-1-i;j++){
                 // Last "i" number of elements are already sorted position so no need to swap
                 if(A[j]==0&&A[j+1]!=0){
                     // Swap
                     int temp=A[j];
                     A[j]=A[j+1];
                     A[j+1]=temp;
                     flag=true;
                 }
             }
             if(!flag) return;
         }
     }
     public static void main(String[] args) {
         int[] A={1,0,2,0,3,4};
         moveZeroes(A);
         for(int i:A){
             System.out.print(i+" ");
         }

     }
}
