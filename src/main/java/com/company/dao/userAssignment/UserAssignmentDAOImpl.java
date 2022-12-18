package com.company.dao.userAssignment;

import com.company.dao.exercise.ExerciseDAOImpl;
import com.company.dao.nutrition.NutritionDAOImpl;
import com.company.dao.user.UserDAOImpl;
import com.company.model.User;
import com.company.model.UserAssignment;
import com.company.model.enums.Assignment_Status;
import com.company.utils.CommonUtils;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserAssignmentDAOImpl implements UserAssignmentDAO{
    private static UserAssignmentDAOImpl userAssignmentDAO;
    private UserAssignmentDAOImpl() {
    }
    public static UserAssignmentDAOImpl getInstance() {
        if (userAssignmentDAO == null)
            userAssignmentDAO = new UserAssignmentDAOImpl();
        return userAssignmentDAO;
    }
    private static final String FIND_BY_ID = "SELECT * FROM user_assignments WHERE id = ?";
    private static final String LIST_OF_ASSIGNMENTS = "SELECT * FROM user_assignments ;";
    private static final String UPDATE = "UPDATE user_assignments SET user_id = ?, trainer_id=?, exercise_id=?, quantity = ?," +
            "nutrition_id = ?, date = ?::date, status=? WHERE id = ?";
    private static final String DELETE = "DELETE FROM user_assignments WHERE id = ?";

    @SneakyThrows
    @Override
    public List<UserAssignment> list() {
        List<UserAssignment> userAssignments = new ArrayList<>();

        try (Connection cn = CommonUtils.getConnection()) {
            Statement statement = cn.createStatement();
            ResultSet rs = statement.executeQuery(LIST_OF_ASSIGNMENTS);

            while (rs.next()) {
                UserAssignment userAssignment = UserAssignment.builder()
                        .id(rs.getInt("id"))
                        .to_user(UserDAOImpl.getInstance().findById(rs.getInt("user_id")))
                        .from_trainer(UserDAOImpl.getInstance().findById(rs.getInt("trainer_id")))
                        .exercise(ExerciseDAOImpl.getInstance().findById(rs.getInt("exercise_id")))
                        .quantity(rs.getInt("quantity"))
                        .nutrition(NutritionDAOImpl.getInstance().findById(rs.getInt("nutrition_id")))
                        .date(LocalDate.parse(rs.getString("date")))
                        .status(Assignment_Status.valueOf(rs.getString("status")))
                        .build();
                userAssignments.add(userAssignment);
            }
            return userAssignments;
        }
    }
    @SneakyThrows
    @Override
    public UserAssignment update(UserAssignment userAssignment) {
        try (Connection cn = CommonUtils.getConnection();
             PreparedStatement ps = cn.prepareStatement(UPDATE)) {
            ps.setInt(1, userAssignment.getTo_user().getId());
            ps.setInt(2, userAssignment.getFrom_trainer().getId());
            ps.setInt(3, userAssignment.getExercise().getId());
            ps.setInt(4, userAssignment.getQuantity());
            ps.setInt(5, userAssignment.getNutrition().getId());
            ps.setString(6, String.valueOf(userAssignment.getDate()));
            ps.setString(7, userAssignment.getStatus().name());
            ps.setInt(8, userAssignment.getId());
            ps.execute();
            userAssignment = findById(userAssignment.getId());
        }

        return userAssignment;
    }
    @SneakyThrows
    @Override
    public UserAssignment findById(Integer id) {
        try (Connection cn = CommonUtils.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(FIND_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return UserAssignment.builder()
                    .id(id)
                    .to_user(UserDAOImpl.getInstance().findById(rs.getInt("user_id")))
                    .from_trainer(UserDAOImpl.getInstance().findById(rs.getInt("trainer_id")))
                    .exercise(ExerciseDAOImpl.getInstance().findById(rs.getInt("exercise_id")))
                    .quantity(rs.getInt("quantity"))
                    .nutrition(NutritionDAOImpl.getInstance().findById(rs.getInt("nutrition_id")))
                    .date(LocalDate.parse(rs.getString("date")))
                    .status(Assignment_Status.valueOf(rs.getString("status")))
                    .build();
        }
    }
@SneakyThrows
    @Override
    public boolean delete(Integer id) {
        try (Connection cn = CommonUtils.getConnection();
             PreparedStatement ps = cn.prepareStatement(DELETE)) {
            ps.setInt(1, id);
            return ps.execute();
        }
    }
    @SneakyThrows
    @Override
    public boolean save(UserAssignment userAssignment) {
        try (Connection cn = CommonUtils.getConnection()) {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(1) FROM user_assignments WHERE user_id = '" + userAssignment.getTo_user().getId() +
                    "' AND trainer_id = '"+userAssignment.getFrom_trainer().getId()+"';");
            rs.next();
            int countOfUser = rs.getInt(1);
            if (countOfUser > 0)
                return false;

            st.execute("INSERT INTO user_assignments(user_id, trainer_id, exercise_id, quantity, nutrition_id, date, status) " +
                    "VALUES('"
                    + userAssignment.getTo_user().getId() + "','" +
                    userAssignment.getFrom_trainer().getId()+"','" +
                    userAssignment.getExercise().getId()+"','" +
                    userAssignment.getQuantity()+"','"+
                    userAssignment.getNutrition().getId()+"','" +
                    userAssignment.getDate()+"','" +
                    userAssignment.getStatus().name()+"');"
            );
            return true;
        }
    }
    @SneakyThrows
    public UserAssignment getUserAssignmentByUser(User user) {

        try (Connection cn = CommonUtils.getConnection()) {
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM user_assignments WHERE user_id = ?");
            ps.setInt(1, user.getId());
            ResultSet rs = ps.executeQuery();
            rs.next();
            return UserAssignment.builder()
                    .to_user(UserDAOImpl.getInstance().findById(rs.getInt("user_id")))
                    .from_trainer(UserDAOImpl.getInstance().findById(rs.getInt("trainer_id")))
                    .exercise(ExerciseDAOImpl.getInstance().findById(rs.getInt("exercise_id")))
                    .quantity(rs.getInt("quantity"))
                    .nutrition(NutritionDAOImpl.getInstance().findById(rs.getInt("nutrition_id")))
                    .date(LocalDate.parse(rs.getString("date")))
                    .status(Assignment_Status.valueOf(rs.getString("status")))
                    .build();
        }
    }
}
