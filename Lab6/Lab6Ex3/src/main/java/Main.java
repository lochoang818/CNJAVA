import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        TextEditor textEditor = context.getBean(TextEditor.class);

        // Sử dụng bean TextEditor
        textEditor.input("hello world");
        textEditor.save("hello");
            // Đóng context sau khi sử dụng
        context.close();
    }
}
