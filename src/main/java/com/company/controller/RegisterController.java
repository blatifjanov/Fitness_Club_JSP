package com.company.controller;
import com.company.model.User;
import com.company.model.enums.Role;
import com.company.service.RegisterService;
import com.company.utils.AppConstants;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

@WebServlet(value = RegisterController.BASE_PATH)
public class RegisterController extends HttpServlet {

    public static final String BASE_PATH = "/register";
    public static final String BASE_PAGE = "register.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(RegisterController.BASE_PAGE);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = User.builder()
                .firstName(req.getParameter("firstName"))
                .lastName(req.getParameter("lastName"))
                .email(req.getParameter("email"))
                .password(req.getParameter("password"))
                .dateOfBirth(LocalDate.parse(req.getParameter("dateOfBirth")))
                .phone(req.getParameter("phone"))
                .gender(req.getParameter("gender"))
                .build();

        RequestDispatcher requestDispatcher;

        if (Objects.isNull(user.getEmail()) || user.getEmail().isBlank() ||
                Objects.isNull(user.getFirstName()) || user.getFirstName().isBlank()
                || Objects.isNull(user.getPassword()) || user.getPassword().isBlank()) {
            StringBuilder sb = new StringBuilder();
            if (Objects.isNull(user.getFirstName()) || user.getFirstName().isBlank())
                sb.append("First name,");
            if (Objects.isNull(user.getLastName()) || user.getLastName().isBlank())
                sb.append(" Last name,");
            if (Objects.isNull(user.getEmail()) || user.getEmail().isBlank())
                sb.append(" Email,");
            if (Objects.isNull(user.getPassword()) || user.getPassword().isBlank())
                sb.append(" Password,");
            if (Objects.isNull(user.getDateOfBirth()))
                sb.append(" Date of birth");
            if (Objects.isNull(user.getPhone()) || user.getPhone().isBlank())
                sb.append(" Phone,");
            if (Objects.isNull(user.getGender()) || user.getGender().isBlank())
                sb.append(" Gender");
            if (sb.charAt(sb.length() - 1) == ',') {
                sb.setCharAt(sb.length() - 1, ' ');
            }
            resp.getWriter()
                    .write("<div align=\"center\"> <h1 style=\"color: red\">" + sb + " is required" + "</h1> </div>");
            requestDispatcher = req.getRequestDispatcher(RegisterController.BASE_PAGE);
            requestDispatcher.include(req, resp);
        } else {
            RegisterService registerService = RegisterService.getInstance();
            boolean isRegistered = registerService.save(user);

            if (isRegistered) {
                HttpSession session = req.getSession();
                user.setRole(Role.USER);
                session.setAttribute(AppConstants.CURRENT_USER, user);
                resp.sendRedirect("/registration-successful.jsp");
            } else {
                resp.getWriter()
                        .write("<div align=\"center\"> <h1 style=\"color: red\">Email already exists</h1>  </div>");
                requestDispatcher = req.getRequestDispatcher("/register.jsp");
                requestDispatcher.include(req, resp);
            }
        }
    }
}
