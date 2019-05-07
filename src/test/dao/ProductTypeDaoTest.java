package dao;

import com.lcvc.ebuy_maven_ssm.dao.AdminDao;
import com.lcvc.ebuy_maven_ssm.dao.ProductTypeDao;
import com.lcvc.ebuy_maven_ssm.model.Admin;
import com.lcvc.ebuy_maven_ssm.test.SpringJunitTest;
import com.lcvc.ebuy_maven_ssm.util.SHA;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

public class ProductTypeDaoTest extends SpringJunitTest {

    @Resource
    private ProductTypeDao productTypeDao;


    @Test
    public void testUpdateProductType(){
    //  System.out.println(productTypeDao.updateProductType());
    }


}
