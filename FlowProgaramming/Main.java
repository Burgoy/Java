package FlowProgaramming;
//Демонстрация обучению многопоточности в Java.
import java.io.File;
import java.util.Arrays;
import java.util.Random;

public class Main {
    String path = "C:\\JavaFlowProgrammin\\path.txt";
    Main(String path){
        File file = new File(path);
    }
    Main(){
        File file = new File(path);
    }

    public static void main(String[] args) {
    }

}


class WhileNoFlow extends Thread{
    public void run(){
        int[] i = new int[100];
        for (int var = i.length; var > 0; var--){
            System.out.println(var);
        }
    }

    public void run2(){
        int[] i = new int[100];
        for (int var = i.length; var > 0; var--){
            System.out.println(var);
        }
    }





    public static void main(String[] args) {
        WhileNoFlow whileNoFlow = new WhileNoFlow();
        WhileNoFlow2 flow2 = new WhileNoFlow2();

        whileNoFlow.start();
        flow2.start();

    }

}
class WhileNoFlow2 extends Thread {
    public void run() {
        int[] i = new int[100];
        for (int var = 1; var < i.length+1; var++) {
            System.out.println(var);
        }
    }
}

class Test implements Runnable{

    @Override
    public void run(){
        try{
            throw new Exception();
        }catch (Exception e){
            for (int i = 0; i < e.getStackTrace().length; i++) System.out.println(e.getStackTrace()[i]);
        }
        finally {
            System.out.println("Конец потока");
        }
    }


    public static void main(String[] args) {
        var stack = new WhileNoFlow2();
        Thread t = Thread.currentThread();
        t.setName("flow_01");
        Test test = new Test();
        test.run();
        stack.start();


    }
}

class Test2 implements Runnable{
    Thread t;

    Test2(){
        t = new Thread(this, "" );
    }
    @Override
    public void run() {

    }
}


//Управление главным потоком
class CurrentThreadDemo{
    public static void main(String[] args) {
        Thread t = Thread.currentThread();

        System.out.println("Текуший поток: " + t);

        t.setName("Thread №1");
        System.out.println("После изменения имени: " + t);

        try{
            for (int var = 5; var > 0; var--){
                System.out.println(var);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Поток прерван");
            e.printStackTrace();
        }
    }
}

class NewThread implements Runnable{

    Thread t;

    NewThread(){
        t = new Thread(this, "Демонстационный поток");
        System.out.println("Дочерний поток: " + t);
        t.start();
    }

    @Override
    public void run() {
        try{
            for (int var = 5; var > 0; var--){
                System.out.println("Дочерний поток: " + var);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Дочерний поток прерван" + "\n");
            e.printStackTrace();
        }

        System.out.println("Дочерний поток завершен");
    }
}


class DemoThread{
    public static void main(String[] args) {
        new NewThread();

        try{
            for (int var = 5; var > 0; var--){
                System.out.println("Главный поток: " + var);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Главный поток прерван" + "\n");
            e.printStackTrace();
        }

        System.out.println("Гланый поток завершен");

    }
}

class Test3 implements Runnable{
    Test3(){
        Thread t = new Thread(this, "Name");
        Thread b = new Thread("PP");

        System.out.println(b);
    }

    @Override
    public void run(){
        System.out.println("Запуск потока");
    }

    public static void main(String[] args) {
        Test3 test3 = new Test3();
    }
}


class NewThread2 extends Thread{
    NewThread2(String hello){
        System.out.println("Hello " + hello);
        super.setName("Дочерний поток");
        System.out.println("Дочерний поток: " + this);
        start();
    }

    @Override
    public void run() {
        try{
            for (int i = 10; i > 0;i--){
                System.out.println("Дочерний поток: " + i);
                sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Прерывание потока");
            e.printStackTrace();
        }
        finally {
            System.out.println("Конец дочернего потока");
        }
    }
}

class ExtendThread{
    public static void main(String[] args) {
        new NewThread2("Name");


    }

}

class NewManyThreads implements Runnable{


    String name;
    Thread t;

    NewManyThreads(String threadname){
        name = threadname;
        t = new Thread(this, name);
        System.out.println("Сохдание нового потока: " + t);
        t.start();
    }


