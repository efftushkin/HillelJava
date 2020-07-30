package SecListMD5PasswordSearch;

import BruteForceMD5.HashCheck;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, FileNotFoundException {
        String PATH_TO_SEC_LIST = "src/SecListMD5PasswordSearch/Resources/OneMillionPasswords.txt";

        String hash = "5f50dfa5385e66ce46ad8d08a9c9be68";
        //f016441d00c16c9b912d05e9d81d894d = very
        //5ebe2294ecd0e0f08eab7690d2a6ee69 = secret
        //13d70e09909669272b19647c2a55dacb = goodforyou
        //5f50dfa5385e66ce46ad8d08a9c9be68

        long start = System.currentTimeMillis();
        long counter = 0;
        boolean isFound = false;

        InputStream inputStream = new FileInputStream(PATH_TO_SEC_LIST);
        Scanner scanner = new Scanner(inputStream);

        while (scanner.hasNextLine()) {
            counter++;

            String nextLine = scanner.nextLine();

            if (HashCheck.check(nextLine, hash)) {
                System.out.println((System.currentTimeMillis() - start) + " millis: the password is " + nextLine);
                isFound = true;
                break;
            }
        }

        if (!isFound) {
            System.out.println((System.currentTimeMillis() - start) + " millis: checked " + counter + " passwords, no one found");
        }
    }
}
