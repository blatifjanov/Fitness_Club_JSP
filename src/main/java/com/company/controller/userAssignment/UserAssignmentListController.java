package com.company.controller.userAssignment;

import com.company.dao.userAssignment.UserAssignmentDAOImpl;
import com.company.model.UserAssignment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = UserAssignmentListController.BASE_PATH)
public class UserAssignmentListController extends HttpServlet {
    public static final String BASE_PATH="/list-assignments";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserAssignmentDAOImpl userAssignmentDAO = UserAssignmentDAOImpl.getInstance();
        List<UserAssignment> list = userAssignmentDAO.list();
        req.setAttribute("userAssignments",list);
        req.getRequestDispatcher("user-assignment-list.jsp").forward(req,resp);
    }

}
