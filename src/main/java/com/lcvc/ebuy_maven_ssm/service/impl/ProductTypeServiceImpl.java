package com.lcvc.ebuy_maven_ssm.service.impl;

import com.lcvc.ebuy_maven_ssm.dao.ProductTypeDao;
import com.lcvc.ebuy_maven_ssm.model.ProductType;
import com.lcvc.ebuy_maven_ssm.service.ProductTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    @Resource
    private ProductTypeDao productTypeDao;


    public List<ProductType> getProductTypeList() {
        return productTypeDao.getProductTypeList();
    }

    public boolean SaveProductType(ProductType productType) {
        boolean stsatus = false;
        if (productTypeDao.SaveProductType(productType) == 1) {
            stsatus = true;
        } else {
            stsatus = false;
        }
        return stsatus;
    }

    public boolean deleteProductType(Integer id) {
        boolean status = false;//存储修改结果
        int n = productTypeDao.deleteProductType(id);
        if (n == 1) {
            status = true;
        }
        return status;
    }


    public boolean existsProductType(String name, Integer id) {
        if (productTypeDao.existsProductType(name, id) == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean updateProductType(ProductType productType) {
        boolean status = false;//存储修改结果
        if (productTypeDao.updateProductType(productType) == 1) {
            status = true;
        } else {
            status = false;
        }

        return status;
    }


    public ProductType getProductType(Integer id) {
        ProductType productType = null;
        if (id != null) {
            productType = productTypeDao.getProductType(id);
        }
        return productType;
    }
}
