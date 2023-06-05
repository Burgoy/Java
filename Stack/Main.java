package Stack;

import java.util.Arrays;
import java.util.Random;

public class Main implements id{

    public void i(){

        System.out.println("hhh");
    }

    @Override
    public void setLegit(int i) {

        System.out.println("Реалезация интерфейса в классе Interface" + i + Int.legit);
    }

    public static void main(String[] args) {
        id id = new Interface();
        id.setLegit(1);
        id.i();
    }
}


interface id{
    void i();
    void setLegit(int i);
    int legit = 10;

}

abstract class Int implements id{

    @Override
    public void setLegit(int i) {
        System.out.println("Реалезация интерфейса в классе Int" + i);
    }
}




interface IntStack{
    void push(int item);//save element to array
    int pop();//take element from array
}

class FixeStack implements IntStack{

    private int stck[];
    private int tos;

    FixeStack (int size){
        stck = new int[size];
        tos = -1;
    }


    @Override
    public void push(int item) {
        if(stck.length == tos){
            System.out.println("Шина заполнена");
        }else tos++;
    }

    @Override
    public int pop() {
        if(tos < 0){
            System.out.println("Шина пуста");
            return 0;
        }else return stck[tos--];
    }

    public static void main(String[] args) {

        IntStack intStack;

        var mySteck1 = new FixeStack(5);
        var mySteck2 = new FixeStack(8);

        for (int i = 0; i < mySteck1.stck.length; i++)mySteck1.push(i);
        for (int i = 0; i < mySteck2.stck.length; i++)mySteck2.push(i);

        System.out.println("Стек 1: ");
        for (int i = 0; i < mySteck1.stck.length; i++) System.out.println(mySteck1.stck[i]);;

        System.out.println();



        System.out.println("Стек 2: ");
        for (int i = 0; i < mySteck2.stck.length; i++) System.out.println(mySteck2.stck[i]);;

    }
}

class DynamicSteck implements IntStack{

    private int tos;
    private int[] stck;

    DynamicSteck(int size){
        stck = new int[size];
        tos = -1;
    }

    @Override
    public void push(int item) {
        if (tos == stck.length){
            do{
                int temp[] = new  int[stck.length + 1];
                for (int i = 0; i > stck.length; i++)temp[i] = stck[i];

                stck = temp;
                stck[++tos] = item;
            }while (tos != stck.length);
        }else
            stck[++tos] = item;
    }

    @Override
    public int pop() { if(tos < 0){
        System.out.println("Шина пуста");
        return 0;
    }else return stck[tos--];
    }
}

class TestStack{
    public static void main(String[] args) {

    }
}

