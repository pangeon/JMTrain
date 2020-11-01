package san.jee.cecherz.filter;

import san.jee.cecherz.model.Profiles;
import san.jee.cecherz.service.ProfileService;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter", value = "/*")
public class LoginFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest http_req = (HttpServletRequest) req;
        if(http_req.getUserPrincipal() != null && http_req.getSession().getAttribute("user") == null) {
            saveProfileInSession(http_req);
        }
        chain.doFilter(req, resp);
    }
    private void saveProfileInSession(HttpServletRequest req) {
        ProfileService ps = new ProfileService();
        String email = req.getUserPrincipal().getName();
        Profiles profileByEmail = ps.getProfileByEmail(email);
        req.getSession(true).setAttribute("user", profileByEmail);
        req.getSession().setMaxInactiveInterval(300);
        System.out.println("--saveProfileInSession--");
        System.out.println("email: " + email);
        System.out.println("profileByEmail: " + profileByEmail);
    }
    public void init(FilterConfig config) throws ServletException {}
    public void destroy() {}
}
