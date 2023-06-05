package Sort;

import java.util.Arrays;
import java.util.Random;

public class Quick {
    private int[] ArraySor;
    
    Quick(int ArrayLength, int minArray, int maxArray){

        ArraySor = new int[ArrayLength];

        for(int i = 0; i < ArraySor.length; i++){
            ArraySor[i] = new Random().nextInt(minArray, maxArray);
        }
        System.out.println(Arrays.toString(ArraySor));
    }

    int[] getArraySor(){
        return ArraySor;
    }


    public void quickSort(int[] ArraySor, int low, int high) {
        //завершить,если массив пуст или уже нечего делить
        if (ArraySor.length == 0 || low >= high) return;

        //выбираем опорный элемент
        int middle = low + (high - low) / 2;
        int border = ArraySor[middle];

        //разделияем на подмассивы и меняем местами
        int i = low, j = high;
        while (i <= j) {
            while (ArraySor[i] < border) i++;
            while (ArraySor[j] > border) j--;
            if (i <= j) {
                int swap = ArraySor[i];
                ArraySor[i] = ArraySor[j];
                ArraySor[j] = swap;
                i++;
                j--;
            }
        }

        //рекурсия для сортировки левой и правой части
        if (low < j) quickSort(ArraySor, low, j);
        if (high > i) quickSort(ArraySor, i, high);
    }

    public static void main(String args[]) {
        Quick sort = new Quick(10, 0, 10);
        sort.quickSort(sort.ArraySor, 0, sort.ArraySor.length - 1);
        System.out.println(Arrays.toString(sort.ArraySor));
    }
}