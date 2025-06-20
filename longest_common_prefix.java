public class longest_common_prefix {
    static String longestCommonPrefixS(String[] arr) {
        StringBuilder ans=new StringBuilder();
        int len = Integer.MAX_VALUE;
        for (String s : arr) {
            if (s.length() < len) {
                len = s.length();
            }
        }
        int j = 0;
        boolean flag = false;
        while (j <= len - 1) {
            for (String s : arr) {
                if (s.charAt(j) == arr[0].charAt(j)){
                    flag = true;
                }
                else return ans.toString();
            }
            if (flag)  ans.append(arr[0].charAt(j));
            j++;
        }
        return ans.toString();
    }
    static int longestCommonPrefix(String[] arr) {
        int len = Integer.MAX_VALUE;
        for (String s : arr) {
            if (s.length() < len) {
                len = s.length();
            }
        }
        int j = 0, count = 0;
        boolean flag = false;
        while (j <= len - 1) {
            for (String s : arr) {
                if (s.charAt(j) == arr[0].charAt(j)) flag = true;
                else return count;
            }
            if (flag) count++;
            j++;
        }
        return count;
    }
    public static void main(String[] args) {
        String[] arr = {"geeksforgeeks", "geeks", "geeks", "geezer"};
        System.out.println(longestCommonPrefixS(arr));
    }
}
