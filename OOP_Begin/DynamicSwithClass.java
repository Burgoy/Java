package OOP_Begin;

import java.util.Arrays;
import java.util.Random;

public class DynamicSwithClass {
    public static void main(String[] args) {
        A1 a1;
        A1 getA1 = new A1();
        B1 getB1 = new B1();
        C1 getC1 = new C1();

        getA1.print();

        a1 = getA1;
        a1.print();

        a1 = getB1;
        a1.print();

        a1 = getC1;
        a1.print();
    }

}

class A1{
    void print(){
        System.out.println("Class A");
    }
}
class B1 extends A1{
    void print() {
        System.out.println("Class B");
    }
}
class C1 extends A1{
    void print() {
        super.print();
    }
}


abstract class Figure{
    double dim1;
    double dim2;

    Figure(double dim1, double dim2){
        this.dim1 = dim1;
        this.dim2 = dim2;
    }

    abstract double area();

}

class Rectangle extends Figure{
    Rectangle(double dim1, double dim2) {
        super(dim1, dim2);
    }

    @Override
    double area() {
        System.out.println("В области четырехугольника");
        return dim1*dim2;
    }
}

class Triangle extends Figure{
    Triangle(double dim1, double dim2){
        super(dim1, dim2);
    }

    @Override
    double area() {
        System.out.println("В области треугольника");
        return dim1*dim2/2;
    }

    abstract class VoidA{
        void aVoid(){}
    }
}

class Result{
    public static void main(String[] args) throws InterruptedException {

        Figure figure;

        Rectangle rectangle = new Rectangle(12, 11);

        System.out.println("Площадь равна " + rectangle.area());

        Triangle triangle = new Triangle(13, 13);

        System.out.println("Площадь равна: " + triangle.area());


        figure= triangle;
        System.out.println(figure.area());


        A3 a3 = new A3();
        A3 a4 = new A5();

        System.out.println(a3.equals(a4));
    }
}


class A3 extends Object{
    Object a;

    protected Object clone(){
        return a;
    }
    A3(){
        this.a = null;
    }
    public static class A4{
         static final int i(int i){
            return i;
        }

    }


}

class A5 extends A3{
    int i;
}

class Balance{
    String  name;
    int bal;

    Balance (String name, int bal){
        this.name = name;
        this.bal = bal;
    }

    void show(){
        if(bal > 0){
            System.out.println( "--> " + name + ": $" + bal);
        }
    }
}

class Main1{
    public static void main(String[] args) {
        Balance current[] = new Balance[3];

        current[0] = new Balance("Vitaly", 1000);
        current[1] = new Balance("Vasa", 10);
        current[2] = new Balance("Masha", 300);
        for(int i = 0; i < current.length; i++) current[i].show();
    }
}



class Puz{

    Random random = new Random();

    private int SizeArray;
    private int MaxRandReg;
    private int MinRandReg;
    private int[] ArraySort;

    Puz(int SizeArray, int MaxRandReg, int MinRandReg){
        this.SizeArray = SizeArray;
        this.MaxRandReg = MaxRandReg;
        this.MinRandReg = MinRandReg;
        ArraySort = new int[SizeArray];

        for (int i = 0; i < ArraySort.length; i++){
            ArraySort[i] = random.nextInt(MinRandReg, MaxRandReg);
        }

        System.out.println("Изначальный масив: "+Arrays.toString(ArraySort));
    }
    void Sort(int[] array){

        int n = array.length;

        for(int i = 0; i < n -1; i++){
            for (int j = 0; j < n -i-1; j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j]= array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        System.out.println("Отсортированный массив: " + Arrays.toString(array));
    }

    void Sort(){
        int[] array = ArraySort;
        int n = array.length;

        for(int i = 0; i < n -1; i++){
            for (int j = 0; j < n -i-1; j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j]= array[j+1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println("Отсортированный массив: " + Arrays.toString(array));
    }

    public static void main(String[] args) {
        Random random = new Random();
        Puz p = new Puz(10, 10, 1);
        p.Sort();

        Puz p2 = new Puz(100, 100, 0);
        p2.Sort();

        String helo = "Name";

        System.out.println(helo.charAt(0));
    }


}

class myPyzir{
    private int arrey[];
    private int max, min, lenght;
    Random rand = new Random();

    myPyzir(int min, int max, int lenght){
        this.max = max;
        this.min = min;
        this.lenght = lenght;
        this.arrey = new int[lenght];

        for(int i = 0; i < arrey.length; i++)arrey[i] = rand.nextInt(min, max);
    }

    void sort(){
        for (int i = 0; i < lenght - 1; i++){
            for(int j = 0; j < lenght - i - 1; j++){
                if(arrey[j] > arrey[j+1]){
                    int temp = arrey[j+1];
                    arrey[j+1] = arrey[j];
                    arrey[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        myPyzir pyz = new myPyzir(0,10,10);
        System.out.println(Arrays.toString(pyz.arrey));
        pyz.sort();
        System.out.println(Arrays.toString(pyz.arrey));

        int[] i = {5, 4, 9, 1, 0};

        for(int k = 0; k < i.length-1; k++){
            for(int j = 0; j < i.length - k - 1; j++){
                if(i[j] > i[j+1]){
                    int temp = i[j+1];
                    i[j+1] = i[j];
                    i[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(i));
    }
}

class Steck{
    private int[] stck;
    private int tos;

    Steck(int size){
        stck = new int[size];
        tos = -1;
    }

    void push(int i){
        if(tos == stck.length -1) System.out.println("Array is full");
        else {
            tos++;
            stck[tos] = i;
        }
    }

    int take(){
        if(tos < 0) {
            System.out.println("Array is empty");
            return 0;
        }
        else {
            int num = stck[tos];
            tos--;
            return num;
        }
    }
}

interface intA{
    int i = 10;
    void i(int i);


    default String myString(){
        return "НЕ Реалезован";
    }
}

interface intB{

    static int i(int i){
        return i;
    }

    default String myString(String name){
        return "No one" + name;
    }
}



class TestINterface implements intA, intB{

    @Override
    public void i(int i) {
        System.out.println("Hello world");
    }

    @Override
    public String myString() {
        return intB.super.myString(" Vital");
    }

    public static void main(String[] args) {
        var test = new TestINterface();
        System.out.println(test.myString().toUpperCase());
        System.out.println(intB.i(10));
        int i = intA.i;


    }
}



interface IntStack{
    void push(int item);//Save element in stack
    int pop();//take element from stack

    private int[] getElement(int n){
        int[] stack = new int[n];
        for (int i = 0; i < n; i++) {
            stack[i] = pop();
        }
        return stack;
    }


    default int[] popNElements(int n){
        return getElement(n);
    }

    default int[] SkipAndPopElement(int skip, int n){
        getElement(skip);
        return getElement(n);
    }
}

class StackInterface implements IntStack{
    @Override
    public void push(int item) {

    }

    @Override
    public int pop() {
        return 10;
    }
}