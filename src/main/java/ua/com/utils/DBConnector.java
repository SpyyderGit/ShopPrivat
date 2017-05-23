package ua.com.utils;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by User on 23.05.2017.
 */
public class DBConnector {
    private String url = "jdbc:mysql://localhost:3306/Shop";
    private String name = "root";
    private String pass = "290731";

    public JdbcTemplate templateConnect() {

        JdbcTemplate jdbcTemplate = null;
        try {
            SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
            dataSource.setDriver(new com.mysql.jdbc.Driver());
            dataSource.setUrl(url);
            dataSource.setUsername(name);
            dataSource.setPassword(pass);
            jdbcTemplate = new JdbcTemplate(dataSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return jdbcTemplate;
    }


    public Connection jdbcConnect() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, name, pass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
