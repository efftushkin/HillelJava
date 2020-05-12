package Students;

import java.util.Arrays;

public class Students {
    Student[] studentsArray;

    public void addStudent(String name, int lessonsCount) {
        Student student = new Student(name, lessonsCount);
        addStudent(student);
    }

    public void addStudent(String name) {
        Student student = new Student(name);
        addStudent(student);
    }

    void addStudent(Student student) {
        if (studentsArray == null) {
            studentsArray = new Student[1];
            studentsArray[0] = student;
        } else {
            //Student[] newStudentsArray = new Student[studentsArray.length + 1];
            Student[] newStudentsArray = Arrays.copyOf(studentsArray, studentsArray.length + 1);
            newStudentsArray[newStudentsArray.length - 1] = student;

            studentsArray = newStudentsArray;
        }
    }
}
