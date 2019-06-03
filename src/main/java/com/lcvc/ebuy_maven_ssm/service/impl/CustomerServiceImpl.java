package com.lcvc.ebuy_maven_ssm.service.impl;

import com.lcvc.ebuy_maven_ssm.dao.CustomerDao;
import com.lcvc.ebuy_maven_ssm.model.Customer;
import com.lcvc.ebuy_maven_ssm.service.CustomerService;
import com.lcvc.ebuy_maven_ssm.util.SHA;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CustomerDao customerDao;


    public List<Customer> getCustomerList(){
        return customerDao.getCustomerList();
    }


     public boolean SaveCustomer(Customer customer) {
     boolean stsatus = false;
     customer.setPassword(SHA.getResult("123456"));
     customer.setCreateTime(new Date());//系统当前时间为创建日期
     if (customerDao.SaveCustomer(customer)==1){
         stsatus= true;
     }else {
         stsatus= false;
     }
     return stsatus;
 }

    public boolean deleteCustomer(Integer id){
        boolean status=false;//存储修改结果
        int n=customerDao.deleteCustomer(id);
                if(n==1){
                    status=true;
                }
        return status;
    }

    public boolean existsUsername(String username){
        if(customerDao.existsUsername(username)==0){
            return false;
        }else{
            return true;
        }
    }

    public boolean updateCustomer(Customer customer){
        boolean status=false;//存储修改结果
            if(customerDao.updateCustomer(customer)==1){
                status=true;
            }else{
                status=false;
            }

        return status;
    }


    public Customer getCustomer(Integer id){
        Customer customer=null;
        if (id!=null){
            customer=customerDao.getCustomer(id);
        }
        return customer;
    }
}
