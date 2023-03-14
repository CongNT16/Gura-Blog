/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import ConnectDB.ConnectDB_Blog;
import Models.Posts;
import Models.Questions;
import Models.Users;
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
public class QuestionDAO extends ConnectDB.ConnectDB_Blog{
    
    public QuestionDAO() {
        connectDB();

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
    
    public static void main(String[] args) {
        
    }
    
    public ArrayList<Questions> getListQuestion() {
        ArrayList<Questions> listQuestion = new ArrayList<Questions>();
        try {
            String strSelect = "  Select * from Questions\n"
                    + "  order by ID ";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String question = rs.getString(2);
                String answ1 = rs.getString(3);
                String answ2 = rs.getString(4);
                String answ3 = rs.getString(5);
                String answ4 = rs.getString(6);
                String result = rs.getString(7);

                Questions q = new Questions(id, question, answ1, answ2, answ3, answ4, result);

                listQuestion.add(q);

            }
        } catch (Exception e) {
            System.out.println("getListUser error :" + e.getMessage());
        }

        return listQuestion;

    }
    
    public ArrayList<Questions> getListQuestionTop1() {
        ArrayList<Questions> listQuestion = new ArrayList<Questions>();
        try {
            String strSelect = "  Select * from Questions\n"
                    + "  where ID = 1 ";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String question = rs.getString(2);
                String answ1 = rs.getString(3);
                String answ2 = rs.getString(4);
                String answ3 = rs.getString(5);
                String answ4 = rs.getString(6);
                String result = rs.getString(7);

                Questions q = new Questions(id, question, answ1, answ2, answ3, answ4, result);

                listQuestion.add(q);

            }
        } catch (Exception e) {
            System.out.println("getListUser error :" + e.getMessage());
        }

        return listQuestion;

    }
    
    public int getTotalQuestion() {

        try {

            String strSelect = "select count(*) from Questions ";
            pstm = cnn.prepareStatement(strSelect);

            rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println("getTotalQuestion error :" + e.getMessage());
        }
        return 0;
    }
    
    public ArrayList<Questions> getPageQuestionView(int index) {
        ArrayList<Questions> listQuestion = new ArrayList<Questions>();
        try {
            String strSelect = "  Select * from Questions \n"
                    + "  Order by ID\n"
                    + "  OFFSET ? ROWS FETCH NEXT 1 ROWS ONLY ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, (index - 1) * 1);
            rs = pstm.executeQuery();
            while (rs.next()) {
                 String id = rs.getString(1);
                String question = rs.getString(2);
                String answ1 = rs.getString(3);
                String answ2 = rs.getString(4);
                String answ3 = rs.getString(5);
                String answ4 = rs.getString(6);
                String result = rs.getString(7);

                Questions q = new Questions(id, question, answ1, answ2, answ3, answ4, result);

                listQuestion.add(q);
            }
        } catch (Exception e) {
            System.out.println("getPagePostView error :" + e.getMessage());
        }
        return listQuestion;
    }
    
}
