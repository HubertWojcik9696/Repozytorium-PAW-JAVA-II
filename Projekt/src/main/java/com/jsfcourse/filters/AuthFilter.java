package com.jsfcourse.filters;

import com.jsfcourse.beans.UzytkownikBean;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/userPanel.xhtml", "/workerPanel.xhtml", "/adminPanel.xhtml"})
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        UzytkownikBean uzytkownikBean = (UzytkownikBean) ((HttpServletRequest) request).getSession().getAttribute("uzytkownikBean");


        String url = httpRequest.getRequestURI();
        boolean zalogowany = uzytkownikBean != null && uzytkownikBean.getZalogowanyUzytkownik() != null;

        if (url.contains("/adminPanel.xhtml") && (!zalogowany || !"administrator".equals(uzytkownikBean.getZalogowanyUzytkownik().getRola()))) {
            httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "Nie masz dostępu do tej strony!");
            return;
        }

        if (url.contains("/workerPanel.xhtml") && (!zalogowany || (!"pracownik".equals(uzytkownikBean.getZalogowanyUzytkownik().getRola())
                && !"administrator".equals(uzytkownikBean.getZalogowanyUzytkownik().getRola())))) {
            httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "Nie masz dostępu do tej strony!");
            return;
        }

        if (url.contains("/userPanel.xhtml") && !zalogowany) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.xhtml");
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
