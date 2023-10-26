import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PlainTextWriter implements TextWriter{
    @Override
    public void write(String filename, String text) {
        try (PrintWriter writer = new PrintWriter(filename)) {

            writer.print(text);
            System.out.println("Text has been written to the file: " + filename);
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }

    }
}
