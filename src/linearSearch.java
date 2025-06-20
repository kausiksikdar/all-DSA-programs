import java.util.Scanner;
public class linearSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of your Array");
        int n = sc.nextInt();
        int[] arr= new int[n];
        System.out.println("Enter the array elements : ");
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the Key");
        int a = sc.nextInt();
        boolean flag = true;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==a){
                flag = false;
                System.out.println("Element Found at index "+i);
                break;
            }
        }
        if(flag){
            System.out.println("Element not Found");
        }
    }
}
