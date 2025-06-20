public class keypadCombinations_recursion {
    /*
    keypad represents the string array containing all possible combinations of string
    dig represents the input string
    //Principal of Inclusion and Exclusion is Used
    we have choices to choose which character is going to include in 'res'
    no character will exclude but at different levels different characters are included
    //Time Complexity Analysis
    in this case keypad[7] = string of length 4
    in worst case 4^n recursive call can be made
    and in each call for string concatenation 'n' time is needed
    so the total TC = O(n.4^n)
    Exponential growth of time
     */
    static void combinations(String dig, String[] keypad,String res){
        if(dig.isEmpty()){
            System.out.print(res+" ");
            return;
        }
        int curr_num = dig.charAt(0)-'0';
        String curr_choices = keypad[curr_num];
        for(int i=0;i<curr_choices.length();i++){
            combinations(dig.substring(1),keypad,res+curr_choices.charAt(i));
        }
    }

    public static void main(String[] args) {
        String dig = "27";
        String[] keypad = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        //indexing keypad = 0  1   2     3     4     5     6      7     8      9
        combinations(dig,keypad,"");
    }
}
