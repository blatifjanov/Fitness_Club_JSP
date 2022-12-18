package com.company.service;

import com.company.model.User;
import com.company.utils.CommonUtils;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class RegisterService {

    private static RegisterService registerService;
    private RegisterService() {
    }
    public static RegisterService getInstance() {
        if (registerService == null)
            registerService = new RegisterService();
        return registerService;
    }

    @SneakyThrows
    public boolean save(User user) {
        try (Connection cn = CommonUtils.getConnection()) {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(1) FROM users WHERE email = '" + user.getEmail() + "';");
            rs.next();
            int countOfUser = rs.getInt(1);
            if (countOfUser > 0)
                return false;

            st.execute("INSERT INTO users(first_name, last_name,email,password,date_of_birth,phone, gender) VALUES('"
                    + user.getFirstName() + "','" + user.getLastName() + "','" + user.getEmail() + "','" + user.getPassword() + "','"
                    + user.getDateOfBirth() + "','" + user.getPhone() + "','" + user.getGender() + "');"
            );
            return true;
        }

    }
}
