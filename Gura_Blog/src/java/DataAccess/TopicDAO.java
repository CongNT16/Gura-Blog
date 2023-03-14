/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import ConnectDB.ConnectDB_Blog;
import Models.Categories;
import Models.Posts;
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
public class TopicDAO extends ConnectDB_Blog {

    public TopicDAO() {
        connectDB();
    }

    Connection cnn;
    Statement stm;
    ResultSet rs;
    PreparedStatement pstm;

    private void connectDB() {
        try {

            cnn = super.connection;
            System.out.println("Connect TopicDAO success");

        } catch (Exception e) {
            System.out.println("Connect TopicDAO error : " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        TopicDAO t = new TopicDAO();
        CategoryDAO c = new CategoryDAO();
        ArrayList<Topics> listPostTopic = (ArrayList<Topics>) t.getAllPostTopic();

        for (Topics topic : listPostTopic) {
            System.out.println(topic.getTopic_name());
        }

        Topics topicWithTopicId = t.getTopicWithTopicID("8719");
        Categories categoryWithCategoryId = c.getCategoryWithCategoryID(topicWithTopicId.getCategory_id());

        System.out.println(topicWithTopicId.getCategory_id() + "" + categoryWithCategoryId.getCategory_name());

    }

    public boolean checkTopicId(String topic_id) {
        try {
            String strSelect = "select * from Topics "
                    + "where topic_id= ? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, topic_id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //tài khoản tồn tại
                return true;
            }

        } catch (Exception e) {
            System.out.println("checkTopicId error : " + e.getMessage());

        }

        return false;

    }

    public ArrayList<Topics> getAllPostTopic() {
        ArrayList<Topics> listPostTopic = new ArrayList<Topics>();
        try {
            String strSelect = "Select t.*,p.post_id from Topics t\n"
                    + "  join Posts p on t.topic_id = p.topic_id\n"
                    + "  order by topic_name asc";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String topic_id = rs.getString(1);
                String topic_name = rs.getString(2);
                String category_id = rs.getString(3);
                String post_id = rs.getString(4);

                Topics t = new Topics(topic_id, topic_name, post_id, category_id);

                listPostTopic.add(t);
            }
        } catch (Exception e) {
            System.out.println("getAllPostTopic error :" + e.getMessage());
        }
        return listPostTopic;

    }

