package com.gmail.artsiombaranau.controllers.TaskAPI;

import com.gmail.artsiombaranau.model.DAO.TaskDAO;
import com.gmail.artsiombaranau.model.entities.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "AddTaskServlet", urlPatterns = "/taskAPI/add")
public class AddTaskServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/views/addTask.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Task task;
        TaskDAO taskDAO;
        int userID = (int) req.getSession().getAttribute("ID");
        LocalDate createdAt = LocalDate.now();
        String taskText = req.getParameter("taskText");
        if (userID != 0 && taskText != null) {
            task = new Task();
            taskDAO = new TaskDAO();
            task.setUserID(userID);
            task.setCreatedAt(createdAt);
            task.setTask(taskText);
            if (taskDAO.create(task)) {
                getServletContext().getRequestDispatcher("/views/menu.jsp").forward(req, resp);
            } else {
                getServletContext().getRequestDispatcher("/views/error.jsp").forward(req, resp);
            }
        } else {
            getServletContext().getRequestDispatcher("/views/addTask.jsp").forward(req, resp);
        }
    }
}

