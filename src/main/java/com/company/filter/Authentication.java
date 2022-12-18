package com.company.filter;
import com.company.controller.CabinetController;
import com.company.model.User;
import com.company.utils.AppConstants;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebFilter(value = CabinetController.BASE_PATH)
public class Authentication implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;


        HttpSession session = req.getSession(false);
        User user = session != null ? (User) session.getAttribute(AppConstants.CURRENT_USER) : null;

        if (Objects.isNull(session) ||
                Objects.isNull(user)) {
            resp.sendRedirect("/login");
            return;
        }

        chain.doFilter(request, response);
    }
}
