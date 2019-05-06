package com.lcvc.ebuy_maven_ssm.dao;

import com.lcvc.ebuy_maven_ssm.model.Admin;
import com.lcvc.ebuy_maven_ssm.model.Product;
import com.lcvc.ebuy_maven_ssm.model.ProductType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductTypeDao {

    /**
     * 返回所有的管理账户集合
     * @return 以List方式返回
     */
    List<ProductType> getProductTypeList();

     int SaveProductType(ProductType productType);


    /**
     * 删除指定账户
     * @param id 关键字
     * @return 删除了多少条记录
     */
    int deleteProductType(Integer id);

    /**
     * 修改账户的基本信息
     * @return 更改了多少条记录
     */
    int updateProductType(ProductType productType);

    /**
     * 查找在数据库中和指定用户名重名的个数
     * @param
     * @param
     * @return 返回重名的个数
     */
    int existsProductType(@Param(value = "name")String name,@Param(value = "id")Integer id);


    /*
       *  根据标识符获取相应的管理账户对象
       *  @param id
       *  @return null 表示没有找到
       * */
    ProductType getProductType(int id);

}
