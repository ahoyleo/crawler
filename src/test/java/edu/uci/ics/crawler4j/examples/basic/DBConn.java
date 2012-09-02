package edu.uci.ics.crawler4j.examples.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class DBConn {
  public static void main(String args[]){
    System.out.println(
        "Copyright 2004, R.G.Baldwin");
    try {
      Statement stmt;

      //Register the JDBC driver for MySQL.
      Class.forName("com.mysql.jdbc.Driver");

      //Define URL of database server for
      // database named mysql on the localhost
      // with the default port number 3306.
      String url =
          "jdbc:mysql://localhost:3306/mysql";

      //Get a connection to the database for a
      // user named root with a blank password.
      // This user is the default administrator
      // having full privileges to do anything.
      Connection con =
          DriverManager.getConnection(url,"root", "");

      //Display URL and connection information
      System.out.println("URL: " + url);
      System.out.println("Connection: " + con);

      //Get a Statement object
      stmt = con.createStatement();
      stmt.executeUpdate(
          "REVOKE ALL PRIVILEGES ON *.* " +
          "FROM 'auser'@'localhost'");
      stmt.executeUpdate(
          "REVOKE GRANT OPTION ON *.* " +
          "FROM 'auser'@'localhost'");
      stmt.executeUpdate(
          "DELETE FROM mysql.user WHERE " +
          "User='auser' and Host='localhost'");
      stmt.executeUpdate("FLUSH PRIVILEGES");
      stmt.executeUpdate(
          "DROP DATABASE JunkDB");
      con.close();
    }catch( Exception e ) {
      e.printStackTrace();
    }//end catch
  }//end main
}//end class Jdbc12


