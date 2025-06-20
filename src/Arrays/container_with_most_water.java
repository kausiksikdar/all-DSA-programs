package Arrays;

public class container_with_most_water {
    static int mostWater(int[] container){
        int n=container.length;
        int st=0,end=n-1,water=0; //Select two pointers at the end
        while (st<end){
            int base=end-st; //Base determining step which is always dec.
            water=Math.max(base*Math.min(container[end],container[st]),water);
            if(container[end]>container[st]) st++; //As base is always dec. we want max. height so that we can get max. water
            else end--; //As base is always dec. we want max. height so that we can get max. water
        }
        return water;
    }
    public static void main(String[] args) {
        int[] container={4,5,0,2,5,2,2};
        System.out.println(mostWater(container));
    }
}
