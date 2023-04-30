package com.goit11.Database;

import org.h2.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL_H2 =  "jdbc:h2:~/GoIt11/Projects/Gradle/JDBC/jdbc-detail/homework";
    Connection connection;

    public Database() throws SQLException {
        DriverManager.registerDriver(new Driver());
        connection = DriverManager.getConnection(URL_H2);
    }

    public static Database getInstance(){
        try {
            return new Database();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection(){
        return connection;
    }
    public boolean check(){
        try {
            return !connection.isClosed();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}

