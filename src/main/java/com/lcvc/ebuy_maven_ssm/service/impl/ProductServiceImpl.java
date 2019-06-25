package com.lcvc.ebuy_maven_ssm.service.impl;

import com.lcvc.ebuy_maven_ssm.dao.ProductDao;
import com.lcvc.ebuy_maven_ssm.dao.ProductTypeDao;
import com.lcvc.ebuy_maven_ssm.model.Product;
import com.lcvc.ebuy_maven_ssm.model.ProductType;
import com.lcvc.ebuy_maven_ssm.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductDao productDao;


    public List<Product> getProductList() {
        return productDao.getProductList();
    }


    public boolean SaveProduct(Product product) {
        boolean stsatus = false;
        if (productDao.SaveProduct(product) == 1) {
            stsatus = true;
        } else {
            stsatus = false;
        }
        return stsatus;
    }

    public boolean deleteProduct(Integer id) {
        boolean status = false;//存储修改结果
        int n = productDao.deleteProduct(id);
        if (n == 1) {
            status = true;
        }
        return status;
    }


    public boolean existsProductType(String name, Integer id) {
        if (productDao.existsProductType(name, id) == 0) {
            return false;
        } else {
            return true;
        }
    }


    public boolean updateProduct(Product product) {
        boolean status = false;//存储修改结果
        if (productDao.updateProduct(product) == 1) {
            status = true;
        } else {
            status = false;
        }

        return status;
    }

    public Product getProduct(Integer id) {
        Product product = null;
        if (id != null) {
            product = productDao.getProduct(id);
        }
        return product;
    }
    @Override
    public List<Product> getProductList(Integer page) {
        int pagesize = 6;//每页显示10条记录
        if (page==null){//如果page为null，默认为第一页
            page=1;
        }else {
            if (page<1){
                page=1;
            }
        }
        int offset = (page - 1) * pagesize + 1;//每页开始的记录数位置（仅在业务层使用，不考虑数据库）

        return productDao.getPartlist(offset - 1, pagesize);//数据库记录位置从0数起）
    }
    @Override
    public int maxPage(){
        int maxPage=0;//默认为0
        int pagesize=6;//每页显示6记录
        int total=productDao.total();//最大记录数
        if (total%pagesize==0){//%表示余数，比如35%5=5
            maxPage=total/pagesize;
        }else {
            maxPage=total/pagesize+1;
        }
        return  maxPage;
    }

    @Override
    public List<Product>  getNewTopProductList(Integer pageSize){
        return productDao.getNewTopProductList(pageSize);
    }

    @Override
    public  List<Product> getHotProductList(Integer pageSize) {
        return productDao.getHotProductList(pageSize);
    }

    @Override
    public  List<Product> getTimeProductList(Integer pageSize) {
        return productDao.getTimeProductList(pageSize);
    }


    public List<Product> getProductTypeShoplistList(Integer id){
        return  productDao.getProductTypeShoplistList(id);
    }

    public  List<Product> getProductShopPirceList(Integer id){
        return productDao.getProductShopPirceList(id);
    }

}
