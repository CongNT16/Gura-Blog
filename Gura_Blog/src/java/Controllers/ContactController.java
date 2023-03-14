/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DataAccess.CategoryDAO;
import DataAccess.MessageDAO;
import Models.Categories;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author nguye
 */
public class ContactController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String messdetail = req.getParameter("messdetail");
        String mess = "";
        MessageDAO m = new MessageDAO();
        CategoryDAO c = new CategoryDAO();

        //Tạo 1 mess_id mới
        String message_id = "";

        while (m.checkMessId(message_id) == false) {
            Random generator = new Random();
            message_id = String.valueOf(generator.nextInt((99999999 - 10000000) + 1) + 10000000);

            //get time local
            LocalDate getdate = LocalDate.now();
            LocalTime gettime = LocalTime.now();

            String createdate = String.valueOf(getdate);
            String createtime = String.valueOf(gettime);

            m.insertMess(message_id, name, email, messdetail, createdate, createtime);

            break;
        }

        ArrayList<Categories> listbarCategory = (ArrayList<Categories>) c.getListCategory();
        req.setAttribute("listbarCategory", listbarCategory);

        ArrayList<Categories> numberTopic = (ArrayList<Categories>) c.getNumberTopic();
        req.setAttribute("numberTopic", numberTopic);

        mess += "Đã gửi thành công!";
        req.setAttribute("mess", mess);
        req.getRequestDispatcher("contact.jsp").forward(req, resp);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryDAO c = new CategoryDAO();
        ArrayList<Categories> listbarCategory = (ArrayList<Categories>) c.getListCategory();
        req.setAttribute("listbarCategory", listbarCategory);

        ArrayList<Categories> numberTopic = (ArrayList<Categories>) c.getNumberTopic();
        req.setAttribute("numberTopic", numberTopic);

        
        req.getRequestDispatcher("contact.jsp").forward(req, resp);
    }

}
