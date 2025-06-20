public class longest_substring_without_repeating_character {
    //Sliding Window protocol
    static int longestSubstringWithoutRepeatingCharacter(String s) {
        int[] count = new int[256];
        int first = 0, second = 0, len = 0;
        while (second < s.length()) { //Till all string is not traversed
            while (count[s.charAt(second)] != 0) { //If current char index, pointed by second is not zero i.e. it has already updated previously so inc. first and make index occurence, pointed by first = zero
                count[s.charAt(first)] = 0;
                first++;
            }
            count[s.charAt(second)] = 1;//Else inc. second by 1
            len = Math.max(len, second - first + 1);//After every iteration store the updated length in 'len'
            second++;
        }
        return len;
    }

    public static void main(String[] args) {
        String s = "ababcddd";
        System.out.println(longestSubstringWithoutRepeatingCharacter(s));
    }
}
