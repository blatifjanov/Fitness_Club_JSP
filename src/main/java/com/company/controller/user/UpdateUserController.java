package com.company.controller.user;

import com.company.dao.user.UserDAOImpl;
import com.company.model.User;
import com.company.model.enums.Role;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(value = UpdateUserController.BASE_PATH)
public class UpdateUserController extends HttpServlet {
    public static final String BASE_PATH = "/update";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAOImpl userDAO = UserDAOImpl.getInstance();
        User user = userDAO.findById(Integer.valueOf(req.getParameter("id")));
        req.setAttribute("user", user);
        req.getRequestDispatcher("update-user.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        User user;
        if (req.getParameter("role").equals("USER")) {
            user = User.builder()
                    .id(Integer.parseInt(id))
                    .firstName(req.getParameter("firstName"))
                    .lastName(req.getParameter("lastName"))
                    .email(req.getParameter("email"))
                    .dateOfBirth(LocalDate.parse(req.getParameter("dateOfBirth")))
                    .phone(req.getParameter("phone"))
                    .gender(req.getParameter("gender"))
                    .role(Role.valueOf(req.getParameter("role")))
                    .balance(Double.parseDouble(req.getParameter("balance")))
                    .build();
        } else {
            user = User.builder()
                    .id(Integer.parseInt(id))
                    .firstName(req.getParameter("firstName"))
                    .lastName(req.getParameter("lastName"))
                    .email(req.getParameter("email"))
                    .dateOfBirth(LocalDate.parse(req.getParameter("dateOfBirth")))
                    .phone(req.getParameter("phone"))
                    .gender(req.getParameter("gender"))
                    .role(Role.valueOf(req.getParameter("role")))
                    .build();
        }

        UserDAOImpl userDAO = UserDAOImpl.getInstance();
        userDAO.update(user);
        resp.sendRedirect("update-user-success.jsp");
    }
}
