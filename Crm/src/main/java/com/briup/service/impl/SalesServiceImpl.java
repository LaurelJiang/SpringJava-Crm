package com.briup.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.briup.bean.Chance;
import com.briup.bean.User;
import com.briup.dao.SalesDao;
import com.briup.dao.UserDao;
import com.briup.service.ISalesService;

/** 
* @author 作者 jtw: 
* @version 创建时间：2020年4月3日 下午4:10:51 
* 类说明 :
*        
*/
@Service
public class SalesServiceImpl implements ISalesService{
	@Autowired
	private SalesDao dao;
	@Autowired 
	private  UserDao userDao;
	
	@Override
	public void insertChance(Chance chance, Integer creatorId, Integer handlerId) {
		User creatorUser = userDao.findById(creatorId).get();
		User handlerUser = userDao.findById(handlerId).orElse(null);
		
		chance.setCreator(creatorUser);
		chance.setHandler(handlerUser);
		dao.save(chance);
	}

	@Override
	public Page<Chance> getChances(String customer, String address) {
		return getChances(0, customer, address);
	}
	
	//通过客户的名字和区域查询用户信息
	@Override
	public Page<Chance> getChances(Integer pageIndex, String customer, String address) {
		PageRequest pageable = PageRequest.of(pageIndex, 3);
		if((customer!=null && customer.trim()!="") && (address!=null && address.trim()!="")) {
			//根据客户名字以及区域进行查询
			return dao.findByCustomerAndAddress(customer, address, pageable);
			
		}else if(customer!=null && customer.trim()!="") {
			//根据客户名字查询
			return dao.findByCustomerLike(customer, pageable);
		}else if(address!=null && address.trim()!="") {
			//根据区域查询
			return dao.findByAddress(address, pageable);
		}else {
			//无条件查询，将所有信息查询出来
			return dao.findAll(pageable);
		}
	}

	@Override
	public void deleteChance(Integer id) {
		
	}

	@Override
	public Chance findChanceById(Integer id) {
		return null;
	}

}
