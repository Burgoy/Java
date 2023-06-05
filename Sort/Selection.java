package Sort;


import java.util.Arrays;
import java.util.Random;

public class Selection {
    int[] array;
    private int min;
    private int max;
    Selection(int length, int min, int max){
        this.min = min;
        this.max = max;
        array = new int[length];
        for(int i = 0; i < array.length; i++){
            array[i] = new Random().nextInt(min, max);
        }
        System.out.println(Arrays.toString(array));

    }
   void selectionSort() {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIdx]) {
                    minIdx = j;
                }
            }
            int var = array[minIdx];
            array[minIdx] = array[i];
            array[i] = var;
        }
    }


    public static void main(String[] args) {
        Selection selection = new Selection(10, 0, 10);
        selection.selectionSort();
        System.out.println(Arrays.toString(selection.array));
    }
}