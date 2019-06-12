package com.lcvc.ebuy_maven_ssm.web.backstage.filter;

import com.lcvc.ebuy_maven_ssm.model.Admin;
import com.lcvc.ebuy_maven_ssm.service.AdminService;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/*
* 登录拦截器（spring MVC 拦截器），用于后台管理系统拦截，判断用户是否登录
* */
public class LoginForAdminInterceptor extends HandlerInterceptorAdapter {
    @Resource
    private AdminService adminService;

    /*
    *
    * 在执行action里面的处理逻辑之前执行，它返回的是boolean，这里如果我们返回true在接着执行postHandel和afterCompletion，如果我们返回false则中断执行
    *
    * */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception{
        boolean judge=false;//默认登录失败
        String path=request.getContextPath();
        String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
        HttpSession session=request.getSession();
        if (session.getAttribute("admin")!=null){//如果已经登录并且登录状态未失效
            Admin admin=(Admin)session.getAttribute("admin");
            if(adminService.login(admin.getUsername(),admin.getPassword())!=null){//将session中的账号密码重新进行验证
                judge=true;
            }else {//如果验证失败，返回登录页面
                session.removeAttribute("admin");//移除session中的账号信息
                response.sendRedirect(basePath+"backstage/toLogin");
            }

        }else {
            response.sendRedirect(basePath+"backstage/toLogin");
        }
        return  judge;
    }


}
