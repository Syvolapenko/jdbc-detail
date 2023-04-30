package com.goit11.Tables;

import com.goit11.Database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TableWorkers {
    private PreparedStatement insertSt;
    private PreparedStatement selectByIdSt;
    private static String sql = "INSERT INTO worker (name, birthday, level, salary) VALUES (?, ?, ?, ?)";
    private static String sql2 = "SELECT level FROM worker WHERE id=?";

    public TableWorkers(Database database) throws SQLException {
        Connection con = database.getConnection();
        insertSt = con.prepareStatement(sql);
        selectByIdSt = con.prepareStatement(sql2);
    }
    public void createNewWorkers(String[]workers, String[]birthdays, String[]levels, int[]salary) throws SQLException {
        for (int i = 0; i < workers.length; i++) {
            String name = workers[i];
            String birthday = birthdays[i];
            String level = levels[i];
            int salaries = salary[i];
            insertSt.setString(1,name);
            insertSt.setString(2,birthday);
            insertSt.setString(3,level);
            insertSt.setInt(4,salaries);
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
                String levels = resultSet.getString("level");
                System.out.println("level " + levels);
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
