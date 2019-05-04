package com.lcvc.ebuy_maven_ssm.web.backstage.product;

import com.lcvc.ebuy_maven_ssm.dao.ProductDao;
import com.lcvc.ebuy_maven_ssm.model.ProductType;
import com.lcvc.ebuy_maven_ssm.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.lcvc.ebuy_maven_ssm.service.ProductService.*;

@Controller
public class AdminProductController {
    @Resource
    private ProductService productService;

    //跳转到产品模块页面
    @RequestMapping(value = "/backstage/product/toProducttype", method = RequestMethod.GET)
    public String toProducttype(HttpServletRequest request){
        request.setAttribute("list",productService.getProductTypeList());
        return "jsp/backstage/product/producttype.jsp";
    }

    //跳转到产品添加页面
    @RequestMapping(value = "/backstage/product/toSaveProductType", method = RequestMethod.GET)
    public String toSaveProductType(HttpServletRequest request){
        return "jsp/backstage/product/productTypeadd.jsp";
    }


//执行产品添加页面

    @RequestMapping(value = "/backstage/product/doSaveProductType", method = RequestMethod.POST)
    public String doSaveProductType(HttpServletRequest request,ProductType productType){
        productType.setName(productType.getName().trim());
        if(productType.getName().length()==0){
            request.setAttribute("myMessage","产品分类添加:产品名称不能为空");
        }else{
            if(productService.SaveProductType(productType)){
                request.setAttribute("myMessage","产品分类添加成功！！！");
            }else{
                request.setAttribute("myMessage","产品分类添加失败！！！");
            }
        }
        return "jsp/backstage/product/productTypeadd.jsp";
    }


    //执行删除产品分类操作
    @RequestMapping(value = "/backstage/product/dodeleteProductType", method = RequestMethod.GET)
    public String dodeleteProductType(HttpServletRequest request, HttpSession session,Integer id,ProductType productType){
        ProductType producttype= (ProductType) session.getAttribute("producttype");
        productService.deleteProductType(id,productType.getId());
        request.setAttribute("list",productService.getProductTypeList());
        return "/jsp/backstage/product/producttype.jsp";
    }

    //跳转到产品添加编辑页面
    @RequestMapping(value = "/backstage/product/toProductTypeupdate", method = RequestMethod.GET)
    public String toProductTypeupdate(HttpServletRequest request,Integer id){
        request.setAttribute("producttype",productService.getProductType(id));
        return "/jsp/backstage/product/productTypeupdate.jsp";
    }

    //执行产品分类编辑操作
    @RequestMapping(value = "/backstage/product/doProductTypeupdate", method = RequestMethod.POST)
    public String ddoProductTypeupdate(HttpSession session,HttpServletRequest request,ProductType productType){
        productType.setName(productType.getName().trim());
        if (productType.getName().equals("")){
            request.setAttribute("myMessage","编辑失败：产品分类名不能为空！");
        }else if (productService.existsProductType(productType.getName(),productType.getId())==true){
            request.setAttribute("myMessage","编辑失败：产品分类名重名！");
        }
        else {
            if (productService.updateProductType(productType.getName(),productType.getId())){
                request.setAttribute("myMessage","基本信息编辑成功！");
            }else {
                request.setAttribute("myMessage","基本信息编辑失败！");
            }

        }

        return "/jsp/backstage/product/productTypeupdate.jsp";
    }

}
