package com.company.controller.user;

import com.company.dao.user.UserDAOImpl;
import com.company.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;


@WebServlet(value = UserListController.BASE_PATH)

public class UserListController extends HttpServlet {

    public static final String BASE_PATH = "/list-users";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Objects.isNull(req.getParameter("id"))) {

            UserDAOImpl userDAO =UserDAOImpl.getInstance();
            List<User> users = userDAO.userList();
            req.setAttribute("users", users);
            RequestDispatcher rd = req.getRequestDispatcher("list-users.jsp");
            rd.forward(req, resp);
        }
    }
}
