/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DataAccess.SubscribeDAO;
import Models.Subscribes;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author nguye
 */
public class SubscribesController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        SubscribeDAO s = new SubscribeDAO();
        
        if (!s.checkEmail(email)) {
            
             //Tạo 1 user_id mới
                String id = "";

                while (s.checkSubId(id) == false) {
                    Random generator = new Random();
                    id = String.valueOf(generator.nextInt((99999999 - 10000000) + 1) + 10000000);

                    s.insertSubcribe(id,email);
                    break;
                }

            
        }

        resp.sendRedirect("HomeController");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SubscribeDAO s = new SubscribeDAO();
        String thread = req.getParameter("thread");
        

        if (thread.equals("1")) {

            ArrayList<Subscribes> listSubscribe = (ArrayList<Subscribes>) s.getListSubscribe();
            req.setAttribute("listSubscribe", listSubscribe);

            req.setAttribute("thread", thread);
            req.getRequestDispatcher("manage_subscribe.jsp").forward(req, resp);
        }
        
        if (thread.equals("3")) {

            String idsubscribedel = req.getParameter("idsubscribedel");
            s.deleteSubBySubId(idsubscribedel);

            resp.sendRedirect("SubscribesController?thread=1");

        }

    }

}
