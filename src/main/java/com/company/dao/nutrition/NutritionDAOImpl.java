package com.company.dao.nutrition;
import com.company.model.Nutrition;
import com.company.utils.CommonUtils;
import lombok.SneakyThrows;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NutritionDAOImpl implements NutritionDAO{
    private static final String LIST_OF_NUTRITION = "SELECT * FROM nutrition;";
    private static final String UPDATE = "UPDATE nutrition SET name = ? WHERE id = ?";
    private static final String FIND_BY_ID = "SELECT * FROM nutrition WHERE id = ?";
    private static final String DELETE = "DELETE FROM nutrition WHERE id = ?";

    private static NutritionDAOImpl nutritionDAO;
    private NutritionDAOImpl() {
    }
    public static NutritionDAOImpl getInstance() {
        if (nutritionDAO == null)
            nutritionDAO = new NutritionDAOImpl();
        return nutritionDAO;
    }
    @SneakyThrows
    @Override
    public List<Nutrition> list() {
        List<Nutrition> nutritionList = new ArrayList<>();

        try (Connection cn = CommonUtils.getConnection()) {
            Statement statement = cn.createStatement();
            ResultSet rs = statement.executeQuery(LIST_OF_NUTRITION);

            while (rs.next()) {
                Nutrition nutrition = Nutrition.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .build();
                nutritionList.add(nutrition);
            }
            return nutritionList;
        }
    }
    @SneakyThrows
    @Override
    public Nutrition update(Nutrition nutrition) {
        try (Connection cn = CommonUtils.getConnection()) {
            try (PreparedStatement ps = cn.prepareStatement(UPDATE)) {
                ps.setString(1, nutrition.getName());
                ps.setInt(2, nutrition.getId());
                ps.execute();
                nutrition = findById(nutrition.getId());
            }
        }

        return nutrition;
    }
    @SneakyThrows
    @Override
    public Nutrition findById(Integer id) {
        try (Connection cn = CommonUtils.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(FIND_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return Nutrition.builder()
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
    public boolean save(Nutrition nutrition) {
        try (Connection cn = CommonUtils.getConnection()) {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(1) FROM nutrition WHERE name = '" + nutrition.getName() + "';");
            rs.next();
            int countOfUser = rs.getInt(1);
            if (countOfUser > 0)
                return false;

            st.execute("INSERT INTO nutrition(name) VALUES('"
                    + nutrition.getName() + "');"
            );
            return true;
        }
    }

}
