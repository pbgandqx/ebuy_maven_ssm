package dao;

import com.lcvc.ebuy_maven_ssm.dao.AdminDao;
import com.lcvc.ebuy_maven_ssm.model.Admin;
import com.lcvc.ebuy_maven_ssm.test.SpringJunitTest;
import com.lcvc.ebuy_maven_ssm.util.SHA;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

public class AdminDaoTest extends SpringJunitTest {

    @Resource
    private AdminDao adminDao;

    @Test
    public void print(){
        System.out.println("hello");
    }

    @Test
    public void testLogin(){
        Admin admin=adminDao.login("user",  SHA.getResult("123456"));
        System.out.println(admin);
        Admin admin2=adminDao.login("user",  SHA.getResult("12345611"));
        System.out.println(admin2);
    }



    @Test
    public void testUpdateAdmin(){
        //System.out.println(adminDao.updateAdmin("user11","小红",15));

    }

    @Test
    public void testExistsAdmin(){
        System.out.println(adminDao.existsAdmin("user",1));
        System.out.println(adminDao.existsAdmin("user11",1));
        System.out.println(adminDao.existsAdmin("user1",1));
    }

    @Test
    public void testGetAdminList(){
        List<Admin> list= adminDao.getAdminList();
        for(int i=0;i<list.size();i++){
            Admin admin=list.get(i);
            System.out.println(admin.getUsername());
        }
    }

    @Test
    public void testDeleteAdmin(){
        System.out.println(adminDao.deleteAdmin(23));//1
        System.out.println(adminDao.deleteAdmin(0));//0
    }

/*
* 添加管理员
*
* */
      @Test
      public void testSaveAdminAdmin(){
       Admin admin=new Admin();
       admin.setUsername("yyqx1234");
       admin.setPassword("12341234");
       admin.setName("易大佬");
       admin.setCreateTime(new Date());
       adminDao.saveAdmin(admin);

      }

      @Test
    public void testGetAdmin(){
          System.out.println(adminDao.getAdmin(1));
          System.out.println(adminDao.getAdmin(22));
      }

    @Test
    public void testGetPartList(){
        List<Admin> list= adminDao.getPartlist(0,10);
        for(int i=0;i<list.size();i++){
            Admin admin=list.get(i);
            System.out.println(admin.getName()+"\t");
            System.out.println();
        }
    }
}
