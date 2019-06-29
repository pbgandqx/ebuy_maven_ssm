package com.lcvc.ebuy_maven_ssm.dao;

import com.lcvc.ebuy_maven_ssm.model.Customer;
import com.lcvc.ebuy_maven_ssm.model.ProductType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerDao {

    /**
     * 返回所有的管理账户集合
     * @return 以List方式返回
     */
    List<Customer> getCustomerList();

     int SaveCustomer(Customer customer);

     /*前台注册*/
     int SaveShopSignupCustomer(Customer customer);

    /**
     * 删除指定账户
     * @param id 关键字
     * @return 删除了多少条记录
     */
    int deleteCustomer(Integer id);

    /**
     * 修改账户的基本信息
     * @return 更改了多少条记录
     */
    int updateCustomer(Customer customer);


    /*
       *  根据标识符获取相应的管理账户对象
       *  @param id
       *  @return null 表示没有找到
       * */
    Customer getCustomer(int id);


    /**
     * 查找在数据库中和指定用户名重名的个数
     * @param username
     * @return 返回重名的个数，0表示不重名
     */
    int existsUsername(@Param(value = "username")String username);

     /*
        * 分页显示数据库记录
        *
        * */

    List<Customer> getPartlist(@Param(value = "offset")int offset,@Param(value = "length")int length);

    /*
       * 获取数据库总记录
       *
       * */
    int total();

    /*shop登录页面*/

    Customer login(@Param(value = "username") String username, @Param(value = "password") String password);

}
