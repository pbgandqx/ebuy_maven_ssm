package com.lcvc.ebuy_maven_ssm.web.backstage.product;

import com.lcvc.ebuy_maven_ssm.model.Product;
import com.lcvc.ebuy_maven_ssm.model.ProductType;
import com.lcvc.ebuy_maven_ssm.service.ProductService;
import com.lcvc.ebuy_maven_ssm.service.ProductTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ProductController {
    @Resource
    private ProductService productService;

    //跳转到产品模块页面
    @RequestMapping(value = "/backstage/product/toProduct", method = RequestMethod.GET)
    public String toProduct(HttpServletRequest request) {
        request.setAttribute("list", productService.getProductList());
        return "jsp/backstage/product/product.jsp";
    }

   //跳转到产品添加页面
    @RequestMapping(value = "/backstage/product/toSaveProduct", method = RequestMethod.GET)
    public String toSaveProduct(HttpServletRequest request) {
        return "jsp/backstage/product/productadd.jsp";
    }


//执行产品添加页面

    @RequestMapping(value = "/backstage/product/doSaveProduct", method = RequestMethod.POST)
    public String doSaveProduct(Model model, Product product) {
        product.setName(product.getName().trim());
        if (product.getName().length() == 0) {
            model.addAttribute("myMessage", "产品分类编辑：产品名称不能为空！");
        }else if (product.getProductType()==null) {
            model.addAttribute("myMessage", "产品分类编辑:产品分类不能为空");
        }  else if (product.getPicUrl().length() == 0) {
            model.addAttribute("myMessage", "产品分类编辑:产品图片不能为空");
        } else if (product.getOrderNum()==null) {
            model.addAttribute("myMessage", "产品分类编辑:产品优先级不能为空");
        }else if (product.getPrice()==null) {
            model.addAttribute("myMessage", "产品分类编辑:产品现价不能为空");
        } else if (product.getOriginalPrice()==null) {
            model.addAttribute("myMessage", "产品分类编辑:产品原价不能为空");
        } else if (product.getClick()==null) {
            model.addAttribute("myMessage", "产品分类编辑:产品点击数不能为空");
        } else if (product.getOnSale()==null) {
            model.addAttribute("myMessage", "产品分类编辑:产品是否上架不能为空");
        } else {
                model.addAttribute("myMessage", "产品分类添加失败！！！");
            }

        return "jsp/backstage/product/productadd.jsp";
    }


    //执行删除产品分类操作
    @ResponseBody
    @RequestMapping(value = "/backstage/product/dodeleteProduct", method = RequestMethod.GET)
    public Map<String,Object> dodeleteProduct(Integer id) {
        Map<String,Object> map=new HashMap<String,Object>();
        productService.deleteProduct(id);
        map.put("status",1);
        return map;
    }

    //跳转到产品添加编辑页面
    @RequestMapping(value = "/backstage/product/toProductupdate", method = RequestMethod.GET)
    public String toProductupdate(Model model, Integer id) {
        model.addAttribute("product",productService.getProduct(id));
        return "/jsp/backstage/product/productupdate.jsp";
    }


    //执行产品编辑操作
    @RequestMapping(value = "/backstage/product/doProductupdate", method = RequestMethod.POST)
    public String doupdateProduct(Model model, Product product) {
        product.setName(product.getName().trim());
        if (product.getName().length() == 0) {
            model.addAttribute("myMessage", "产品分类编辑：产品名称不能为空！");
        }else if (product.getProductType()==null) {
            model.addAttribute("myMessage", "产品分类编辑:产品分类不能为空");
        }  else if (product.getPicUrl().length() == 0) {
            model.addAttribute("myMessage", "产品分类编辑:产品图片不能为空");
        } else if (product.getOrderNum()==null) {
            model.addAttribute("myMessage", "产品分类编辑:产品优先级不能为空");
        }else if (product.getPrice()==null) {
            model.addAttribute("myMessage", "产品分类编辑:产品现价不能为空");
        } else if (product.getOriginalPrice()==null) {
            model.addAttribute("myMessage", "产品分类编辑:产品原价不能为空");
        } else if (product.getClick()==null) {
            model.addAttribute("myMessage", "产品分类编辑:产品点击数不能为空");
        } else if (product.getOnSale()==null) {
            model.addAttribute("myMessage", "产品分类编辑:产品是否上架不能为空");
        }  else {
            if (productService.updateProduct(product)) {
                model.addAttribute("myMessage", "产品分类信息编辑成功！");
            } else {
                model.addAttribute("myMessage", "产品分类信息编辑失败！");
            }
        }
            return "/jsp/backstage/product/productupdate.jsp";

    }



}
