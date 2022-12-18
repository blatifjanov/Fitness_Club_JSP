package com.company.controller.assignedTasks;

import com.company.dao.user.UserDAOImpl;
import com.company.dao.userAssignment.UserAssignmentDAO;
import com.company.dao.userAssignment.UserAssignmentDAOImpl;
import com.company.model.User;
import com.company.model.UserAssignment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = AssignedTasksController.BASE_PATH)
public class AssignedTasksController extends HttpServlet {
    public static final String BASE_PATH = "/assigned-tasks";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        UserDAOImpl userDAO = UserDAOImpl.getInstance();
        User user = userDAO.findById(Integer.valueOf(id));
        UserAssignmentDAOImpl userAssignmentDAO = UserAssignmentDAOImpl.getInstance();
        UserAssignment userAssignment = userAssignmentDAO.getUserAssignmentByUser(user);
        HttpSession session = req.getSession();
        session.setAttribute("userAssignment",userAssignment);
        resp.sendRedirect("assigned-tasks.jsp");
    }

}
