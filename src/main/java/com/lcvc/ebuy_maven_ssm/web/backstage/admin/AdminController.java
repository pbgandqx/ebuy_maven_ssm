package com.lcvc.ebuy_maven_ssm.web.backstage.admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.lcvc.ebuy_maven_ssm.model.Admin;
import com.lcvc.ebuy_maven_ssm.model.exception.MyWebException;
import com.lcvc.ebuy_maven_ssm.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
	@Resource
	private AdminService adminService;

	@RequestMapping(value = "/backstage/admin/toUpdatePassword", method = RequestMethod.GET)
	public String toUpdatePassword(){
		return "/jsp/backstage/admin/passwordupdate.jsp";
	}
	
	@RequestMapping(value = "/backstage/admin/doUpdatePassword", method = RequestMethod.POST)
	public String doUpdatePassword(String oldPass,String newPass,String confirmPass,HttpSession session
			,HttpServletRequest request){
		Admin admin=(Admin)session.getAttribute("admin");
		if(adminService.login(admin.getUsername(), oldPass)!=null){//如果原密码正确
			if (newPass.equals("")){
				request.setAttribute("myMessage", "密码修改失败：新密码不能为空！");
			} else if(newPass.equals(confirmPass)){//如果新密码和确认密码相同
				//保存新密码
				adminService.updatePassword(newPass, admin.getId());
				request.setAttribute("myMessage", "密码修改成功！");
			}else{//如果不相同
				request.setAttribute("myMessage", "密码修改失败：新密码和确认密码不一致");
			}
		}else{//如果原密码错误
			request.setAttribute("myMessage", "密码修改失败：原密码不正确");
		}		
		return "/jsp/backstage/admin/passwordupdate.jsp";
	}

	//跳转到修改信息页面
	@RequestMapping(value = "/backstage/admin/toUpdateAdmin", method = RequestMethod.GET)
	public String toUpdateAdmin(){
		return "/jsp/backstage/admin/adminupdate.jsp";
	}

	//执行修改管理账户的基本信息
	@RequestMapping(value = "/backstage/admin/doUpdateAdmin", method = RequestMethod.POST)
	public String doUpdateAdmin(Admin admin,HttpSession session,HttpServletRequest request){
		Admin adminsession=(Admin)session.getAttribute("admin");
		if (admin.getUsername().equals("")){
			request.setAttribute("myMessage","账户名不能为空！");
		}else if (admin.getName().equals("")){
			request.setAttribute("myMessage","姓名不能为空！");
		}else if (adminService.existsAdmin(admin.getUsername(),adminsession.getId())==true){
			request.setAttribute("myMessage","账户名重名！");
		}
		else {
			admin.setId(adminsession.getId());
				if(adminService.updateAdmin(admin)){
					adminsession.setUsername(admin.getUsername());
					adminsession.setName(admin.getName());
					request.setAttribute("myMessage","基本信息修改成功！");
				}

			/*catch (MyWebException e){
				request.setAttribute("myMessage",e.getMessage());
			}*/
		}
		return "/jsp/backstage/admin/adminupdate.jsp";
	}
}
