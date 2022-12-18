package com.company.controller;
import com.company.model.User;
import com.company.service.LoginService;
import com.company.utils.AppConstants;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebServlet(value = LoginController.BASE_PATH)
public class LoginController extends HttpServlet {

    public static final String BASE_PATH = "/login";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = User.builder()
                .email(req.getParameter("email"))
                .password(req.getParameter("password"))
                .build();
        RequestDispatcher requestDispatcher;

        if (Objects.isNull(user.getEmail()) || user.getEmail().isBlank()
                || Objects.isNull(user.getPassword()) || user.getPassword().isBlank()) {

            resp.getWriter().write("<div align=\"center\"> <h1 style=\"color: green\">EMAIL OR PASSWORD REQUIRED!</h1>  </div>");
            requestDispatcher = req.getRequestDispatcher("login.jsp");
            requestDispatcher.include(req, resp);

        } else {
            LoginService loginService = LoginService.getInstance();
            boolean isLogin = loginService.login(user);

            if (isLogin) {
                HttpSession session = req.getSession();

                session.setAttribute(AppConstants.CURRENT_USER, user);
                resp.sendRedirect(CabinetController.BASE_PATH);

            } else {
                resp.getWriter()
                        .write("<div align=\"center\"> <h1 style=\"color: green\">WRONG EMAIL OR PASSWORD! PLEASE TRY AGAIN</h1>  </div>");
                requestDispatcher = req.getRequestDispatcher("login.jsp");
                requestDispatcher.include(req, resp);

            }
        }
    }
}
