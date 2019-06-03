import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


public class ReadFile { // reading file with array list
    private static ArrayList<String> lines = new ArrayList<String>();

    public ReadFile(String pathname) {
        try {
            for(String line: Files.readAllLines(Paths.get(pathname)))
                lines.add(line);
        } catch (IOException e){
            System.out.println("File could not be read!");
        }
    }

    public ArrayList<String> getLines(){
        return lines;	}
}