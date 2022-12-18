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
import java.util.Objects;

@WebServlet(value = AddMembershipController.BASE_PATH)
public class AddMembershipController extends HttpServlet {
    public static final String BASE_PATH = "/add-membership";
    public static final String BASE_PAGE="add-membership.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(AddMembershipController.BASE_PAGE);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Membership membership = Membership.builder()
                .membershipName(req.getParameter("name"))
                .price(Double.parseDouble(req.getParameter("price")))
                .build();
        RequestDispatcher rd;
        if (Objects.isNull(membership.getMembershipName()) || membership.getMembershipName().isBlank() || membership.getPrice() <= 0) {
            StringBuilder sb= new StringBuilder();
            if(Objects.isNull(membership.getMembershipName())||membership.getMembershipName().isBlank())
                sb.append("Membership name is required,");
            if(membership.getPrice()<=0)
                sb.append("Price must be positive");
            if (sb.charAt(sb.length() - 1) == ',') {
                sb.setCharAt(sb.length() - 1, ' ');
            }
            resp.getWriter()
                    .write("<div align=\"center\"> <h1 style=\"color: red\">" +sb + "</h1> </div>");
            rd = req.getRequestDispatcher(AddMembershipController.BASE_PAGE);
            rd.include(req, resp);
        } else {
            MembershipDAOImpl membershipDAO = MembershipDAOImpl.getInstance();
            boolean isSaved = membershipDAO.save(membership);
            if (isSaved) {
                resp.sendRedirect("add-membership-success.jsp");
            } else {
                resp.getWriter()
                        .write("<div align=\"center\"> <h1 style=\"color: red\">Membership already exists</h1>  </div>");
                rd = req.getRequestDispatcher(AddMembershipController.BASE_PAGE);
                rd.include(req, resp);
            }
        }
    }
}
