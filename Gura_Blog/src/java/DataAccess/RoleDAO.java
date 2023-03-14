/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import ConnectDB.ConnectDB_Blog;
import Models.Roles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class RoleDAO extends ConnectDB_Blog{

    public RoleDAO() {
        connectDB();
    }
    
    Connection cnn;
    Statement stm;
    ResultSet rs;
    PreparedStatement pstm;

    private void connectDB() {
        try {

            cnn = super.connection;
            System.out.println("Connect RoleDAO success");

        } catch (Exception e) {
            System.out.println("Connect RoleDAO error : " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        
    }
    
    public ArrayList<Roles> getListRole(){
        ArrayList<Roles> listRole = new ArrayList<Roles>();
        try {
            String strSelect = "Select * from Roles\n" +
                               "  order by role_id asc" ;
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String role_id = rs.getString(1);
                String role_name = rs.getString(2);
                
                Roles t = new Roles(role_id, role_name);
                
                listRole.add(t);
                
            }
        } catch (Exception e) {
            System.out.println("getListRole error :" + e.getMessage());
        }
        
        return listRole;
        
    }

    public void updateEditRole(String user_id, String role_id) {
        try {
            String strSelect = "UPDATE Users\n" +
                                "SET role_id = ? \n" +
                                "WHERE user_id = ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, role_id);
            pstm.setString(2, user_id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //product tồn tại
                
            }

        } catch (Exception e) {
            System.out.println("updateEditRole error : " + e.getMessage());

        }
    }

    
    
}
