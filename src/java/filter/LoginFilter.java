/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filter;

import entity.Kullanici;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author Ufuk
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) sr;
        HttpServletResponse response = (HttpServletResponse) sr1;

        String url = request.getRequestURI();

        HttpSession session = request.getSession();

        Kullanici kullanici = null;

        if (session != null) {
            kullanici = (Kullanici) session.getAttribute("validUser");
        }
        
        if (kullanici == null) {
            if (url.contains("Daire")) {
                response.sendRedirect(request.getContextPath() + "/panel/Kullanici.xhtml");
            } else if (url.contains("Bahce")) {
                response.sendRedirect(request.getContextPath() + "/panel/Kullanici.xhtml");
            } else if (url.contains("Tarla")) {
                response.sendRedirect(request.getContextPath() + "/panel/Kullanici.xhtml");
            } else if (url.contains("Villa")) {
                response.sendRedirect(request.getContextPath() + "/panel/Kullanici.xhtml");
            } else {
                fc.doFilter(sr, sr1);
            }
        } else {
            if (url.contains("Logout")) {
                session.invalidate();
                response.sendRedirect(request.getContextPath() + "/panel/Kullanici.xhtml");
            } else {
                fc.doFilter(sr, sr1);
            }
        }
    }

}