    public ArrayList<Topics> getNumberPost() {
        ArrayList<Topics> numberPost = new ArrayList<Topics>();
        try {
            String strSelect = "SELECT t.topic_id, COUNT(post_id) as 'Number Post'\n"
                    + "FROM  Topics t\n"
                    + "left JOIN Posts p\n"
                    + "ON t.topic_id = p.topic_id\n"
                    + "GROUP BY t.topic_id;";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String topic_id = rs.getString(1);
                int number_post = rs.getInt(2);

                Topics t = new Topics(topic_id, number_post);

                numberPost.add(t);
            }
        } catch (Exception e) {
            System.out.println("getNumberPost error :" + e.getMessage());
        }
        return numberPost;

    }

    public Topics getTopic(String getpostid) {
        Topics topicWithPostId = new Topics();
        try {
            String strSelect = "Select t.*,p.post_id from Topics t\n"
                    + "join Posts p on t.topic_id = p.topic_id\n"
                    + "where post_id = ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, getpostid);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String topic_id = rs.getString(1);
                String topic_name = rs.getString(2);
                String category_id = rs.getString(3);
                String post_id = rs.getString(4);

                Topics t = new Topics(topic_id, topic_name, post_id, category_id);

                topicWithPostId = t;

            }
        } catch (Exception e) {
            System.out.println("getTopic error :" + e.getMessage());
        }

        return topicWithPostId;

    }

    public ArrayList<Topics> getTopicWithCategoryId(String getcategoryid) {
        ArrayList<Topics> listTopicWithCategoryId = new ArrayList<Topics>();
        try {
            String strSelect = "Select t.*, c.category_name from Topics t\n"
                    + "  left join Categories c on t.category_id = c.category_id\n"
                    + "  where c.category_id = ?\n"
                    + "  order by t.topic_name asc";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, getcategoryid);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String topic_id = rs.getString(1);
                String topic_name = rs.getString(2);
                String category_id = rs.getString(3);
                String post_id = rs.getString(4);

                Topics t = new Topics(topic_id, topic_name, post_id, category_id);

                listTopicWithCategoryId.add(t);

            }
        } catch (Exception e) {
            System.out.println("getTopicWithCategoryId error :" + e.getMessage());
        }

        return listTopicWithCategoryId;

    }

    public ArrayList<Topics> getListTopic() {
        ArrayList<Topics> listTopic = new ArrayList<Topics>();
        try {
            String strSelect = "Select * from Topics\n"
                    + "  order by topic_name asc";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String topic_id = rs.getString(1);
                String topic_name = rs.getString(2);
                String category_id = rs.getString(3);

                Topics t = new Topics(topic_id, topic_name, category_id);

                listTopic.add(t);

            }
        } catch (Exception e) {
            System.out.println("getListTopic error :" + e.getMessage());
        }

        return listTopic;

    }

    public void insertTopic(String topic_id, String topic_name, String category_id) {
        try {

            String strSelect = "INSERT INTO [Topics] (topic_id, topic_name , category_id)\n"
                    + "VALUES (?,?,?)";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, topic_id);
            pstm.setString(2, topic_name);
            pstm.setString(3, category_id);

            pstm.execute();

        } catch (Exception e) {
            System.out.println("insertTopic error : " + e.getMessage());

        }
    }

    public void deleteTopicByTopicId(String topicid) {
        PostDAO p = new PostDAO();

        ArrayList<Posts> listpost = (ArrayList<Posts>) p.getListPost();
        for (Posts post : listpost) {
            if (post.getTopic_id().equals(topicid)) {
                p.deletePostByPostId(post.getPost_id());
            }
        }

        try {
            String strSelect = "DELETE FROM Topics WHERE topic_id= ?\n";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, topicid);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //product tồn tại

            }

        } catch (Exception e) {
            System.out.println("deleteTopicByTopicId error : " + e.getMessage());

        }

    }

    public Topics getTopicWithTopicID(String topicid) {
        Topics topic = new Topics();
        try {
            String strSelect = "Select * from Topics \n"
                    + "where topic_id = ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, topicid);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String topic_id = rs.getString(1);
                String topic_name = rs.getString(2);
                String category_id = rs.getString(3);

                Topics t = new Topics(topic_id, topic_name, category_id);

                topic = t;

            }
        } catch (Exception e) {
            System.out.println("getTopicWithTopicID error :" + e.getMessage());
        }
        return topic;

    }

    public void updateEditTopic(String topic_id, String topic_name, String category_id) {
        try {
            String strSelect = "UPDATE Topics\n"
                    + "SET topic_name =? , category_id = ?\n"
                    + "WHERE topic_id = ?;";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, topic_name);
            pstm.setString(2, category_id);
            pstm.setString(3, topic_id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //product tồn tại

            }

        } catch (Exception e) {
            System.out.println("updateEditTopic error : " + e.getMessage());

        }
    }

    public int getTotalTopic() {
        try {

            String strSelect = "select count(*) from Topics";
            pstm = cnn.prepareStatement(strSelect);

            rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println("getTotalTopic error :" + e.getMessage());
        }
        return 0;
    }

    public boolean checkTopicName(String topic_name) {
        try {
            String strSelect = "select * from Topics "
                    + "where topic_name= ? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, topic_name);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //tài khoản tồn tại
                return true;
            }

        } catch (Exception e) {
            System.out.println("checkTopicName error : " + e.getMessage());

        }

        return false;
    }

}
