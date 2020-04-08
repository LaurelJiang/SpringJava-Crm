package com.briup.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.bean.Chance;
import com.briup.bean.User;
import com.briup.service.ISalesService;
import com.briup.service.IUserService;

/** 
* @author 作者 jtw: 
* @version 创建时间：2020年4月3日 下午2:49:24 
* 类说明 :
*        
*/
@Controller
public class SalesController {
	@Autowired
	private  ISalesService service;
	@Autowired
	private  IUserService userService;
	
	
	@RequestMapping("toSales")
	public String  findSales(HttpSession session ,String customer,String  address,Integer id) {
		
		List<User> jinglis = userService.findByJingli(4);
		session.setAttribute("jinglis", jinglis);
		
		Chance chances = service.findChanceById(id);
		session.setAttribute("chances", chances);
		
		return  "pages/sales";
		
	}
	
	
	@RequestMapping("addSales")
	@ResponseBody
	public String addSales(Chance chance,Integer creatorId,Integer handlerId) {
		service.insertChance(chance, creatorId, handlerId);
		return  "添加成功";
	}
	
/*	@RequestMapping("toSales")
	@ResponseBody
	public String toSales(HttpSession session,Integer id) {
		Chance chances = service.findChanceById(id);
		session.setAttribute("chances", chances);
		
		return "pages/sales";
	}*/
}
