/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import ConnectDB.ConnectDB_Blog;
import Models.Categories;
import Models.Topics;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class CategoryDAO extends ConnectDB_Blog {

    public CategoryDAO() {
        connectDB();
    }

    Connection cnn;
    Statement stm;
    ResultSet rs;
    PreparedStatement pstm;

    private void connectDB() {
        try {

            cnn = super.connection;
            System.out.println("Connect CategoryDAO success");

        } catch (Exception e) {
            System.out.println("Connect CategoryDAO error : " + e.getMessage());
        }
    }

    public static void main(String[] args) {

    }

    public boolean checkCategoryId(String category_id) {
        try {
            String strSelect = "select * from Categories "
                    + "where category_id= ? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, category_id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //tài khoản tồn tại
                return true;
            }

        } catch (Exception e) {
            System.out.println("checkCategoryId error : " + e.getMessage());

        }

        return false;
    }

    public ArrayList<Categories> getAllCategory() {
        ArrayList<Categories> listTopicCategory = new ArrayList<Categories>();
        try {
            String strSelect = "Select c.*,t.topic_id from Categories c\n"
                    + "  join Topics t on  c.category_id = t.category_id\n"
                    + "  order by c.category_name asc";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String category_id = rs.getString(1);
                String category_name = rs.getString(2);
                String topic_id = rs.getString(3);

                Categories c = new Categories(category_id, category_name, topic_id);

                listTopicCategory.add(c);
            }
        } catch (Exception e) {
            System.out.println("getAllCategory error :" + e.getMessage());
        }
        return listTopicCategory;

    }

    public ArrayList<Categories> getListCategory() {
        ArrayList<Categories> listCategory = new ArrayList<Categories>();
        try {
            String strSelect = "Select * from Categories "
                    + "order by category_name asc";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String category_id = rs.getString(1);
                String category_name = rs.getString(2);

                Categories c = new Categories(category_id, category_name);

                listCategory.add(c);
            }
        } catch (Exception e) {
            System.out.println("getListCategory error :" + e.getMessage());
        }
        return listCategory;

    }

    public ArrayList<Categories> getNumberTopic() {
        ArrayList<Categories> numberTopic = new ArrayList<Categories>();
        try {
            String strSelect = "SELECT c.category_id, COUNT(topic_id) as 'Number Topic'\n"
                    + "FROM  Categories c\n"
                    + "left JOIN Topics t\n"
                    + "ON c.category_id = t.category_id\n"
                    + "GROUP BY c.category_id;";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String category_id = rs.getString(1);
                int number_topic = rs.getInt(2);

                Categories c = new Categories(category_id, number_topic);

                numberTopic.add(c);
            }
        } catch (Exception e) {
            System.out.println("getNumberTopic error :" + e.getMessage());
        }
        return numberTopic;

    }

    public Categories getCategory(String gettopicid) {
        Categories categoryWithTopicid = new Categories();
        try {
            String strSelect = "Select c.*,t.topic_id from Categories c\n"
                    + "join Topics t on  c.category_id = t.category_id\n"
                    + "where topic_id = ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, gettopicid);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String category_id = rs.getString(1);
                String category_name = rs.getString(2);
                String topic_id = rs.getString(3);

                Categories c = new Categories(category_id, category_name, topic_id);

                categoryWithTopicid = c;

            }
        } catch (Exception e) {
            System.out.println("getCategory error :" + e.getMessage());
        }

        return categoryWithTopicid;

    }

    public void insertCategory(String category_id, String category_name) {
        try {

            String strSelect = "INSERT INTO [Categories] (category_id, category_name)\n"
                    + "VALUES (?,?)";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, category_id);
            pstm.setString(2, category_name);

            pstm.execute();

        } catch (Exception e) {
            System.out.println("insertCategory error : " + e.getMessage());

        }
    }

    public void deleteCategoryByCategoryId(String categoryid) {
        TopicDAO t = new TopicDAO();
        
        ArrayList<Topics> listtopic = (ArrayList<Topics>) t.getListTopic();
        for (Topics topic : listtopic) {
            if (topic.getCategory_id().equals(categoryid)) {
                t.deleteTopicByTopicId(topic.getTopic_id());
            }
        }
        
        try {
            String strSelect = "DELETE FROM Categories WHERE category_id= ?\n";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, categoryid);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //product tồn tại

            }

        } catch (Exception e) {
            System.out.println("deleteCategoryByCategoryId error : " + e.getMessage());

        }
        

    }

    public Categories getCategoryWithCategoryID(String categoryid) {
        Categories category = new Categories();
        try {
            String strSelect = "Select * from Categories \n"
                    + "where category_id = ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, categoryid);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String category_id = rs.getString(1);
                String category_name = rs.getString(2);

                Categories c = new Categories(category_id, category_name);

                category = c;

            }
        } catch (Exception e) {
            System.out.println("getCategoryWithCategoryID error :" + e.getMessage());
        }
        return category;

    }

    public void updateEditCategory(String category_id, String category_name) {

        try {
            String strSelect = "UPDATE Categories\n"
                    + "SET category_name =? \n"
                    + "WHERE category_id = ?;";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, category_name);
            pstm.setString(2, category_id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //product tồn tại

            }

        } catch (Exception e) {
            System.out.println("updateEditCategory error : " + e.getMessage());

        }

    }

    public int getTotalCategory() {
        try {

            String strSelect = "select count(*) from Categories ";
            pstm = cnn.prepareStatement(strSelect);

            rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println("getTotalCategory error :" + e.getMessage());
        }
        return 0;
    }

    public boolean checkCategoryName(String category_name) {
        try {
            String strSelect = "select * from Categories "
                    + "where category_name= ? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, category_name);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //tài khoản tồn tại
                return true;
            }

        } catch (Exception e) {
            System.out.println("checkCategoryName error : " + e.getMessage());

        }

        return false;
    }

}
