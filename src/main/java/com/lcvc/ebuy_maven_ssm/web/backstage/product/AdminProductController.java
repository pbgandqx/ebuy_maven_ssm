package com.lcvc.ebuy_maven_ssm.web.backstage.product;

import com.lcvc.ebuy_maven_ssm.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminProductController {
    @Resource
    private AdminService adminService;

    //跳转到产品模块页面
    @RequestMapping(value = "/backstage/product/toProductAdmin", method = RequestMethod.GET)
    public String toProductAdmin(HttpServletRequest request){
        request.setAttribute("list",adminService.getAdminList());
        return "/jsp/backstage/product/productclassify.jsp";
    }

}
