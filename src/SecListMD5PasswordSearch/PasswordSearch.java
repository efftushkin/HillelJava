package SecListMD5PasswordSearch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PasswordSearch {
    private final int BATCH_SIZE = 10_000_000;
    private final int CHECK_FREQ = 1_000_000;
    private final int THREADS_COUNT = 20;

    private final String PATH_TO_PASSWORDS;
    private final String hash;
    private String password = "";

    private final ExecutorService executorService;
    Future<String>[] submit = new Future[THREADS_COUNT];
    FindPassword[] finder = new FindPassword[THREADS_COUNT];


    public PasswordSearch(String PATH_TO_PASSWORDS, String hash) throws ExecutionException, InterruptedException {
        this.PATH_TO_PASSWORDS = PATH_TO_PASSWORDS;
        this.hash = hash;

        this.executorService = Executors.newFixedThreadPool(THREADS_COUNT);
    }

    public String search() throws FileNotFoundException, ExecutionException, InterruptedException {
        ArrayList<String> passwords = new ArrayList<>(BATCH_SIZE);

        InputStream inputStream = new FileInputStream(PATH_TO_PASSWORDS);
        Scanner scanner = new Scanner(inputStream);

        long start = System.currentTimeMillis();
        long counter = 0;
        boolean isFound = false;

        while (scanner.hasNextLine()) {
            counter++;

            String nextLine = scanner.nextLine();

            if (counter % CHECK_FREQ == 0) {
                isFound = checkThreads();

                if (isFound) {
                    System.out.println("(" + millisToString(System.currentTimeMillis() - start) + ") "
                            + (System.currentTimeMillis() - start) + " millis: the password is " + password);

                    break;
                }
            }

            passwords.add(nextLine);

            if (counter % BATCH_SIZE == 0) {
                System.out.println("(" + millisToString(System.currentTimeMillis() - start) + ") " + (System.currentTimeMillis() - start) + " millis: " + counter + " lines read");

                isFound = !startThread(executorService, submit, finder, passwords, hash);

                if (isFound) {
                    System.out.println("(" + millisToString(System.currentTimeMillis() - start) + ") "
                            + (System.currentTimeMillis() - start) + " millis: the password is " + password);

                    break;
                }

                passwords = new ArrayList<>(BATCH_SIZE);
            }
        }
        if (passwords.size() > 0 && !isFound) {
            startThread(executorService, submit, finder, passwords, hash);
        }

        if (!isFound) {
            System.out.println("(" + millisToString(System.currentTimeMillis() - start) + ") " + (System.currentTimeMillis() - start) + " millis: checked " + counter + " passwords, no one found");
            return "";
        }

        return password;
    }

    private boolean checkThreads() throws ExecutionException, InterruptedException {
        for (int i = 0; i < THREADS_COUNT; i++) {
            if (submit[i] == null) {
                continue;
            }

            if (submit[i].isDone()) {
                password = submit[i].get();

                if (!password.isEmpty()) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean startThread(ExecutorService executorService, Future<String>[] submit, FindPassword[] finder, ArrayList<String> passwords, String hash) throws ExecutionException, InterruptedException {
        while(true) {
            for (int i = 0; i < submit.length; i++) {
                if (submit[i] == null) {
                    submit[i] = executorService.submit(new FindPassword(passwords, hash));
                    return true;
                }

                if (submit[i].isDone()) {
                    password = submit[i].get();

                    if (!password.isEmpty()) {
                        return false;
                    }

                    submit[i] = executorService.submit(new FindPassword(passwords, hash));
                    return true;
                }
            }
        }
    }

    private String millisToString(long millis) {
        long seconds = millis / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;

        seconds = seconds - minutes * 60;
        minutes = minutes - hours * 60;

        StringBuilder result = new StringBuilder();

        if (hours < 10) {
            result.append("0");
        }
        result.append(hours);
        result.append(":");

        if (minutes < 10) {
            result.append("0");
        }
        result.append(minutes);
        result.append(":");

        if (seconds < 10) {
            result.append("0");
        }
        result.append(seconds);

        return result.toString();
    }
}
