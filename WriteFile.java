import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class WriteFile {    // adding outputs to file
    public static String filename;
    public static void append(String str)   throws IOException {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
            writer.append(str);
            writer.close();

    }
}
