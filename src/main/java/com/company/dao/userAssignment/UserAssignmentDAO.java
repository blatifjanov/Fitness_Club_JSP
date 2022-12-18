package com.company.dao.userAssignment;

import com.company.model.UserAssignment;

import java.util.List;

public interface UserAssignmentDAO {
    List<UserAssignment> list();

    UserAssignment update(UserAssignment userAssignment);

    UserAssignment findById(Integer id);

    boolean delete(Integer id);

    boolean save(UserAssignment userAssignment);
}
