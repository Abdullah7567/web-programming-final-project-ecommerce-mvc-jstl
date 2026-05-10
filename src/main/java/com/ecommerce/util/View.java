package com.ecommerce.util;
import javax.servlet.*; import javax.servlet.http.*; import java.io.IOException;
public class View {
    public static void forward(HttpServletRequest req, HttpServletResponse resp, String jsp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/" + jsp).forward(req, resp);
    }
}
