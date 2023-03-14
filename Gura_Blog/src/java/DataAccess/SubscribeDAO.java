/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import ConnectDB.ConnectDB_Blog;
import Models.Subscribes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class SubscribeDAO extends ConnectDB_Blog {

    public SubscribeDAO() {
        connectDB();
    }

    Connection cnn;
    Statement stm;
    ResultSet rs;
    PreparedStatement pstm;

    private void connectDB() {
        try {

            cnn = super.connection;
            System.out.println("Connect SubscribeDAO success");

        } catch (Exception e) {
            System.out.println("Connect SubscribeDAO error : " + e.getMessage());
        }
    }

    public static void main(String[] args) {

    }

    public void insertSubcribe(String id, String email) {
        try {

            String strSelect = "INSERT INTO [dbo].[Subscribes] ([email],[id])\n"
                    + "VALUES (?,?)";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, email);
            pstm.setString(2, id);
            pstm.execute();

        } catch (Exception e) {
            System.out.println("insertSubcribe error : " + e.getMessage());

        }
    }

    public boolean checkEmail(String email) {
        try {
            String strSelect = "select * from Subscribes "
                    + "where email= ? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, email);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //tài khoản tồn tại
                return true;
            }

        } catch (Exception e) {
            System.out.println("checkEmail error : " + e.getMessage());

        }

        return false;
    }

    public void deleteSubBySubId(String id) {
        try {
            String strSelect = "DELETE FROM Subscribes WHERE id= ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //product tồn tại

            }

        } catch (Exception e) {
            System.out.println("deleteSubBySubId error : " + e.getMessage());

        }
    }

    public ArrayList<Subscribes> getListSubscribe() {
        ArrayList<Subscribes> listSubscribe = new ArrayList<Subscribes>();
        try {
            String strSelect = "Select * from Subscribes \n"
                    + "  order by email asc";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String email = rs.getString(1);
                String id = rs.getString(2);

                Subscribes s = new Subscribes(email, id);

                listSubscribe.add(s);
            }
        } catch (Exception e) {
            System.out.println("getListSubscribe error :" + e.getMessage());
        }
        return listSubscribe;

    }

    public boolean checkSubId(String id) {
        try {
            String strSelect = "select * from Subscribes "
                    + "where id= ? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //tài khoản tồn tại
                return true;
            }

        } catch (Exception e) {
            System.out.println("checkSubId error : " + e.getMessage());

        }

        return false;
    }

    public int getTotalSubscribe() {
        try {

            String strSelect = "select count(*) from Subscribes";
            pstm = cnn.prepareStatement(strSelect);

            rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println("getTotalSubscribe error :" + e.getMessage());
        }
        return 0;
    }

}
