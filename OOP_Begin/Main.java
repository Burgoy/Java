package OOP_Begin;

public class Main implements OneInterface{
    public static void main(String[] args) {
        for (int i = 0; i< args.length; i++){ System.out.println("args[" + i + "]: " + args[i]);}
    }

    @Override
    public int getNum() {
        return 10;
    }

}
