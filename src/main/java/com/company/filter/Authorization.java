package com.company.filter;
import com.company.model.User;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

public class Authorization implements Filter {
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig=filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        HttpSession session = httpServletRequest.getSession(false);
        User user = session != null ? (User) session.getAttribute("user") : null;

        if (Objects.isNull(session) ||
                Objects.isNull(user)) {
            httpServletResponse.sendRedirect("/login");
            return;
        }

        if (!Objects.equals(user.getRole().name(), filterConfig.getInitParameter("role"))) {
            response.getWriter().write("You do not have an access");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("cabinet.jsp");
            requestDispatcher.include(request, response);
            return;
        }


        chain.doFilter(request, response);
    }
}
