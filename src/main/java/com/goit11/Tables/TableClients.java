package com.goit11.Tables;

import com.goit11.Database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TableClients {
    private PreparedStatement insertSt;
    private PreparedStatement selectByIdSt;
    private static String sql1 = "INSERT INTO client (name) VALUES (?)";
    private static String sql2 = "SELECT name FROM client WHERE id=?";
    public TableClients(Database database) throws SQLException {
        Connection con = database.getConnection();
        insertSt = con.prepareStatement(sql1);
        selectByIdSt = con.prepareStatement(sql2);
    }

    public void createNewClients(String[] clients) throws SQLException {
        for (int i = 0; i < clients.length; i++) {
            String name = clients[i];
            insertSt.setString(1, name);
            insertSt.addBatch();
        }
        insertSt.executeBatch();
    }

    public boolean print(long id) {
        try {
            selectByIdSt.setLong(1, id);
        } catch (Exception ex) {
            return false;
        }
        try (ResultSet resultSet = selectByIdSt.executeQuery()) {
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                System.out.println("name " + name);
                return true;
            } else {
                System.out.println("Client with " + id + " not find");
                return false;
            }
        } catch (Exception ex) {
            return false;
        }
    }
}

