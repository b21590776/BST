import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Exp2 {

    public static void main(String[] args) throws IOException {
        WriteFile.filename = args[1];                           // arg[1] output file name
        Files.deleteIfExists(Paths.get(WriteFile.filename));    // deleting output file if exist
        ReadFile commands = new ReadFile(args[0]);              // arg[0] input file name
        Selecter select = new Selecter();
        select.operation(commands.getLines());                  // selects operation according to commands

    }
}
