package LogicSurchElement;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RundomGenerate_Surch {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Впиши пределы массива");
        int max = scanner.nextInt();
        int[] i = new int[max];
        boolean k = false;

        System.out.println("Впиши пределы генерации рандомного числа");
        int min = scanner.nextInt();
        System.out.println(" ");
        int max1 = scanner.nextInt();

        System.out.println("Впиши искомое значение");
        int num = scanner.nextInt();
        System.out.println(num);

        for (int i1 = 0; i1 < i.length; i1++) {
            i[i1] = random.nextInt(min, max1);
        }

        for(int x: i){
            if (x == num){
                k = true;
                break;
            }
        }

        if (k){
            System.out.println("Число найдено");
        }else System.out.println("неповезло");

        System.out.println(Arrays.toString(i));

        for ( int j = min; j < i.length; j++){
            for(int f = j; f < i.length; f++){
                System.out.print(".");
            }
            System.out.println();
        }
    }
}

