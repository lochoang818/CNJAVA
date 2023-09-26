import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements Repository<Product, String> {
    Connection c;
    @Override
    public String add(Product item) {
        try{
            c= ConnectionDB.getConnection();
            String sql = "insert into product (name,price,color )values('" + item.getName() + "'," + item.getPrice() + ",'" + item.getColor() + "')";
            Statement stm = c.createStatement();

            stm.executeUpdate(sql);
            stm.close();
            c.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        } {

        }
        return "Add Product Successfully";
    }

    @Override
    public List<Product> readAll() {
        ArrayList<Product> array= new ArrayList<>();

        try{
            c= ConnectionDB.getConnection();
            String sql="select * from product";
            Statement stm= c.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                Product pr= new Product();
                pr.setId(rs.getString("id"));
                pr.setName(rs.getString("name"));
                pr.setColor(rs.getString("color"));
                pr.setPrice(Double.parseDouble(rs.getString("price")));

                array.add(pr);

            }
            c.close();

        }
        catch (SQLException e){

        }


        return array;

    }

    @Override
    public Product read(String id) {
        Product p = null;
        try {
            c = ConnectionDB.getConnection();
            String sql = "select * from product where id=?";
            PreparedStatement preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) { // Kiểm tra xem có dữ liệu trả về hay không
                p = new Product(rs.getString("id"), rs.getString("name"), rs.getString("color"), rs.getDouble("price"));
            }

            rs.close();
            preparedStatement.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace(); // Hoặc xử lý lỗi khác tùy theo nhu cầu
        }

        return p;
    }


    @Override
    public boolean update(Product item) {
        try {
            c = ConnectionDB.getConnection();
            String sql = "update product set name=?, color=?, price=? where id=? ";
            PreparedStatement preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1, item.getName());
            preparedStatement.setString(2, item.getColor());
            preparedStatement.setDouble(3, item.getPrice());
            preparedStatement.setString(4, item.getId());

            int rowsAffected = preparedStatement.executeUpdate();
            preparedStatement.close();
            c.close();

            return rowsAffected > 0; // Trả về true nếu có dòng bị ảnh hưởng, nghĩa là xóa thành công
        } catch (SQLException e) {
            e.printStackTrace(); // Hoặc xử lý lỗi khác tùy theo nhu cầu
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
        try {
            c = ConnectionDB.getConnection();
            String sql = "delete from product where id=?";
            PreparedStatement preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1, id);

            int rowsAffected = preparedStatement.executeUpdate();
            preparedStatement.close();
            c.close();

            return rowsAffected > 0; // Trả về true nếu có dòng bị ảnh hưởng, nghĩa là xóa thành công
        } catch (SQLException e) {
            e.printStackTrace(); // Hoặc xử lý lỗi khác tùy theo nhu cầu
            return false;
        }
    }
}
