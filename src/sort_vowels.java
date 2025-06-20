public class sort_vowels {
    static String sortVowels(String s){
        int[] lower=new int[26];
        int[] upper=new int[26];
        StringBuilder S=new StringBuilder(s);
        StringBuilder ans= new StringBuilder();
        int index=0;
        while (index<S.length()){
            if(S.charAt(index)=='A'||S.charAt(index)=='E'||S.charAt(index)=='I'||S.charAt(index)=='O'||S.charAt(index)=='U'){
                upper[S.charAt(index)-'A']++;
            }
            if(S.charAt(index)=='a'||S.charAt(index)=='e'||S.charAt(index)=='i'||S.charAt(index)=='o'||S.charAt(index)=='u'){
                lower[S.charAt(index)-'a']++;
            }
            index++;
        }
        for (int i=0;i< upper.length;i++){
            char ch=(char)('A'+i);
            while (upper[i]!=0){
                ans.append(ch);
                upper[i]--;
            }
        }
        for (int i=0;i< lower.length;i++){
            char ch=(char)('a'+i);
            while (lower[i]!=0){
                ans.append(ch);
                lower[i]--;
            }
        }
        index=0;
        while (index<S.length()){
            if(S.charAt(index)=='A'||S.charAt(index)=='E'||S.charAt(index)=='I'||S.charAt(index)=='O'||S.charAt(index)=='U') {
                S.setCharAt(index,'#');
            }
            if(S.charAt(index)=='a'||S.charAt(index)=='e'||S.charAt(index)=='i'||S.charAt(index)=='o'||S.charAt(index)=='u'){
                S.setCharAt(index,'#');
            }
            index++;
        }
        int first=0,second=0;
        while (second<ans.length()){
            if(S.charAt(first)=='#'){
                S.setCharAt(first, ans.charAt(second));
                second++;
            }
            first++;
        }
        return S.toString();
    }
    public static void main(String[] args) {
        String s="leetcOdE";
        System.out.println(sortVowels(s));
    }
}
