package com.lcvc.ebuy_maven_ssm.service.impl;

import com.lcvc.ebuy_maven_ssm.dao.AdminDao;
import com.lcvc.ebuy_maven_ssm.model.Admin;
import com.lcvc.ebuy_maven_ssm.service.AdminService;
import com.lcvc.ebuy_maven_ssm.util.SHA;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminDao adminDao;

    public Admin login(String username, String password) {

        if (password.length()!=32){
            //将密码加密后再进行比对
            password = SHA.getResult(password);
        }

        Admin admin = adminDao.login(username, password);
        return admin;
    }


    public boolean updatePassword(String newPass, Integer id) {
        Boolean status = false;//默认编辑失败
        newPass = SHA.getResult(newPass);
        Admin admin = new Admin();
        admin.setId(id);
        admin.setPassword(newPass);
        if (adminDao.updateAdmin(admin) > 0) {
            status = true;
        }
        return status;
    }


    public boolean updateAdmin(Admin admin) {
        boolean status = false;//存储修改结果
        if (adminDao.existsAdmin(admin.getUsername(), admin.getId()) == 0) {//如果不重名
            if (adminDao.updateAdmin(admin) == 1) {
                status = true;
            } else {
                status = false;
            }
        }
        return status;
    }


    public boolean deleteAdmin(Integer id, Integer adminId) {
        boolean status = false;//存储修改结果
        if (id != null && adminId != null) {
            if (adminId != id.intValue()) {//如果不是自己删除自己
                int n = adminDao.deleteAdmin(id);
                if (n == 1) {
                    status = true;
                }
            }
        }
        return status;
    }

    public boolean existsAdmin(String username, Integer id) {
        if (adminDao.existsAdmin(username, id) == 0) {
            return false;
        } else {
            return true;
        }
    }


    public boolean saveAdmin(Admin admin) {
        boolean stsatus = false;
        admin.setPassword(SHA.getResult("123456"));
        admin.setCreateTime(new Date());//系统当前时间为创建日期
        if (adminDao.saveAdmin(admin) == 1) {
            stsatus = true;
        } else {
            stsatus = false;
        }
        return stsatus;
    }

    public boolean existsUsername(String username) {
        if (adminDao.existsUsername(username) == 0) {
            return false;
        } else {
            return true;
        }
    }

    public Admin getAdmin(Integer id) {
        Admin admin = null;
        if (id != null) {
            admin = adminDao.getAdmin(id);
        }
        return admin;
    }
    public List<Admin> getAdminList() {
        return adminDao.getAdminList();
    }

@Override
    public List<Admin> getPartlist(Integer page) {
        int pagesize = 10;//每页显示10条记录
        if (page==null){//如果page为null，默认为第一页
            page=1;
        }else {
            if (page<1){
                page=1;
            }
        }
        int offset = (page - 1) * pagesize + 1;//每页开始的记录数位置（仅在业务层使用，不考虑数据库）

        return adminDao.getPartlist(offset - 1, pagesize);//数据库记录位置从0数起）
    }
    @Override
    public int maxPage(){
        int maxPage=0;
        int pagesize=10;
        int total=adminDao.getAdminList().size();
        if (total%pagesize==0){
            maxPage=total/pagesize;
        }else {
            maxPage=total/pagesize+1;
        }
        return  maxPage;
    }
}
