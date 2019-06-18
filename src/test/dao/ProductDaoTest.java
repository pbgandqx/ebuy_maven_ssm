package dao;

import com.lcvc.ebuy_maven_ssm.dao.ProductDao;
import com.lcvc.ebuy_maven_ssm.model.Product;
import com.lcvc.ebuy_maven_ssm.test.SpringJunitTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class ProductDaoTest extends SpringJunitTest {

    @Resource
    private ProductDao productDao;

    @Test
    public void testgetProductList(){
        List<Product> list=productDao.getProductList();
        for (int i=0;i<list.size();i++){
            Product product=list.get(i);
            System.out.println(product.getName()+"\t");
            System.out.println(product.getProductType().getName()+"\t");
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
      //  product.setCreateTime(new Date());
        productDao.SaveProduct(product);

    }
}
