package Sort;

import java.util.Arrays;
import java.util.Random;

public class Quick {
    int[] array;
    private int min;
    private int max;
    Quick(int length, int min, int max){
        this.min = min;
        this.max = max;
        array = new int[length];
        for(int i = 0; i < array.length; i++){
            array[i] = new Random().nextInt(min, max);
        }
        System.out.println(Arrays.toString(array));

    }
    int serch(int ser){
        int num = min;
        int nums = 0;
        while(ser == num){
            if(ser == array[num]){
                return num;
            }
            num++;
        }
        return ser;
    }

    public static void main(String[] args) {
        System.out.println(new Quick(10, 0, 10).serch(5));
    }
}