package com.company.controller.user;

import com.company.dao.user.UserDAOImpl;
import com.company.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = DeleteUserController.BASE_PATH)
public class DeleteUserController extends HttpServlet {
    public static final String BASE_PATH = "/delete";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAOImpl userDAO = UserDAOImpl.getInstance();
        String id = req.getParameter("id");
        User user = userDAO.findById(Integer.valueOf(id));
        req.setAttribute("user", user);
        req.getRequestDispatcher("delete.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        UserDAOImpl userDAO = UserDAOImpl.getInstance();
        boolean isDeleted = userDAO.delete(Integer.valueOf(id));
        if (!isDeleted) {
        resp.sendRedirect("delete-success.jsp");
        }
    }
}
