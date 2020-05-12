package Students;

public class Student {
    String name;
    int[] marks;
    int[] presence;

    Student(String name) {
        this(name, 32);
    }

    Student(String name, int lessonsCount) {
        this.name = name;
        marks = new int[lessonsCount];
        presence = new int[lessonsCount];
    }
}
