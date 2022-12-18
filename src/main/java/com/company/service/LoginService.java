package com.company.service;
import com.company.model.User;
import com.company.model.enums.Role;
import com.company.utils.CommonUtils;
import lombok.SneakyThrows;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

public class LoginService {
    private static LoginService loginService;

    private LoginService() {
    }

    public static LoginService getInstance() {
        if (loginService == null)
            loginService = new LoginService();
        return loginService;
    }

    @SneakyThrows
    public boolean login(User user) {
        try (Connection cn = CommonUtils.getConnection()) {
            PreparedStatement ps = cn.prepareStatement("SELECT COUNT(1) FROM users WHERE email = ? AND password = ?");

            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());

            ResultSet rs = ps.executeQuery();

            rs.next();
            int countOfUsers = rs.getInt(1);

            if (countOfUsers == 0)
                return false;


            PreparedStatement pst = cn.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?");
            pst.setString(1, user.getEmail());
            pst.setString(2, user.getPassword());

            ResultSet rst = pst.executeQuery();

            if (rst.next()) {
                user.setId(rst.getInt("id"));
                user.setFirstName(rst.getString("first_name"));
                user.setLastName(rst.getString("last_name"));
                user.setEmail(rst.getString("email"));
                user.setPassword(rst.getString("password"));
                user.setDateOfBirth(LocalDate.parse(rst.getString("date_of_birth")));
                user.setPhone(rst.getString("phone"));
                user.setGender(rst.getString("gender"));
                user.setRole(Role.valueOf(rst.getString("role")));
                user.setBalance(rst.getDouble("balance"));
            }
            return true;
        }
    }
}
