public class OOPS {
    //As it is created outside the class and static keyword is used so the total_customer is created only once it will share by all the objects (Example of Static data member)
    //It is created when class is created; all the other attributes will be created when object will be created
    static int total_customer=0;
    static int amount=0;
    static int total_balance=0;
    static class Customer {
        String name;
        int account_no;
        int balance;

        //Default Constructer
        Customer() {
            System.out.println("Only Constructer is called, nothing to print, only object is created...");
            total_customer++;
        }

        //Parameterised Constructer, multiple constructer can be created in a same class
        Customer(String name, int account_no, int balance) {
            this.name = name;
            this.account_no = account_no;
            this.balance = balance;
            total_customer++;
            total_balance+=balance;
            System.out.print("Parameterized Constructor -> ");
        }

        //Parameterised Copy Constructor
        Customer(Customer B) {
            name = B.name;
            account_no = B.account_no;
            balance = B.balance;
            System.out.print("Copy Constructor -> ");
        }
        void deposit(int amount){
            if(amount>0)  {
                System.out.print("After deposit -> ");
                total_balance+=amount;
                balance+=amount;
            }
        }
        void withdraw(int amount){
            if(amount>0 && amount<=balance){
                System.out.print("After Withdraw -> ");
                total_balance-=amount;
                balance-=amount;
            }
        }
        void display() {
            System.out.print(name+" ");
            System.out.print(account_no+" ");
            System.out.print(balance+" ");
            System.out.println();
        }
        //Java has A automatic Garbage Collector which act as a Destructor which release the dynamically allocated memory taking by this class in heap
        //Object is not deleted by Destructor but the memory allocated dynamically for this class is released (from Heap)
        //Object will be deleted when main function will be deleted (from Stack)
    }

    public static void main(String[] args) {

        //Java has a by default constructer And we also can create it
        Customer c4 = new Customer();
        //As we are not giving any argument while creating c4, it will get some default value (null, 0 ,0)
        c4.display();


        //We can create a parameterized constructor
        Customer c = new Customer("Kausik", 123, 1000);
        c.display();


        Customer c1 = new Customer("Mohit", 225, 2000);
        c1.display();
        c1.deposit(2000);
        c1.display();
        c1.withdraw(3000);
        c1.display();


        //Java has a by default copy constructer And we also can create it
        // Created Copy Constructer
        Customer c2 = new Customer(c);
        c2.display();


        //Only one copy of the total_customer is created and shared by everyone
        System.out.println(total_customer);


        System.out.println(total_balance);
    }
}
