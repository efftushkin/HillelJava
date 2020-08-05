package SecListMD5PasswordSearch;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashCheck {
    public static boolean check(String pass, String hash) {
        MessageDigest md = null;

        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        md.update(pass.getBytes());
        byte[] digest = md.digest();

        String newHash = DatatypeConverter.printHexBinary(digest);

        return hash.equalsIgnoreCase(newHash);
    }
}
