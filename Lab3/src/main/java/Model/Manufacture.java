package Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Manufacture")
public class Manufacture {
    @Id
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "location")

    private String location;
    @Column(name = "employee")
    private int employee;
    @OneToMany(mappedBy = "manufacture", cascade = CascadeType.ALL,fetch = FetchType.EAGER)

    private List<Phone> phone;
    public Manufacture(String id, String name, String location, int employee, List<Phone> phone) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.employee = employee;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Manufacture{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", employee=" + employee +
                '}';
    }

    public Manufacture() {
    }

    public Manufacture(String id, String name, String location, int employee) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.employee = employee;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getEmployee() {
        return employee;
    }

    public void setEmployee(int employee) {
        this.employee = employee;
    }

    public List<Phone> getPhone() {
        return phone;
    }

    public void setPhone(List<Phone> phone) {
        this.phone = phone;
    }



}
