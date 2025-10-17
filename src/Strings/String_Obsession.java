package Strings;
import java.util.*;
public class String_Obsession {
    static Map<String, Integer> map = new HashMap<>();
    public static int dfs(String main, List<String> stringList)
    {
        if(map.containsKey(main))
            return map.get(main);

        int maxRemovals = 0;

        for(String string : stringList) {
            int idx = main.indexOf(string);

            if (idx != -1) {
                String newMain = main.substring(0, idx) + main.substring(idx + string.length());
                maxRemovals = Math.max(maxRemovals, 1 + dfs(newMain, stringList));
            }
        }
        map.put(main, maxRemovals);
        return maxRemovals;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        System.out.println("Please Enter the main String : ");
        String main = sc.next();

        List<String> stringList = new ArrayList<>();
        System.out.println("Please the List of Substrings : ");
        while (t-->0)
        {
            String string = sc.next();
            stringList.add(string);
        }

        System.out.println("The max no of removal is : "+dfs(main,stringList));
    }
}
