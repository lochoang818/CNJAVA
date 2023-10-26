import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Initialize Spring context using Java configuration
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieve beans from the context
        Product firstProduct = context.getBean("firstBean", Product.class);
        Product secondProduct = context.getBean("secondBean", Product.class);
        Product thirdProduct = context.getBean("thirdBean", Product.class);

        // Print product information
        System.out.println("First Product: " + firstProduct);
        System.out.println("Second Product: " + secondProduct);
        System.out.println("Third Product: " + thirdProduct);

        // Check if first two beans are prototype objects and the third bean is a singleton object
        System.out.println("First Bean is Prototype: " + context.isPrototype("firstBean"));
        System.out.println("Second Bean is Prototype: " + context.isPrototype("secondBean"));
        System.out.println("Third Bean is Singleton: " + context.isSingleton("thirdBean"));

        // Close the context
        context.close();
    }
}