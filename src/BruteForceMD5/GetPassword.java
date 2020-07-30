package BruteForceMD5;

import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Callable;

public class GetPassword implements Callable<String> {
    int deep;
    char[] symbols;
    String hash;
    int startIndex;
    int endIndex;

    public GetPassword(int deep, String hash, char[] symbols) {
        this(deep, hash, symbols, 0, 0);
    }

    public GetPassword(int deep, String hash, char[] symbols, int startIndex, int endIndex) {
        this.deep = deep;
        this.hash = hash;
        this.symbols = symbols;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public String call() throws Exception {
        return getPass(deep, symbols, "", hash, startIndex, endIndex);
    }

    public String getPass(int deep, char[] chars, String pass, String hash) throws NoSuchAlgorithmException {
        return getPass(deep, chars, pass, hash, 0, 0);
    }

    public String getPass(int deep, char[] chars, String pass, String hash, int startIndex, int endIndex) throws NoSuchAlgorithmException {
        if (Thread.interrupted()) {
//            System.out.println(Thread.currentThread().getName() + " is interrupted");
            return "";
        }

        if (deep == 0) {
            if (HashCheck.check(pass, hash)) {
                return pass;
            } else {
                return "";
            }
        }

        deep--;

        int i = 0;
        int endI = chars.length;

        if (startIndex != 0) {
            i = startIndex;
        }
        if (endIndex != 0) {
            endI = endIndex + 1;
        }

        for (; i < endI; i++) {
            String newPass = pass + chars[i];

            String password = getPass(deep, chars, newPass, hash, 0, 0);

            if (!password.isEmpty()) {
                return password;
            }
        }

        return "";
    }
}
