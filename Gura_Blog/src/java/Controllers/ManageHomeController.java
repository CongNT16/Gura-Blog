/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DataAccess.CategoryDAO;
import DataAccess.CommentDAO;
import DataAccess.MessageDAO;
import DataAccess.PostDAO;
import DataAccess.SubscribeDAO;
import DataAccess.TagDAO;
import DataAccess.TopicDAO;
import DataAccess.UserDAO;
import DataAccess.WebDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author nguye
 */
public class ManageHomeController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        WebDAO w = new WebDAO();
        String click = req.getParameter("click");

        if (click.equals("del")) {
            w.updateNotifi(null);
            resp.sendRedirect("ManageHomeController");
        }

        if (click.equals("edit")) {

            String editNotifi = req.getParameter("editNotifi").trim();
            w.updateNotifi(editNotifi);
            resp.sendRedirect("ManageHomeController");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (session.getAttribute("user_login_roleid") == null) {
            resp.sendRedirect("404error.html");
        } else if (session.getAttribute("user_login_roleid").equals("1") || session.getAttribute("user_login_roleid").equals("2")) {
            CategoryDAO c = new CategoryDAO();
            CommentDAO cm = new CommentDAO();
            MessageDAO m = new MessageDAO();
            PostDAO p = new PostDAO();
            TagDAO tg = new TagDAO();
            TopicDAO t = new TopicDAO();
            UserDAO u = new UserDAO();
            WebDAO w = new WebDAO();
            SubscribeDAO s = new SubscribeDAO();

            int total_user = u.getTotalUser();
            int total_admin = u.getTotalAdmin();
            int total_poster = u.getTotalPoster();
            int total_post = p.getTotalPost();
            int total_category = c.getTotalCategory();
            int total_topic = t.getTotalTopic();
            int total_tag = tg.getTotalTag();
            int total_comment = cm.getTotalComment();
            int total_message = m.getTotalMessage();
            int total_subscribe = s.getTotalSubscribe();
            String notifi = w.getNotifi();

            req.setAttribute("total_user", total_user);
            req.setAttribute("total_admin", total_admin);
            req.setAttribute("total_poster", total_poster);
            req.setAttribute("total_post", total_post);
            req.setAttribute("total_category", total_category);
            req.setAttribute("total_topic", total_topic);
            req.setAttribute("total_tag", total_tag);
            req.setAttribute("total_comment", total_comment);
            req.setAttribute("total_message", total_message);
            req.setAttribute("total_subscribe", total_subscribe);
            req.setAttribute("notifi", notifi);

            req.getRequestDispatcher("manage_home.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("404error.html");
        }
    }

}
