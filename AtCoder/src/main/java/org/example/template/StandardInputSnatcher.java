package org.example.template;

import java.io.IOException;
import java.io.InputStream;

public class StandardInputSnatcher extends InputStream {

    private final StringBuilder buffer = new StringBuilder();
    private static final String crlf = System.getProperty("line.separator");

    public void inputln(String str) {
        buffer.append(str).append(crlf);
    }

    @Override
    public int read() throws IOException {
        if (buffer.length() == 0) {
            return -1;
        }
        int result = buffer.charAt(0);
        buffer.deleteCharAt(0);
        return result;
    }
}
