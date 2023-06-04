package OOP_Begin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Konstructor_experement {
    public static void main(String[] args) throws IOException {
        Test test = new Test(2);
        test.Write();
        test.test(test);
        test.Write();

        test.result(test);
    }
}

class Test{
    int i;
    Test(int b){
        i = b;
    }

    void Write(){
        System.out.println(i);
    }

    void test(Test o){
        o.i = i*2;
    }

    int i(){
        return 12;
    }

    void result(Test o){
        System.out.println(o.i());
    }

}

class Facktorial{
    public static void main(String[] args) {
        var factorial = new  Facktorial();
        var scan = new Scanner(System.in);
        while(scan.hasNext()) System.out.println(factorial.fact(scan.nextLong()));
    }
    long fact(long n){
        long result;
        if (n == 1)return 1;
        result = fact(n - 1) * n;
        return result;
    }
}

class PrivateDemonstration{

    private int i;

    void aVoid(){
        System.out.println(i);
    }

    int setI(int c){
        i = c;
       return i;
    }

    public static void main(String[] args) {
        PrivateDemonstration p = new PrivateDemonstration();
        System.out.println(p.setI(12));
        p.aVoid();
    }
}

class PrivateSteck{

    int leg;

    PrivateSteck(int legith){
        leg = legith;
    }

    private int i[] = new int[leg];
    private int num = -1;

    void input(int telo){
        //Ввод числа в стек
        if (num == (leg - 1)) System.out.println("Стек заполнен");
        else i[num++] = telo;
    }

    int output(){
        if (num == 0){
            System.out.println("Стек пуст");
            return 0;
        }
        else return i[num--];
    }

    public static void main(String[] args) {
        PrivateSteck privateSteck = new PrivateSteck(10);

        privateSteck.input(1);
        System.out.println(privateSteck.output());
    }
}

class UseStatic{
    static int i = 10;

    static void i(){
        System.out.println(i);
    }

    static int getI(){return 10;}

    public static void main(String[] args) {
        System.out.println(getI());
    }
}

class TestStatic {

    static void aVoid (int i){
        //  System.out.println(getI() + i);
    }

    public static void main(String[] args) {
        //System.out.println(getI());
        UseStatic.i();
    }
}
// STOPSHIP: 26.02.2023


class Outer{
    int i;
    void test(){
        Inner inner = new Inner();
        inner.inner();
    }

    class Inner{
        void inner(){
            for (i = 0; i < 10; i++)
            System.out.println("Hello world");
        }
    }
}

class Exemple{
    public static void main(String[] args) {
    Outer outer = new Outer();
    outer.test();
    }
}

class Stringkk{
    String i = "Hello";
    String b = "Hi";

    public static void main(String[] args) {
        Stringkk stringkk = new Stringkk();
        System.out.println(stringkk.i.length() + "\n" + stringkk.i.charAt(1));

        if (stringkk.i.equals(stringkk.b)) System.out.println("Они равны");
        else System.out.println("Они не равны");
    }
}

class Command{
    void i(String i[]){
        for (String x : i){
            System.out.println(x + "\n");
        }
    }

    public static void main(String[] args) {
        Command c = new Command();
        c.i(new String[]{"Hello ", "My ", "Friend."});

    }
}

class TEST{
     static void aVoid(int... i){
        for(int v : i)
        System.out.println(v);
    }

    static int[] io(int...j){
         return j;

    }


    public static void main(String[] args) {
        Random random = new Random();
        int[] k = new int[10];
         for(int i = 0; i < 10; i++){
             k[i] = random.nextInt(0, 10);
         }
        System.out.println(Arrays.toString(io(k)));
        System.out.println(io(k).length);

    }
}

class VarArgs4 {
    static void vaTest(int ... v){
System. out. print ( "vaтest ( int ... ) : "
        + "Количество аргументов: "
        + v.length + "Содержимое: ");
        for(int x : v){
            System.out.print(x + " ");
            System.out.println();
        }

    }
    static void vaтest(boolean ... v){
        System. out .print ( "vaTest (boolean ... ) "
        + "Количество аргументов: "
        + v.length + "Содержимое: ");
    for(boolean x : v) {
        System.out.print(x + " ");
        System.out.println();
    }
    }
    public static void main(String args[]) {
        vaTest(1, 2, 3);// Верно !
        vaтest(true, false, false);// Верно !
        vaTest();// Ошибка:неоднозначность !
    }
}


class Box{
    int anInt;

    Box(){anInt = 0;}
    Box(int i){
        anInt = i;
    }
    Box(Box box){
        anInt = box.anInt;
    }

    int volume(){
        return anInt*4;
    }
}

class BoxChild extends Box{
        int c;

    BoxChild(int Int, int c1){
        super(Int);
        anInt = Int;
        c = c1;
    }

    BoxChild (BoxChild ob){
        super(ob);
        c = ob.c;
    }
    int  a(){return 12;}
}

class Demo{
    public static void main(String[] args) {
        BoxChild boxChild = new BoxChild(10, 10);
        Box box = new Box(12);
        int vol;

        vol = boxChild.volume();
        System.out.println(box.volume());

    }
}


class SuperA{
    int i1;
    SuperA(int i){i1 = i;}
    SuperA(){}
    SuperA(SuperA ob){
        i1 = ob.i1;
    }

}
class SuperB extends SuperA{
    SuperB(int I){
        super.i1 = I;
    }

    SuperB (){
        super(10);

    }
    int anInt(int o){
        this.i1 = o;
        return o;
    }

}
class DemoA{
    public static void main(String[] args) {
        SuperA superA = new SuperA();
        SuperB superB1 = new SuperB();
        System.out.println(superA.i1);
        System.out.println(superB1.i1);
        System.out.println(superA.i1);
        SuperB superB = new SuperB(12);
        SuperA superA1 = new SuperA(superB);
        System.out.println(superA1.i1);

        System.out.println(superB.anInt(10));

    }
}


class A{
    int a;
    int b;
    A(int a,int b){
        this.a = a;
        this.b = b;
    }
    A(){
        this.a = 0;
        this.b = 0;
    }

    void sout(){
        System.out.println("Hello");
    }
}
class B extends A{
    B(int a, int b) {
        super(a, b);
    }

    void A(){
        System.out.println("Hello world");
    }
    int a(){
        super.a = 12;
        return super.a;
    }

    void sout(){
        System.out.println("Hello world");
        super.sout();
    }
}

class demo{
    public static void main(String[] args) {
        Random rand = new Random();
        demo dem = new demo(10);
        B b = new B(12, 11);
        A a;
        a = b;

        System.out.println(a.a);
        System.out.println(a.b);

        b.sout();

        for(int val = 0; val < dem.val; val++){
            dem.xxx(rand.toString());
        }
        dem.showxxx();
    }
    private int val;

    demo(int val){
        this.val = val;
    }
    ArrayList<String> maven = new ArrayList<>();

    int val(){return this.val;}

    void xxx(String name){

        maven.add(name);
    }
    void showxxx(){
        System.out.println(maven);

    }

    void showxxx(int i){
        System.out.println(i);
    }
}