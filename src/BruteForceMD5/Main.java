package BruteForceMD5;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String hash = "5ebe2294ecd0e0f08eab7690d2a6ee69";
        String password = "";

        char[] smallLetters = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        for (int deep = 1; deep < 6; deep++) {
            password = getPass(deep, smallLetters, password, hash);
            if (!password.isEmpty()) {
                break;
            } else {
                System.out.println("Not " + deep + " symbols");
            }
        }

        System.out.println(password);
    }

    public static String getPass(int deep, char[] chars, String pass, String hash) throws NoSuchAlgorithmException {
        if (deep == 0) {
            if (HashCheck.check(pass, hash)) {
                System.out.println(pass);
                return pass;
            } else {
                return "";
            }
        }

        deep--;

        for (int i = 0; i < chars.length; i++) {
            String newPass = pass + String.valueOf(chars[i]);

            if (HashCheck.check(newPass, hash)) {
                return newPass;
            }

            String password = getPass(deep, chars, newPass, hash);

            if (!password.isEmpty()) {
                return password;
            }
        }

        return "";
    }
}
