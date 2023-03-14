/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DataAccess.CommentDAO;
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
public class EditCommentPostController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("user_login_roleid") == null) {
            resp.sendRedirect("404error.html");
        } else {

            String thread = req.getParameter("thread");
            String postid = req.getParameter("postid");
            CommentDAO c = new CommentDAO();

            if (thread.equals("3")) {
                String idcommentdel = req.getParameter("idcommentdel");
                c.deleteCommentByCommentId(idcommentdel);

                resp.sendRedirect("PostController?postid=" + postid);

            }
            if (thread.equals("4")) {
                String idcommentedit = req.getParameter("idcommentedit");
                String editdetail = req.getParameter("editdetail");
                c.updateCommentByCommentId(idcommentedit, editdetail);

                resp.sendRedirect("PostController?postid=" + postid);

            }
        }
    }

}
