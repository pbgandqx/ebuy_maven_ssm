package com.lcvc.ebuy_maven_ssm.service.impl;

import com.lcvc.ebuy_maven_ssm.dao.ProductTypeDao;
import com.lcvc.ebuy_maven_ssm.model.ProductType;
import com.lcvc.ebuy_maven_ssm.service.ProductTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    @Resource
    private ProductTypeDao productTypeDao;


    public List<ProductType> getProductTypeList() {
        return productTypeDao.getProductTypeList();
    }

    public boolean SaveProductType(ProductType productType) {
        boolean stsatus = false;
        if (productTypeDao.SaveProductType(productType) == 1) {
            stsatus = true;
        } else {
            stsatus = false;
        }
        return stsatus;
    }

    public boolean deleteProductType(Integer id) {
        boolean status = false;//存储修改结果
        int n = productTypeDao.deleteProductType(id);
        if (n == 1) {
            status = true;
        }
        return status;
    }


    public boolean existsProductType(String name, Integer id) {
        if (productTypeDao.existsProductType(name, id) == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean updateProductType(ProductType productType) {
        boolean status = false;//存储修改结果
        if (productTypeDao.updateProductType(productType) == 1) {
            status = true;
        } else {
            status = false;
        }

        return status;
    }


    public ProductType getProductType(Integer id) {
        ProductType productType = null;
        if (id != null) {
            productType = productTypeDao.getProductType(id);
        }
        return productType;
    }


    public List<ProductType> getProductTypeList(Integer page) {
        int pagesize =2;//每页显示3条记录
        if (page==null){//如果page为null，默认为第一页
            page=1;
        }else {
            if (page<1){
                page=1;
            }
        }
        int offset = (page - 1) * pagesize + 1;//每页开始的记录数位置（仅在业务层使用，不考虑数据库）

        return productTypeDao.getPartlist(offset - 1, pagesize);//数据库记录位置从0数起）
    }

    public int maxPage(){
        int maxPage=0;//默认为0
        int pagesize=2;//每页显示3记录
        int total=productTypeDao.total();//最大记录数
        if (total%pagesize==0){//%表示余数，比如35%5=5
            maxPage=total/pagesize;
        }else {
            maxPage=total/pagesize+1;
        }
        return  maxPage;
    }
}
