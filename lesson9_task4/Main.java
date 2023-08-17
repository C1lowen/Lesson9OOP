package lesson9_task4;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Deque<String> deque = new ArrayDeque<>();
        deque.add("Sheldon");
        deque.add("Leonard");
        deque.add("Volovitc");
        deque.add("Kutrapalli");
        deque.add("Penny");

        System.out.print("Введите количество стаканов: ");
        int count = sc.nextInt();

        queueStatus(deque, count);

        System.out.println(deque);
    }

    public static void queueStatus(Deque<String> deque, int count){
        for(int i = 0; i < count; i++){
            deque.add(deque.getFirst());
            deque.add(deque.getFirst());
            deque.removeFirst();
        }
    }


}
