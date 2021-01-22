package com.gmail.artsiombaranau.controllers.TaskAPI;

import com.gmail.artsiombaranau.model.DAO.TaskDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteTasksServlet", urlPatterns = "/taskAPI/delete")
public class DeleteTasksServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaskDAO taskDAO;
        String[] list = req.getParameterValues("taskID");
        if (list != null && list.length > 0) {
            taskDAO = new TaskDAO();
            Runnable thread = () -> {
                for (String ID : list) {
                    taskDAO.delete(Integer.parseInt(ID));
                }
            };
            new Thread(thread).start();
        }
        getServletContext().getRequestDispatcher("/views/menu.jsp").forward(req, resp);
    }
}
