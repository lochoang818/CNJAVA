package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TextEditor {
    public String text;
    @Autowired
    @Qualifier("plainTextWriter")
    public TextWriter textWriter;
    public TextEditor(){

    }
    public void input(String text){
        this.text = text;
    }
    public void save(String fileName){
        textWriter.write(fileName,text);

    }
}
