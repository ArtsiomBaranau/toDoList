package com.gmail.artsiombaranau.controllers.TaskAPI;

import com.gmail.artsiombaranau.model.DAO.TaskDAO;
import com.gmail.artsiombaranau.model.entities.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowTasksServlet", urlPatterns = "/taskAPI/show")
public class ShowTasksServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Task> list;
        int userID = (int) req.getSession().getAttribute("ID");
        if (userID != 0) {
            list = new TaskDAO().readAllTasksByUserID(userID);
            if (list != null) {
                req.setAttribute("taskList", list);
                getServletContext().getRequestDispatcher("/views/show.jsp").forward(req, resp);
            } else {
                getServletContext().getRequestDispatcher("/views/error.jsp").forward(req, resp);
            }
        } else {
            getServletContext().getRequestDispatcher("/views/login.jsp").forward(req, resp);
        }
    }
}
