package com.ecommerce.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EncodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");

        if (res instanceof HttpServletResponse && req instanceof HttpServletRequest) {
            HttpServletRequest request = (HttpServletRequest) req;
            HttpServletResponse response = (HttpServletResponse) res;
            String uri = request.getRequestURI();

            // JSP/Servlet sayfalarının Türkçe karakterleri doğru göstermesi için UTF-8 header'ı gönderilir.
            // Statik css/js/resim gibi dosyalara müdahale edilmez.
            if (!uri.contains("/assets/")) {
                response.setContentType("text/html; charset=UTF-8");
                response.setHeader("Content-Type", "text/html; charset=UTF-8");
            }
        }

        chain.doFilter(req, res);
    }
}
