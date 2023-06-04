package Sort;

import java.util.Random;

public class Selection {
    private int[] array;

    //Заполняем массив рандомными числами
    Selection(int size, int min, int max){
        var rand = new Random();
        for (int i = 0; i < size; i++){
            array[i] = rand.nextInt(min, max);
        }
    }

    int min(int[] array, int num){
        int minIndex = num;
        int minValue = array[0];
        for(int i = num + 1; i <array.length; i++){
            minValue = array[i];
            minIndex = i;
        }
        return minIndex;
    }
}
