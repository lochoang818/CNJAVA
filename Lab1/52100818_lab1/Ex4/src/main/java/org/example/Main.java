package org.example;

import org.apache.commons.io.FileUtils;
import org.apache.commons.validator.routines.UrlValidator;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java FileDownloader <URL>");
            return;
        }

        String url = args[0];
        UrlValidator urlValidator = new UrlValidator();

        if (!urlValidator.isValid(url)) {
            System.err.println("Invalid URL: " + url);
            return;
        }

        try {
            String fileName = url.substring(url.lastIndexOf('/') + 1);
            File outputFile = new File(fileName);

            // Download the file
            FileUtils.copyURLToFile(new URL(url), outputFile);

            System.out.println("File downloaded successfully as: " + outputFile.getName());
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}