package com.lcvc.ebuy_maven_ssm.service;

import com.lcvc.ebuy_maven_ssm.dao.ProductDao;
import com.lcvc.ebuy_maven_ssm.dao.ProductTypeDao;
import com.lcvc.ebuy_maven_ssm.model.Product;
import com.lcvc.ebuy_maven_ssm.model.ProductType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductService {
    @Resource
    private ProductDao productDao;

    /**
     * 返回所有的管理账户集合
     * @return 以List方式返回
     */
    public List<Product> getProductList(){
        return productDao.getProductList();
    }

 /*
    * 将账户信息存进数据库
    * @param  producttype
    * @return true表示保存成功，false表示保存失败
    * */
 public boolean SaveProductType(ProductType productType) {
     boolean stsatus = false;
     if (productDao.SaveProductType(productType)==1){
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
    public boolean deleteProductType(Integer id){
        boolean status=false;//存储修改结果
        int n=productDao.deleteProductType(id);
                if(n==1){
                    status=true;
                }
        return status;
    }

    /**
     * 查找在数据库中和指定用户名重名的个数
     * @param
     * @param
     * @return 返回重名的个数
     */
    public boolean existsProductType(String name,Integer id){
        if (productDao.existsProductType(name,id)==0){
            return false;
        }else {
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
    public boolean updateProductType(ProductType productType){
        boolean status=false;//存储修改结果
            if(productDao.updateProductType(productType)==1){
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
    public ProductType getProductType(Integer id){
        ProductType productType=null;
        if (id!=null){
            productType=productDao.getProductType(id);
        }
        return productType;
    }
}
