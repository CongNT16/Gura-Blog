/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DataAccess.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

/**
 *
 * @author nguye
 */
public class RegisterController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //register
        String account = req.getParameter("account");
        String email = req.getParameter("email");
        String password1 = req.getParameter("password1");
        String password2 = req.getParameter("password2");
        String mess = "";

        //check tai khoan ton tai hay khong
        UserDAO u = new UserDAO();
        if (u.checkUserAccount(account)) {
            //có tồn tại account

            //Thong bao
            mess += "Account đã tồn tại vui lòng tạo tài khoản với account khác";

            req.setAttribute("account", account);
            req.setAttribute("email", email);

            req.setAttribute("erraccount", mess);
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        } else if (u.checkUserEmail(email)) {
            //có tồn tại email

            //Thong bao
            mess += "Email đã tồn tại vui lòng tạo tài khoản với email khác";

            req.setAttribute("account", account);
            req.setAttribute("email", email);

            req.setAttribute("erremail", mess);
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        } else {
            //insertdata

            if (password1.equals(password2)) {

                //Tạo 1 user_id mới
                String user_id = "";

                while (u.checkUserId(user_id) == false) {
                    Random generator = new Random();
                    user_id = String.valueOf(generator.nextInt((99999999 - 10000000) + 1) + 10000000);

                    //get time local
                    LocalDate getdate = LocalDate.now();
                    LocalTime gettime = LocalTime.now();

                    String createdate = String.valueOf(getdate);
                    String createtime = String.valueOf(gettime);

                    String avatar = "avatar.png";

                    u.insertUser(user_id, account, email, password1, createdate, createtime);
                    if (u.checkUserId(user_id)) {
                        u.updateUser(user_id, avatar);
                    }
                    break;
                }

                req.setAttribute("account", account);
                req.setAttribute("password", password1);
                req.getRequestDispatcher("login.jsp").forward(req, resp);

            } else {

                mess += "Nhập lại password";

                req.setAttribute("account", account);
                req.setAttribute("email", email);

                req.setAttribute("errpass", mess);
                req.getRequestDispatcher("register.jsp").forward(req, resp);
            }

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
