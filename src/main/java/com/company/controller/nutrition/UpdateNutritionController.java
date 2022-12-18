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

@WebServlet(value = UpdateNutritionController.BASE_PATH)
public class UpdateNutritionController extends HttpServlet {
    public static final String BASE_PATH = "/updateNutrition";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NutritionDAOImpl nutritionDAO = NutritionDAOImpl.getInstance();
        Nutrition nutrition = nutritionDAO.findById(Integer.valueOf(req.getParameter("id")));
        req.setAttribute("nutrition", nutrition);
        req.getRequestDispatcher("update-nutrition.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Nutrition nutrition = Nutrition.builder()
                .id(Integer.parseInt(id))
                .name(req.getParameter("name"))
                .build();
        NutritionDAOImpl nutritionDAO = NutritionDAOImpl.getInstance();
        nutritionDAO.update(nutrition);
        resp.sendRedirect("update-nutrition-success.jsp");
    }
}