    @Override
    public void run() {
        try{
            for (int i = 10; i > 0;i--){
                System.out.println( name + " поток: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Прерывание потока " + name);
            e.printStackTrace();
        }
        finally {
            System.out.println(name + " завершон");
        }
    }
}

class MultiThreadDemo{
    public static void main(String[] args) throws InterruptedException {
        var t1 = new NewManyThreads("First");
        var t2 = new NewManyThreads("Second");
        var t3 = new NewManyThreads("Third");


        t1.t.join();
        t2.t.join();
        t3.t.join();

        try{
            System.out.println("Ожидание завершения других потоков");
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.out.println("Главный поток прерван");
            e.printStackTrace();
        }
        finally {
            System.out.println("Главный поток завершен");
        }
    }
}

class DemoJoin{
    public static void main(String[] args) {
        var t1 = new NewManyThreads("Thread 1");
        var t2 = new NewManyThreads("Thread 2");
        var t3 = new NewManyThreads("Thread 3");



        System.out.println("Thread 1 is beeping " + t1.t.isAlive());
        System.out.println("Thread 2 is beeping " + t2.t.isAlive());
        System.out.println("Thread 3 is beeping " + t3.t.isAlive());

        try {
            System.out.println("Ожидание завершения потоков");
            t1.t.join();
            t2.t.join();
            t3.t.join();

        } catch (InterruptedException e) {
            System.out.println("Главный поток прерван");
            e.printStackTrace();
        }

        System.out.println("Thread 1 is over " + t1.t.isAlive());
        System.out.println("Thread 2 is over " + t2.t.isAlive());
        System.out.println("Thread 3 is over " + t3.t.isAlive());
        System.out.println("Измененя в программе");
        System.out.println("Конец главного потока");

    }
}

class DemoJoiqn implements Runnable{
    String name;
    Thread t;
    public DemoJoiqn(String name) {
        this.name = name;
        t = new Thread(this, this.name);
        t.start();
    }



