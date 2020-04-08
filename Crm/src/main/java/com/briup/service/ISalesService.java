package com.briup.service;

import org.springframework.data.domain.Page;

import com.briup.bean.Chance;

/** 
* @author 作者 jtw: 
* @version 创建时间：2020年4月3日 下午4:09:54 
* 类说明 :
*        
*/
public interface ISalesService {
	/**
	 * 新增销售商机
	 * @param chance
	 * @param creatorId
	 * @param handlerId
	 */
	void insertChance(Chance chance,Integer creatorId,Integer handlerId);
	
	
	/**
	 * 如果商机开发成功
	 * @param customer
	 * @param address
	 * @return
	 
	void insertChance(Chance chance);
	 查询显示*/
	Page<Chance> getChances(String customer,String  address);
	Page<Chance> getChances(Integer pageIndex,String customer,String address);
	
	/**
	 * 删除功能
	 * @param id
	 */
	void deleteChance(Integer id);
	
	/**
	 * 根据id查询指定的销售商机
	 * @param id
	 * @return
	 */
	Chance  findChanceById(Integer id);
}
