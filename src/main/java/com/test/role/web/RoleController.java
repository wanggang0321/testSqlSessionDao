package com.test.role.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.common.page.PageInfo;
import com.test.common.utils.StringUtils;
import com.test.role.entity.Role;
import com.test.role.service.RoleService;

@Controller
@RequestMapping(value = "aspen/Role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value = "/system_User_Role_Browse_ListDiv")
	public String system_User_Role_Browse_ListDiv(HttpServletRequest request, HttpServletResponse response, Model model,
							 String pn,String page_receive){
		if(pn==null||pn.equals(""))
		{
			pn="1";
		}
		Integer pagenum = 1;
		Map map = new HashMap();
		
		if(StringUtils.isNotBlank(pn)){
			pagenum = Integer.parseInt(pn);
		}
		int count = roleService.SelectRoleALL_Count(map);
		
//		PageInfo paging = new PageInfo(pagenum, count, 3);
		PageInfo paging = new PageInfo(pagenum, count);
		model.addAttribute("paging", paging);	//保存分页信息
		
		
		int start = (pagenum-1) * paging.getPageSize();
		int rows = paging.getPageSize();
		map.put("start", start);
		map.put("rows", rows);
		List<Role> rolelist =  roleService.SelectRoleALL(map);
		model.addAttribute("rolelist",rolelist);
		model.addAttribute("count",count);
		model.addAttribute("page_receive",page_receive);
		
		return "modules/system/role/system_User_Role_Browse_ListDiv";
		
	}

}
