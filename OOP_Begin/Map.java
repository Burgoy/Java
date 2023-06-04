package Collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//Изучение Map
public class Map {
    HashMap<String, String> map = new HashMap<>();

    void Put(String Kay, String Data){
        map.put(Kay, Data);
    }

    String getMap(String kay){
        return map.get(kay);
    }

    public static void main(String[] args) {
        Map map1 = new Map();

        for (int i = 0; i < 10; i++){
            map1.Put("kay" + i*2, "Data" + i);
        }

        List<String> KayList = new ArrayList(map1.map.keySet());
        List<String> DataList = new ArrayList<>(map1.map.values());
        List<java.util.Map.Entry<String, String>> list = new ArrayList<>(map1.map.entrySet());

        System.out.println(list);
        System.out.println(map1.getMap("kay16"));
    }
}
