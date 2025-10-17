package Strings;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/*
    There is given a string with some words including position of that words in correct string includes a single
    space between two words, Return the corrected string
*/
public class write_correctly {
    public static void main(String[] args) {
        String str = "is2 Sentence4 This1 a3";
        StringBuilder ans = new StringBuilder();

        //TreeMap is used to maintain the word position in sorted order
        TreeMap<Integer, String> map = new TreeMap<>();

        int i=0,st=0;
        while(i < str.length())
        {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9')
            {
                int pos = str.charAt(i) - '0';
                map.put(pos, str.substring(st,i));
            }
            else if (str.charAt(i) == ' ')
            {
                st = i+1;
            }
            i++;
        }

        for (Map.Entry<Integer, String> entry: map.entrySet())
        {
            ans.append(entry.getValue());
            ans.append(' ');
        }

        String answer = ans.deleteCharAt(ans.length()-1).toString();

        System.out.println(answer);
    }
}
