package lesson9_task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Group group = new Group();

        Student st1 = new Student("Alex","Milevsky", Gender.MAN, 0, "Group-1");
        Student st2 = new Student("Masha","Olegor", Gender.WOMAN, 1, "Group-1");
        Student st3 = new Student("Alex","Milevsky", Gender.MAN, 2, "Group-1");
        Student st4 = new Student("Maria","Shapoklyak", Gender.WOMAN, 3, "Group-1");
        Student st5 = new Student("Fill","Dostoiev", Gender.MAN, 4, "Group-1");

        group.setGroupName("Group-1");
        try {
            group.addStudent(st1);
            group.addStudent(st2);
            group.addStudent(st3);
            group.addStudent(st4);
            group.addStudent(st5);
        } catch (GroupOverflowException e) {
            throw new RuntimeException(e);
        }

        System.out.println(group);







    }


}
