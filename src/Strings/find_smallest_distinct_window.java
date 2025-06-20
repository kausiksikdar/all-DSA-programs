package Strings;

public class find_smallest_distinct_window {
    static int findSmallestDistinctWindow(String s){
        int first=0,second=0,len=s.length(),diff=0;
        int[] count=new int[256];
        //Find out all different characters
        for (int i=0;i<s.length();i++){
            if (count[s.charAt(i)]==0) diff++;
            count[s.charAt(i)]++;
        }
        //Make all the places of count array=0
        for (int i=0;i<256;i++){
            count[i]=0;
        }
        //check for window
        while (second<s.length()){

            //Inc. phase of window.....
            //While diff!=0 i.e. all distinct char not traversed,
            while (diff!=0 && second<s.length()){
                 if(count[s.charAt(second)]==0){
                     diff--;
                 }
                 //Update the freq. of count array simultaneously
                 count[s.charAt(second)]++;
                 second++;
            }
            //Finally update the length of window
            len=Math.min(len,second-first);

            //Dec. phase of window.....
            //While diff==0 i.e. all distinct char we get in our window, now dec. the size of window and check that is possible or not
            while (diff!=1){
                len=Math.min(len,second-first);
                count[s.charAt(first)]--;
                if(count[s.charAt(first)]==0) diff++;
                first++;
            }
        }
        return len;
    }
    public static void main(String[] args) {
        String s="abbaabcbcacb";
        System.out.println(findSmallestDistinctWindow(s));
    }
}
