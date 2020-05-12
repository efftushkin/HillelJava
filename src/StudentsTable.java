public class StudentsTable {
    public static void main(String[] args) {
        String[] students = new String[1];
        int[][] ratings = new int[1][32];

        //void addStudent(String name = "Иванов")
        String name = "Иванов";

        if (students[0] == null) {
            students[0] = name;
        } else {
            String[] newStudents = new String[students.length + 1];
            int[][] newRatings = new int[students.length + 1][32];

            for (int i = 0; i < students.length; i++) {
                newStudents[i] = students[i];
                newRatings[i] = ratings[i];
            }

            newStudents[newStudents.length - 1] = name;

            students = newStudents;
            ratings = newRatings;
        }
        //addStudent(String name = "Петров")
        name = "Петров";

        if (students[0] == null) {
            students[0] = name;
        } else {
            String[] newStudents = new String[students.length + 1];
            int[][] newRatings = new int[students.length + 1][32];

            for (int i = 0; i < students.length; i++) {
                newStudents[i] = students[i];
                newRatings[i] = ratings[i];
            }

            newStudents[newStudents.length - 1] = name;

            students = newStudents;
            ratings = newRatings;
        }

        int lessonNumber;

        //Иванов
        name = "Иванов";
        lessonNumber = 1;
        if (!addRating(students, ratings, name, lessonNumber, 9)) {
            System.out.println("Can't add rating for student " + name + ", lesson " + lessonNumber);
        }
        lessonNumber = 33;
        if (!addRating(students, ratings, name, lessonNumber, 8)) {
            System.out.println("Can't add rating for student " + name + ", lesson " + lessonNumber);
        }
        lessonNumber = 31;
        if (!addRating(students, ratings, name, lessonNumber, 10)) {
            System.out.println("Can't add rating for student " + name + ", lesson " + lessonNumber);
        }
        lessonNumber = 5;
        if (!addRating(students, ratings, name, lessonNumber, 9)) {
            System.out.println("Can't add rating for student " + name + ", lesson " + lessonNumber);
        }
        lessonNumber = 1;
        if (!addRating(students, ratings, name, lessonNumber, 10)) {
            System.out.println("Can't add rating for student " + name + ", lesson " + lessonNumber);
        }
        //Петров
        name = "Петров";
        lessonNumber = -1;
        if (!addRating(students, ratings, name, lessonNumber, 8)) {
            System.out.println("Can't add rating for student " + name + ", lesson " + lessonNumber);
        }
        lessonNumber = 4;
        if (!addRating(students, ratings, name, lessonNumber, 10)) {
            System.out.println("Can't add rating for student " + name + ", lesson " + lessonNumber);
        }
        lessonNumber = 6;
        if (!addRating(students, ratings, name, lessonNumber, 10)) {
            System.out.println("Can't add rating for student " + name + ", lesson " + lessonNumber);
        }
        //Сидоров
        name = "Сидоров";
        lessonNumber = 10;
        if (!addRating(students, ratings, name, lessonNumber, 10)) {
            System.out.println("Can't add rating for student " + name + ", lesson " + lessonNumber);
        }

        printStudents(students, ratings);
    }

    public static boolean addRating(String[] students, int[][] ratings, String name, int lessonNumber, int rating) {
        int studentIndex = findStudent(students, name);

        if (studentIndex >= 0) {
            if (lessonNumber >= 0 && lessonNumber < ratings[studentIndex].length) {
                ratings[studentIndex][lessonNumber - 1] = rating;
                return true;
            }
        }

        return false;
    }

    public static int findStudent(String[] students, String name) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].equalsIgnoreCase(name)) {
                return i;
            }
        }

        return -1;
    }

    public static void printStudents(String[] students, int[][] ratings) {
        if (students[0] == null) {
            System.out.println("We don't have any students");
        }

        boolean haveRatings;
        String delimiter;

        System.out.println("Our Students' ratings:");

        for (int i = 0; i < students.length; i++) {
            System.out.print(students[i] + ":");

            haveRatings = false;
            delimiter = " ";

            for (int j = 0; j < ratings[i].length; j++) {
                if (ratings[i][j] != 0) {
                    System.out.print(delimiter + "lesson " + (j + 1) + ": " + ratings[i][j]);

                    haveRatings = true;
                    delimiter = "; ";
                }
                if (haveRatings && j == ratings[i].length - 1) {
                    System.out.print("\n");
                }
            }

            if (!haveRatings) {
                System.out.println("no ratings found");
            }
        }
    }
}
