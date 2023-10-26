package org.example;

import org.springframework.stereotype.Component;

@Component
public interface TextWriter {
    void write(String filename, String text);
}
