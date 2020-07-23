package BruteForceMD5;

import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, ExecutionException, InterruptedException {
        String hash = "5ebe2294ecd0e0f08eab7690d2a6ee69";
        String password = "";
        //f016441d00c16c9b912d05e9d81d894d = very
        //5ebe2294ecd0e0f08eab7690d2a6ee69 = secret
        //13d70e09909669272b19647c2a55dacb
        long start = System.currentTimeMillis();
        long end = start;
        int THREADS_COUNT = 26;

        char[] smallLetters = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};


        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_COUNT);
        Future<String>[] submit = new Future[THREADS_COUNT];

        for (int deep = 1; deep < 9; deep++) {
            if (deep <= 4) {
                password = new GetPassword(deep, hash, smallLetters).getPass(deep, smallLetters, "", hash);
            } else {
                GetPassword[] getter = new GetPassword[THREADS_COUNT];

                int startIndex = 0;
                int endIndex = -1;

                for (int i = 0; i < THREADS_COUNT; i++) {
                    startIndex = endIndex + 1;

                    endIndex += smallLetters.length / THREADS_COUNT;

                    if (i == THREADS_COUNT - 1) {
                        endIndex = smallLetters.length - 1;
                    }

                    submit[i] = executorService.submit(new GetPassword(deep, hash, smallLetters, startIndex, endIndex));
                }

                for (; ; ) {
                    Thread.sleep(1000);

                    boolean allIsDone = true;

                    for (int i = 0; i < THREADS_COUNT; i++) {
                        if (submit[i].isDone()) {
                            password = submit[i].get();

                            if (!password.isEmpty()) {
                                allIsDone = true;
                                break;
                            }
                        } else if (allIsDone) {
                            allIsDone = false;
                        }
                    }
                    if (allIsDone) {
                        break;
                    }
                }
            }

            if (!password.isEmpty()) {
                break;
            } else {
                end = System.currentTimeMillis();
                System.out.print((end - start) + " millis: ");
                System.out.println("Not " + deep + " symbols");
                start = end;
            }
        }

        executorService.shutdownNow();

        end = System.currentTimeMillis();
        System.out.println((end - start) + " millis: the password is " + password);
    }
}
