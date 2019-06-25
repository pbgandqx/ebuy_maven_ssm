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


    public List<Customer> getCustomerList(Integer page) {
        int pagesize = 3;//每页显示3条记录
        if (page==null){//如果page为null，默认为第一页
            page=1;
        }else {
            if (page<1){
                page=1;
            }
        }
        int offset = (page - 1) * pagesize + 1;//每页开始的记录数位置（仅在业务层使用，不考虑数据库）

        return customerDao.getPartlist(offset - 1, pagesize);//数据库记录位置从0数起）
    }
    @Override
    public int maxPage(){
        int maxPage=0;//默认为0
        int pagesize=3;//每页显示3记录
        int total=customerDao.total();//最大记录数
        if (total%pagesize==0){//%表示余数，比如35%5=5
            maxPage=total/pagesize;
        }else {
            maxPage=total/pagesize+1;
        }
        return  maxPage;
    }

    public Customer login(String username, String password) {
        Customer customer = customerDao.login(username, password);
        return customer;
    }
}
