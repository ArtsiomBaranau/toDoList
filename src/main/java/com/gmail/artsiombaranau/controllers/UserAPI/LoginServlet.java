package com.gmail.artsiombaranau.controllers.UserAPI;

import com.gmail.artsiombaranau.model.DAO.UserDAO;
import com.gmail.artsiombaranau.model.entities.User;
import com.gmail.artsiombaranau.utils.AuthorizationUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/", "/userAPI/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (AuthorizationUtil.isLogined(req.getSession())) {
            getServletContext().getRequestDispatcher("/views/menu.jsp").forward(req, resp);
        } else
            getServletContext().getRequestDispatcher("/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session;
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        if (userName != null && password != null) {
            User user = new UserDAO().checkRegistration(userName, password);
            if (user != null) {
                session = req.getSession();
                session.setAttribute("ID", user.getID());
                session.setAttribute("userName", user.getUserName());
                getServletContext().getRequestDispatcher("/views/menu.jsp").forward(req, resp);
            } else {
                getServletContext().getRequestDispatcher("/views/login.jsp").forward(req, resp);
            }
        } else {
            getServletContext().getRequestDispatcher("/views/login.jsp").forward(req, resp);
        }
    }
}
