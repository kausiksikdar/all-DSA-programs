public class print_the_array_elements_by_recursion_indexGivenInFunction {
    static void printElements(int[] A, int idx){
        int n= A.length;
        if(idx==n) return;
        System.out.print(A[idx]+" ");
        printElements(A,idx+1);
    }

    public static void main(String[] args) {
        int[] A={1,2,3,4,5,6,7,8,9,10};
        printElements(A,0);
    }
}
