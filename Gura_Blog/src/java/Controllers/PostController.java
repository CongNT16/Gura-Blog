/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DataAccess.CategoryDAO;
import DataAccess.CommentDAO;
import DataAccess.PostDAO;
import DataAccess.TagDAO;
import DataAccess.TopicDAO;
import DataAccess.UserDAO;
import Models.Categories;
import Models.Comments;
import Models.Posts;
import Models.Tags;
import Models.Topics;
import Models.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author nguye
 */
public class PostController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        CommentDAO cm = new CommentDAO();

        String postid = req.getParameter("postid");
        String userid = req.getParameter("userid");
        String commentdetail = req.getParameter("commentdetail");

        //Tạo 1 mess_id mới
        String comment_id = "";

        while (cm.checkCommentId(comment_id) == false) {
            Random generator = new Random();
//            comment_id = String.valueOf(generator.nextInt((99999999 - 10000000) + 1) + 10000000);
            long rannum = (long) Math.floor(Math.random() * (9999999999L - 1000000000L + 1) + 1000000000L);
            comment_id = String.valueOf(rannum);

            //get time local
            LocalDate getdate = LocalDate.now();
            LocalTime gettime = LocalTime.now();

            String createdate = String.valueOf(getdate);
            String createtime = String.valueOf(gettime);

            cm.insertComment(comment_id, userid, postid, commentdetail, createdate, createtime);

            break;
        }

        resp.sendRedirect("PostController?postid=" + postid);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String getpostid = req.getParameter("postid");
        PostDAO p = new PostDAO();
        TopicDAO t = new TopicDAO();
        TagDAO tg = new TagDAO();
        CategoryDAO c = new CategoryDAO();
        UserDAO u = new UserDAO();
        CommentDAO cm = new CommentDAO();

        Posts postDetail = p.getPost(getpostid);
        Topics topicWithpost = t.getTopic(getpostid);
        Categories categoryWithTopic = c.getCategory(postDetail.getTopic_id());
        Users userInforAuthor = u.getUserInfor(postDetail.getPost_author_id());
        p.updateNumberView(postDetail.getNumber_view(), postDetail.getPost_id());
        ArrayList<Categories> listbarCategory = (ArrayList<Categories>) c.getListCategory();
        req.setAttribute("listbarCategory", listbarCategory);

        ArrayList<Categories> numberTopic = (ArrayList<Categories>) c.getNumberTopic();
        req.setAttribute("numberTopic", numberTopic);

        ArrayList<Tags> listPostTag = (ArrayList<Tags>) tg.getPostTag();
        req.setAttribute("listPostTag", listPostTag);

        ArrayList<Comments> listComment = (ArrayList<Comments>) cm.getListCommentASC();
        req.setAttribute("listComment", listComment);

        ArrayList<Users> listUser = (ArrayList<Users>) u.getListUser();
        req.setAttribute("listUser", listUser);

        req.setAttribute("post_id", postDetail.getPost_id());
        req.setAttribute("post_title", postDetail.getPost_title());
        if (p.checkPostId(postDetail.getPost_id())) {
            req.setAttribute("post_view", postDetail.getNumber_view());
        }

        req.setAttribute("topic_id", postDetail.getTopic_id());
        req.setAttribute("post_body", postDetail.getPost_body());
        req.setAttribute("post_author_id", postDetail.getPost_author_id());
        req.setAttribute("post_create_date", postDetail.getPost_create_date());
        req.setAttribute("imagename", postDetail.getImg_filename());

        req.setAttribute("topic", topicWithpost.getTopic_name());
        req.setAttribute("topic_id", topicWithpost.getTopic_id());

        req.setAttribute("category", categoryWithTopic.getCategory_name());
        req.setAttribute("category_id", categoryWithTopic.getCategory_id());

        req.setAttribute("avatar_author", userInforAuthor.getUser_avatar());
        String fullname_author = userInforAuthor.getUser_firstname() + " " + userInforAuthor.getUser_lastname();
        req.setAttribute("name_author", fullname_author);

        ArrayList<Posts> numberComment = (ArrayList<Posts>) p.getNumberCommentCofirm();
        req.setAttribute("numberComment", numberComment);

        req.getRequestDispatcher("post.jsp").forward(req, resp);
    }

}
