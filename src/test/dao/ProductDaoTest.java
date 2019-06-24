package dao;

import com.lcvc.ebuy_maven_ssm.dao.ProductDao;
import com.lcvc.ebuy_maven_ssm.model.Product;
import com.lcvc.ebuy_maven_ssm.test.SpringJunitTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;
import java.util.Date;

public class ProductDaoTest extends SpringJunitTest {

    @Resource
    private ProductDao productDao;

    @Test
    public void testgetProductList(){
        List<Product> list=productDao.getProductList();
        for (int i=0;i<list.size();i++){
            Product product=list.get(i);
            System.out.println(product.getName()+"\t");
          //  System.out.println(product.getProductTypeId().getName()+"\t");
            System.out.println();
        }
        System.out.println(productDao.getProductList());
    }

    @Test
    public void testGetPartList(){
        List<Product> list= productDao.getPartlist(0,10);
        for(int i=0;i<list.size();i++){
            Product product=list.get(i);
            System.out.println(product.getName()+"\t");
            System.out.println();
        }
    }
    @Test
    public void testSaveProduct(){
        Product product=new Product();
        product.setName("猕猴桃蛋糕");
        product.setNumber(100);
        product.setOnSale(true);
        product.setPicUrl("/lcvc_ebuy/upload/image/20170907/20170907203238_612.jpg");
       //product.setPrice();
        product.setOrderNum(100);
      //  product.setOriginalPrice();
        product.setClick(100);

       product.setCreateTime(new Date());
       productDao.SaveProduct(product);
        System.out.println(product.getId());

    }
}
