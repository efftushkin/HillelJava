package FilesForge;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int ARRAY_SIZE = 10_000;

        String PATH_TO_JAVA_OBJECTS = "src/FilesForge/Resources/StudentsObjects.dat";
        String PATH_TO_JAVA_ARRAY_LIST = "src/FilesForge/Resources/StudentsArrayList.dat";
        String PATH_TO_JSON_ARRAY = "src/FilesForge/Resources/StudentsObjects.json";
        String PATH_TO_JSON_ARRAY_LIST = "src/FilesForge/Resources/StudentsArrayList.json";

        long startMillis = 0;

        Student[] array = new Student[ARRAY_SIZE];
        ArrayList<Student> arrayList = new ArrayList<>(ARRAY_SIZE);

        for (int i = 0; i < ARRAY_SIZE; i++) {
            Student student = new Student(i, "Student #" + i);
            array[i] = student;
            arrayList.add(student);
        }

        testRWJavaObjects(array, PATH_TO_JAVA_OBJECTS);
        testRWJavaArrayList(arrayList, PATH_TO_JAVA_ARRAY_LIST);
        testRWJSONArray(array, PATH_TO_JSON_ARRAY);
        testRWJSONArrayList(arrayList, PATH_TO_JSON_ARRAY_LIST);
    }

    private static void testRWJavaObjects(Student[] array, String path) throws IOException, ClassNotFoundException {
        OutputStream outputStream = new FileOutputStream(path);
        outputStream = new OutputStreamPerfMon(outputStream, "Measuring output of objects to internal format");

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        for (Student student : array) {
            objectOutputStream.writeObject(student);
        }

        objectOutputStream.writeObject(null);

        outputStream.close();

        array = new Student[array.length];

        System.out.println("Measuring input of objects from internal format");
        long start = System.currentTimeMillis();

        try (InputStream inputStream = new FileInputStream(path)) {
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            int i = 0;

            Object o = objectInputStream.readObject();
            while (o != null || i < array.length) {
                array[i] = (Student) o;
                o = objectInputStream.readObject();
                i++;
            }

            System.out.println("Example: " + array[99]);
        }

        System.out.println("Read duration: " + (System.currentTimeMillis() - start));
    }

    private static void testRWJavaArrayList(ArrayList<Student> arrayList, String path) throws IOException, ClassNotFoundException {
        OutputStream outputStream = new FileOutputStream(path);
        outputStream = new OutputStreamPerfMon(outputStream, "Measuring output of ArrayList to internal format");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(arrayList);

        outputStream.close();

        System.out.println("Measuring input of ArrayList from internal format");
        long start = System.currentTimeMillis();

        try (InputStream inputStream = new FileInputStream(path)) {
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            final Object o = objectInputStream.readObject();

            ArrayList<Student> a = (ArrayList<Student>) o;

            System.out.println("Example: " + a.get(99));
        }

        System.out.println("Read duration: " + (System.currentTimeMillis() - start));
    }

    private static void testRWJSONArray(Student[] array, String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        System.out.println("Measuring output of array of objects to json");
        long start = System.currentTimeMillis();

        OutputStream outputStream = new FileOutputStream(path);
        //outputStream = new OutputStreamPerfMon(outputStream, "Measuring output of array of objects to json");

        objectMapper.writeValue(outputStream, array);

        outputStream.close();

        System.out.println("Write duration: " + (System.currentTimeMillis() - start));

        System.out.println("Measuring input of array from json");
        start = System.currentTimeMillis();

        try (InputStream inputStream = new FileInputStream(path)) {
            Student[] a = objectMapper.readValue(inputStream, Student[].class);

            System.out.println("Example: " + a[99]);
        }

        System.out.println("Read duration: " + (System.currentTimeMillis() - start));
    }

    private static void testRWJSONArrayList(ArrayList<Student> arrayList, String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        System.out.println("Measuring output of ArrayList to json");
        long start = System.currentTimeMillis();

        try (OutputStream outputStream = new FileOutputStream(path)) {
            objectMapper.writeValue(outputStream, arrayList);
        }

        System.out.println("Write duration: " + (System.currentTimeMillis() - start));

        System.out.println("Measuring input of ArrayList from json");
        start = System.currentTimeMillis();

        try (InputStream inputStream = new FileInputStream(path)) {

            ArrayList<Student> a = objectMapper.readValue(inputStream, ArrayList.class);

            System.out.println("Class: " + a.getClass());
            System.out.println("Example: " + a.get(99) + " (this is not element of Student)");
        }

        System.out.println("Read duration: " + (System.currentTimeMillis() - start));
    }
}
