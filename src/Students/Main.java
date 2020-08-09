package Students;

public class Main {
    public static void main(String[] args) {
        StudentsCourse students = new StudentsCourse("Hillel Java Elementary", 32);
        students.addStudent("St1");
        students.addStudent("Newbee");
        students.addStudent("St2");

        students.addMark("St1", 2, 10);
        students.addMark("St1", 4, 9);
        students.addMark("St1", 6, 8);
        students.addMark("St1", 8, 10);

        students.addMark("St2", 1, 10);
        students.addMark("St2", 3, 8);
        students.addMark("St2", 5, 9);
        students.addMark("St2", 7, 10);

        students.addPresence("st1", 2, true);
        students.addPresence("st1", 4, true);
        students.addPresence("st1", 6, true);
        students.addPresence("st1", 8, true);

        students.addPresence("st2", 1, true);
        students.addPresence("st2", 3, true);
        students.addPresence("st2", 5, true);
        students.addPresence("st2", 7, true);

        students.print();

        System.out.println("\n--Add Newbee--");
        students.addStudent("Newbee");
        students.print();

        System.out.println("\n--Remove Newbee--");
        students.removeStudent("Newbee");
        students.print();

        String name;
        name = "st1";
        if(students.contains(name)) {
            System.out.println("Course contains student " + name);
        } else {
            System.out.println("Course doesn't contain student " + name);
        }
        name = "st3";
        if(students.contains(name)) {
            System.out.println("Course contains student " + name);
        } else {
            System.out.println("Course doesn't contain student " + name);
        }

        System.out.println("\n--Clear course--");
        students.clear();
        students.print();
    }
}
