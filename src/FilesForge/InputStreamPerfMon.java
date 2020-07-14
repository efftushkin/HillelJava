package FilesForge;

import java.io.IOException;
import java.io.InputStream;

public class InputStreamPerfMon extends InputStream {
    private long start;
    private final InputStream inputStream;

    public InputStreamPerfMon(InputStream inputStream) {
        if (inputStream == null) {
            throw new NullPointerException();
        }

        this.inputStream = inputStream;
    }

    @Override
    public int read() throws IOException {
        if (start == 0) {
            start = System.currentTimeMillis();
        }

        int read = inputStream.read();

        if (read == -1) {
            System.out.println("Read duration: " + (System.currentTimeMillis() - start));
        }

        return read;
    }
}
