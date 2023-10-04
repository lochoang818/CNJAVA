package Model;

import jakarta.persistence.*;

@Entity
@Table(name="MobilePhone")
public class Phone {
    @Id
    private String id;
    @Column(name = "Name", nullable = false, length = 128)
    private String name;
    @Column(name = "Color", nullable = false)

    private String color;
    @Column(name = "Price", nullable = false)

    private int price;
    private String country;
    private  int quantity;
    @ManyToOne
    @JoinColumn(name = "manufacture_id")
    private Manufacture manufacture;

    public String getColor() {
        return color;
    }

    public Phone(String id, String name, String color, int price, String country, int quantity) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.price = price;
        this.country = country;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", country='" + country + '\'' +
                ", quantity=" + quantity +
                ", manufacture=" + manufacture +
                '}';
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Manufacture getManufacture() {
        return manufacture;
    }

    public void setManufacture(Manufacture manufacture) {
        this.manufacture = manufacture;
    }

    public Phone(String id, String name, String color, int price, String country, int quantity, Manufacture manufacture) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.price = price;
        this.country = country;
        this.quantity = quantity;
        this.manufacture = manufacture;
    }

    public Phone() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
