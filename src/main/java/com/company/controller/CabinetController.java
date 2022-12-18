package com.company.controller;
import com.company.model.User;
import com.company.utils.AppConstants;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = CabinetController.BASE_PATH)
public class CabinetController extends HttpServlet {
    public static final String BASE_PATH = "/cabinet";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        User currentUser = (User) session.getAttribute(AppConstants.CURRENT_USER);
        req.setAttribute(AppConstants.CURRENT_USER, currentUser);

        RequestDispatcher rd = req.getRequestDispatcher("cabinet.jsp");
        rd.forward(req, resp);
    }

}
