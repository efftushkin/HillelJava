package Students;

public class Student {
    String name;
    int[] marks;
    boolean[] presence;

    Student(String name) {
        this(name, 32);
    }

    Student(String name, int lessonsCount) {
        this.name = name;
        marks = new int[lessonsCount];
        presence = new boolean[lessonsCount];
    }

    public void setMark(int lessonNumber, int mark) {
        if (marks.length >= lessonNumber && mark >= 0) {
            marks[lessonNumber - 1] = mark;
        }
    }

    public void setPresence(int lessonNumber, boolean presence) {
        if (this.presence.length >= lessonNumber) {
            this.presence[lessonNumber - 1] = presence;
        }
    }

    public void printRatings() {
        boolean haveRatings;
        String delimiter;

        System.out.print(name + ":");

        haveRatings = false;
        delimiter = " ";

        for (int i = 0; i < marks.length; i++) {
            if (marks[i] != 0) {
                System.out.print(delimiter + "lesson " + (i + 1) + ": " + marks[i]);

                haveRatings = true;
                delimiter = "; ";
            }
            if (haveRatings && i == marks.length - 1) {
                System.out.print("\n");
            }
        }

        if (!haveRatings) {
            System.out.println(" no ratings found");
        }
    }

    public void printPresence() {
        boolean haveBeen;
        String delimiter;

        System.out.print(name + ":");

        haveBeen = false;
        delimiter = " ";

        for (int i = 0; i < presence.length; i++) {
            if (presence[i]) {
                System.out.print(delimiter + "lesson " + (i + 1) + ": present");

                haveBeen = true;
                delimiter = "; ";
            }
            if (haveBeen && i == presence.length - 1) {
                System.out.print("\n");
            }
        }

        if (!haveBeen) {
            System.out.println(" did not attend");
        }
    }
}
