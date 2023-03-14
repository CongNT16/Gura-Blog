/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DataAccess.CategoryDAO;
import DataAccess.PostDAO;
import DataAccess.TagDAO;
import DataAccess.TopicDAO;
import DataAccess.UserDAO;
import DataAccess.WebDAO;
import Models.Categories;
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

import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class HomeController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        PostDAO p = new PostDAO();
        UserDAO u = new UserDAO();
        TopicDAO t = new TopicDAO();
        TagDAO tg = new TagDAO();
        CategoryDAO c = new CategoryDAO();
        WebDAO w = new WebDAO();

        String notifi = w.getNotifi();
        session.setAttribute("notifi", notifi);

        //gettotalpost
        int totalPost = p.getTotalPost();
        int endPage = totalPost / 7;
        if (totalPost % 7 != 0) {
            endPage++;
        }
        req.setAttribute("endPage", endPage);

        String indexPage = req.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);

        ArrayList<Posts> listPagePost = (ArrayList<Posts>) p.getPagePostView(index);
        req.setAttribute("listPagePost", listPagePost);
        req.setAttribute("tagPage", index);


        ArrayList<Users> listUser = (ArrayList<Users>) u.getListUser();
        req.setAttribute("listuser", listUser);

        ArrayList<Topics> listPostTopic = (ArrayList<Topics>) t.getAllPostTopic();
        req.setAttribute("listtopic", listPostTopic);

        ArrayList<Categories> listTopicCategory = (ArrayList<Categories>) c.getAllCategory();
        req.setAttribute("listcategory", listTopicCategory);

        ArrayList<Categories> listbarCategory = (ArrayList<Categories>) c.getListCategory();
        req.setAttribute("listbarCategory", listbarCategory);

        ArrayList<Categories> numberTopic = (ArrayList<Categories>) c.getNumberTopic();
        req.setAttribute("numberTopic", numberTopic);

        ArrayList<Tags> listTag = (ArrayList<Tags>) tg.getListTag();
        req.setAttribute("listTag", listTag);

        ArrayList<Tags> numberPost = (ArrayList<Tags>) tg.getNumberPost();
        req.setAttribute("numberPost", numberPost);

        

        req.getRequestDispatcher("home.jsp").forward(req, resp);

    }

}
