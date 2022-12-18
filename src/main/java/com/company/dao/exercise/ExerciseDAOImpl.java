package com.company.dao.exercise;

import com.company.model.Exercise;
import com.company.utils.CommonUtils;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ExerciseDAOImpl implements ExerciseDAO {
    private static final String LIST_OF_EXERCISES = "SELECT * FROM exercises;";
    private static final String UPDATE = "UPDATE exercises SET name = ? WHERE id = ?";
    private static final String FIND_BY_ID = "SELECT * FROM exercises WHERE id = ?";
    private static final String DELETE = "DELETE FROM exercises WHERE id = ?";

    private static ExerciseDAOImpl exerciseDAO;

    private ExerciseDAOImpl() {
    }

    public static ExerciseDAOImpl getInstance() {
        if (exerciseDAO == null)
            exerciseDAO = new ExerciseDAOImpl();
        return exerciseDAO;
    }

    @SneakyThrows
    @Override
    public List<Exercise> list() {
        List<Exercise> exercises = new ArrayList<>();

        try (Connection cn = CommonUtils.getConnection()) {
            Statement statement = cn.createStatement();
            ResultSet rs = statement.executeQuery(LIST_OF_EXERCISES);

            while (rs.next()) {
                Exercise exercise = Exercise.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .build();
                exercises.add(exercise);
            }
            return exercises;
        }
    }

    @SneakyThrows
    @Override
    public Exercise update(Exercise exercise) {
        try (Connection cn = CommonUtils.getConnection();
             PreparedStatement ps = cn.prepareStatement(UPDATE)) {
            ps.setString(1, exercise.getName());
            ps.setInt(2, exercise.getId());
            ps.execute();
            exercise = findById(exercise.getId());
        }

        return exercise;
    }

    @SneakyThrows
    @Override
    public Exercise findById(Integer id) {
        try (Connection cn = CommonUtils.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(FIND_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return Exercise.builder()
                    .id(id)
                    .name(rs.getString("name"))
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
    public boolean save(Exercise exercise) {
        try (Connection cn = CommonUtils.getConnection()) {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(1) FROM exercises WHERE name = '" + exercise.getName() + "';");
            rs.next();
            int countOfUser = rs.getInt(1);
            if (countOfUser > 0)
                return false;

            st.execute("INSERT INTO exercises(name) VALUES('"
                    + exercise.getName() + "');"
            );
            return true;
        }

    }

}
