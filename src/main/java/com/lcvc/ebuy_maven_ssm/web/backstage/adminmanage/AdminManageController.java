package com.lcvc.ebuy_maven_ssm.web.backstage.adminmanage;

import com.lcvc.ebuy_maven_ssm.model.Admin;
import com.lcvc.ebuy_maven_ssm.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String toManageAdmin(Model model,Integer page){
		if (page==null){
			page=1;
		}else {
			if (page<1){
				page=1;
			}
		}
		model.addAttribute("list",adminService.getPartlist(page));
		model.addAttribute("page",page);
		model.addAttribute("maxPage",adminService.maxPage());
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
	@RequestMapping(value = "/backstage/adminmanage/toSaveAdmin", method = RequestMethod.GET)
	public String toSaveAdmin(HttpServletRequest request){
		return "/jsp/backstage/adminmanage/adminadd.jsp";
	}

	//执行管理员添加页面

	@RequestMapping(value = "/backstage/adminmanage/doSaveAdmin", method = RequestMethod.POST)
	public String doSaveAdmin(HttpServletRequest request,Admin admin){
		admin.setUsername(admin.getUsername().trim());
		admin.setName(admin.getName().trim());
		if(admin.getUsername().length()==0){
			request.setAttribute("myMessage","账户创建失败:账户名不能为空");
		}else if(admin.getName().length()==0){
			request.setAttribute("myMessage","账户创建失败:网名不能为空");
		}else if(adminService.existsUsername(admin.getUsername())){
			request.setAttribute("myMessage","账户创建失败:账户名已存在，请选择其他的账户名");
		}else if(adminService.existsUsername(admin.getUsername())){
			request.setAttribute("myMessage","账户创建失败:账户名已存在，请选择其他的账户名");
		}else{
			if(adminService.saveAdmin(admin)){
				request.setAttribute("myMessage","账户创建成功");
			}else{
				request.setAttribute("myMessage","账户创建失败");
			}
		}
		return "/jsp/backstage/adminmanage/adminadd.jsp";
	}
//跳转到管理员编辑页面
             @RequestMapping(value = "/backstage/adminmanage/toUpdateAdmin", method = RequestMethod.GET)
            public String toUpdateAdmin(HttpServletRequest request,Integer id){
		request.setAttribute("admin",adminService.getAdmin(id));
	            return "/jsp/backstage/adminmanage/adminupdate.jsp";
}

    //执行管理员编辑操作
	@RequestMapping(value = "/backstage/adminmanage/doUpdateAdmin", method = RequestMethod.POST)
	public String doUpdateAdmin(HttpSession session,HttpServletRequest request,Admin admin){
		admin.setUsername(admin.getUsername().trim());
		admin.setName(admin.getName().trim());
		if (admin.getUsername().equals("")){
			request.setAttribute("myMessage","编辑失败：账户名不能为空！");
		}else if (admin.getName().equals("")){
			request.setAttribute("myMessage","编辑失败：网名不能为空！");
		}else if (adminService.existsAdmin(admin.getUsername(),admin.getId())==true){
			request.setAttribute("myMessage","编辑失败：账户名重名！");
		}
		else {
			if (adminService.updateAdmin(admin)){
				request.setAttribute("myMessage","基本信息编辑成功！");
		}else {
				request.setAttribute("myMessage","基本信息编辑失败！");
			}

		}

		return "/jsp/backstage/adminmanage/adminupdate.jsp";
	}

}
