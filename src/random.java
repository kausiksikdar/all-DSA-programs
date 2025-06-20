import java.util.Random;

public class random {
    public static void main(String[] args) {
        Random r = new Random();
        //r.nextInt(upper-lower)+lower
        System.out.println(r.nextInt(10-0)+1);
    }
}
