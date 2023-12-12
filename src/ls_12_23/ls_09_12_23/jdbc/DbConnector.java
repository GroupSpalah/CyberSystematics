package ls_12_23.ls_09_12_23.jdbc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class DbConnector {

    private static Connection connection;

    public static final String URL = "jdbc:mysql://localhost:3306/learn_sql?serverTimezone=Europe/Kiev";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "123456";

    public static Connection getConnection() throws SQLException {
        if (Objects.isNull(connection)) {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        }

        return connection;
    }

    public static void showAllCustomers() throws SQLException {

        String query = "SELECT * FROM customers";

        /*try {

        } catch ()*/

        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int customerNo = resultSet.getInt("CustomerNo");
                String fName = resultSet.getString("FName");
                String lName = resultSet.getString("LName");
                String mName = resultSet.getString("mName");
                String city = resultSet.getString("city");
                String phone = resultSet.getString("phone");

                System.out.println(customerNo + "\t" + fName + "\t" + lName + "\t" +
                        mName + "\t" + city + "\t" + phone);
            }
        }
    }

    public static void showCustomersFile() throws SQLException, IOException {

        Path pathToFile = Paths.get("./Queries");

        List<String> queries = Files.readAllLines(pathToFile);

//        int size = queries.size();

        queries.forEach(query -> {

            try (Statement statement = getConnection().createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {

                while (resultSet.next()) {
                    int customerNo = resultSet.getInt("CustomerNo");
                    String fName = resultSet.getString("FName");
                    String lName = resultSet.getString("LName");
                    String mName = resultSet.getString("mName");
                    String city = resultSet. getString("city");
                    String phone = resultSet.getString("phone");

                    System.out.println(customerNo + "\t" + fName + "\t" + lName + "\t" +
                            mName + "\t" + city + "\t" + phone);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public static void showCustomerByIdUsingStatement(int id, String firstName) throws SQLException {

        String query = "SELECT * FROM customers WHERE CustomerNo = " + id + " AND fName = '" + firstName + "'";

        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int customerNo = resultSet.getInt("CustomerNo");
                String fName = resultSet.getString("FName");
                String lName = resultSet.getString("LName");
                String mName = resultSet.getString("mName");
                String city = resultSet.getString("city");
                String phone = resultSet.getString("phone");

                System.out.println(customerNo + "\t" + fName + "\t" + lName + "\t" +
                        mName + "\t" + city + "\t" + phone);
            }
        }
    }

    public static void showCustomerByIdUsingJoin(int id) throws SQLException {

        String query = "SELECT * \n" +
                "FROM customers c\n" +
                "INNER JOIN orders o\n" +
                "ON c.CustomerNo = o.CustomerNo\n" +
                "WHERE c.CustomerNo = ?";
        PreparedStatement statement = getConnection().prepareStatement(query);

        statement.setInt(1, id);

        try (statement;
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int orderID = resultSet.getInt("orderID");
                String fName = resultSet.getString("FName");
                String lName = resultSet.getString("LName");
                String orderDate = resultSet.getString("OrderDate");


                System.out.println(fName + "\t" + lName + "\t" +
                        orderID + "\t" + orderDate);
            }
        }
    }

    public static void showCustomerByIdUsingPreparedStatement(int id, String firstName) throws SQLException {

        String query = "SELECT * FROM customers WHERE CustomerNo = ? AND fName = ?";
        PreparedStatement statement = getConnection().prepareStatement(query);

        statement.setInt(1, id);
        statement.setString(2, firstName);

        try (statement;
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int customerNo = resultSet.getInt("CustomerNo");
                String fName = resultSet.getString("FName");
                String lName = resultSet.getString("LName");
                String mName = resultSet.getString("mName");
                String city = resultSet.getString("city");
                String phone = resultSet.getString("phone");

                System.out.println(customerNo + "\t" + fName + "\t" + lName + "\t" +
                        mName + "\t" + city + "\t" + phone);
            }
        }
    }

    public static void insert(Customer customer) throws SQLException {
        String query = "INSERT INTO Customers(FName, LName, MName, City, Phone, Address1, Address2, DateInSystem) " +
                "VALUES(?,?,?,?,?,?,?,?)";

        PreparedStatement statement = getConnection().prepareStatement(query);

        statement.setString(1, customer.firstName());
        statement.setString(2, customer.lastName());
        statement.setString(3, customer.middleName());
        statement.setString(4, customer.city());
        statement.setString(5, customer.phone());
        statement.setString(6, customer.address1());
        statement.setString(7, customer.address2());
        statement.setString(8, customer.dateSystem().toString());

        try (statement) {
            statement.executeUpdate();
        }
    }

    public static void deleteById(int id) throws SQLException {
        String query = "DELETE FROM customers WHERE customerNo = ?";
        PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setInt(1, id);

        try (statement) {
            statement.executeUpdate();
        }

    }

    public static void main(String[] args) throws SQLException, IOException {
//        showAllCustomers();
//        showCustomerByIdUsingStatement(1, "Анатолій");
//        showCustomerByIdUsingPreparedStatement(1, "Анатолій");

        Customer customer = new Customer("Andriy", "Valevskiy", "Olexandrovich",
                "Dnipro", "(095)7796546", "Franko", "Dzvinka", LocalDate.now());

//        insert(customer);

//        showCustomersFile();
//        showCustomerByIdUsingJoin(3);
        deleteById(4);
    }
}


