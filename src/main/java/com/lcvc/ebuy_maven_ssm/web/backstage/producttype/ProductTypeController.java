package com.lcvc.ebuy_maven_ssm.web.backstage.producttype;

import com.lcvc.ebuy_maven_ssm.model.ProductType;
import com.lcvc.ebuy_maven_ssm.service.ProductTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ProductTypeController {
    @Resource
    private ProductTypeService productTypeService;

    //跳转到产品模块页面
    @RequestMapping(value = "/backstage/producttype/toProducttype", method = RequestMethod.GET)
    public String toProducttype(HttpServletRequest request) {
        request.setAttribute("list", productTypeService.getProductTypeList());
        return "jsp/backstage/producttype/producttype.jsp";
    }

    //跳转到产品分类添加页面
    @RequestMapping(value = "/backstage/producttype/toSaveProductType", method = RequestMethod.GET)
    public String toSaveProductType(HttpServletRequest request) {
        return "jsp/backstage/producttype/productTypeadd.jsp";
    }


//执行产品分类添加页面

    @RequestMapping(value = "/backstage/producttype/doSaveProductType", method = RequestMethod.POST)
    public String doSaveProductType(Model model, ModelAndView modelAndView, ProductType productType) {
        productType.setName(productType.getName().trim());
        if (productType.getName().length() == 0) {
            model.addAttribute("myMessage", "产品分类添加:产品名称不能为空");
        } else if (productType.getImageUrl().length() == 0) {
            model.addAttribute("myMessage", "产品分类添加:产品图片不能为空");
        } else if (productType.getOrderNum()==null) {
            model.addAttribute("myMessage", "产品分类添加:产品优先级不能为空");
        } else {
            if (productTypeService.SaveProductType(productType)) {

                model.addAttribute("productType",null) ;
                model.addAttribute("myMessage", "产品分类添加成功！！！");
            } else {
                model.addAttribute("myMessage", "产品分类添加失败！！！");
            }
        }
        return "jsp/backstage/producttype/productTypeadd.jsp";
    }


    //执行删除产品分类操作
    @RequestMapping(value = "/backstage/producttype/dodeleteProductType", method = RequestMethod.GET)
    public String dodeleteProductType(HttpServletRequest request, HttpSession session, Integer id) {
        ProductType producTtype = (ProductType) session.getAttribute("productType");
        productTypeService.deleteProductType(id);
        request.setAttribute("list", productTypeService.getProductTypeList());
        return "/jsp/backstage/producttype/producttype.jsp";
    }

    //跳转到产品添加编辑页面
    @RequestMapping(value = "/backstage/producttype/toProductTypeupdate", method = RequestMethod.GET)
    public String toProductTypeupdate(HttpServletRequest request, Integer id) {
        request.setAttribute("productType",productTypeService.getProductType(id));
        return "/jsp/backstage/producttype/productTypeupdate.jsp";
    }

    //执行产品分类编辑操作
    @RequestMapping(value = "/backstage/producttype/doProductTypeupdate", method = RequestMethod.POST)
    public String doProductTypeupdate(HttpSession session, HttpServletRequest request, ProductType productType) {
        productType.setName(productType.getName().trim());
        if (productType.getName().equals("")) {
            request.setAttribute("myMessage", "编辑失败：产品分类名不能为空！");
        } else if (productType.getImageUrl().equals("")) {
            request.setAttribute("myMessage", "产品分类添加:产品图片不能为空");
        } else if (productType.getOrderNum().equals("")) {
            request.setAttribute("myMessage", "产品分类添加:产品优先级不能为空");
        } else {
            if (productTypeService.updateProductType(productType)) {
                request.setAttribute("myMessage", "产品分类信息编辑成功！");
            } else {
                request.setAttribute("myMessage", "产品分类信息编辑失败！");
            }
        }
            return "/jsp/backstage/producttype/productTypeupdate.jsp";

    }


}
