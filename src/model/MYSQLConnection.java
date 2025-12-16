package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class MYSQLConnection {

    private static Connection connection;

    public static void createConnection() {
        try {
            if(connection == null){
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Adyapana_institute", "root", "Inter@357#%&N");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static ResultSet executeSearch(String query) throws Exception{
        createConnection();
        return connection.createStatement().executeQuery(query);
    }
    
    public static Integer executeIUD(String query) throws Exception{
        createConnection();
        return connection.createStatement().executeUpdate(query);
    }
}
