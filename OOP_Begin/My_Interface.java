package OOP_Begin;

interface OneInterface{
    int i = 10;
    int getNum();
    default void Result(){
        int result = i + getNum();
    }
}