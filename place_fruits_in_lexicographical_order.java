public class place_fruits_in_lexicographical_order {
    /* We use Selection Sort algo here
    As in selection sort with one element we compare the entire array and put it in correct position
    By 'compareTo' method we compare entire s1 with s2 and determine its correct position that
    it should come before or after s1 or s2
    */
    static void sortFruits(String[] str){
        int n= str.length;
        //'i' represents the current index
        for(int i=n-1;i>0;i--){
            //Find maximum element in unsorted part of Array
            int max_idx=i;
            for(int j=i-1;j>=0;j--){
                if(str[j].compareTo(str[max_idx])>0){
                    max_idx=j;
                }
            }
            //swap current element with maximum element -> current idx 'i' have correct element
            //A[min_idx] with A[i]
            //Do swap if needed when i==max_idx means we are at middle of array So we don't need
            //to swap element with its own
            if(max_idx!=i){
                String temp=str[i];
                str[i]=str[max_idx];
                str[max_idx]=temp;
            }
        }
    }
    public static void main(String[] args) {
        String[] str={"apple","banana","orange","kiwi","avogadro"};
        sortFruits(str);
        for(String i:str){
            System.out.print(i+" ");
        }
    }
}
