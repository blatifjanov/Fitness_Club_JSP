package com.company.controller.membership;
import com.company.dao.membership.MembershipDAOImpl;
import com.company.model.Membership;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(value = UpdateMembershipController.BASE_PATH)
public class UpdateMembershipController extends HttpServlet {
    public static final String BASE_PATH = "/updateMembership";
    public static final String BASE_PAGE = "update-membership.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MembershipDAOImpl membershipDAO = MembershipDAOImpl.getInstance();
        Membership membership = membershipDAO.findById(Integer.valueOf(req.getParameter("id")));
        req.setAttribute("membership", membership);
        req.getRequestDispatcher(UpdateMembershipController.BASE_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Membership membership = Membership.builder()
                .id(Integer.parseInt(id))
                .membershipName(req.getParameter("name"))
                .price(Double.parseDouble(req.getParameter("price")))
                .build();
        MembershipDAOImpl membershipDAO = MembershipDAOImpl.getInstance();
        membershipDAO.update(membership);
        resp.sendRedirect("update-membership-success.jsp");
    }
}
