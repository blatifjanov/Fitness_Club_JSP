package com.company.dao.user;

import com.company.model.User;
import com.company.model.enums.Role;
import com.company.utils.CommonUtils;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO{
    private static UserDAOImpl userDAO;
    private UserDAOImpl() {
    }
    public static UserDAOImpl getInstance() {
        if (userDAO == null)
            userDAO = new UserDAOImpl();
        return userDAO;
    }
    private static final String FIND_BY_ID = "SELECT * FROM USERS WHERE id = ?";
    private static final String LIST_OF_USERS = "SELECT * FROM users WHERE role='USER';";
    private static final String LIST_OF_TRAINERS = "SELECT * FROM users WHERE role='TRAINER';";
    private static final String UPDATE = "UPDATE users SET first_name = ?, last_name=?, email=?, date_of_birth = ?::date," +
            "phone = ?, gender = ?, role = ?, balance = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM users WHERE id = ?";

    @SneakyThrows
    @Override
    public List<User> userList() {
        List<User> users = new ArrayList<>();

        try (Connection cn = CommonUtils.getConnection()) {
            Statement statement = cn.createStatement();
            ResultSet rs = statement.executeQuery(LIST_OF_USERS);

            while (rs.next()) {
                User user = User.builder()
                        .id(rs.getInt("id"))
                        .firstName(rs.getString("first_name"))
                        .lastName(rs.getString("last_name"))
                        .email(rs.getString("email"))
                        .dateOfBirth(LocalDate.parse(rs.getString("date_of_birth")))
                        .phone(rs.getString("phone"))
                        .gender(rs.getString("gender"))
                        .balance(rs.getDouble("balance"))
                        .role(Role.valueOf(rs.getString("role")))
                        .build();
                users.add(user);
            }
            return users;
        }
    }
    @SneakyThrows
    @Override
    public List<User> trainerList() {
        List<User> trainers = new ArrayList<>();

        try (Connection cn = CommonUtils.getConnection()) {
            Statement statement = cn.createStatement();
            ResultSet rs = statement.executeQuery(LIST_OF_TRAINERS);

            while (rs.next()) {
                User user = User.builder()
                        .id(rs.getInt("id"))
                        .firstName(rs.getString("first_name"))
                        .lastName(rs.getString("last_name"))
                        .email(rs.getString("email"))
                        .dateOfBirth(LocalDate.parse(rs.getString("date_of_birth")))
                        .phone(rs.getString("phone"))
                        .gender(rs.getString("gender"))
                        .role(Role.valueOf(rs.getString("role")))
                        .build();
                trainers.add(user);
            }
            return trainers;
        }
    }
    @SneakyThrows
    @Override
    public User findById(Integer id) {
        try (Connection cn = CommonUtils.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(FIND_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return User.builder()
                    .id(id)
                    .firstName(rs.getString("first_name"))
                    .lastName(rs.getString("last_name"))
                    .email(rs.getString("email"))
                    .dateOfBirth(LocalDate.parse(rs.getString("date_of_birth")))
                    .phone(rs.getString("phone"))
                    .gender(rs.getString("gender"))
                    .role(Role.valueOf(rs.getString("role")))
                    .balance(rs.getDouble("balance"))
                    .build();
        }
    }
    @SneakyThrows
    @Override
    public User update(User user) {
        try (Connection cn = CommonUtils.getConnection();
             PreparedStatement ps = cn.prepareStatement(UPDATE)) {
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, String.valueOf(user.getDateOfBirth()));
            ps.setString(5, user.getPhone());
            ps.setString(6, user.getGender());
            ps.setString(7, String.valueOf(user.getRole()));
            ps.setDouble(8, user.getBalance());
            ps.setInt(9, user.getId());
            ps.execute();
            user = findById(user.getId());
        }

        return user;
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
}
