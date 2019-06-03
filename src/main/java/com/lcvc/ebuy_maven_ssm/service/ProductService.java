package com.lcvc.ebuy_maven_ssm.service;

import com.lcvc.ebuy_maven_ssm.dao.ProductDao;
import com.lcvc.ebuy_maven_ssm.dao.ProductTypeDao;
import com.lcvc.ebuy_maven_ssm.model.Product;
import com.lcvc.ebuy_maven_ssm.model.ProductType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public interface ProductService {

    /**
     * 返回所有的管理账户集合
     *
     * @return 以List方式返回
     */
    List<Product> getProductList();

    /*
       * 将账户信息存进数据库
       * @param  producttype
       * @return true表示保存成功，false表示保存失败
       * */
    boolean SaveProduct(Product product);

    /**
     * 删除指定账户
     *
     * @param id 被删除的账户id
     * @return true表示删除成功
     */
    boolean deleteProduct(Integer id);

    /**
     * 查找在数据库中和指定用户名重名的个数
     *
     * @param
     * @param
     * @return 返回重名的个数
     */
    boolean existsProductType(String name, Integer id);

    /**
     * 修改账户的基本信息
     * 说明：
     * 1、修改后的账户名不能与其他账户的账户名重名
     *
     * @param
     * @param
     * @param
     * @return false表示修改失败，true表示修改成功
     */
    boolean updateProduct(Product product);

    /*
        *  根据标识符获取相应的管理账户对象
        *  @param id
        *  @return null 表示没有找到
        * */
    Product getProduct(Integer id);
}
