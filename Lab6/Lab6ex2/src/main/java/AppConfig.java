import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


@Configuration
public class AppConfig {

    @Bean
    @Scope("prototype")
    public Product firstBean() {
        Product product = new Product();
        product.setId(1);
        product.setName("First Product");
        product.setPrice(19.99);
        product.setDescription("Description of the first product");
        return product;
    }

    @Bean
    @Scope("prototype")
    public Product secondBean() {
        return new Product(2, "Second Product", 29.99, "Description of the second product");
    }

    @Bean
    @Scope("singleton")
    public Product thirdBean() {
        Product product = new Product();
        product.setId(3);
        product.setName("Third Product");
        product.setPrice(39.99);
        product.setDescription("Description of the third product");
        return product;
    }
}