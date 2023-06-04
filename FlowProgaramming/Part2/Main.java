package FlowProgaramming.Part2;
//Демонстрация обучению многопоточности в Java.
public class Main {
}

class A{
    synchronized void foo(B b){
        String name = Thread.currentThread().getName();

        System.out.println(name + " вошел в метод A.foo()");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Класс А прерван");
        }
        System.out.println(name + "пытается вызвать метод B.last() ");

        b.last();
    }

    synchronized void last(){
        System.out.println("В методе A.last()");
    }
}

class B {
    synchronized void bar(A a){
        String name = Thread.currentThread().getName();
        System.out.println(name + " вошел в метод B.bar()");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Класс B прерван");
        }
        System.out.println(name + "пытается вызвать метод A.last() ");

        a.last();
    }

    synchronized void last(){
        System.out.println("В метттотде A.last()");
    }
}

class DeadLock implements Runnable{
    A a = new A();
    B b = new B();

    DeadLock(){
        Thread.currentThread().setName("General thread");
        Thread t = new Thread(this, "Соперничающий поток");
        t.start();
        a.foo(b);
        System.out.println("Назад в главный поток");
    }

    @Override
    public void run() {
        b.bar(a);

        System.out.println("Назад в другой порток");
    }

    public static void main(String[] args) {
//        new DeadLock();
        loop1:
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                if(i == 3)break loop1;
                System.out.println("i = " + i + " " + "j = " + j);
            }
        }
    }
}

abstract class test{
    test(){
        System.out.println("Constrycktor test");
    }
    void i(){

    }
    abstract void i2();
}

class Test extends test{
    Test(){
        super();
    }

    @Override
    void i2() {

    }
}

//Зададча:
/*
Написать многопоточную программ у котороая не будет давать доступ к себе 10 секунд*/

class Monitor implements Runnable{
    private int time = 10;

    Monitor(int time){
        this.time = time;
        new Thread(this).start();
    }

    Monitor(){new Thread(this).start();}

    synchronized void aVoid() throws InterruptedException {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < time; i++){
            Thread.sleep(1000);
        }
        notify();
    }

    @Override
    public void run() {
        try {
            new Monitor(10).aVoid();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Client implements Runnable{
    Client(){
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Попытка подключиться");
        Monitor monitor = new Monitor(10);

    }
}

class NewThread implements Runnable{
    private String name;
    public Thread t;
    private boolean suspendFlag;

    NewThread(String name){
        this.name = name;
        t = new Thread(this, this.name);
        System.out.println("Новый поток" + t);
        suspendFlag = false;
        t.start();
    }

    public static NewThread MakeFlow(){
        NewThread newThread= new NewThread("String");
        newThread.t.start();
        return newThread;
    }


    @Override
    public void run() {
        try{
            for (int i = 15; i > 0; i--){
                System.out.println(this.name + ": " + i);
                Thread.sleep(200);
                synchronized (this){
                    while (suspendFlag){
                        wait();
                    }
                }
            }
            } catch (InterruptedException e) {
            System.out.println(name + " прерван");
            e.printStackTrace();
        }
        System.out.println(name + " завершен");
    }

    synchronized void mysuspend(){
        suspendFlag = true;
    }

    synchronized void myresume(){
        suspendFlag = false;
        notify();
    }
}

class SuspendResume{
    public static void main(String[] args) {


        var ob1 = new NewThread("Один");
        var ob2 = new NewThread("Два");


        try {
            Thread.sleep(1000);
            ob1.mysuspend();
            System.out.println("Приостоновка потока Один");
            Thread.sleep(1000);
            ob1.myresume();
            System.out.println("Возобновление потока Один");
            ob1.t.getState();
            ob2.mysuspend();
            System.out.println("Приостоновка потока Два");
            Thread.sleep(1000);
            ob2.myresume();
            System.out.println("Возобновление потока Два");

        }catch (InterruptedException e){
            System.out.println("Главный поток прерван");
            e.printStackTrace();

        }

        try {
            System.out.println("Ожиданмие завершения потоков");
            ob1.t.join();
            ob2.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Завршение глваного потока");
    }
}


