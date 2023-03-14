/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import ConnectDB.ConnectDB_Blog;
import Models.Comments;
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
public class CommentDAO extends ConnectDB_Blog {

    public CommentDAO() {
        connectDB();
    }

    Connection cnn;
    Statement stm;
    ResultSet rs;
    PreparedStatement pstm;

    private void connectDB() {
        try {

            cnn = super.connection;
            System.out.println("Connect CommentDAO success");

        } catch (Exception e) {
            System.out.println("Connect CommentDAO error : " + e.getMessage());
        }
    }

    public static void main(String[] args) {

    }

    public boolean checkCommentId(String comment_id) {
        try {
            String strSelect = "select * from Comments "
                    + "where comment_id= ? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, comment_id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //tài khoản tồn tại
                return true;
            }

        } catch (Exception e) {
            System.out.println("checkCommentId error : " + e.getMessage());

        }

        return false;
    }

    public ArrayList<Comments> getListComment() {
        ArrayList<Comments> listComment = new ArrayList<Comments>();
        try {
            String strSelect = "Select * from Comments \n"
                    + "  order by comment_create_date desc, comment_create_time desc";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String comment_id = rs.getString(1);
                String user_id = rs.getString(2);
                String comment_detail = rs.getString(3);
//                String comment_create_date = rs.getString(4);
//                String comment_create_time = rs.getString(5);
                SimpleDateFormat cd = new SimpleDateFormat("dd-MM-yyyy");
                String comment_create_date = "";
                if (rs.getDate("comment_create_date") != null) {
                    comment_create_date = cd.format(rs.getDate("comment_create_date"));
                }
                String comment_create_time = String.valueOf(rs.getTime("comment_create_time"));
                String comment_parent_id = rs.getString(6);
                String post_id = rs.getString(7);
                String comment_status = rs.getString(8);

                Comments cm = new Comments(comment_id, user_id, post_id, comment_parent_id, comment_detail, comment_create_date, comment_create_time,comment_status);

                listComment.add(cm);
            }
        } catch (Exception e) {
            System.out.println("getListComment error :" + e.getMessage());
        }
        return listComment;

    }
    
    public ArrayList<Comments> getListCommentASC() {
        ArrayList<Comments> listComment = new ArrayList<Comments>();
        try {
            String strSelect = "Select * from Comments \n"
                    + "  order by comment_create_date asc, comment_create_time asc";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String comment_id = rs.getString(1);
                String user_id = rs.getString(2);
                String comment_detail = rs.getString(3);
//                String comment_create_date = rs.getString(4);
//                String comment_create_time = rs.getString(5);
                SimpleDateFormat cd = new SimpleDateFormat("dd-MM-yyyy");
                String comment_create_date = "";
                if (rs.getDate("comment_create_date") != null) {
                    comment_create_date = cd.format(rs.getDate("comment_create_date"));
                }
                String comment_create_time = String.valueOf(rs.getTime("comment_create_time"));
                String comment_parent_id = rs.getString(6);
                String post_id = rs.getString(7);
                String comment_status = rs.getString(8);

                Comments cm = new Comments(comment_id, user_id, post_id, comment_parent_id, comment_detail, comment_create_date, comment_create_time,comment_status);

                listComment.add(cm);
            }
        } catch (Exception e) {
            System.out.println("getListCommentASC error :" + e.getMessage());
        }
        return listComment;

    }

    public void insertComment(String comment_id, String userid, String postid, String commentdetail, String createdate, String createtime) {
        try {

            String strSelect = "INSERT INTO [dbo].[Comments] ([comment_id],[user_id],[post_id],[comment_detail],[comment_create_date],[comment_create_time])\n"
                    + "VALUES (?,?,?,?,?,?)";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, comment_id);
            pstm.setString(2, userid);
            pstm.setString(3, postid);
            pstm.setString(4, commentdetail);
            pstm.setString(5, createdate);
            pstm.setString(6, createtime);

            pstm.execute();

        } catch (Exception e) {
            System.out.println("insertComment error : " + e.getMessage());

        }
    }

    public int getTotalComment() {
        try {

            String strSelect = "select count(*) from Comments";
            pstm = cnn.prepareStatement(strSelect);

            rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println("getTotalComment error :" + e.getMessage());
        }
        return 0;
    }

    public void deleteCommentByCommentId(String comment_id) {
        try {
            String strSelect = "DELETE FROM Comments WHERE comment_id= ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, comment_id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //product tồn tại

            }

        } catch (Exception e) {
            System.out.println("deleteCommentByCommentId error : " + e.getMessage());

        }
    }

    public void updateCommentByCommentId(String idcommentedit, String editdetail) {
        try {
            String strSelect = "UPDATE Comments\n"
                    + "SET comment_detail =?\n"
                    + "WHERE comment_id = ?;";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, editdetail);
            pstm.setString(2, idcommentedit);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //product tồn tại

            }

        } catch (Exception e) {
            System.out.println("updateEditPost error : " + e.getMessage());

        }
    }

    public void updateSatusCommentByCommentId(String idcommentconfirm) {
        try {
            String strSelect = "UPDATE Comments\n"
                    + "SET comment_status =?\n"
                    + "WHERE comment_id = ?;";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, "1");
            pstm.setString(2, idcommentconfirm);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //product tồn tại

            }

        } catch (Exception e) {
            System.out.println("updateEditPost error : " + e.getMessage());

        }
    }

}
