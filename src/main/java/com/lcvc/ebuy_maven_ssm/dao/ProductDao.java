package com.lcvc.ebuy_maven_ssm.dao;

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
    List<Product> getProductList();

     int SaveProduct(Product product);


    /**
     * 删除指定账户
     * @param id 关键字
     * @return 删除了多少条记录
     */
    int deleteProduct(Integer id);

    /**
     * 修改账户的基本信息
     * @return 更改了多少条记录
     */
    int updateProduct(Product product);

    /**
     * 查找在数据库中和指定用户名重名的个数
     * @param
     * @param
     * @return 返回重名的个数
     */
    int existsProductType(@Param(value = "name") String name, @Param(value = "id") Integer id);


    /*
       *  根据标识符获取相应的管理账户对象
       *  @param id
       *  @return null 表示没有找到
       * */
    Product getProduct(int id);
       /*
        * 分页显示数据库记录
        *
        * */

    List<Product> getPartlist(@Param(value = "offset")int offset,@Param(value = "length")int length);

     /*
        * 获取数据库总记录
        *
        * */
     int total();

     List<Product>  getNewTopProductList(Integer pageSize);


     /*
     *
     * 获取热门订单
     * */
     List<Product> getHotProductList(Integer pageSize);

    /*
   *
   * 获取活动推介
   * */
    List<Product> getTimeProductList(Integer pageSize);

    /*
  *
  * 获取产品分类列表
  * */
    List<Product> getProductTypeShoplistList(Integer id);

}
