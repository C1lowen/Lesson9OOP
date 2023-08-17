package lesson9_task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        createArray();
    }

    public static void createArray() {
        List<Integer> list = new ArrayList<>();
        fillArray(list);

        System.out.println(list);

        list.remove(0);
        list.remove(0);
        list.remove(list.size()-1);

        System.out.println(list);

    }

    public static void fillArray(List<Integer> list){
        Random rn = new Random();

        for(int i = 0; i < 10; i++){
            list.add(rn.nextInt(20));
        }
    }
}
