package core_java.dummy;

import java.io.*;

public class TryWithResource {

    static String firstLineOfFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } finally {
            br.close();
        }
    }

    static void copy(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            try {
                byte[] buf = new byte[1000];
                int n;
                while ((n = in.read(buf)) >= 0)
                    out.write(buf);
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }

    public static void main(String[] args) {
    }
}
