/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import ConnectDB.ConnectDB_Blog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author nguye
 */
public class WebDAO extends ConnectDB_Blog{

    public WebDAO() {
        connectDB();
    }
    
    Connection cnn;
    Statement stm;
    ResultSet rs;
    PreparedStatement pstm;

    private void connectDB() {
        try {

            cnn = super.connection;
            System.out.println("Connect WebDAO success");

        } catch (Exception e) {
            System.out.println("Connect WebDAO error : " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        
    }

    public String getNotifi() {
        String getNotifi = "";
        try {

            String strSelect = "SELECT Notification\n" +
                                "FROM Web;";
            pstm = cnn.prepareStatement(strSelect);

            rs = pstm.executeQuery();
            while (rs.next()) {
                getNotifi= rs.getString(1);
            }

        } catch (Exception e) {
            System.out.println("getNotifi error :" + e.getMessage());
        }
        return getNotifi;
    }

    public void updateNotifi(String editNotifi) {
        try {
            String strSelect = "UPDATE Web\n" +
                                "SET Notification = ?" ;
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, editNotifi);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //product tồn tại
                
            }

        } catch (Exception e) {
            System.out.println("updateNotifi error : " + e.getMessage());

        }
    }
    
    
    
}
