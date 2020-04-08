package com.briup.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.briup.bean.Customer;

/** 
* @author 作者 jtw: 
* @version 创建时间：2020年4月4日 下午6:35:28 
* 类说明 :
*       与客户相关的dao 
*/
public interface CustomerDao  extends JpaRepository<Customer, Integer>{
	
	//客户管理相关
	
	//数据分析相关内容
	List<Customer> findByRegion(String region);
	List<Customer> findByLevel(String level);
}
