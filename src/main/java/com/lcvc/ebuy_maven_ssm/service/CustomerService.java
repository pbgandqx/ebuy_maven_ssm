package com.lcvc.ebuy_maven_ssm.service;

import com.lcvc.ebuy_maven_ssm.dao.CustomerDao;
import com.lcvc.ebuy_maven_ssm.dao.ProductTypeDao;
import com.lcvc.ebuy_maven_ssm.model.Customer;
import com.lcvc.ebuy_maven_ssm.model.ProductType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerService {
    @Resource
    private CustomerDao customerDao;

    /**
     * 返回所有的管理账户集合
     * @return 以List方式返回
     */
    public List<Customer> getCustomerList(){
        return customerDao.getCustomerList();
    }

 /*
    * 将账户信息存进数据库
    * @param  producttype
    * @return true表示保存成功，false表示保存失败
    * */
 public boolean SaveCustomer(Customer customer) {
     boolean stsatus = false;
     if (customerDao.SaveCustomer(customer)==1){
         stsatus= true;
     }else {
         stsatus= false;
     }
     return stsatus;
 }
    /**
     * 删除指定账户
     * @param id 被删除的账户id
     * @return true表示删除成功
     */
    public boolean deleteCustomer(Integer id){
        boolean status=false;//存储修改结果
        int n=customerDao.deleteCustomer(id);
                if(n==1){
                    status=true;
                }
        return status;
    }
/**
        * 判断账户名是否存在（用于创建新账户的时候）
            * @param username
     * @return true表示存在，false表示存在
     */
    public boolean existsUsername(String username){
        if(customerDao.existsUsername(username)==0){
            return false;
        }else{
            return true;
        }
    }

    /**
     * 修改账户的基本信息
     * 说明：
     * 1、修改后的账户名不能与其他账户的账户名重名
     * @param
     * @param
     * @param
     * @return false表示修改失败，true表示修改成功
     */
    public boolean updateCustomer(Customer customer){
        boolean status=false;//存储修改结果
            if(customerDao.updateCustomer(customer)==1){
                status=true;
            }else{
                status=false;
            }

        return status;
    }

    /*
        *  根据标识符获取相应的管理账户对象
        *  @param id
        *  @return null 表示没有找到
        * */
    public Customer getCustomer(Integer id){
        Customer customer=null;
        if (id!=null){
            customer=customerDao.getCustomer(id);
        }
        return customer;
    }
}
