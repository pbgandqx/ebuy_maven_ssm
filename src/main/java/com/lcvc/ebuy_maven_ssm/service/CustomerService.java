package com.lcvc.ebuy_maven_ssm.service;

import com.lcvc.ebuy_maven_ssm.dao.CustomerDao;
import com.lcvc.ebuy_maven_ssm.dao.ProductTypeDao;
import com.lcvc.ebuy_maven_ssm.model.Customer;
import com.lcvc.ebuy_maven_ssm.model.ProductType;
import com.lcvc.ebuy_maven_ssm.util.SHA;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public interface CustomerService {

    /**
     * 返回所有的管理账户集合
     * @return 以List方式返回
     */
     List<Customer> getCustomerList();

 /*
    * 将账户信息存进数据库
    * @param  producttype
    * @return true表示保存成功，false表示保存失败
    * */
  boolean SaveCustomer(Customer customer) ;
    /**
     * 删除指定账户
     * @param id 被删除的账户id
     * @return true表示删除成功
     */
     boolean deleteCustomer(Integer id);
/**
        * 判断账户名是否存在（用于创建新账户的时候）
            * @param username
     * @return true表示存在，false表示存在
     */
     boolean existsUsername(String username);

    /**
     * 修改账户的基本信息
     * 说明：
     * 1、修改后的账户名不能与其他账户的账户名重名
     * @param
     * @param
     * @param
     * @return false表示修改失败，true表示修改成功
     */
     boolean updateCustomer(Customer customer);

    /*
        *  根据标识符获取相应的管理账户对象
        *  @param id
        *  @return null 表示没有找到
        * */
     Customer getCustomer(Integer id);

    /*分页
 * */
    List<Customer> getCustomerList(Integer page);

    int maxPage();

    /*shop登录*/
    Customer login(String username,String password);

    /*
    * 将账户信息存进数据库
    * @param  producttype
    * @return true表示保存成功，false表示保存失败
    * */
    boolean SaveShopSignupCustomer(Customer customer) ;
}
