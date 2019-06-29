package service;

import com.lcvc.ebuy_maven_ssm.service.CustomerService;
import com.lcvc.ebuy_maven_ssm.test.SpringJunitTest;
import org.junit.Test;

import javax.annotation.Resource;

public class CustomerServiceTest extends SpringJunitTest {
    @Resource
    private CustomerService customerService;

    @Test
    public void testLogin(){
        System.out.println(customerService.login("xiaoer","888888"));
    }

}
