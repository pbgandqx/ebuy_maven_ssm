package com.lcvc.ebuy_maven_ssm.dao;

import com.lcvc.ebuy_maven_ssm.model.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminDao {
    /**
     * 根据账户名和密码去数据库查询
     * @param username 账户名
     * @param password 密码
     * @return null表示没有找到记录
     */
    Admin login(@Param(value = "username") String username, @Param(value = "password") String password);



    int updateAdmin(Admin admin);


    /**
     * 查找在数据库中和指定用户名重名的个数
     * @param username
     * @param id
     * @return 返回重名的个数
     */
    int existsAdmin(@Param(value = "username")String username,@Param(value = "id")Integer id);


    /**
     * 返回所有的管理账户集合
     * @return 以List方式返回
     */
    List<Admin> getAdminList();

    /**
     * 删除指定账户
     * @param id 关键字
     * @return 删除了多少条记录
     */
    int deleteAdmin(Integer id);


   int saveAdmin(Admin admin);

    /**
     * 查找在数据库中和指定用户名重名的个数
     * @param username
     * @return 返回重名的个数，0表示不重名
     */
    int existsUsername(@Param(value = "username")String username);

      /*
       *  根据标识符获取相应的管理账户对象
       *  @param id
       *  @return null 表示没有找到
       * */
    Admin getAdmin(int id);



}
