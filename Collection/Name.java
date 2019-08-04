package Collection;

import java.util.Map;
import java.util.TreeMap;

public class Name {
    public static void main(String[] args) {
        String[] arr = {"Vasya", "Dimon", "Vova", "Vasya", "Igor", "Vova", "Yarik", "Vova", "Yarik", "Misha"};

        Map<String, Integer> countMap = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            String a = arr[i];
            Integer currentNum = countMap.get(a);
            countMap.put(a, currentNum == null ? 1 : currentNum + 1);
        }
        System.out.println(countMap);

        Phonebook ph = new Phonebook();

        ph.add("Vasya", "3456568885");
        ph.add("Yarik", "0398588932");
        ph.add("Misha", "0194775856");
        ph.add("Vasya", "4202057604");


        System.out.println(ph.get("Vasya"));
        System.out.println(ph.get("Misha"));


        }
    }
