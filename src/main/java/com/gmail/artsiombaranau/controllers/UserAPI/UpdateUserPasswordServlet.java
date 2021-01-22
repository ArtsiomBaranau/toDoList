package com.gmail.artsiombaranau.controllers.UserAPI;

import com.gmail.artsiombaranau.model.DAO.UserDAO;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateUserPasswordServlet", urlPatterns = "/userAPI/update")
public class UpdateUserPasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/views/updatePassword.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean result = false;
        int ID = (int) req.getSession().getAttribute("ID");
        String newPassword = req.getParameter("newPassword");
        if (newPassword != null) {
            result = new UserDAO().update(ID, newPassword);
            if (result) {
                getServletContext().getRequestDispatcher("/views/menu.jsp").forward(req, resp);
            } else
                getServletContext().getRequestDispatcher("/views/error.jsp").forward(req, resp);
        } else {
            getServletContext().getRequestDispatcher("/views/updatePassword.jsp").forward(req, resp);
        }
    }
}
