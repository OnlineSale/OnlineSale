package com.shop.authentication.filter;

import com.shop.authentication.service.AuthenticationService;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuan on 16-5-5.
 */
public class AuthenticationFilter implements Filter{

    private final static String LOGIN_URL="/register/authenticateFailed";
    private final static String ConfigExcludePatterns="excludePatterns";
    private List<String> excludePatternList=new ArrayList<String>();

    @Resource
    private AuthenticationService authenticationService;

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("PermissionFilter.init()");
        String excludePatterns=filterConfig.getInitParameter(ConfigExcludePatterns);
        initExcludePatternList(excludePatterns);
    }

    private void initExcludePatternList(String excludePatterns) {
        if(excludePatterns==null)
            return;
        String[] patterns=excludePatterns.split(",");
        for(String pattern:patterns){
            excludePatternList.add(pattern);
        }
    }


    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        String requestUrl=request.getRequestURI();
        if(isExcludeUrls(requestUrl)){
            filterChain.doFilter(request,response);
            return;
        }
        HttpSession session=request.getSession();
        switch (authenticationService.authenticatePermission(session)){
            case AuthenticationService.ERROR:
                response.sendRedirect(LOGIN_URL);
                break;
            case AuthenticationService.DENY:
                response.sendRedirect(LOGIN_URL);
                break;
            case AuthenticationService.SUCCESS:
                filterChain.doFilter(request,response);
                break;
            default:
                break;
        }

    }



    public void destroy() {
        System.out.println("PermissionFilter.destroy()");
    }
    private boolean isExcludeUrls(String url){
        for(String pattern:excludePatternList){
            if(url.matches(pattern))
                return true;
        }
        return false;
    }
}
