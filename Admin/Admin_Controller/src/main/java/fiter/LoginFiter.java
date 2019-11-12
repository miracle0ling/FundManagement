package fiter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginFiter implements HandlerInterceptor{
    @Override
    public void afterCompletion(HttpServletRequest arg0,
                                HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        // TODO Auto-generated method stub

    }
    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {
        // TODO Auto-generated method stub

    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object arg0) throws Exception {
        // TODO Auto-generated method stub

        String path = request.getRequestURI();
        if(!path.contains("/login")) {
            String username=(String) request.getSession().getAttribute("anum");
            if(username == null){
                response.sendRedirect(request.getContextPath()+"/login");
                return false;
            }
        }
        return true;
    }

}
