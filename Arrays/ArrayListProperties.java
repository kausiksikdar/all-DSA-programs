package Arrays;

import java.util.ArrayList;
import java.util.Collections;
public class ArrayListProperties {
    static void swap(ArrayList<Integer> matrix) {
        int i = 0;
        int j = matrix.size() - 1;
        while (i < j) {
            Integer temp = Integer.valueOf(matrix.get(i));
           matrix.set(i, matrix.get(j));
           matrix.set(j, temp);
           i++;
           j--;
        }
        System.out.println(matrix);
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        //To add an element at the end of an arraylist
        list.add(23);
        list.add(34);
        list.add(79);
        list.add(63);
        list.add(58);
        list.add(85);
        System.out.println(list);
        //To add at any particular index of arraylist
        list.add(2,36);
        System.out.println(list);
        //To access a particular index element
        System.out.println(list.get(3));
        //To set a particular data at any index
        list.set(1,56);
        System.out.println(list);
        //To remove a particular element through index
        list.remove(3);
        System.out.println(list);
        //To remove the list by only element
        list.remove(Integer.valueOf(5));//If the elements is not there it will not remove
        System.out.println(list);
        list.remove(Integer.valueOf(56));
        System.out.println(list);
        //Print what the "Remove" method returns
        //If the element is present it will return true and delete it
        System.out.println(list.remove(Integer.valueOf(23)));
        System.out.println(list);
        //If the element is present it will return false
        System.out.println(list.remove(Integer.valueOf(5)));
        //Another way to check whether an element exists in an arraylist or not
        System.out.println(list.contains(36));
        System.out.println(list.contains(90));
        //If we not specify the type of arraylist it will contain every type of things
        ArrayList<Object> l = new ArrayList<>();
        l.add("r");
        l.add(34);
        System.out.println(l);
        //To clear total list
        list.clear();
        System.out.println(list);
        //To swap an arraylist
        ArrayList<Integer> matrix = new ArrayList<>();
        System.out.println();
        matrix.add(12);
        matrix.add(36);
        matrix.add(25);
        matrix.add(89);
        matrix.add(55);
        matrix.add(3);
        matrix.add(20);
        matrix.add(37);
        matrix.add(100);
        matrix.add(54);
        matrix.add(98);
        matrix.add(98);
        matrix.add(2);
        matrix.add(1);
        matrix.add(92);
        matrix.add(889);
        matrix.add(0);
        //Before swapping
        System.out.println(matrix);
        //After swapping by swap function creating by me
        swap(matrix);
        //Swap by the help of Collection properties
        Collections.reverse(matrix);
        System.out.println(matrix);
        //To sort an arraylist
        Collections.sort(matrix);//It sorts in ascending order
        System.out.println(matrix);
        Collections.sort(matrix, Collections.reverseOrder());//To sort descending order -> Collections.reverseorder() is a comparator
        System.out.println(matrix);
        //Compare arraylist of strings
        ArrayList<String> name = new ArrayList<>();
        name.add("Welcome");
        name.add("To");
        name.add("Physics");
        name.add("Wallah");
        System.out.println(name);
        Collections.sort(name);//Ascending order
        System.out.println(name);
        Collections.sort(name, Collections.reverseOrder());//Descending order
        System.out.println(name);
    }
}
