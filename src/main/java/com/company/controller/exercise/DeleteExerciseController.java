package com.company.controller.exercise;
import com.company.dao.exercise.ExerciseDAOImpl;
import com.company.model.Exercise;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = DeleteExerciseController.BASE_PATH)
public class DeleteExerciseController extends HttpServlet {
    public static final String BASE_PATH = "/deleteExercise";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ExerciseDAOImpl exerciseDAO = ExerciseDAOImpl.getInstance();
        String id = req.getParameter("id");
        Exercise exercise = exerciseDAO.findById(Integer.valueOf(id));
        req.setAttribute("exercise", exercise);
        req.getRequestDispatcher("delete-exercise.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        ExerciseDAOImpl exerciseDAO = ExerciseDAOImpl.getInstance();
        boolean isDeleted = exerciseDAO.delete(Integer.valueOf(id));
        if (!isDeleted) {
            resp.sendRedirect("delete-exercise-success.jsp");
        }
    }
}
