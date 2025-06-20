public class OOPs_Encapsulation{
    static class Customer{
        private String name;
        private int balance;
        private int age;
        Customer(String name, int balance, int age){
            this.name=name;
            this.balance=balance;
            this.age=age;
        }
        //We cannot access the balance directly; we can only access it by the deposit function
        //By this method no one will directly access the balance and disrupt it; only valid amount is deposited in balance
        void deposit(int amount){
            if (amount>0){
                balance+=amount;
            }
            System.out.println("Your current balance is -> "+balance);
        }
        void display(){
            System.out.print(name+" ");
            System.out.print(balance+" ");
            System.out.print(age+" ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Customer A1=new Customer("Kausik",2000,30);
        A1.display();
        A1.deposit(2000);
    }
}
