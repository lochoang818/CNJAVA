import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Product {
    private int id;
    private String name;
    private double price;
    private String description;

    // Getters and setters
}