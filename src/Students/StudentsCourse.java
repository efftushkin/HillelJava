package Students;

import java.util.Arrays;

public class StudentsCourse {
    private String name;
    private int lessonsCount;
    private Student[] studentsArray;

    public StudentsCourse() {
        this("Course", 32);
    }

    public StudentsCourse(String name, int lessonsCount) {
        this.name = name;
        this.lessonsCount = lessonsCount;
        studentsArray = new Student[0];
    }

    void addStudent(String name) {
        Student[] newStudentsArray = Arrays.copyOf(studentsArray, studentsArray.length + 1);
        newStudentsArray[newStudentsArray.length - 1] = new Student(name, this.lessonsCount);

        studentsArray = newStudentsArray;
    }

    public Student[] findStudent(String name) {
        Student[] students = new Student[0];

        for (Student student : studentsArray) {
            if (student.getName().equalsIgnoreCase(name)) {
                students = Arrays.copyOf(students, students.length + 1);
                students[students.length - 1] = student;
            }
        }

        return students;
    }

    public void addMark(String name, int lessonNumber, int mark) {
        Student[] students = findStudent(name);

        if (students.length == 0) {
            System.out.println("Not found student " + name);
            return;
        }

        for (Student student : students) {
            student.setMark(lessonNumber, mark);
        }
    }

    public void addPresence(String name, int lessonNumber, boolean presence) {
        Student[] students = findStudent(name);

        if (students.length == 0) {
            System.out.println("Not found student " + name);
            return;
        }

        for (Student student : students) {
            student.setPresence(lessonNumber, presence);
        }
    }

    public void removeStudent(String name) {
        Student[] students = findStudent(name);

        if (students.length == 0) {
            System.out.println("Not found student " + name);
            return;
        }

        int deletedCount = 0;

        Student[] newStudentsArray = new Student[studentsArray.length - students.length];

        for (int i = 0; i < studentsArray.length; i++) {
            if (!studentsArray[i].getName().equalsIgnoreCase(name)) {
                newStudentsArray[i - deletedCount] = studentsArray[i];
            } else {
                deletedCount++;
            }
        }

        studentsArray = newStudentsArray;
    }

    public void clear() {
        studentsArray = new Student[0];
    }

    public boolean contains(String name) {
        return findStudent(name).length > 0;
    }

    public void print() {
        System.out.println("Course " + this.name);

        if (studentsArray.length == 0) {
            System.out.println("No students found");
            return;
        }

        System.out.println("Marks:");

        for (Student student : studentsArray) {
            student.printRatings();
        }

        System.out.println("Presence:");

        for (Student student : studentsArray) {
            student.printPresence();
        }
    }
}
