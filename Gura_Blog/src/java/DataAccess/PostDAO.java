/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import ConnectDB.ConnectDB_Blog;
import Models.Posts;
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
public class PostDAO extends ConnectDB_Blog {

    public PostDAO() {
        connectDB();

    }

    public static void main(String[] args) {
        PostDAO p = new PostDAO();
//        ArrayList<Posts> listpost = (ArrayList<Posts>)p.getAllPost();
//        for (Posts post : listpost) {
//            System.out.println(post.getPost_create_date());}

        ArrayList<Posts> listpost = (ArrayList<Posts>) p.getListPostWithKeyWord("%hello%");
        for (Posts post : listpost) {
            System.out.println(post.getPost_title());
            if (post.getPost_id() == null) {
                System.out.println("không có kết quả");
            }
        }

        String test = String.valueOf(listpost);

        if (test.equals(null)) {
            System.out.println("không có kết quả");
        }

//        long rannum = (long) Math.floor(Math.random() * (9999999999L - 1000000000L + 1) + 1000000000L);
//        System.out.println(rannum);
//
//        int count = p.getTotalPost();
//        System.out.println(count);
//
//        Posts postDetail = p.getPost("1263748920");
//        System.out.println(postDetail.getPost_title());
    }

    //Khai bao cac thanh phan xu ly
    Connection cnn;
    Statement stm;
    ResultSet rs;
    PreparedStatement pstm;

    private void connectDB() {
        try {

            cnn = super.connection;
            System.out.println("Connect PostDAO success");

        } catch (Exception e) {
            System.out.println("Connect PostDAO error : " + e.getMessage());
        }
    }

    public boolean checkPostId(String post_id) {
        try {
            String strSelect = "select * from Posts "
                    + "where post_id= ? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, post_id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //tài khoản tồn tại
                return true;
            }

        } catch (Exception e) {
            System.out.println("checkPostId error : " + e.getMessage());

        }

