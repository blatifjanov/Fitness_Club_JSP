package com.company.dao.membership;
import com.company.model.Membership;
import java.util.List;

public interface MembershipDAO {
    List<Membership> list();
    Membership update(Membership membership);
    Membership findById(Integer id);
    boolean delete(Integer id);
    boolean save(Membership membership);
}
