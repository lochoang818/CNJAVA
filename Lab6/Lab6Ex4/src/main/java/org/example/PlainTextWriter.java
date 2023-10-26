package org.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;
@Qualifier
@Component("plainTextWriter")
public class PlainTextWriter implements TextWriter {
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