        return false;
    }

    public ArrayList<Posts> getAllPost() {
        ArrayList<Posts> listpost = new ArrayList<Posts>();
        try {
            String strSelect = "Select p.*, tp.topic_name,c.category_id,c.category_name \n"
                    + "  from Posts p \n"
                    + "  join Topics tp on p.topic_id = tp.topic_id \n"
                    + "  join Categories c on c.category_id = tp.category_id\n"
                    + "  Order by post_create_date DESC,post_create_time DESC";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String post_id = rs.getString(1);
                String post_title = rs.getString(2);
                String topic_id = rs.getString(3);

                SimpleDateFormat cd = new SimpleDateFormat("dd-MM-yyyy");
                String createdate = "";
                if (rs.getDate("post_create_date") != null) {
                    createdate = cd.format(rs.getDate("post_create_date"));
                }
                String createtime = String.valueOf(rs.getTime("post_create_time"));

                String post_body = rs.getString(6);
                String post_author_id = rs.getString(7);
                String img_filename = rs.getString(8);
                int number_view = rs.getInt(9);
                String topic_name = rs.getString(10);
                String category_id = rs.getString(11);
                String category_name = rs.getString(12);

                Posts p = new Posts(post_id, post_title, topic_id, createdate, createtime, post_body, post_author_id, img_filename, number_view, topic_name, category_id, category_name);

                listpost.add(p);
            }
        } catch (Exception e) {
            System.out.println("getAllPost error :" + e.getMessage());
        }
        return listpost;
    }

    public ArrayList<Posts> getAllPostPage(int index) {
        ArrayList<Posts> listpost = new ArrayList<Posts>();
        try {
            String strSelect = "Select p.*, tp.topic_name,c.category_id,c.category_name \n"
                    + "  from Posts p \n"
                    + "  join Topics tp on p.topic_id = tp.topic_id \n"
                    + "  join Categories c on c.category_id = tp.category_id\n"
                    + "  Order by post_create_date DESC,post_create_time DESC\n"
                    + "  OFFSET ? ROWS FETCH NEXT 7 ROWS ONLY ;";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, (index - 1) * 7);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String post_id = rs.getString(1);
                String post_title = rs.getString(2);
                String topic_id = rs.getString(3);

                SimpleDateFormat cd = new SimpleDateFormat("dd-MM-yyyy");
                String createdate = "";
                if (rs.getDate("post_create_date") != null) {
                    createdate = cd.format(rs.getDate("post_create_date"));
                }
                String createtime = String.valueOf(rs.getTime("post_create_time"));

                String post_body = rs.getString(6);
                String post_author_id = rs.getString(7);
                String img_filename = rs.getString(8);
                int number_view = rs.getInt(9);
                String topic_name = rs.getString(10);
                String category_id = rs.getString(11);
                String category_name = rs.getString(12);

                Posts p = new Posts(post_id, post_title, topic_id, createdate, createtime, post_body, post_author_id, img_filename, number_view, topic_name, category_id, category_name);

                listpost.add(p);
            }
        } catch (Exception e) {
            System.out.println("getAllPostPage error :" + e.getMessage());
        }
        return listpost;
    }

    public Posts getPost(String getPostid) {
        Posts postDetail = new Posts();
        try {
            String strSelect = "select * from Posts "
                    + "where post_id= ? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, getPostid);

            rs = pstm.executeQuery();
            while (rs.next()) {
                String post_id = rs.getString(1);
                String post_title = rs.getString(2);
                String topic_id = rs.getString(3);

                SimpleDateFormat cd = new SimpleDateFormat("dd-MM-yyyy");
                String createdate = "";
                if (rs.getDate("post_create_date") != null) {
                    createdate = cd.format(rs.getDate("post_create_date"));
                }
                String createtime = String.valueOf(rs.getTime("post_create_time"));

                String post_body = rs.getString(6);
                String post_author_id = rs.getString(7);
                String img_filename = rs.getString(8);
                int number_view = rs.getInt(9);

                Posts p = new Posts(post_id, post_title, topic_id, createdate, createtime, post_body, post_author_id, img_filename, number_view);

                postDetail = p;
            }
        } catch (Exception e) {
            System.out.println("getPost error :" + e.getMessage());
        }
        return postDetail;
    }

    public ArrayList<Posts> getNumberComment() {
        ArrayList<Posts> numberComment = new ArrayList<Posts>();
        try {
            String strSelect = "SELECT p.post_id, COUNT(comment_id) as 'Number Comment'\n"
                    + "FROM  Posts p\n"
                    + "left JOIN Comments c\n"
                    + "ON p.post_id = c.post_id\n"
                    + "GROUP BY p.post_id";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String post_id = rs.getString(1);
                int number_post = rs.getInt(2);

                Posts p = new Posts(post_id, number_post);

                numberComment.add(p);
            }
        } catch (Exception e) {
            System.out.println("getNumberComment error :" + e.getMessage());
        }
        return numberComment;

    }

    public ArrayList<Posts> getNumberCommentCofirm() {
        ArrayList<Posts> numberComment = new ArrayList<Posts>();
        try {
            String strSelect = "SELECT p.post_id, COUNT(comment_id) as 'Number Comment'\n"
                    + "  FROM  Posts p\n"
                    + "  left JOIN Comments c\n"
                    + "  ON p.post_id = c.post_id\n"
                    + "  where c.comment_status = '1'\n"
                    + "  GROUP BY p.post_id";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String post_id = rs.getString(1);
                int number_post = rs.getInt(2);

                Posts p = new Posts(post_id, number_post);

                numberComment.add(p);
            }
        } catch (Exception e) {
            System.out.println("getNumberCommentCofirm error :" + e.getMessage());
        }
        return numberComment;

    }

    //đếm số lượng post trong database
    public int getTotalPost() {

        try {

            String strSelect = "select count(*) from Posts ";
            pstm = cnn.prepareStatement(strSelect);

            rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println("getTotalPost error :" + e.getMessage());
        }
        return 0;
    }

    public ArrayList<Posts> getPagePost(int index) {
        ArrayList<Posts> listPagePost = new ArrayList<Posts>();
        try {
            String strSelect = "SELECT * FROM Posts \n"
                    + "Order by post_create_date DESC,post_create_time DESC \n"
                    + "OFFSET ? ROWS FETCH NEXT 7 ROWS ONLY ;";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, (index - 1) * 7);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String post_id = rs.getString(1);
                String post_title = rs.getString(2);
                String topic_id = rs.getString(3);

                SimpleDateFormat cd = new SimpleDateFormat("dd-MM-yyyy");
                String createdate = "";
                if (rs.getDate("post_create_date") != null) {
                    createdate = cd.format(rs.getDate("post_create_date"));
                }
                String createtime = String.valueOf(rs.getTime("post_create_time"));

                String post_body = rs.getString(6);
                String post_author_id = rs.getString(7);
                String img_filename = rs.getString(8);
                int number_view = rs.getInt(9);

                Posts p = new Posts(post_id, post_title, topic_id, createdate, createtime, post_body, post_author_id, img_filename, number_view);

                listPagePost.add(p);
            }
        } catch (Exception e) {
            System.out.println("getPagePost error :" + e.getMessage());
        }
        return listPagePost;
    }

    public ArrayList<Posts> getPagePostView(int index) {
        ArrayList<Posts> listPagePost = new ArrayList<Posts>();
        try {
            String strSelect = "  SELECT * FROM Posts \n"
                    + "  Order by post_view desc\n"
                    + "  OFFSET ? ROWS FETCH NEXT 7 ROWS ONLY ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, (index - 1) * 7);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String post_id = rs.getString(1);
                String post_title = rs.getString(2);
                String topic_id = rs.getString(3);

                SimpleDateFormat cd = new SimpleDateFormat("dd-MM-yyyy");
                String createdate = "";
                if (rs.getDate("post_create_date") != null) {
                    createdate = cd.format(rs.getDate("post_create_date"));
                }
                String createtime = String.valueOf(rs.getTime("post_create_time"));

                String post_body = rs.getString(6);
                String post_author_id = rs.getString(7);
                String img_filename = rs.getString(8);
                int number_view = rs.getInt(9);

                Posts p = new Posts(post_id, post_title, topic_id, createdate, createtime, post_body, post_author_id, img_filename, number_view);

                listPagePost.add(p);
            }
        } catch (Exception e) {
            System.out.println("getPagePostView error :" + e.getMessage());
        }
        return listPagePost;
    }

    public ArrayList<Posts> getListPost() {
        ArrayList<Posts> listPost = new ArrayList<Posts>();
        try {
            String strSelect = "SELECT * FROM Posts \n"
                    + "Order by post_create_date DESC,post_create_time DESC \n";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String post_id = rs.getString(1);
                String post_title = rs.getString(2);
                String topic_id = rs.getString(3);

                SimpleDateFormat cd = new SimpleDateFormat("dd-MM-yyyy");
                String createdate = "";
                if (rs.getDate("post_create_date") != null) {
                    createdate = cd.format(rs.getDate("post_create_date"));
                }
                String createtime = String.valueOf(rs.getTime("post_create_time"));

                String post_body = rs.getString(6);
                String post_author_id = rs.getString(7);
                String img_filename = rs.getString(8);
                int number_view = rs.getInt(9);

                Posts p = new Posts(post_id, post_title, topic_id, createdate, createtime, post_body, post_author_id, img_filename, number_view);

                listPost.add(p);
            }
        } catch (Exception e) {
            System.out.println("getListPost error :" + e.getMessage());
        }
        return listPost;
    }

    public ArrayList<Posts> getListTopThreePostTopic() {
        ArrayList<Posts> listPost = new ArrayList<Posts>();
        try {
            String strSelect = "with D as (\n"
                    + "SELECT *,row_number() \n"
                    + "over (partition by topic_id \n"
                    + "      Order by post_create_date DESC ,post_create_time DESC) rn\n"
                    + "From Posts)\n"
                    + "SELECT *\n"
                    + "FROM D\n"
                    + "WHERE rn <= 3\n"
                    + "Order by post_create_date DESC ,post_create_time DESC";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String post_id = rs.getString(1);
                String post_title = rs.getString(2);
                String topic_id = rs.getString(3);

                SimpleDateFormat cd = new SimpleDateFormat("dd-MM-yyyy");
                String createdate = "";
                if (rs.getDate("post_create_date") != null) {
                    createdate = cd.format(rs.getDate("post_create_date"));
                }
                String createtime = String.valueOf(rs.getTime("post_create_time"));

                String post_body = rs.getString(6);
                String post_author_id = rs.getString(7);
                String img_filename = rs.getString(8);
                int number_view = rs.getInt(9);

                Posts p = new Posts(post_id, post_title, topic_id, createdate, createtime, post_body, post_author_id, img_filename, number_view);

                listPost.add(p);
            }
        } catch (Exception e) {
            System.out.println("getListTopThreePostTopic error :" + e.getMessage());
        }
        return listPost;
    }

    public ArrayList<Posts> getListPostWithKeyWord(String keyWord) {
        ArrayList<Posts> listPost = new ArrayList<Posts>();
        try {
            String strSelect = "SELECT *\n"
                    + "from Posts\n"
                    + "WHERE post_title LIKE ?\n"
                    + "Order by post_create_date DESC,post_create_time DESC";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, "%" + keyWord + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                String post_id = rs.getString(1);
                String post_title = rs.getString(2);
                String topic_id = rs.getString(3);

                SimpleDateFormat cd = new SimpleDateFormat("dd-MM-yyyy");
                String createdate = "";
                if (rs.getDate("post_create_date") != null) {
                    createdate = cd.format(rs.getDate("post_create_date"));
                }
                String createtime = String.valueOf(rs.getTime("post_create_time"));

                String post_body = rs.getString(6);
                String post_author_id = rs.getString(7);
                String img_filename = rs.getString(8);
                int number_view = rs.getInt(9);

                Posts p = new Posts(post_id, post_title, topic_id, createdate, createtime, post_body, post_author_id, img_filename, number_view);

                listPost.add(p);
            }
        } catch (Exception e) {
            System.out.println("getListPostWithKeyWord error :" + e.getMessage());
        }
        return listPost;
    }

    public void insertCreatePost(String post_id, String post_title, String topic_id, String post_create_date, String post_create_time, String post_body, String post_author_id, String image_filename) {
        try {

            String strSelect = "INSERT INTO [dbo].[Posts] ([post_id],[post_title],[topic_id],[post_create_date],[post_create_time],[post_body],[post_author_id],[img_filename])\n"
                    + "VALUES (?,?,?,?,?,?,?,?)";

            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, post_id);
            pstm.setString(2, post_title);
            pstm.setString(3, topic_id);
            pstm.setString(4, post_create_date);
            pstm.setString(5, post_create_time);
            pstm.setString(6, post_body);
            pstm.setString(7, post_author_id);
            pstm.setString(8, image_filename);

            pstm.execute();

        } catch (Exception e) {
            System.out.println("insertCreatePost error : " + e.getMessage());

        }
    }

    public void deletePostByPostId(String post_id) {
        try {
            String strSelect = "DELETE FROM PostTag WHERE post_id= ?\n"
                    + "DELETE FROM Comments WHERE post_id= ?\n"
                    + "DELETE FROM Posts WHERE post_id= ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, post_id);
            pstm.setString(2, post_id);
            pstm.setString(3, post_id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //product tồn tại

            }

        } catch (Exception e) {
            System.out.println("deletePostByPostId error : " + e.getMessage());

        }
    }

    public void updateEditPost(String post_id, String post_title, String topic_id, String post_detail, String img_filename) {

        try {
            String strSelect = "UPDATE Posts\n"
                    + "SET post_title =?,topic_id =?,post_body =?, img_filename = ?\n"
                    + "WHERE post_id = ?;";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, post_title);
            pstm.setString(2, topic_id);
            pstm.setString(3, post_detail);
            pstm.setString(4, img_filename);
            pstm.setString(5, post_id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //product tồn tại

            }

        } catch (Exception e) {
            System.out.println("updateEditPost error : " + e.getMessage());

        }

    }

    public boolean checkPostTitle(String post_title) {
        try {
            String strSelect = "select * from Posts "
                    + "where post_title= ? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, post_title);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //tài khoản tồn tại
                return true;
            }

        } catch (Exception e) {
            System.out.println("checkPostTitle error : " + e.getMessage());

        }

        return false;
    }

    public int getNumberSearch(String keyWord) {
        int numberSearch = 0;
        try {
            String strSelect = "select count(*) as 'number search'\n"
                    + "  from (\n"
                    + "  SELECT *\n"
                    + "  from Posts\n"
                    + "  WHERE post_title LIKE ? ) as s";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, "%" + keyWord + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                int result = rs.getInt(1);

                numberSearch = result;
            }
        } catch (Exception e) {
            System.out.println("getNumberSearch error :" + e.getMessage());
        }
        return numberSearch;

    }

    public void updateNumberView(int post_view, String post_id) {

        try {
            String strSelect = "UPDATE Posts\n"
                    + "SET post_view =?\n"
                    + "WHERE post_id = ?;";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, post_view + 1);
            pstm.setString(2, post_id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //product tồn tại

            }

        } catch (Exception e) {
            System.out.println("updateNumberView error : " + e.getMessage());

        }

    }

}
