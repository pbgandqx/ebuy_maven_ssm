package service;

import com.lcvc.ebuy_maven_ssm.dao.AdminDao;
import com.lcvc.ebuy_maven_ssm.service.AdminService;
import com.lcvc.ebuy_maven_ssm.test.SpringJunitTest;
import org.junit.Test;

import javax.annotation.Resource;

public class AdminServiceTest extends SpringJunitTest {
    @Resource
    private AdminService adminService;

    @Test
    public void testLogin(){
        System.out.println(adminService.login("user","123456"));
    }
}
