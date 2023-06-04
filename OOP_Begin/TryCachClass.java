package OOP_Begin;

import java.util.Arrays;
import java.util.Random;

public class TryCachClass {
    Random rand = new Random();

    private boolean var;
    private int leghit;
    private int[] i = new int[leghit];

    TryCachClass(int leghit){
        this.leghit = leghit;
        for (int i = 0; i < leghit; i++)this.i[i] = rand.nextInt(0, 10);
        System.out.println(Arrays.toString(this.i));
    }

    void Take() throws ArrayIndexOutOfBoundsException {
        int num = this.i.length - 1;
        do {
            try{
                System.out.println(this.i[num]);
                num--;
                var = true;
            }catch (ArrayIndexOutOfBoundsException e){
                e.printStackTrace();
                var = false;
            }

        }while(var);
    }

    public static void main(String[] args) throws Throwable {
        TryCachClass t= new TryCachClass(10);
        t.Take();
    }
}

class Test2{
    public static void main(String[] args) {
        int i, var;
        try{
            i = 0;
            var = 2/i;
        }catch (ArithmeticException e){
            System.out.println("Ошибка при вычислении");

            System.out.println("Exception: " + e);
            for (int n = 0; n < e.getStackTrace().length; n++) System.out.print(e.getStackTrace()[n]);

            var = 0;
        }
        System.out.println("\n" + "var = " + var);
    }
}

class MultipleCatches{
    public static void main(String[] args) throws ArrayIndexOutOfBoundsException, ArithmeticException{
        int c[] = new int[0];
        try{

            throw new ArithmeticException();


        }
        catch (ArithmeticException | ArrayIndexOutOfBoundsException e){
            System.out.println("Exception: " + e);
            for (int n = 0; n < e.getStackTrace().length; n++) System.out.print(e.getStackTrace()[n]);
        }

        System.out.println( '\n' +"Paste operators try/catch");
        System.out.println(Arrays.toString(c));
    }
}

class TEs{
    void i(Object a){

    }
}

class MultipleCatches2 {

    void i(){}
    public static void main(String args[]) throws Exception{

        TEs tEs = new TEs();
        tEs.i(tEs);

        try {
            int i[];

            throw new ArithmeticException();
        } catch (ArithmeticException е) {
            System.out.println("Дeлeниe на нуль: " + е);
        } catch (ArrayIndexOutOfBoundsException е) {
            System.out.println("Oшибкa индексации за пределами массива: " + е);
        }
        System.out.println("После блока операторов try/catch.");
    }
}