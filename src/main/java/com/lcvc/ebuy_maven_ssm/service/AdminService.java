package com.lcvc.ebuy_maven_ssm.service;

import com.lcvc.ebuy_maven_ssm.dao.AdminDao;
import com.lcvc.ebuy_maven_ssm.model.Admin;
import com.lcvc.ebuy_maven_ssm.util.SHA;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminService {
    @Resource
    private AdminDao adminDao;


    /**
     * 根据账户名和密码去数据库查询，进行登录判断
     * @param username 账户名
     * @param password 密码
     * @return null表示登录失败
     */
    public Admin login(String username, String password){
        //将密码加密后再进行比对
        password= SHA.getResult(password);
        Admin admin=adminDao.login(username, password);
        return admin;
    }


    /*
	 * 张三丰
	 * 20180330
	 * 将新密码保存到数据库中
	 * @return true表示密码更改成功，false表示密码更改失败
	 */
    public boolean updatePassword(String newPass,Integer id){
        Boolean status=false;//默认编辑失败
        newPass= SHA.getResult(newPass);
        if(adminDao.updatePassword(newPass,id)>0){
            status=true;
        }
        return status;
    }


    /**
     * 修改账户的基本信息
     * 说明：
     * 1、修改后的账户名不能与其他账户的账户名重名
     * @param username
     * @param name
     * @param id
     * @return false表示修改失败，true表示修改成功
     */
    public boolean updateAdmin(String username,String name,Integer id){
        boolean status=false;//存储修改结果
        if(adminDao.existsAdmin(username,id)==0){//如果不重名
            if(adminDao.updateAdmin(username,name,id)==1){
                status=true;
            }else{
                status=false;
            }
        }
        return status;
    }

    /**
     * 返回所有的管理账户集合
     * @return 以List方式返回
     */
    public List<Admin> getAdminList(){
        return adminDao.getAdminList();
    }

    /**
     * 删除指定账户
     * @param id 被删除的账户id
     *@param adminId 执行删除的管理账户
     * @return true表示删除成功
     */
    public boolean deleteAdmin(Integer id,Integer adminId){
        boolean status=false;//存储修改结果
        if(id!=null&&adminId!=null){
            if(adminId!=id.intValue()){//如果不是自己删除自己
                int n=adminDao.deleteAdmin(id);
                if(n==1){
                    status=true;
                }
            }
        }
        return status;
    }
    /**
     * 查找在数据库中和指定用户名重名的个数
     * @param username
     * @param id
     * @return 返回重名的个数
     */
    public boolean existsAdmin(String username,Integer id){
        if (adminDao.existsAdmin(username,id)==0){
            return false;
        }else {
            return true;
        }
    }

    public boolean saveAdmin(Admin admin) {
        boolean stsatus = false;
        if (adminDao.saveAdmin(admin)==1){
            stsatus= true;
        }else {
            stsatus= false;
        }
        return stsatus;
    }

}
