/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import ConnectDB.ConnectDB_Blog;
import Models.Messages;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class MessageDAO extends ConnectDB_Blog{

    public MessageDAO() {
        connectDB();
    }
    
    Connection cnn;
    Statement stm;
    ResultSet rs;
    PreparedStatement pstm;

    private void connectDB() {
        try {

            cnn = super.connection;
            System.out.println("Connect MessageDAO success");

        } catch (Exception e) {
            System.out.println("Connect MessageDAO error : " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        
    }

    public boolean checkMessId(String message_id) {
         try {
            String strSelect = "select * from Messages "
                    + "where message_id= ? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, message_id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //tài khoản tồn tại
                return true;
            }

        } catch (Exception e) {
            System.out.println("checkMessId error : " + e.getMessage());

        }

        return false;
    }

    public void insertMess(String message_id, String name, String email, String messdetail, String createdate, String createtime) {
        try {

            String strSelect = "INSERT INTO [dbo].[Messages] ([message_id],[user_send_name],[user_send_email],[message_detail],[message_create_date],[message_create_time])\n"
                    + "VALUES (?,?,?,?,?,?)";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, message_id);
            pstm.setString(2, name);
            pstm.setString(3, email);
            pstm.setString(4, messdetail);
            pstm.setString(5, createdate);
            pstm.setString(6, createtime);

            pstm.execute();

        } catch (Exception e) {
            System.out.println("insertMess error : " + e.getMessage());

        }
    }

    public int getTotalMessage(){
        try {

            String strSelect = "select count(*) from Messages";
            pstm = cnn.prepareStatement(strSelect);

            rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println("getTotalMessage error :" + e.getMessage());
        }
        return 0;
    }
    
    public ArrayList<Messages> getListMessage() {
        ArrayList<Messages> listMessage = new ArrayList<Messages>();
        try {
            String strSelect = "Select * from Messages "
                    + "  order by message_create_date desc, message_create_time desc";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String message_id = rs.getString(1);
                String message_detail = rs.getString(2);
                String user_send_name = rs.getString(3);
                String user_send_email = rs.getString(4);
//                String comment_create_date = rs.getString(4);
//                String comment_create_time = rs.getString(5);
                SimpleDateFormat cd = new SimpleDateFormat("dd-MM-yyyy");
                String message_create_date = "";
                if (rs.getDate("message_create_date") != null) {
                    message_create_date = cd.format(rs.getDate("message_create_date"));
                }
                String message_create_time = String.valueOf(rs.getTime("message_create_time"));

                Messages m = new Messages(message_id, message_detail, user_send_name, user_send_email, message_create_date, message_create_time);

                listMessage.add(m);
            }
        } catch (Exception e) {
            System.out.println("getListMessage error :" + e.getMessage());
        }
        return listMessage;

    }

    public void deleteMessageByMessageId(String message_id) {
        try {
            String strSelect = "DELETE FROM Messages WHERE message_id= ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, message_id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //product tồn tại

            }

        } catch (Exception e) {
            System.out.println("deleteMessageByMessageId error : " + e.getMessage());

        }
    }
    
    
    
    
}
