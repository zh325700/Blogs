/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import controller.LoginController;
/**
 *
 * @author zhanghan
 */import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class LoginFilter implements Filter {


  public static final String LOGIN_PAGE = "/login.xhtml";

  @Override
  public void doFilter(ServletRequest servletRequest,
      ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {

    HttpServletRequest httpServletRequest =
        (HttpServletRequest) servletRequest;
    HttpServletResponse httpServletResponse =
        (HttpServletResponse) servletResponse;

    // managed bean name is exactly the session attribute name
    LoginController login = (LoginController) httpServletRequest
        .getSession().getAttribute("login");

    if (login != null) {
      if (login.isLoggedIn()) {
        // user is logged in, continue request
        filterChain.doFilter(servletRequest, servletResponse);
      } else {
        // user is not logged in, redirect to login page
        httpServletResponse.sendRedirect(
            httpServletRequest.getContextPath() + LOGIN_PAGE);
      }
    } else {
      // user is not logged in, redirect to login page
      httpServletResponse.sendRedirect(
          httpServletRequest.getContextPath() + LOGIN_PAGE);
    }
  }

  @Override
  public void init(FilterConfig arg0) throws ServletException {
  }

  @Override
  public void destroy() {
    // close resources
  }
}