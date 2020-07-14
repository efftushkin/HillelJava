package FilesForge;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class OutputStreamPerfMon extends OutputStream {
    private long start;
    private final OutputStream outputStream;

    public OutputStreamPerfMon(OutputStream outputStream) {
        if (outputStream == null) {
            throw new NullPointerException();
        }

        this.outputStream = outputStream;
    }

    @Override
    public void write(int b) throws IOException {
        if (start == 0) {
            start = System.currentTimeMillis();
        }

    }
}
