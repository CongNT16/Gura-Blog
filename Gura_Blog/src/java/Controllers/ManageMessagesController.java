/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DataAccess.MessageDAO;
import Models.Messages;
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
public class ManageMessagesController extends HttpServlet {

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
            MessageDAO m = new MessageDAO();

            if (thread.equals("1")) {

                ArrayList<Messages> listMessage = (ArrayList<Messages>) m.getListMessage();
                req.setAttribute("listMessage", listMessage);

                req.setAttribute("thread", thread);
                req.getRequestDispatcher("manage_messages.jsp").forward(req, resp);
            }

            if (thread.equals("3")) {

                String idmessagedel = req.getParameter("idmessagedel");
                m.deleteMessageByMessageId(idmessagedel);

                resp.sendRedirect("ManageMessagesController?thread=1");

            }
        } else {
            resp.sendRedirect("404error.html");
        }
    }

}
