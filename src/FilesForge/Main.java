package FilesForge;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int ARRAY_SIZE = 10_000;
        String PATH_TO_JAVA = "src/FilesForge/Resources/Goods.dat";
        String PATH_TO_JSON = "src/FilesForge/Resources/Goods.json";

        ArrayList<Merch> array = new ArrayList<>();

        for (int i = 0; i < ARRAY_SIZE; i++) {
            array.add(new Merch(i, "Cookie #" + i));
        }

        System.out.println(array.get(99));

        try (OutputStream outputStream = new FileOutputStream(PATH_TO_JAVA)) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            objectOutputStream.writeObject(array);
        }

        try (InputStream inputStream = new FileInputStream(PATH_TO_JAVA)) {
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            final Object o = objectInputStream.readObject();

            ArrayList<Merch> a = (ArrayList<Merch>) o;

            System.out.println(a.get(99));
        }

        ObjectMapper objectMapper = new ObjectMapper();

        try (OutputStream outputStream = new FileOutputStream(PATH_TO_JSON)) {
            objectMapper.writeValue(outputStream, array);
        }

        try (InputStream inputStream = new FileInputStream(PATH_TO_JSON)) {
            ArrayList a = objectMapper.readValue(inputStream, ArrayList.class);

            System.out.println(a.getClass());
            System.out.println(a.get(99));
        }
    }
}
