package com.company.controller.nutrition;
import com.company.dao.nutrition.NutritionDAOImpl;
import com.company.model.Nutrition;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(value = AddNutritionController.BASE_PATH)
public class AddNutritionController extends HttpServlet {
    public static final String BASE_PATH="/add-nutrition";
    public static final String BASE_PAGE="add-nutrition.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(AddNutritionController.BASE_PAGE);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Nutrition nutrition = Nutrition.builder()
                .name(req.getParameter("name"))
                .build();
        RequestDispatcher requestDispatcher;
        if (Objects.isNull(nutrition.getName()) || nutrition.getName().isBlank()) {
            resp.getWriter()
                    .write("<div align=\"center\"> <h1 style=\"color: red\">" + "Name is required" + "</h1> </div>");
            requestDispatcher = req.getRequestDispatcher(AddNutritionController.BASE_PAGE);
            requestDispatcher.include(req, resp);
        } else {
            NutritionDAOImpl nutritionDAO = NutritionDAOImpl.getInstance();
            boolean isSaved = nutritionDAO.save(nutrition);
            if (isSaved) {
                resp.sendRedirect("add-nutrition-success.jsp");
            } else {
                resp.getWriter()
                        .write("<div align=\"center\"> <h1 style=\"color: red\">Exercise already exists</h1>  </div>");
                requestDispatcher = req.getRequestDispatcher(AddNutritionController.BASE_PAGE);
                requestDispatcher.include(req, resp);
            }
        }
    }
}
