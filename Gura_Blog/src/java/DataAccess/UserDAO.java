/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import ConnectDB.ConnectDB_Blog;
import Models.Posts;
import Models.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
//import java.util.ArrayList;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author nguye
 */
public class UserDAO extends ConnectDB_Blog {
    //Lưu ý phải mở nguồn connect database
//    cnn = super.connection;
    //có thể đóng database
//    finally{
//            pstm.close();
//        }

    public UserDAO() {
        connectDB();

    }

    public static void main(String[] args) {
        UserDAO u = new UserDAO();
        System.out.println(u.checklogin("user0", "123"));
//        ArrayList<Users> list = (ArrayList<Users>)u.getAll();
//        for (Users users : list) {
//            System.out.println(users.getUser_account());
//        Users list = u.getUser("user0", "1234");
        Users poster = u.getUserInfor("28429107");
        String name = poster.getUser_firstname() + " " + poster.getUser_lastname();
        String fistname = poster.getUser_firstname();
        String lastname = poster.getUser_lastname();
        if (fistname == null || lastname == null) {
            System.out.println("oke");
        }
        if (fistname != null && lastname != null) {
            System.out.println("in duoc");
        }
        System.out.println(name);

//        System.out.println(list.getUser_role());
//get time local
        LocalDate getdate = LocalDate.now();
        LocalTime gettime = LocalTime.now();

        String createdate = String.valueOf(getdate);

        String createtime = String.valueOf(gettime);
        System.out.println(createdate + "   " + createtime);

//        u.insertUser("64527421", "nguyencong1", "nguyencong1@gmail.com", "123", "2022-10-25", "11:01:58");
//        u.insertUserRole("1627354623");
//        Users userInfor = u.getUser("user0", "123");
//        String userid = String.valueOf(userInfor.getUser_id());
//        Users userRoleId = u.getUserRoleId(userid);
//
//        String userRole = String.valueOf(userRoleId.getRole_id());
//        
//        System.out.println(userInfor.getUser_id()); 
//        System.out.println(userRole);
    }

    //Khai bao cac thanh phan xu ly
    Connection cnn;
    Statement stm;
    ResultSet rs;
    PreparedStatement pstm;

    private void connectDB() {
        try {

            cnn = super.connection;
            System.out.println("Connect UserDAO success");

        } catch (Exception e) {
            System.out.println("Connect UserDAO error : " + e.getMessage());
        }
    }

    public boolean checklogin(String account, String password) {

        try {
            String strSelect = "select * from Users "
                    + "where user_account= ? and "
                    + "user_password= ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, account);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //tài khoản tồn tại
                return true;
            }

        } catch (Exception e) {
            System.out.println("checklogin error : " + e.getMessage());

        }

