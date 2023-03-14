/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DataAccess.CategoryDAO;
import DataAccess.PostDAO;
import DataAccess.TopicDAO;
import DataAccess.UserDAO;
import Models.Categories;
import Models.Posts;
import Models.Topics;
import Models.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class CategoryController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryDAO c = new CategoryDAO();
        TopicDAO t = new TopicDAO();
        PostDAO p = new PostDAO();
        UserDAO u = new UserDAO();

        String getcategoryid = req.getParameter("categoryid");

        ArrayList<Categories> listbarCategory = (ArrayList<Categories>) c.getListCategory();
        req.setAttribute("listbarCategory", listbarCategory);

        ArrayList<Categories> numberTopic = (ArrayList<Categories>) c.getNumberTopic();
        req.setAttribute("numberTopic", numberTopic);

        ArrayList<Topics> listTopicWithCategoryId = (ArrayList<Topics>) t.getTopicWithCategoryId(getcategoryid);
        req.setAttribute("listTopicCate", listTopicWithCategoryId);

        ArrayList<Topics> listNumberPost = (ArrayList<Topics>) t.getNumberPost();
        req.setAttribute("listNumberPost", listNumberPost);

        ArrayList<Posts> listPost = (ArrayList<Posts>) p.getListPost();
        req.setAttribute("listPost", listPost);

        ArrayList<Posts> listTopThreePostTopic = (ArrayList<Posts>) p.getListTopThreePostTopic();
        req.setAttribute("listTopThreePostTopic", listTopThreePostTopic);

        ArrayList<Users> listUser = (ArrayList<Users>) u.getListUser();
        req.setAttribute("listuser", listUser);

        ArrayList<Topics> listPostTopic = (ArrayList<Topics>) t.getAllPostTopic();
        req.setAttribute("listtopic", listPostTopic);

        req.getRequestDispatcher("category.jsp").forward(req, resp);
    }

}
