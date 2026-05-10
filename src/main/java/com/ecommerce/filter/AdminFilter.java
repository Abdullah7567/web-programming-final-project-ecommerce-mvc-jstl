package com.ecommerce.filter;
import com.ecommerce.model.User; import javax.servlet.*; import javax.servlet.annotation.WebFilter; import javax.servlet.http.*; import java.io.IOException;
@WebFilter("/admin/*")
public class AdminFilter implements Filter {
 public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)throws IOException,ServletException{HttpServletRequest r=(HttpServletRequest)req;HttpServletResponse h=(HttpServletResponse)res;String path=r.getRequestURI(); if(path.endsWith("/admin/login")){chain.doFilter(req,res);return;} User u=(User)r.getSession().getAttribute("user"); if(u==null||!"ADMIN".equals(u.getRole())){h.sendRedirect(r.getContextPath()+"/admin/login");return;} chain.doFilter(req,res);}
}
