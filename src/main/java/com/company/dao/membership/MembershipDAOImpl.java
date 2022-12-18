package com.company.dao.membership;
import com.company.model.Membership;
import com.company.utils.CommonUtils;
import lombok.SneakyThrows;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MembershipDAOImpl implements MembershipDAO {
    private static final String LIST_OF_MEMBERSHIPS = "SELECT * FROM memberships;";
    private static final String UPDATE = "UPDATE memberships SET name = ?, price = ? WHERE id = ?";
    private static final String FIND_BY_ID = "SELECT * FROM memberships WHERE id = ?";
    private static final String DELETE = "DELETE FROM memberships WHERE id = ?";

    private static MembershipDAOImpl membershipDAO;

    private MembershipDAOImpl() {
    }

    public static MembershipDAOImpl getInstance() {
        if (membershipDAO == null)
            membershipDAO = new MembershipDAOImpl();
        return membershipDAO;
    }

    @SneakyThrows
    @Override
    public List<Membership> list() {
        List<Membership> memberships = new ArrayList<>();

        try (Connection cn = CommonUtils.getConnection()) {
            Statement statement = cn.createStatement();
            ResultSet rs = statement.executeQuery(LIST_OF_MEMBERSHIPS);

            while (rs.next()) {
                Membership membership = Membership.builder()
                        .id(rs.getInt("id"))
                        .membershipName(rs.getString("name"))
                        .price(rs.getDouble("price"))
                        .build();
                memberships.add(membership);
            }
            return memberships;
        }
    }
    @SneakyThrows
    @Override
    public Membership update(Membership membership) {
        try (Connection cn = CommonUtils.getConnection();
             PreparedStatement ps = cn.prepareStatement(UPDATE)) {
            ps.setString(1, membership.getMembershipName());
            ps.setDouble(2,membership.getPrice());
            ps.setInt(3, membership.getId());
            ps.execute();
            membership = findById(membership.getId());
        }

        return membership;
    }
    @SneakyThrows
    @Override
    public Membership findById(Integer id) {
        try (Connection cn = CommonUtils.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(FIND_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return Membership.builder()
                    .id(id)
                    .membershipName(rs.getString("name"))
                    .price(rs.getDouble("price"))
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
    public boolean save(Membership membership) {
        try (Connection cn = CommonUtils.getConnection()) {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(1) FROM memberships WHERE name = '" + membership.getMembershipName() + "';");
            rs.next();
            int countOfUser = rs.getInt(1);
            if (countOfUser > 0)
                return false;

            st.execute("INSERT INTO memberships(name, price) VALUES('"
                    + membership.getMembershipName()+"','"+membership.getPrice() + "');"
            );
            return true;
        }
    }
}