        return false;
    }

    public boolean checkUser(String account, String email) {
        try {
            String strSelect = "select * from Users "
                    + "where user_account= ? and "
                    + "user_email=?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, account);
            pstm.setString(2, email);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //tài khoản tồn tại
                return true;
            }

        } catch (Exception e) {
            System.out.println("checkUser error : " + e.getMessage());

        }

        return false;
    }

    public boolean checkUser2(String account, String password) {

        try {
            String strSelect = "select * from Users "
                    + "where user_account= ? and "
                    + "user_password=?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, account);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //tài khoản tồn tại
                return true;
            }

        } catch (Exception e) {
            System.out.println("checkUser2 error : " + e.getMessage());

        }

        return false;

    }

    public boolean checkUserId(String user_id) {
        try {
            String strSelect = "select * from Users "
                    + "where user_id= ? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, user_id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //tài khoản tồn tại
                return true;
            }

        } catch (Exception e) {
            System.out.println("checkUserId error : " + e.getMessage());

        }

        return false;
    }

    public boolean checkUserAccount(String user_account) {
        try {
            String strSelect = "select * from Users "
                    + "where user_account= ? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, user_account);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //tài khoản tồn tại
                return true;
            }

        } catch (Exception e) {
            System.out.println("checkUserAccount error : " + e.getMessage());

        }

        return false;
    }

    public boolean checkUserEmail(String user_emal) {
        try {
            String strSelect = "select * from Users "
                    + "where user_email= ? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, user_emal);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //tài khoản tồn tại
                return true;
            }

        } catch (Exception e) {
            System.out.println("checkUserEmail error : " + e.getMessage());

        }

        return false;
    }

    public boolean checkUserRole(String user_id) {
        try {
            String strSelect = "select * from User-Role "
                    + "where user_id= ? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, user_id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //tài khoản tồn tại
                return true;
            }

        } catch (Exception e) {
            System.out.println("checkUserRole error : " + e.getMessage());

        }

        return false;
    }

    public void insertUser(String user_id, String account, String email, String password1, String createdate, String createtime) {

        try {

            String strSelect = "INSERT INTO [dbo].[Users] ([user_id],[user_account],[user_email],[user_password],[user_create_date],[user_create_time])\n"
                    + "VALUES (?,?,?,?,?,?)";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, user_id);
            pstm.setString(2, account);
            pstm.setString(3, email);
            pstm.setString(4, password1);
            pstm.setString(5, createdate);
            pstm.setString(6, createtime);

            pstm.execute();

        } catch (Exception e) {
            System.out.println("insertUser error : " + e.getMessage());

        }

    }

    public void insertUserRoleID(String user_id, String role_id) {

        try {

            String strSelect = "UPDATE Users\n"
                    + "SET role_id = ?\n"
                    + "WHERE user_id = ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, role_id);
            pstm.setString(2, user_id);

            pstm.execute();

        } catch (Exception e) {
            System.out.println("insertUserRoleID error : " + e.getMessage());

        }

    }

    public void updatePassword(String account, String newpassword1) {

        try {
            String strSelect = "update Users "
                    + "set user_password= ? "
                    + "where user_account= ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, newpassword1);
            pstm.setString(2, account);
            pstm.execute();

        } catch (Exception e) {
            System.out.println("updatePassword error : " + e.getMessage());

        }

    }

    public Users getUser(String acc, String pass) {
        Users userInfor = new Users();
        try {
            String strSelect = "select * from Users "
                    + "where user_account= ? and "
                    + "user_password=?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, acc);
            pstm.setString(2, pass);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("user_id");
                String account = rs.getString("user_account");
                String email = rs.getString("user_email");
                String password = rs.getString("user_password");

                SimpleDateFormat cd = new SimpleDateFormat("dd-MM-yyyy");
                String createdate = "";
                if (rs.getDate("user_create_date") != null) {
                    createdate = cd.format(rs.getDate("user_create_date"));
                }
                String createtime = String.valueOf(rs.getTime("user_create_time"));

                String firstname = rs.getString("user_firstname");
                String lastname = rs.getString("user_lastname");

                String gender = "Male";
                if (!rs.getBoolean("user_gender")) {
                    gender = "Female";
                }

                SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
                String dob = "";
                if (rs.getDate("user_dateofbirth") != null) {
                    dob = f.format(rs.getDate("user_dateofbirth"));
                }

                String phone = rs.getString("user_phone");
                String address = rs.getString("user_address");

                String avatar = rs.getString("user_avatar");
                String about = rs.getString("user_about");
                String role_id = rs.getString("role_id");

                Users u = new Users(id, account, email, password, createdate, createtime, firstname, lastname, gender, dob, phone, address, avatar, about, role_id);
                userInfor = u;
            }
        } catch (Exception e) {
            System.out.println("getUser error :" + e.getMessage());
        }
        return userInfor;
    }

    public Users getUserInfor(String userid) {
        Users userInfor = new Users();
        try {
            String strSelect = "select * from Users "
                    + "where user_id= ? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, userid);

            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("user_id");
                String account = rs.getString("user_account");
                String email = rs.getString("user_email");
                String password = rs.getString("user_password");

                SimpleDateFormat cd = new SimpleDateFormat("dd-MM-yyyy");
                String createdate = "";
                if (rs.getDate("user_create_date") != null) {
                    createdate = cd.format(rs.getDate("user_create_date"));
                }
                String createtime = String.valueOf(rs.getTime("user_create_time"));

                String firstname = rs.getString("user_firstname");
                String lastname = rs.getString("user_lastname");

                String gender = "Male";
                if (!rs.getBoolean("user_gender")) {
                    gender = "Female";
                }

                SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
                String dob = "";
                if (rs.getDate("user_dateofbirth") != null) {
                    dob = f.format(rs.getDate("user_dateofbirth"));
                }

                String phone = rs.getString("user_phone");
                String address = rs.getString("user_address");

                String avatar = rs.getString("user_avatar");
                String about = rs.getString("user_about");
                String role_id = rs.getString("role_id");

                Users u = new Users(id, account, email, password, createdate, createtime, firstname, lastname, gender, dob, phone, address, avatar, about, role_id);
                userInfor = u;
            }
        } catch (Exception e) {
            System.out.println("getUserInfor error :" + e.getMessage());
        }
        return userInfor;
    }

    public ArrayList<Users> getNumberPost() {
        ArrayList<Users> numberPost = new ArrayList<Users>();
        try {
            String strSelect = "SELECT u.user_id, COUNT(post_id) as 'Number Post'\n"
                    + "FROM  Users u\n"
                    + "left JOIN Posts p\n"
                    + "ON u.user_id = p.post_author_id\n"
                    + "GROUP BY u.user_id";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String user_id = rs.getString(1);
                int number_post = rs.getInt(2);

                Users u = new Users(user_id, number_post);

                numberPost.add(u);
            }
        } catch (Exception e) {
            System.out.println("getNumberPost error :" + e.getMessage());
        }
        return numberPost;

    }

    public ArrayList<Users> getNumberComment() {
        ArrayList<Users> numberComment = new ArrayList<Users>();
        try {
            String strSelect = "SELECT u.user_id, COUNT(comment_id) as 'Number Comment'\n"
                    + "FROM  Users u\n"
                    + "left JOIN Comments c\n"
                    + "ON u.user_id = c.user_id\n"
                    + "GROUP BY u.user_id";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String user_id = rs.getString(1);
                int number_post = rs.getInt(2);

                Users u = new Users(user_id, number_post);

                numberComment.add(u);
            }
        } catch (Exception e) {
            System.out.println("getNumberComment error :" + e.getMessage());
        }
        return numberComment;

    }

    public void UpdateInfor(String user_id, String user_account, String user_email, String user_firstname, String user_lastname, String user_gender, String user_dateofbirth, String user_phone, String user_address, String user_avatar, String user_about) {

        try {
            String strSelect = "update Users "
                    + "set user_account= ? , user_email= ? , user_firstname= ? , user_lastname= ? , user_gender= ? , user_dateofbirth= ? , user_phone= ? ,  user_address= ? , user_avatar= ? , user_about=? "
                    + "where user_id= ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, user_account);
            pstm.setString(2, user_email);
            pstm.setString(3, user_firstname);
            pstm.setString(4, user_lastname);
            pstm.setString(5, user_gender);
            pstm.setString(6, user_dateofbirth);
            pstm.setString(7, user_phone);
            pstm.setString(8, user_address);
            pstm.setString(9, user_avatar);
            pstm.setString(10, user_about);
            pstm.setString(11, user_id);
            pstm.execute();

        } catch (Exception e) {
            System.out.println("UpdateInfor error : " + e.getMessage());

        }
    }

    public ArrayList<Users> getListUser() {
        ArrayList<Users> listUser = new ArrayList<Users>();
        try {
            String strSelect = "  Select * from Users\n"
                    + "  order by user_account ";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String user_id = rs.getString(1);
                String user_account = rs.getString(2);
                String user_email = rs.getString(3);
                String user_password = rs.getString(4);

                SimpleDateFormat cd = new SimpleDateFormat("dd-MM-yyyy");
                String createdate = "";
                if (rs.getDate("user_create_date") != null) {
                    createdate = cd.format(rs.getDate("user_create_date"));
                }
                String createtime = String.valueOf(rs.getTime("user_create_time"));

                String user_firstname = rs.getString(7);
                String user_lastname = rs.getString(8);

                String gender = "Male";
                if (!rs.getBoolean("user_gender")) {
                    gender = "Female";
                }

                SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
                String dob = "";
                if (rs.getDate("user_dateofbirth") != null) {
                    dob = f.format(rs.getDate("user_dateofbirth"));
                }

                String user_phone = rs.getString(11);
                String user_address = rs.getString(12);
                String user_avatar = rs.getString(13);
                String user_about = rs.getString(14);
                String role_id = rs.getString(15);

                Users u = new Users(user_id, user_account, user_email, user_password, createdate, createtime, user_firstname, user_lastname, gender, dob, user_phone, user_address, user_avatar, user_about, role_id);

                listUser.add(u);

            }
        } catch (Exception e) {
            System.out.println("getListUser error :" + e.getMessage());
        }

        return listUser;

    }
    
   

    public void deleteUserByUserId(String user_id) {
        PostDAO p = new PostDAO();
        ArrayList<Posts> listpost = (ArrayList<Posts>) p.getListPost();
        for (Posts post : listpost) {
            if (post.getPost_author_id().equals(user_id)) {
                p.deletePostByPostId(post.getPost_id());
            }
        }
        
        try {
            String strSelect = "DELETE FROM Comments WHERE user_id= ?\n"
                    + "DELETE FROM Users WHERE user_id= ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, user_id);
            pstm.setString(2, user_id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //product tồn tại

            }

        } catch (Exception e) {
            System.out.println("deleteUserByUserId error : " + e.getMessage());

        }
    }

    public void updateUser(String user_id, String avatar) {
        try {
            String strSelect = "update Users "
                    + "set user_avatar= ? "
                    + "where user_id= ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, avatar);
            pstm.setString(2, user_id);
            pstm.execute();

        } catch (Exception e) {
            System.out.println("updateUser error : " + e.getMessage());

        }
    }

    public void changePass(String userid, String newpass1) {
        try {
            String strSelect = "update Users "
                    + "set user_password= ? "
                    + "where user_id= ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, newpass1);
            pstm.setString(2, userid);
            pstm.execute();

        } catch (Exception e) {
            System.out.println("changePass error : " + e.getMessage());

        }
    }

    public int getTotalUser() {
        try {

            String strSelect = "select count(*) from Users where role_id = 4";
            pstm = cnn.prepareStatement(strSelect);

            rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println("getTotalUser error :" + e.getMessage());
        }
        return 0;
    }

    public int getTotalAdmin() {
        try {

            String strSelect = "select count(*) from Users where role_id = 1";
            pstm = cnn.prepareStatement(strSelect);

            rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println("getTotalAdmin error :" + e.getMessage());
        }
        return 0;
    }

    public int getTotalPoster() {
        try {

            String strSelect = "select count(*) from Users where role_id = 2";
            pstm = cnn.prepareStatement(strSelect);

            rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println("getTotalPoster error :" + e.getMessage());
        }
        return 0;
    }

}
