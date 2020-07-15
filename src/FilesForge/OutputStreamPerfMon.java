package FilesForge;

import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamPerfMon extends OutputStream {
    private long start;
    private final OutputStream outputStream;
    private final String message;

    public OutputStreamPerfMon(OutputStream outputStream, String message) {
        if (outputStream == null) {
            throw new NullPointerException();
        }

        this.outputStream = outputStream;
        this.message = message;
    }

    @Override
    public void write(int b) throws IOException {
        if (start == 0) {
            System.out.println(message);

            start = System.currentTimeMillis();
        }

        outputStream.write(b);
    }

    @Override
    public void close() throws IOException {
        System.out.println("Write duration: " + (System.currentTimeMillis() - start));

        outputStream.close();
    }
}
