package innopolis.lesson15.dao;

import innopolis.lesson15.ConnectorImpl;
import innopolis.lesson15.pojo.Laptop;
import org.apache.log4j.Logger;

import java.sql.*;

public class LaptopDao implements SimpleDao {

    final static Logger logger = Logger.getLogger(Laptop.class.getName());

    static final String QUERY_ALL = "SELECT * FROM SHOP.LAPTOP";

    static final String QUERY_PRICE_PARAM = "SELECT * FROM shop.laptop WHERE price > ?";

    static final String QUERY_LAPTOP_ID = "SELECT * FROM shop.laptop WHERE id = ?";

    static final String QUERY_ADD_LAPTOP = "INSERT INTO shop.laptop (name, price, menufacturer_id) VALUES (?, ?, ?)";

    static final String SQL_ERROR_MSG = "Ошибка SQL {}";

//    static final String CREATE_TABLE = "CREATE TABLE shit\n" +
//            "(\n" +
//            "    Id SERIAL PRIMARY KEY,\n" +
//            "    name CHARACTER VARYING(30),\n" +
//            "    Email CHARACTER VARYING(30),\n" +
//            "    Age INTEGER\n" +
//            ");";

    @Override
    public void addLaptop(Laptop laptop) {
        logger.info("Добавление пользователя " +laptop);
        try (Connection connection = ConnectorImpl.getConnection();
             PreparedStatement statement = connection.prepareStatement(QUERY_ADD_LAPTOP)
        ) {
            statement.setString(1, laptop.getName());
            statement.setInt(2, laptop.getPrice());
            statement.setInt(3, laptop.getManufacturerId());
            statement.executeQuery();
        } catch (SQLException e) {
            logger.error(SQL_ERROR_MSG, e);
        }
        logger.info("Пользователь добавлен");
    }

    @Override
    public void selectAll() {
        logger.info("Выбор всех пользователей:");
        try (Connection connection = ConnectorImpl.getConnection();
             Statement statement = connection.createStatement()
        ) {
            try (ResultSet rs = statement.executeQuery(QUERY_ALL)) {
                while (rs.next()) {
                    System.out.println(rs.getString("name"));
                }
            }
        } catch (SQLException e) {
            logger.error(SQL_ERROR_MSG, e);
        }
    }

    @Override
    public void selectLaptopMorePrice(int price) {
        logger.info("Ноутбуки с ценой = " + price);
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
            logger.error(SQL_ERROR_MSG, e);
        }
    }

    @Override
    public Laptop getLaptopById(int id) {
        logger.info(String.format("Ноутбук (%d)", id));
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
            logger.error(SQL_ERROR_MSG, e);
        }
        logger.info("Ничего не найдено, Кутузов!");
        return null;
    }

    @Override
    public void printMetaData() {
        logger.info("Метаданные базы");
        try (Connection connection = ConnectorImpl.getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();
            logger.info("Database "+metaData.getDatabaseProductName());
            logger.info("Version "+metaData.getDriverVersion());
        } catch (SQLException e) {
            logger.error("SQLError {}", e);
        }
    }

    @Override
    public void printMetaDataRowSet() {
        logger.info("Метаданные таблицы");
        try (Connection connection = ConnectorImpl.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSetMetaData rsMetaData = statement.executeQuery(QUERY_ALL).getMetaData();
            int colCount = rsMetaData.getColumnCount();
            for (int i = 1; i < colCount; i++) {
                logger.info(rsMetaData.getTableName(i));
                logger.info(rsMetaData.getSchemaName(i));
                logger.info(rsMetaData.getColumnName(i));
            }
        } catch (SQLException e) {
            logger.error("SQLError {}", e);
        }
    }
}