    @Override
    public void run() {
        System.out.println("Происходит поток");
        for (int i = 0; i < 100; i++){
            try {
                Thread.sleep(100);
                System.out.println(i);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public static void main(String[] args) throws InterruptedException {
        var demo = new DemoJoiqn("Thread");
        demo.t.join();
        System.out.println("Конец основного потока");
    }

}

class CallMe{
    void call(String msg){
        System.out.print("[" + msg);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("Поток прерван");
            e.printStackTrace();
        }
        System.out.println("]");

    }
}

class Caller implements Runnable{

    private String msg;
    CallMe target;
    Thread t;

    public Caller(CallMe target, String msg){
        this.msg = msg;
        this.target = target;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        synchronized (target){
            target.call(msg);
        }

    }
}

class test implements Runnable{
    Random rand = new Random();
    test t;
    Thread thread;
    private String name;
    int[] array;
    test(String name, int legit){
        this.name = name;
        array = new int[legit];
        for(int i = 0; i < array.length; i++){
            array[i] = rand.nextInt(0, 10);
        }
        System.out.println(Arrays.toString(array));

        thread = new Thread(this, this.name);
        thread.start();
    }

    @Override
    public void run() {
        synchronized (thread){
            for(int var = 0; var < array.length - 1; var++){
                for (int num = 0; var < array.length - var - 1; num++){
                    if(array[num] > array[num+1]){
                        int zamena =  array[num];
                        array[num] = array[num + 1];
                        array[num+1] = zamena;
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        try{
            new test("One", 10);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }
}

class FlowExemple implements Runnable{

    private String name = "Flow_Example";
    private String words;
    Thread t;

    FlowExemple(String name, String words){
        this.name = name;
        this.words = words;
        t = new Thread(this, this.name);
        t.start();
    }
    FlowExemple(String words){
        this.words = words;
        t = new Thread(this, this.name);
        t.start();

    }

    @Override
    synchronized public void run() {
        System.out.println(words);
    }

    public static void main(String[] args) throws InterruptedException {
        FlowExemple ob1 = new FlowExemple( "Object_01", "1");
        FlowExemple ob2 = new FlowExemple( "Object_02", "2");
        FlowExemple ob3 = new FlowExemple( "Object_03", "3");

        ob1.t.join();
        ob2.t.join();
        ob3.t.join();
    }
}

class Q{
    private int n;
    private boolean ValueSet = false;


    synchronized int get(){
        while (!ValueSet){
            try {
                wait();
            }catch (InterruptedException e){e.printStackTrace();}
        }
        System.out.println("Получено: " + n);
        ValueSet = false;
        notify();
        return n;
    }

    synchronized void put(int n){
        while (ValueSet){
            try {
                wait();
            }catch (InterruptedException e){e.printStackTrace();}
            this.n = n;
            ValueSet = true;
            System.out.println("Отпралено: " + this.n);
            notify();
        }
    }
}
class Producer implements Runnable{
    Q q = new Q();

    public Producer(Q q){
        this.q = q;
        new Thread(this, "Поставщик").start();
    }
    @Override
    public void run() {
        int i = 0;
        try {
            while(true){
                Thread.sleep(1000);
                q.put(i++);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable{
    Q q;
    Consumer(Q q){
        this.q = q;
        new Thread(this, "Потребитель").start();
    }

    @Override
    public void run() {
        while (true){
            q.get();
        }
    }
}

class PC{
    public static void main(String[] args) {
        var q = new Q();
        new Producer(q);
        new Consumer(q);
        System.out.println("Для остановки нажми Ctrl+C");}
}


class newQ{
    int n;
    boolean valueSet = false;

    synchronized int get() {
        while (!valueSet)
            try{
                wait();
            } catch (InterruptedException e) {
                System.out.println("Исключение типа InterruptedException перехвачено");
                e.printStackTrace();
            }
        System.out.println("Отправлено" + n);
        valueSet = false;
        notify();
        return n;
    }
    synchronized void put(int n){
        while (!valueSet)
            try{
                wait();
            } catch (InterruptedException e) {
                System.out.println("Исключение типа InterruptedException перехвачено");
                e.printStackTrace();
            }
        this.n = n;
        System.out.println("Отправлено" + n);
        valueSet = false;
        notify();
    }
}

/*Этот метод для теста новой формы записи цикла который
    не был описан ни в одной книге блять,
    только ввиде примера боже почему так*/
class Ftest{
    private boolean var;

    Ftest(boolean var){this.var = var;}

    void p(){
        System.out.println("The begin while p");
        while (!var)
            System.out.println("This i");
    }

    public static void main(String[] args) {
        new Ftest(false).p();
    }
}

class Program {

    public static void main(String[] args) {

        Store store=new Store();
        Producer1 producer = new Producer1(store);
        Consumer1 consumer = new Consumer1(store);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
// Класс Магазин, хранящий произведенные товары
class Store{
    private int product=0;
    public synchronized void get() {
        while (product<1) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        product--;
        System.out.println("Покупатель купил 1 товар");
        System.out.println("Товаров на складе: " + product);
        notify();
    }
    public synchronized void put() {
        while (product>=3) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        product++;
        System.out.println("Производитель добавил 1 товар");
        System.out.println("Товаров на складе: " + product);
        notify();
    }
}
// класс Производитель
class Producer1 implements Runnable{

    Store store;
    Producer1(Store store){
        this.store=store;
    }
    public void run(){
        for (int i = 1; i < 6; i++) {
            store.put();
        }
    }
}
// Класс Потребитель
class Consumer1 implements Runnable{

    Store store;
    Consumer1(Store store){
        this.store=store;
    }
    public void run(){
        for (int i = 1; i < 6; i++) {
            store.get();
        }
    }
}

class NewPRoduct implements Runnable{
    private int product;



    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    @Override
    public void run() {
        System.out.println("Hello world");
    }
}

class Potreb implements Runnable{
    private int[] array;
    Random rand = new Random();
    Potreb potreb;
    Thread t;

    Potreb(String name, int lenght){
        this.array = new int[lenght];
        for(int i = 0; i < array.length; i++){
            array[i] = rand.nextInt(0, 15);
        }
        t = new Thread(this, name);
        System.out.println(Arrays.toString(array));
        t.start();
    }



    synchronized int[] sort(){
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < array.length - 1; i++){
            for(int i1 = 0; i1 < array.length - i - 1; i1++){
                int var = array[i1];
                array[i1] = array[i];
                array[i] = var;
            }
        }

        notify();
        return array;
    }

    @Override
    public void run() {
        System.out.println("Начало потока: " + t.getName());
        System.out.println(Arrays.toString(sort()));
    }

    public static void main(String[] args) {
        var var1 = new Potreb("Thread 1", 10);
        var var2 = new Potreb("Thread 2", 100);
        var var3 = new Potreb("Thread 3", 1000);
    }
}

