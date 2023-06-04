package OOP_Begin;

import java.util.Random;

public class Kniga {
    public static void main(String[] args) {
        Stack stack = new Stack(0);

        for (int item = 0; item < 10; item++) stack.push(item);
        for (int item = 0; item < 10; item++) System.out.println(stack.take());
    }

}

class Stack {
    int stck[] = new int[10];
    int tos;
    int Item;
    Random random = new Random();


    //Вершина стека
    Stack (int item){
        item = Item;
        tos = -1;
    }

    //размещение элемента в стеке
    void push(int item){
        tos++;
        if(tos == 10){
            System.out.println("Full empty");
        }else stck[tos] = item;
    }

    int take(){
       if (tos < 0){
           System.out.println("Null empty");
           return 0;
       }else return stck[tos--];
    }

    //размещение чисел в стеке
    void RandomNumSteck(int NumMin, int NumMax){
        for (int i = 0; 0 < 10; i++) stck[i] = random.nextInt(NumMin, NumMax);
    }

    void Sort(){
        Sort sort = new Sort();
        sort.equals(stck);
    }
}