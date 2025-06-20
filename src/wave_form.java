public class wave_form {
    static void printWaveForm(int[][] num){
        for(int j=0;j<num.length;j++){
            if(j%2==0){
                for(int i=0;i<num.length;i++){
                    System.out.print(num[i][j]+" ");
                }
            }
            else{
                for(int i = num.length-1;i>=0; i--){
                    System.out.print(num[i][j]+" ");
                }
            }
        }
    }
    public static void main(String[] args) {
        int[][] arr={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printWaveForm(arr);
    }
}
