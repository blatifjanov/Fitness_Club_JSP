package com.company.controller.membership;
import com.company.dao.membership.MembershipDAOImpl;
import com.company.model.Membership;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet(value = MembershipListController.BASE_PATH)
public class MembershipListController extends HttpServlet {
    public static final String BASE_PATH = "/list-memberships";
    public static final String BASE_PAGE= "list-memberships.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Objects.isNull(req.getParameter("id"))) {
            MembershipDAOImpl membershipDAO = MembershipDAOImpl.getInstance();
            List<Membership> memberships = membershipDAO.list();
            req.setAttribute("memberships", memberships);
            RequestDispatcher rd = req.getRequestDispatcher(MembershipListController.BASE_PAGE);
            rd.forward(req, resp);
        }
    }
}
