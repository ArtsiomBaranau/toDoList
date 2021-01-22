package com.gmail.artsiombaranau.controllers.UserAPI;

import com.gmail.artsiombaranau.model.DAO.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteUserServlet", urlPatterns = "/userAPI/delete")
public class DeleteUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean result = false;
        UserDAO userDAO;
        int ID = (int) req.getSession().getAttribute("ID");
        if (ID != 0) {
            userDAO = new UserDAO();
            result = userDAO.delete(ID);
        }
        if (result) {
            req.getSession().invalidate();
            getServletContext().getRequestDispatcher("/views/login.jsp").forward(req, resp);
        } else {
            getServletContext().getRequestDispatcher("/views/error.jsp").forward(req, resp);
        }
    }
}
