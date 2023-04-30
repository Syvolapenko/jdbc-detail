package com.goit11;

import com.goit11.Database.Database;
import com.goit11.Tables.TableClients;
import com.goit11.Tables.TableWorkers;

import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException {
        String[]clients = {"Vasiliy","Slava","Viktoria","Anton","Olena"};
        String[]workers = {"Max","Alex","Natalia","Vlad","Valeria","Jurij","Andrej","Alina","Yulia","Vitaliy"};
        String[]birthdays = {"1998-11-30","1996-04-16","2000-03-06","1992-07-26","1994-10-03","2001-06-18","1993-12-13",
                            "1997-09-23","1995-02-10","2000-05-20"};
        String[]levels = {"Middle","Junior","Trainee","Senior","Middle","Trainee","Senior","Junior","Senior","Middle"};
        int[] salary = {1500,800,400,3000,2000,450,4000,900,3500,2500};
        TableClients tableClients = new TableClients(Database.getInstance());
//        tableClients.createNewClients(clients);
//        tableClients.print(3);
        TableWorkers tableWorkers = new TableWorkers(Database.getInstance());
//        tableWorkers.createNewWorkers(workers,birthdays,levels,salary);
         tableWorkers.print(3);

    }
}