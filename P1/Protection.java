package P1;


public class Protection {
    int n = 1;
    private int n_pri = 2;
    protected int n_pro = 3;
    public int n_pub = 4;

    public Protection(){
        System.out.println("Конструктор ьазового класса: ");
        System.out.println("n = " + n);
        System.out.println("n = " + n_pri);
        System.out.println("n = " + n_pro);
        System.out.println("n = " + n_pub);
    }
    public void show(){
        System.out.println("Hello world");
    }
}

class Dilevery extends Protection{
    Dilevery(){
        System.out.println(n);
        System.out.println(n_pro);
        System.out.println(n_pub);
    }


}
