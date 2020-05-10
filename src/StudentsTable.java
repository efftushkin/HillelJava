import java.util.Arrays;

public class StudentsTable {
    public static void main(String[] args) {
        String[] students = {"Иванов"};
        int[][] ratings = new int[1][32];

        addStudent(students, ratings, "Петров");
        addStudent(students, ratings, "Сидоров");
    }

    public static void addStudent(String[] students, int[][] ratings, String name) {
        String[] oldStudents = Arrays.copyOf(students, students.length);

        students = new String[students.length + 1];
        students = Arrays.copyOf(oldStudents, oldStudents.length);
        students[students.length - 1] = name;

        int[][] oldRatings = Arrays.copyOf(ratings, ratings.length);

        ratings = new int[ratings.length + 1][32];
        ratings = Arrays.copyOf(oldRatings, oldRatings.length);
    }
}
