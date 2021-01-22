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

@WebServlet(name = "RegisterServlet", urlPatterns = "/userAPI/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (AuthorizationUtil.isLogined(req.getSession())) {
            getServletContext().getRequestDispatcher("/views/menu.jsp").forward(req, resp);
        } else {
            getServletContext().getRequestDispatcher("/views/register.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session;
        User newUser;
        User registeredUser;
        UserDAO userDAO;
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        if (firstName != null && lastName != null && userName != null && password != null) {
            newUser = new User();
            userDAO = new UserDAO();
            newUser.setFirstName(firstName);
            newUser.setLastName(lastName);
            newUser.setUserName(userName);
            newUser.setPassword(password);
            if (userDAO.create(newUser)) {
                session = req.getSession();
                registeredUser = userDAO.checkRegistration(userName, password);
                if (registeredUser != null) {
                    session.setAttribute("ID", registeredUser.getID());
                    session.setAttribute("userName", registeredUser.getUserName());
                    session.setMaxInactiveInterval(60 * 60 * 24 * 3);
                    getServletContext().getRequestDispatcher("/views/menu.jsp").forward(req, resp);
                } else {
                    getServletContext().getRequestDispatcher("/views/error.jsp").forward(req, resp);
                }
            } else {
                getServletContext().getRequestDispatcher("/views/register.jsp").forward(req, resp);
            }
        } else {
            getServletContext().getRequestDispatcher("/views/register.jsp").forward(req, resp);
        }
    }
}
