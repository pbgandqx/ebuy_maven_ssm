package com.lcvc.ebuy_maven_ssm.web.shop;

import com.lcvc.ebuy_maven_ssm.model.Customer;
import com.lcvc.ebuy_maven_ssm.service.CustomerService;
import com.lcvc.ebuy_maven_ssm.service.ProductService;
import com.lcvc.ebuy_maven_ssm.service.ProductTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/shop")
public class ShopLoginController {
    @Resource
    private CustomerService customerService;

    /*
      * 显示登录页面，该登录页面是使用Ajax进行登录
      */
    @RequestMapping(value = "/tosignin", method = RequestMethod.GET)
    public String tosignin() {
        return "jsp/shop/signin.jsp";
    }

    /*
     * 用于判断登录
     */
    @ResponseBody
    @RequestMapping(value = "/dosignin", method = RequestMethod.POST)
    public Map<String,Object> dosignin(String username, String password, HttpSession session) {
        Map<String,Object> map=new HashMap<String,Object>();
        Customer customer=customerService.login(username, password);
        if(customer!=null){
            session.setAttribute("customer", customer);
            map.put("status",1);
        }else{
            map.put("status",0);
            map.put("myMessage", "登录失败:密码错误");
        }
        return map;
    }

    /*
	 * 显示登录页面，该登录页面是使用Ajax进行登录
	 */
    @RequestMapping(value = "/tosignup", method = RequestMethod.GET)
    public String tosignup() {
        return "jsp/shop/signup.jsp";
    }


    /*执行注册*/
    @RequestMapping(value = "/doSaveShopSignup", method = RequestMethod.POST)
    public String doSaveShopSignup(Model model, ModelAndView modelAndView, Customer customer) {
        customer.setUsername(customer.getUsername().trim());
        customer.setPassword(customer.getPassword().trim());
        if (customer.getPassword().length() == 0) {
            model.addAttribute("myMessage", "账号密码不能为空!");
        } else if (customer.getUsername().length() == 0) {
            model.addAttribute("myMessage", "账号名不能为空");
        }else {
            if (customerService.SaveCustomer(customer)==true) {
                model.addAttribute("customer",null) ;
                model.addAttribute("myMessage", "用户注册成功,请登录！！！");
            } else {
                model.addAttribute("myMessage", "用户注册失败，请重试！！！");
            }
        }
        return "jsp/shop/signup.jsp";
    }

    /*执行注册页面
    @ResponseBody
    @RequestMapping(value = "/doSaveShopSignup", method = RequestMethod.POST)
    public Map<String,Object> doSaveShopSignup(Customer customer, HttpSession session) {
        Map<String,Object> map=new HashMap<String,Object>();
        if(customerService.SaveShopSignupCustomer(customer)){
            map.put("status",1);
        }else{
            map.put("status",0);
            map.put("myMessage", "注册失败！");
        }
        return map;
    }
*/

}
