package com.company.controller.exercise;

import com.company.dao.exercise.ExerciseDAOImpl;
import com.company.model.Exercise;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet(value = ExerciseListController.BASE_PATH)
public class ExerciseListController extends HttpServlet {
    public static final String BASE_PATH = "/list-exercises";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Objects.isNull(req.getParameter("id"))) {

            ExerciseDAOImpl exerciseDAO = ExerciseDAOImpl.getInstance();
            List<Exercise> exercises = exerciseDAO.list();
            req.setAttribute("exercises", exercises);
            RequestDispatcher rd = req.getRequestDispatcher("list-exercises.jsp");
            rd.forward(req, resp);
        }
    }
}
