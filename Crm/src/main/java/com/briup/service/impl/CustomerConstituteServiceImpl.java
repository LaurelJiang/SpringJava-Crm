package com.briup.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.CustomerConstitute;
import com.briup.dao.CustomerDao;
import com.briup.service.ICustomerConstituteService;

/** 
* @author 作者 jtw: 
* @version 创建时间：2020年4月4日 下午6:34:29 
* 类说明 :
*       额外的工具类，给绘图提供数据 
*/
@Service
public class CustomerConstituteServiceImpl implements ICustomerConstituteService{
	
	@Autowired
	private CustomerDao dao;
	
	@Override
	public List<CustomerConstitute> regionAnalyze() {
		ArrayList<CustomerConstitute> list = new ArrayList<>();
		//从数据库将所有客户信息查找出来 需要获取总数
		float nums = dao.findAll().size();
		String[] regions= {"华中","华南","华东","华北"};
		//然后更具地区进行帅选  然后封装成list对象
		for (String region  : regions) {
			int num = dao.findByRegion(region).size();
			float y=num/nums*100;
			CustomerConstitute cc = new CustomerConstitute(region, y, region);
			list.add(cc);
		}
		System.out.println(list);
		return list;
	}
 
	@Override
	public List<CustomerConstitute> levelAnalyze() {
		List<CustomerConstitute> list = new ArrayList<>();
		//从数据库中获取所有客户的信息  
		float nums = dao.findAll().size();
		String[]  levels= {"普通客户","大客户","合作伙伴","重点开发客户"};
		//根据客户的等级，进行帅选，封装成list对象
		for (String level : levels) {
			int num = dao.findByLevel(level).size();
			float y=num/nums*100;
			CustomerConstitute cc = new CustomerConstitute(level, y, level);
			list.add(cc);
		}
		System.out.println(list);
		return  list;
	}

}
