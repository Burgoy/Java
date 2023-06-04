package OOP_Begin;

public class Kniga2 {
    public static void main(String[] args) {
        Nums nums_first = new Nums();
        Nums nums_second = new Nums(10, 15);
    }
}

class Nums{
    int a;
    int b;

    Nums(int i, int c){
        a = i;
        b = c;
    }

    Nums(){
        a = 0;
        b = 0;
    }

    String equalsTo(Nums i) {
        boolean h;
        if (a == 0 && b == 0) {
            h = false;
        } else h = true;
        String j = null;
        if (h) {
            if (i.a == a && i.b == b) {
                j = "true";
            } else j = "false";
        } else System.out.println("Введите параметры");

        return j;
    }
}