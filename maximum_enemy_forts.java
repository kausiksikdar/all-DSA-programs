public class maximum_enemy_forts {
    static int maxEnemyForts(int[] f){
        int r=0,j=0;
        for(int i=0;i<f.length;i++){
            if(f[i]!=0){
                if(f[j]==-f[i]) r=Math.max(r,i-j-1);
                j=i;
            }
        }return r;
    }

    public static void main(String[] args) {
        int[] A = {0,0,1,-1};
        System.out.println(maxEnemyForts(A));
    }
}
