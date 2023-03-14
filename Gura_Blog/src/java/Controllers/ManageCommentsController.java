/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DataAccess.CommentDAO;
import Models.Comments;
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
public class ManageCommentsController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("user_login_roleid") == null) {
            resp.sendRedirect("404error.html");
        } else if (session.getAttribute("user_login_roleid").equals("1")) {
            String thread = req.getParameter("thread");
            CommentDAO cm = new CommentDAO();

            if (thread.equals("1")) {

                ArrayList<Comments> listComment = (ArrayList<Comments>) cm.getListComment();
                req.setAttribute("listComment", listComment);

                req.setAttribute("thread", thread);
                req.getRequestDispatcher("manage_comments.jsp").forward(req, resp);
            }

            if (thread.equals("3")) {

                String idcommentdel = req.getParameter("idcommentdel");
                cm.deleteCommentByCommentId(idcommentdel);

                resp.sendRedirect("ManageCommentsController?thread=1");

            }
            if(thread.equals("4")){
                
                String idcommentconfirm = req.getParameter("idcommentconfirm");
                cm.updateSatusCommentByCommentId(idcommentconfirm);

                resp.sendRedirect("ManageCommentsController?thread=1");
            
            
            }

        } else {
            resp.sendRedirect("404error.html");
        }
    }

}
