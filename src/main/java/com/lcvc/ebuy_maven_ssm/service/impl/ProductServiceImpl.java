package com.lcvc.ebuy_maven_ssm.service.impl;

import com.lcvc.ebuy_maven_ssm.dao.ProductDao;
import com.lcvc.ebuy_maven_ssm.dao.ProductTypeDao;
import com.lcvc.ebuy_maven_ssm.model.Product;
import com.lcvc.ebuy_maven_ssm.model.ProductType;
import com.lcvc.ebuy_maven_ssm.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductDao productDao;


    public List<Product> getProductList() {
        return productDao.getProductList();
    }


    public boolean SaveProduct(Product product) {
        boolean stsatus = false;
        if (productDao.SaveProduct(product) == 1) {
            stsatus = true;
        } else {
            stsatus = false;
        }
        return stsatus;
    }

    public boolean deleteProduct(Integer id) {
        boolean status = false;//存储修改结果
        int n = productDao.deleteProduct(id);
        if (n == 1) {
            status = true;
        }
        return status;
    }


    public boolean existsProductType(String name, Integer id) {
        if (productDao.existsProductType(name, id) == 0) {
            return false;
        } else {
            return true;
        }
    }


    public boolean updateProduct(Product product) {
        boolean status = false;//存储修改结果
        if (productDao.updateProduct(product) == 1) {
            status = true;
        } else {
            status = false;
        }

        return status;
    }

    public Product getProduct(Integer id) {
        Product product = null;
        if (id != null) {
            product = productDao.getProduct(id);
        }
        return product;
    }
}
