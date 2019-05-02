package com.lcvc.ebuy_maven_ssm.dao;

import com.lcvc.ebuy_maven_ssm.model.Admin;
import com.lcvc.ebuy_maven_ssm.model.Product;
import com.lcvc.ebuy_maven_ssm.model.ProductType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductDao {

    /**
     * 返回所有的管理账户集合
     * @return 以List方式返回
     */
    List<ProductType> getProductTypeList();

     int SaveProductType(ProductType productType);

}
