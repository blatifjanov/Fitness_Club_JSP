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
import java.util.List;
import java.util.Objects;

@WebServlet(value = NutritionListController.BASE_PATH)
public class NutritionListController extends HttpServlet {
    public static final String BASE_PATH="/list-nutrition";
    public static final String BASE_PAGE="list-nutrition.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Objects.isNull(req.getParameter("id"))) {

            NutritionDAOImpl nutritionDAO = NutritionDAOImpl.getInstance();
            List<Nutrition> nutritionList = nutritionDAO.list();
            req.setAttribute("nutritionList", nutritionList);
            RequestDispatcher rd = req.getRequestDispatcher("list-nutrition.jsp");
            rd.forward(req, resp);
        }
    }

}
