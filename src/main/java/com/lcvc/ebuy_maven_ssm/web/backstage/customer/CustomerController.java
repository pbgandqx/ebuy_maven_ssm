package com.lcvc.ebuy_maven_ssm.web.backstage.customer;

import com.lcvc.ebuy_maven_ssm.model.Customer;
import com.lcvc.ebuy_maven_ssm.model.ProductType;
import com.lcvc.ebuy_maven_ssm.service.CustomerService;
import com.lcvc.ebuy_maven_ssm.service.ProductTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class CustomerController {
    @Resource
    private CustomerService customerService;

    //跳转到客户模块页面
    @RequestMapping(value = "/backstage/customer/tocustomer", method = RequestMethod.GET)
    public String tocustomer(HttpServletRequest request) {
        request.setAttribute("list", customerService.getCustomerList());
        return "jsp/backstage/customer/customer.jsp";
    }

   //跳转到客户添加页面
    @RequestMapping(value = "/backstage/customer/toSaveCustomer", method = RequestMethod.GET)
    public String toSaveCustomer(HttpServletRequest request) {
        return "jsp/backstage/customer/customeradd.jsp";
    }


//执行客户添加页面d

    @RequestMapping(value = "/backstage/customer/doSaveCustomer", method = RequestMethod.POST)
    public String doSaveCustomer(HttpServletRequest request, Customer customer) {
        customer.setUsername(customer.getUsername().trim());
        customer.setName(customer.getName().trim());
        if (customer.getName().length() == 0) {
            request.setAttribute("myMessage", "客户添加:客户名字不能为空");
        } else if (customer.getUsername().length() == 0) {
            request.setAttribute("myMessage", "客户添加:客户账号名不能为空");
        }else if(customerService.existsUsername(customer.getUsername())){
            request.setAttribute("myMessage","客户添加失败:客户账户名已存在，请选择其他的账户名");
        } else {
            if (customerService.SaveCustomer(customer)) {
                request.setAttribute("myMessage", "客户添加成功！！！");
            } else {
                request.setAttribute("myMessage", "客户添加失败！！！");
            }
        }
        return "jsp/backstage/customer/customeradd.jsp";
    }


    //执行删除产品分类操作
    @RequestMapping(value = "/backstage/customer/dodeleteCustomer", method = RequestMethod.GET)
    public String dodeleteCustomer(HttpServletRequest request, HttpSession session, Integer id) {
        Customer customer = (Customer) session.getAttribute("customer");
        customerService.deleteCustomer(id);
        request.setAttribute("list", customerService.getCustomerList());
        return "/jsp/backstage/customer/customer.jsp";
    }

    //跳转到客户编辑页面
    @RequestMapping(value = "/backstage/customer/toCustomerUpdate", method = RequestMethod.GET)
    public String toCustomerUpdate(HttpServletRequest request, Integer id) {
        request.setAttribute("customer",customerService.getCustomer(id));
        return "/jsp/backstage/customer/customerupdate.jsp";
    }

    //执行客户编辑操作
    @RequestMapping(value = "/backstage/customer/doCustomerUpdate", method = RequestMethod.POST)
    public String doCustomerUpdate(HttpSession session, HttpServletRequest request, Customer customer) {
        customer.setName(customer.getName().trim());
        customer.setUsername(customer.getUsername().trim());
        if (customer.getUsername().equals("")) {
            request.setAttribute("myMessage", "编辑失败：客户账号名不能为空！");
        } else if (customer.getName().equals("")) {
            request.setAttribute("myMessage", "编辑失败:客户名字不能为空！");
        }  else {
            if (customerService.updateCustomer(customer)) {
                request.setAttribute("myMessage", "客户信息编辑成功！");
            } else {
                request.setAttribute("myMessage", "客户信息编辑失败！");
            }
        }
            return "/jsp/backstage/customer/customerupdate.jsp";

    }

}
