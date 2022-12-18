package com.company.controller.nutrition;

import com.company.dao.exercise.ExerciseDAOImpl;
import com.company.dao.nutrition.NutritionDAOImpl;
import com.company.model.Exercise;
import com.company.model.Nutrition;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(value = DeleteNutritionController.BASE_PATH)
public class DeleteNutritionController extends HttpServlet {
    public static final String BASE_PATH = "/deleteNutrition";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NutritionDAOImpl nutritionDAO = NutritionDAOImpl.getInstance();
        String id = req.getParameter("id");
        Nutrition nutrition = nutritionDAO.findById(Integer.valueOf(id));
        req.setAttribute("nutrition", nutrition);
        req.getRequestDispatcher("delete-nutrition.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        NutritionDAOImpl nutritionDAO = NutritionDAOImpl.getInstance();
        boolean isDeleted = nutritionDAO.delete(Integer.valueOf(id));
        if (!isDeleted) {
            resp.sendRedirect("delete-nutrition-success.jsp");
        }
    }
}
