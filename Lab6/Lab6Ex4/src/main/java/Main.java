
import org.example.TextEditor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example")

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        TextEditor textEditor = context.getBean(TextEditor.class);

        // Use the org.example.TextEditor bean
        textEditor.input("hello world");
        textEditor.save("hello");

        // Close the context after using the beans

    }
}