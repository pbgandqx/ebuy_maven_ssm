package com.lcvc.ebuy_maven_ssm.service;

import com.lcvc.ebuy_maven_ssm.dao.AdminDao;
import com.lcvc.ebuy_maven_ssm.model.Admin;
import com.lcvc.ebuy_maven_ssm.util.SHA;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public interface AdminService {
    /**
     * 根据账户名和密码去数据库查询，进行登录判断
     *
     * @param username 账户名
     * @param password 密码
     * @return null表示登录失败
     */
    Admin login(String username, String password);

/*
     * 张三丰
	 * 20180330
	 * 将新密码保存到数据库中
	 * @return true表示密码更改成功，false表示密码更改失败
	 */

    boolean updatePassword(String newPass, Integer id);


    /**
     * 修改账户的基本信息
     * 说明：
     * 1、修改后的账户名不能与其他账户的账户名重名
     *
     * @param
     * @param
     * @param
     * @return false表示修改失败，true表示修改成功
     */
    boolean updateAdmin(Admin admin);

    /**
     * 返回所有的管理账户集合
     *
     * @return 以List方式返回
     */
    List<Admin> getAdminList();

    /**
     * 删除指定账户
     *
     * @param id      被删除的账户id
     * @param adminId 执行删除的管理账户
     * @return true表示删除成功
     */
    boolean deleteAdmin(Integer id, Integer adminId);

    /**
     * 查找在数据库中和指定用户名重名的个数
     *
     * @param username
     * @param id
     * @return 返回重名的个数
     */
    boolean existsAdmin(String username, Integer id);
    /*
    * 将账户信息存进数据库
    * @param  admin
    * @return true表示保存成功，false表示保存失败
    * */

    boolean saveAdmin(Admin admin);

    /**
     * 判断账户名是否存在（用于创建新账户的时候）
     *
     * @param username
     * @return true表示存在，false表示存在
     */
    boolean existsUsername(String username);

    /*
        *  根据标识符获取相应的管理账户对象
        *  @param id
        *  @return null 表示没有找到
        * */
    Admin getAdmin(Integer id);

    /*分页
    * */
    List<Admin> getPartlist(Integer page);

    int maxPage();
}
