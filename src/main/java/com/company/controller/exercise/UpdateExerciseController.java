package com.company.controller.exercise;
import com.company.dao.exercise.ExerciseDAOImpl;
import com.company.model.Exercise;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = UpdateExerciseController.BASE_PATH)
public class UpdateExerciseController extends HttpServlet {
    public static final String BASE_PATH = "/updateExercise";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ExerciseDAOImpl exerciseDAO = ExerciseDAOImpl.getInstance();
        Exercise exercise = exerciseDAO.findById(Integer.valueOf(req.getParameter("id")));
        req.setAttribute("exercise", exercise);
        req.getRequestDispatcher("update-exercise.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Exercise exercise = Exercise.builder()
                .id(Integer.parseInt(id))
                .name(req.getParameter("name"))
                .build();
        ExerciseDAOImpl exerciseDAO = ExerciseDAOImpl.getInstance();
        exerciseDAO.update(exercise);
        resp.sendRedirect("update-exercise-success.jsp");
    }
}
