package com.company.controller.membership;
import com.company.dao.membership.MembershipDAOImpl;
import com.company.model.Membership;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(value = DeleteMembershipController.BASE_PATH)
public class DeleteMembershipController extends HttpServlet {
    public static final String BASE_PATH = "/deleteMembership";
    public static final String BASE_PAGE = "delete-membership.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MembershipDAOImpl membershipDAO = MembershipDAOImpl.getInstance();
        String id = req.getParameter("id");
        Membership membership = membershipDAO.findById(Integer.valueOf(id));
        req.setAttribute("membership", membership);
        req.getRequestDispatcher(DeleteMembershipController.BASE_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        MembershipDAOImpl membershipDAO = MembershipDAOImpl.getInstance();
        boolean isDeleted = membershipDAO.delete(Integer.valueOf(id));
        if (!isDeleted) {
            resp.sendRedirect("delete-membership-success.jsp");
        }

    }
}
