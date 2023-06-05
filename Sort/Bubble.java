package Sort;

public class Bubble{
    Random random = new Random();
    int MinNum, MaxNum, Legit;
    Sort(int MinNum, int MaxNum, int Legit){
        this.Legit = Legit;
        this.MaxNum = MaxNum;
        this.MinNum = MinNum;
    }

    int[] CreateMasive(){
        int i[] = new int[Legit];
        for (int var = 0; var < Legit; var++) i[var] = random.nextInt(MinNum, MaxNum);
        return i;
    }

    int[] SortPuz(int[] array){
        array = this.CreateMasive();
        for(int i = 0; i < array.lenght - 1; i++){
            for(int j = 0; j < array.lenght-i-1; j++){
                if (array[j] > array[j+1]){
                    int var = array[j];
                    array[j] = array[j+1];
                    array[j+1] = var;
                }
            }
        }
        return array;
    }
}

