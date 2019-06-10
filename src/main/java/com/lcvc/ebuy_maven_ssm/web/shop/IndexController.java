package com.lcvc.ebuy_maven_ssm.web.shop;import com.lcvc.ebuy_maven_ssm.service.ProductService;import com.lcvc.ebuy_maven_ssm.service.ProductTypeService;import org.springframework.stereotype.Controller;import org.springframework.ui.Model;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RequestMethod;import javax.annotation.Resource;@Controllerpublic class IndexController {	@Resource	private ProductService productService;	@Resource	private ProductTypeService productTypeService;	@RequestMapping(value = "/shop/toindex", method = RequestMethod.GET)	public String index(Model model) {		model.addAttribute("productType", productTypeService.getProductTypeList());//当前页显示的记录集合		model.addAttribute("newProducts", productService.getNewTopProductList(10));//当前页显示的记录集合		return "/jsp/shop/index.jsp";	}}