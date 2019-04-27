package com.lcvc.ebuy_maven_ssm.web.backstage.adminmanage;

import com.lcvc.ebuy_maven_ssm.model.Admin;
import com.lcvc.ebuy_maven_ssm.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class AdminManageController {
	@Resource
	private AdminService adminService;

	//跳转到管理员管理页面
	@RequestMapping(value = "/backstage/adminmanage/toManageAdmin", method = RequestMethod.GET)
	public String toManageAdmin(HttpServletRequest request){
		request.setAttribute("list",adminService.getAdminList());
		return "/jsp/backstage/adminmanage/adminmanage.jsp";
	}

	//执行删除管理员操作
	@RequestMapping(value = "/backstage/adminmanage/doDeleteAdmin", method = RequestMethod.GET)
	public String doDeleteAdmin(HttpServletRequest request,HttpSession session,Integer id){
		Admin admin=(Admin)session.getAttribute("admin");
		adminService.deleteAdmin(id,admin.getId());
		request.setAttribute("list",adminService.getAdminList());
		return "/jsp/backstage/adminmanage/adminmanage.jsp";
	}

	//跳转到管理员添加页面
	@RequestMapping(value = "/backstage/adminmanage/toAddAdmin", method = RequestMethod.GET)
	public String toAddAdmin(HttpServletRequest request){
		return "/jsp/backstage/adminmanage/adminadd.jsp";
	}

	//执行管理员添加页面

	@RequestMapping(value = "/backstage/admin/doSaveAdmin", method = RequestMethod.POST)
	public String doSaveAdmin(Integer id,String username,String name,String password,HttpSession session,HttpServletRequest request){
		Admin admin=(Admin)session.getAttribute("admin");
		if (username.equals("")){
			request.setAttribute("myMessage","添加管理员失败：账户名不能为空！");
		}else if (password.equals("")){
			request.setAttribute("myMessage","添加管理员失败：密码不能为空！");
		} else if (name.equals("")){
			request.setAttribute("myMessage","添加管理员失败：姓名不能为空！");
		}else if (adminService.existsAdmin(username,admin.getId())==true){
			request.setAttribute("myMessage","添加管理员失败：账户名重名！");
		}
		else {
		//	if(adminService.saveAdmin(admin)){
			//	admin.setId(id);
				admin.setUsername(username);
				admin.setPassword(password);
				admin.setName(name);
				admin.setCreateTime(new Date());
				adminService.saveAdmin(admin);
				request.setAttribute("myMessage","管理员添加成功！");
			//}

		}
		return "/jsp/backstage/adminmanage/adminadd.jsp";
	}

}
