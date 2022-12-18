package com.company.controller.user;

import com.company.dao.user.UserDAOImpl;
import com.company.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = UserProfileController.BASE_PATH)
public class UserProfileController extends HttpServlet {
    public static final String BASE_PATH = "/user-profile";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAOImpl userDAO = UserDAOImpl.getInstance();
        String id = req.getParameter("id");
        User user = userDAO.findById(Integer.valueOf(id));
        req.setAttribute("user", user);
        req.getRequestDispatcher("user-profile.jsp").forward(req, resp);
        System.out.println(" i came here ");
    }
}
