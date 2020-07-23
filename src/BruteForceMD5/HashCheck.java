package BruteForceMD5;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashCheck {
    public static boolean check(String pass, String hash) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(pass.getBytes());
        byte[] digest = md.digest();

        String newHash = DatatypeConverter.printHexBinary(digest);

        return hash.equalsIgnoreCase(newHash);
    }
}
