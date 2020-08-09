package SecListMD5PasswordSearch;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class FindPassword implements Callable<String> {
    ArrayList<String> passwords;
    String hash;

    public FindPassword(ArrayList<String> passwords, String hash) {
        this.passwords = passwords;
        this.hash = hash;
    }

    @Override
    public String call() throws Exception {
        return findPass(passwords, hash);
    }

    public String findPass(ArrayList<String> passwords, String hash) {
        for (String password : passwords) {
            if (HashCheck.check(password, hash)) {
                return password;
            }
        }

        return "";
    }
}
