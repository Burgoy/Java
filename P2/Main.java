package P2;

import P1.Protection;

import javax.security.auth.callback.Callback;
import java.util.Scanner;

public class Main extends P1.Protection{
    void aVoid(){
        System.out.println(n_pro);
        System.out.println(n_pub);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.show();
    }
}

class SomeClass{
    java.util.Scanner scanner = new Scanner(System.in);
    P1.Protection protection = new Protection();

    void i(){
        protection.n_pub = scanner.nextInt();
    }
}

class Demo extends Main{
    Main main = new Main();
    SomeClass someClass = new SomeClass();
}

class Demo1 implements Callback{
    public void callback(int p){
        System.out.println("Реалезует callback " + p);
    }
    {
        int k;
    }
    void aVoid(){
    }

    public static void main(String[] args) {
        System.out.println();
    }
}