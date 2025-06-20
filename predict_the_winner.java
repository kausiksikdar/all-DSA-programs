public class predict_the_winner {
    //TC=O(n^2) SC=O(n)
    //Space complexity is O(n) as we take an extra array to mark the existence check
    //Time complexity is O(n^2) as two times iteration was done
    static int predictTheWinnerBrt(int[] person, int n, int personLeft, int index, int k){
        if (personLeft==1){
            for (int j=0;j<person.length;j++){
                if (person[j]==0){
                    return j;
                }
            }
        }
        int steps_of_kill=(k-1)%personLeft;
        while (steps_of_kill!=0){
            index=(index+1)%n;
            while (person[index]==1){
                index=(index+1)%n;
            }
            steps_of_kill--;
        }
        person[index]=1;
        while (person[index]==1){
            index=(index+1)%n;
        }
        return predictTheWinnerBrt(person,n,personLeft-1,index,k);
    }
    //TC=O(n) SC=O(n)
    static int Winner(int n,int k){
        if (n==1) return 0;
        return (Winner(n-1,k)+k)%n;
    }
    public static void main(String[] args) {
        int n=5,k=3; //'n' represents total no of players and 'k' represents after how many persons, a person to be killed
        int[] person=new int[n];
        int winner=predictTheWinnerBrt(person,n,n,0,k);
        System.out.println(winner);
        int winner2=Winner(n,k);
        System.out.println(winner2);
    }
}
