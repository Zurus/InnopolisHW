package innopolis.lesson15.dao;

import innopolis.lesson15.ConnectorImpl;
import innopolis.lesson15.pojo.Laptop;

import java.sql.*;

public class LaptopDao implements SimpleDao {

    static final String QUERY_ALL = "SELECT * FROM SHOP.LAPTOP";

    static final String QUERY_PRICE_PARAM = "SELECT * FROM shop.laptop WHERE price > ?";

    static final String QUERY_LAPTOP_ID = "SELECT * FROM shop.laptop WHERE id = ?";

    static final String QUERY_ADD_LAPTOP = "INSERT INTO shop.laptop (name, price, menufacturer_id) VALUES (?, ?, ?)";

    static final String QUERY_ADD_CUSTOMER = "INSERT INTO customers (id, name, email, age) VALUES (?, ?, ?, ?)";

    static final String QUERY_SELECT_ALL = "SELECT * FROM customers";

    static final String CREATE_TABLE = "CREATE TABLE customers\n" +
            "(\n" +
            "    Id SERIAL PRIMARY KEY,\n" +
            "    name CHARACTER VARYING(30),\n" +
            "    Email CHARACTER VARYING(30),\n" +
            "    Age INTEGER\n" +
            ");";


    @Override
    public void selectAllCustomers() {
        try (Connection connection = ConnectorImpl.getConnection();
             Statement statement = connection.createStatement()
        ) {
            try (ResultSet rs = statement.executeQuery(QUERY_SELECT_ALL)) {
                while (rs.next()) {
                    System.out.println(rs.getString("name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createTable() {
        try (Connection connection = ConnectorImpl.getConnection();
             Statement statement = connection.createStatement()
        ) {
            statement.executeUpdate(CREATE_TABLE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addCustomer() {
        try (Connection connection = ConnectorImpl.getConnection();
             PreparedStatement statement = connection.prepareStatement(QUERY_ADD_CUSTOMER)
        ) {
            statement.setInt(1, 1);
            statement.setString(2, "simpleName");
            statement.setString(3, "someMail@mail.com");
            statement.setInt(4, 30);
            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addLaptop(Laptop laptop) {
        try (Connection connection = ConnectorImpl.getConnection();
             PreparedStatement statement = connection.prepareStatement(QUERY_ADD_LAPTOP)
        ) {
            statement.setString(1, laptop.getName());
            statement.setInt(2, laptop.getPrice());
            statement.setInt(3, laptop.getManufacturerId());
            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void selectAll() {
        try (Connection connection = ConnectorImpl.getConnection();
             Statement statement = connection.createStatement()
        ) {
            try (ResultSet rs = statement.executeQuery(QUERY_ALL)) {
                while (rs.next()) {
                    System.out.println(rs.getString("name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void selectLaptopMorePrice(int price) {
        try (Connection connection = ConnectorImpl.getConnection();
             PreparedStatement statement = connection.prepareStatement(QUERY_PRICE_PARAM)
        ) {
            statement.setInt(1, price);
            try (ResultSet rs =  statement.executeQuery()) {
                while (rs.next()) {
                    System.out.println(rs.getString("name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Laptop getLaptopById(int id) {
        try (Connection connection = ConnectorImpl.getConnection();
            PreparedStatement statement = connection.prepareStatement(QUERY_LAPTOP_ID))
        {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Laptop (resultSet.getInt(1),
                                        resultSet.getString(2),
                                        resultSet.getInt(3),
                            resultSet.getInt(4));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
