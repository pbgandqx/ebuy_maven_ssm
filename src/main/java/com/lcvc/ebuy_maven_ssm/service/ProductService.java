package com.lcvc.ebuy_maven_ssm.service;

import com.lcvc.ebuy_maven_ssm.dao.AdminDao;
import com.lcvc.ebuy_maven_ssm.dao.ProductDao;
import com.lcvc.ebuy_maven_ssm.model.Admin;
import com.lcvc.ebuy_maven_ssm.model.Product;
import com.lcvc.ebuy_maven_ssm.model.ProductType;
import com.lcvc.ebuy_maven_ssm.util.SHA;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ProductService {
    @Resource
    private ProductDao productDao;

    /**
     * 返回所有的管理账户集合
     * @return 以List方式返回
     */
    public List<ProductType> getProductTypeList(){
        return productDao.getProductTypeList();
    }

 /*
    * 将账户信息存进数据库
    * @param  producttype
    * @return true表示保存成功，false表示保存失败
    * */
 public boolean SaveProductType(ProductType productType) {
     boolean stsatus = false;
     if (productDao.SaveProductType(productType)==1){
         stsatus= true;
     }else {
         stsatus= false;
     }
     return stsatus;
 }


}
