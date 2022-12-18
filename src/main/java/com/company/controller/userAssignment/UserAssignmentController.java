package com.company.controller.userAssignment;

import com.company.dao.exercise.ExerciseDAOImpl;
import com.company.dao.nutrition.NutritionDAOImpl;
import com.company.dao.user.UserDAOImpl;
import com.company.dao.userAssignment.UserAssignmentDAOImpl;
import com.company.model.Exercise;
import com.company.model.Nutrition;
import com.company.model.User;
import com.company.model.UserAssignment;
import com.company.model.enums.Assignment_Status;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@WebServlet(value = UserAssignmentController.BASE_PATH)
public class UserAssignmentController extends HttpServlet {

    public static final String BASE_PATH = "/user-assignments";
    public static final String BASE_PAGE = "user-assignments.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAOImpl userDAO = UserDAOImpl.getInstance();
        List<User> users = userDAO.userList();
        req.setAttribute("users",users);
        ExerciseDAOImpl exerciseDAO = ExerciseDAOImpl.getInstance();
        List<Exercise> exercises = exerciseDAO.list();
        req.setAttribute("exercises",exercises);
        NutritionDAOImpl nutritionDAO = NutritionDAOImpl.getInstance();
        List<Nutrition> nutritionList = nutritionDAO.list();
        req.setAttribute("nutritionList",nutritionList);
        req.getRequestDispatcher(UserAssignmentController.BASE_PAGE).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        if (Objects.isNull(req.getParameter("userId")) || req.getParameter("userId").isBlank()
                || Objects.isNull(req.getParameter("trainerId")) || req.getParameter("trainerId").isBlank()
                || Objects.isNull(req.getParameter("exerciseId")) || req.getParameter("exerciseId").isBlank()
                || Objects.isNull(req.getParameter("nutritionId")) || req.getParameter("nutritionId").isBlank()) {
            StringBuilder sb = new StringBuilder();
            if (Objects.isNull(req.getParameter("userId")) || req.getParameter("userId").isBlank()) {
                sb.append("User ID,");
            }
            if (Objects.isNull(req.getParameter("trainerId")) || req.getParameter("trainerId").isBlank()) {
                sb.append("Trainer ID,");
            }
            if (Objects.isNull(req.getParameter("exerciseId")) || req.getParameter("exerciseId").isBlank()) {
                sb.append("Exercise ID,");
            }
            if(Objects.isNull(req.getParameter("nutritionId")) || req.getParameter("nutritionId").isBlank())
            sb.append("Nutrition ID");

            if (sb.charAt(sb.length() - 1) == ',') {
                sb.setCharAt(sb.length() - 1, ' ');
            }
            resp.getWriter()
                    .write("<div align=\"center\"> <h1 style=\"color: red\">" + sb + " is required" + "</h1> </div>");
            requestDispatcher = req.getRequestDispatcher(UserAssignmentController.BASE_PAGE);
            requestDispatcher.include(req, resp);
        }

        if (Integer.parseInt(req.getParameter("quantity")) <= 0) {
            resp.getWriter()
                    .write("<div align=\"center\"> <h1 style=\"color: red\">" +"Quantity must be positive" + "</h1> </div>");
            requestDispatcher = req.getRequestDispatcher(UserAssignmentController.BASE_PAGE);
            requestDispatcher.include(req, resp);
        }

        UserAssignment userAssignment = UserAssignment.builder()
                .to_user(UserDAOImpl.getInstance().findById(Integer.valueOf(req.getParameter("userId"))))
                .from_trainer(UserDAOImpl.getInstance().findById(Integer.valueOf(req.getParameter("trainerId"))))
                .exercise(ExerciseDAOImpl.getInstance().findById(Integer.valueOf(req.getParameter("exerciseId"))))
                .quantity(Integer.parseInt(req.getParameter("quantity")))
                .nutrition(NutritionDAOImpl.getInstance().findById(Integer.valueOf(req.getParameter("nutritionId"))))
                .date(LocalDate.parse(req.getParameter("date")))
                .status(Assignment_Status.valueOf(req.getParameter("status")))
                .build();

        UserAssignmentDAOImpl userAssignmentDAO = UserAssignmentDAOImpl.getInstance();
        boolean isSaved = userAssignmentDAO.save(userAssignment);

        if (isSaved) {
            resp.sendRedirect("/user-assignment-successful.jsp");
        } else {
            resp.getWriter()
                    .write("<div align=\"center\"> <h1 style=\"color: red\">Assignment already exists</h1>  </div>");
            requestDispatcher = req.getRequestDispatcher(UserAssignmentController.BASE_PAGE);
            requestDispatcher.include(req, resp);
        }
    }
}
