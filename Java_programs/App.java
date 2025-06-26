package Java_programs;
public class App{
    //We have to make every individual features public to access it from anywhere
    public int price = 20000;
    public String name = "Sikdar";
    public String str1 = "within class : I am a public member";
    public void printInside(){
        System.out.println("within class : I am a public method");

    }

    public static void main(String[] args) {
        App a = new App();
        System.out.println(a.str1);
        a.printInside();
        System.out.println();
        App2 b = new App2();
        System.out.println(b.str2);
        b.printOutside();
    }
}
//As the below class is not public we cannot call it outside the package
class App2{
    int price = 32000;
    String name = "Kausik";
    public String str2 = "Within package Outside class : I am a public member";
    void printOutside(){
        System.out.println("Within package Outside class : I am a public method");
    }
}