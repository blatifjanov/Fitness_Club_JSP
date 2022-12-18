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
import java.util.Objects;

@WebServlet(value = AddExerciseController.BASE_PATH)
public class AddExerciseController extends HttpServlet {
    public static final String BASE_PATH = "/add-exercise";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("add-exercise.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Exercise exercise = Exercise.builder()
                .name(req.getParameter("name"))
                .build();
        RequestDispatcher rd;
        if (Objects.isNull(exercise.getName()) || exercise.getName().isBlank()) {
            resp.getWriter()
                    .write("<div align=\"center\"> <h1 style=\"color: red\">" + "Name is required" + "</h1> </div>");
            rd = req.getRequestDispatcher("add-exercise.jsp");
            rd.include(req, resp);
        } else {
            ExerciseDAOImpl exerciseDAO = ExerciseDAOImpl.getInstance();
            boolean isSaved = exerciseDAO.save(exercise);
            if (isSaved) {
                resp.sendRedirect("add-exercise-success.jsp");
            } else {
                resp.getWriter()
                        .write("<div align=\"center\"> <h1 style=\"color: red\">Exercise already exists</h1>  </div>");
                rd = req.getRequestDispatcher("add-exercise.jsp");
                rd.include(req, resp);
            }
        }

    }
}
