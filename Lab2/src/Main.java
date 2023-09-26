import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws SQLException {
        ProductDAO productDAO = new ProductDAO();
//        productDAO.add(new Product("1","alo","black",123));
        Scanner sc =new Scanner(System.in);
        while(true){
            System.out.println("1. Read all products");
            System.out.println("2. Read detail of a product by id");
            System.out.println("3. Add a new product");
            System.out.println("4. Update a product");
            System.out.println("5. Delete a product by id");
            System.out.println("6. exit");
            System.out.print("Your choice: ");
            int select = sc.nextInt();
            if(select ==6){
                break;
            }
            switch (select){
                case 1:
                    for(Product p : productDAO.readAll()){
                        System.out.println(p);
                    }
                    break;
                case 2:
                    sc.nextLine();

                    System.out.print("Enter id: ");
                    String id = sc.nextLine();
                    if(productDAO.read(id)==null){
                        System.out.println("Id doesn't exist");
                    }
                    else{
                        System.out.println(productDAO.read(id));
                    }
                    break;
                case 3:
                    System.out.println("-----------------------");
                    sc.nextLine();
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter color: ");
                    String color = sc.nextLine();
                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();

                    Product p = new Product(name,color,price);
                    System.out.println(productDAO.add(p));

                    break;
                case 4:
                    sc.nextLine();
                    System.out.print("Enter update Id: ");
                    String updateId = sc.nextLine();
                    System.out.print("Enter name: ");
                    String updateName = sc.nextLine();
                    System.out.print("Enter color: ");
                    String updateColor = sc.nextLine();
                    System.out.print("Enter price: ");
                    double updatePrice = sc.nextDouble();

                    p = new Product(updateId,updateName,updateColor,updatePrice);
                    if(productDAO.update(p)){
                        System.out.println("Update successfully");
                    }
                    else{
                        System.out.println("Update fail");
                    }
                    break;
                case 5:
                    sc.nextLine();

                    System.out.print("Enter deleted id: ");
                    String idDelete = sc.nextLine();
                    if(productDAO.delete(idDelete)){
                        System.out.println("Delete successfully");
                    }
                    else{
                        System.out.println("Id does not exist");
                    }
                    break;

                default:
                    break;
            }
        }
    }
}

