package com.company.controller.user;
import com.company.dao.user.UserDAO;
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


@WebServlet(value = TrainerListController.BASE_PATH)

public class TrainerListController extends HttpServlet {

    public static final String BASE_PATH = "/list-trainers";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Objects.isNull(req.getParameter("id"))) {
            UserDAO userDAO = UserDAOImpl.getInstance();
            List<User> trainers = userDAO.trainerList();
            req.setAttribute("trainers", trainers);
            RequestDispatcher rd = req.getRequestDispatcher("list-trainers.jsp");
            rd.forward(req, resp);

        }
    }
}
