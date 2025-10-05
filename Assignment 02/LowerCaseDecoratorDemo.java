import java.io.*;
class LowerCaseReader extends FilterReader {
    protected LowerCaseReader(Reader in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        return (c == -1) ? c : Character.toLowerCase((char) c);
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        int numRead = super.read(cbuf, off, len);
        if (numRead == -1) return -1;

        for (int i = off; i < off + numRead; i++) {
            cbuf[i] = Character.toLowerCase(cbuf[i]);
        }

        return numRead;
    }
}

public class LowerCaseDecoratorDemo {
    public static void main(String[] args) {

        String input = "aditya JADHAV";

        try (Reader sr = new StringReader(input);
             Reader lr = new LowerCaseReader(sr);
             BufferedReader br = new BufferedReader(lr)) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

