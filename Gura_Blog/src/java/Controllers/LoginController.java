/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DataAccess.UserDAO;
import DataAccess.WebDAO;
import Models.Users;
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
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //change pass

        String account = req.getParameter("account");
        String email = req.getParameter("email");
        String newpassword1 = req.getParameter("newpassword1");
        String newpassword2 = req.getParameter("newpassword2");
        String mess = "";
        //check account ton tai hay khong

        UserDAO u = new UserDAO();
        if (u.checkUser(account, email)) {
            //có tồn tại

            if (newpassword1.equals(newpassword2)) {
                u.updatePassword(account, newpassword1);

                req.setAttribute("account", account);
                req.setAttribute("password", newpassword1);
                req.getRequestDispatcher("login.jsp").forward(req, resp);

            } else {

                mess += "Nhập lại password";
                req.setAttribute("account", account);
                req.setAttribute("email", email);
                req.setAttribute("errpass", mess);
                req.getRequestDispatcher("forgot_password.jsp").forward(req, resp);
            }

        } else {
            //insertdata

            //Thong bao
            mess += "Sai tài khoản hoặc email";
            req.setAttribute("errall", mess);
            req.getRequestDispatcher("forgot_password.jsp").forward(req, resp);

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Nhan thong tin tu view
        HttpSession session = req.getSession();

        String account = req.getParameter("account");
        String password = req.getParameter("password");

        if (account != null && password != null) {

            String mess = "";
            //Xu ly thong tin
            UserDAO u = new UserDAO();

            boolean OK = u.checklogin(account, password);

            if (OK) {

                Users userInfor = u.getUser(account, password);

                String userRole = String.valueOf(userInfor.getRole_id());

                if (userRole.equals("4")) {
                    session.setAttribute("user_login_account", userInfor.getUser_account());
                    session.setAttribute("user_login_id", userInfor.getUser_id());
                    session.setAttribute("user_login_roleid", userInfor.getRole_id());
                    session.setAttribute("user_login_avatar", userInfor.getUser_avatar());

                    req.getRequestDispatcher("HomeController").forward(req, resp);
                }

                if (userRole.equals("1")) {
                    session.setAttribute("user_login_account", userInfor.getUser_account());
                    session.setAttribute("user_login_id", userInfor.getUser_id());
                    session.setAttribute("user_login_roleid", userInfor.getRole_id());
                    session.setAttribute("user_login_avatar", userInfor.getUser_avatar());

                    req.getRequestDispatcher("HomeController").forward(req, resp);
                }
                if (userRole.equals("2")) {
                    session.setAttribute("user_login_account", userInfor.getUser_account());
                    session.setAttribute("user_login_id", userInfor.getUser_id());
                    session.setAttribute("user_login_roleid", userInfor.getRole_id());
                    session.setAttribute("user_login_avatar", userInfor.getUser_avatar());

                    req.getRequestDispatcher("HomeController").forward(req, resp);
                }

            } else {
                mess += "Sai tài khoản hoặc mật khẩu";
                req.setAttribute("mess", mess);
                req.setAttribute("account", account);
                req.setAttribute("password", password);
                req.getRequestDispatcher("login.jsp").forward(req, resp);

            }
        } else {

            resp.sendRedirect("login.jsp");
        }
        //Tra ket qua ve view
    }

}
