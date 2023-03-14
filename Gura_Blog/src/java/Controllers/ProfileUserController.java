/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DataAccess.UserDAO;
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
public class ProfileUserController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String getuserid = req.getParameter("userid");
        String thread = req.getParameter("thread");
        UserDAO u = new UserDAO();
        String mess = "";

        if (thread.equals("1")) {
            Users userInfor = u.getUserInfor(getuserid);
            session.setAttribute("user_infor_id", userInfor.getUser_id());
            req.setAttribute("user_infor_account", userInfor.getUser_account());
            req.setAttribute("user_infor_firstname", userInfor.getUser_firstname());
            req.setAttribute("user_infor_lastname", userInfor.getUser_lastname());
            req.setAttribute("user_infor_gender", userInfor.getUser_gender());
            req.setAttribute("user_infor_dob", userInfor.getUser_dob());
            req.setAttribute("user_infor_email", userInfor.getUser_email());
            req.setAttribute("user_infor_phone", userInfor.getUser_phone());
            req.setAttribute("user_infor_address", userInfor.getUser_address());
            req.setAttribute("user_infor_about", userInfor.getUser_about());
            req.setAttribute("user_infor_avatar", userInfor.getUser_avatar());
//            req.setAttribute("user_login_account", userInfor.getUser_account());

            req.setAttribute("thread", thread);
            req.getRequestDispatcher("profile_page.jsp").forward(req, resp);

        }
        if (thread.equals("2")) {
            String userid = req.getParameter("userid");
            Users userInfor = u.getUserInfor(userid);
            session.setAttribute("user_infor_id", userInfor.getUser_id());

            req.setAttribute("userid", userid);
            req.setAttribute("user_edit_account", userInfor.getUser_account());
            req.setAttribute("user_edit_firstname", userInfor.getUser_firstname());
            req.setAttribute("user_edit_lastname", userInfor.getUser_lastname());
            req.setAttribute("user_edit_gender", userInfor.getUser_gender());
            req.setAttribute("user_edit_dob", userInfor.getUser_dob());
            req.setAttribute("user_edit_email", userInfor.getUser_email());
            req.setAttribute("user_edit_phone", userInfor.getUser_phone());
            req.setAttribute("user_edit_address", userInfor.getUser_address());
            req.setAttribute("user_edit_about", userInfor.getUser_about());
            req.setAttribute("user_edit_avatar", userInfor.getUser_avatar());
//            req.setAttribute("user_login_account", userInfor.getUser_account());

            req.setAttribute("thread", thread);
            req.getRequestDispatcher("profile_page.jsp").forward(req, resp);
        }

        if (thread.equals("3")) {
            String userid = req.getParameter("userid");
            Users userInfor = u.getUserInfor(userid);
//            req.setAttribute("user_login_account", userInfor.getUser_account());
            session.setAttribute("user_infor_id", userInfor.getUser_id());

            String account = req.getParameter("user_edit_account");
            String firstname = req.getParameter("user_edit_firstname");
            String lastname = req.getParameter("user_edit_lastname");
            String gender = req.getParameter("user_edit_gender");
            String dob = req.getParameter("user_edit_dob");
            String email = req.getParameter("user_edit_email");
            String phone = req.getParameter("user_edit_phone");
            String address = req.getParameter("user_edit_address");
            String about = req.getParameter("user_edit_about");
            String avatar = req.getParameter("user_edit_avatar");
            

            if (!account.equals(userInfor.getUser_account()) && u.checkUserAccount(account)) {
                //có tồn tại account

                //Thong bao
                mess += "Account đã tồn tại";
                req.setAttribute("erraccount", mess);

                req.setAttribute("userid", userid);
                req.setAttribute("user_edit_account", account);
                req.setAttribute("user_edit_firstname", firstname);
                req.setAttribute("user_edit_lastname", lastname);
                req.setAttribute("user_edit_gender", gender);
                req.setAttribute("user_edit_dob", dob);
                req.setAttribute("user_edit_email", email);
                req.setAttribute("user_edit_phone", phone);
                req.setAttribute("user_edit_address", address);
                req.setAttribute("user_edit_about", about);
                req.setAttribute("user_edit_avatar", avatar);
//                req.setAttribute("user_login_account", userInfor.getUser_account());
                

                req.setAttribute("thread", 2);
                req.getRequestDispatcher("profile_page.jsp").forward(req, resp);
            } //check email tồn tại hay không
            else if (!email.equals(userInfor.getUser_email()) && u.checkUserEmail(email)) {
                //có tồn tại email

                //Thong bao
                mess += "Email đã tồn tại";
                req.setAttribute("erremail", mess);

                req.setAttribute("userid", userid);
                req.setAttribute("user_edit_account", account);
                req.setAttribute("user_edit_firstname", firstname);
                req.setAttribute("user_edit_lastname", lastname);
                req.setAttribute("user_edit_gender", gender);
                req.setAttribute("user_edit_dob", dob);
                req.setAttribute("user_edit_email", email);
                req.setAttribute("user_edit_phone", phone);
                req.setAttribute("user_edit_address", address);
                req.setAttribute("user_edit_about", about);
                req.setAttribute("user_edit_avatar", avatar);
//                req.setAttribute("user_login_account", userInfor.getUser_account());

                req.setAttribute("thread", 2);
                req.getRequestDispatcher("profile_page.jsp").forward(req, resp);
            } else {
                u.UpdateInfor(userid, account, email, firstname, lastname, gender, dob, phone, address, avatar, about);
                if (u.checkUserId(userid)) {

                    Users userUpdater = u.getUserInfor(userid);

                    req.setAttribute("userid", userid);
                    req.setAttribute("user_infor_account", userUpdater.getUser_account());
                    req.setAttribute("user_infor_firstname", userUpdater.getUser_firstname());
                    req.setAttribute("user_infor_lastname", userUpdater.getUser_lastname());
                    req.setAttribute("user_infor_gender", userUpdater.getUser_gender());
                    req.setAttribute("user_infor_dob", userUpdater.getUser_dob());
                    req.setAttribute("user_infor_email", userUpdater.getUser_email());
                    req.setAttribute("user_infor_phone", userUpdater.getUser_phone());
                    req.setAttribute("user_infor_address", userUpdater.getUser_address());
                    req.setAttribute("user_infor_about", userUpdater.getUser_about());
                    req.setAttribute("user_infor_avatar", userUpdater.getUser_avatar());
//                    req.setAttribute("user_login_account", userUpdater.getUser_account());
                    session.setAttribute("user_login_account", userUpdater.getUser_account());
                    session.setAttribute("user_login_avatar", userUpdater.getUser_avatar());
                }

                req.setAttribute("thread", 1);
                req.getRequestDispatcher("profile_page.jsp").forward(req, resp);
            }

        }

        if (thread.equals("4")) {
            String userid = req.getParameter("userid");
            Users userInfor = u.getUserInfor(userid);
//            req.setAttribute("user_login_account", userInfor.getUser_account());
            session.setAttribute("user_infor_id", userInfor.getUser_id());

            req.setAttribute("userid", userid);
            req.setAttribute("user_infor_about", userInfor.getUser_about());
            req.setAttribute("user_infor_avatar", userInfor.getUser_avatar());

            req.setAttribute("thread", 3);
            req.getRequestDispatcher("profile_page.jsp").forward(req, resp);
        }

        if (thread.equals("5")) {
            String userid = req.getParameter("userid");
            Users userInfor = u.getUserInfor(userid);
//            req.setAttribute("user_login_account", userInfor.getUser_account());
            session.setAttribute("user_infor_id", userInfor.getUser_id());

            String oldpass = req.getParameter("oldpass");
            String newpass1 = req.getParameter("newpass1");
            String newpass2 = req.getParameter("newpass2");

            if (!oldpass.equals(userInfor.getUser_password())) {
                mess += "Nhập lại old password";

                req.setAttribute("userid", userid);
                req.setAttribute("user_infor_about", userInfor.getUser_about());
                req.setAttribute("user_infor_avatar", userInfor.getUser_avatar());
                req.setAttribute("erroldpass", mess);
                req.setAttribute("thread", 3);
                req.getRequestDispatcher("profile_page.jsp").forward(req, resp);

            } else {
                if (newpass1.equals(newpass2)) {
                    u.changePass(userid, newpass1);

                    if (u.checkUserId(userid)) {

                        Users userUpdater = u.getUserInfor(userid);

                        req.setAttribute("userid", userid);
                        req.setAttribute("user_infor_account", userUpdater.getUser_account());
                        req.setAttribute("user_infor_firstname", userUpdater.getUser_firstname());
                        req.setAttribute("user_infor_lastname", userUpdater.getUser_lastname());
                        req.setAttribute("user_infor_gender", userUpdater.getUser_gender());
                        req.setAttribute("user_infor_dob", userUpdater.getUser_dob());
                        req.setAttribute("user_infor_email", userUpdater.getUser_email());
                        req.setAttribute("user_infor_phone", userUpdater.getUser_phone());
                        req.setAttribute("user_infor_address", userUpdater.getUser_address());
                        req.setAttribute("user_infor_about", userUpdater.getUser_about());
                        req.setAttribute("user_infor_avatar", userUpdater.getUser_avatar());
                    }

                    req.setAttribute("thread", 1);
                    req.getRequestDispatcher("profile_page.jsp").forward(req, resp);

                } else {
                    mess += "Nhập lại new pass";
                    req.setAttribute("userid", userid);
                    req.setAttribute("user_infor_about", userInfor.getUser_about());
                    req.setAttribute("user_infor_avatar", userInfor.getUser_avatar());
                    req.setAttribute("errnewpass1", mess);
                    req.setAttribute("thread", 3);
                    req.getRequestDispatcher("profile_page.jsp").forward(req, resp);
                }
            }

        }

    }

}
