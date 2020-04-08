package com.briup.service;

import java.util.List;

import com.briup.bean.CustomerConstitute;

/** 
* @author 作者 jtw: 
* @version 创建时间：2020年4月4日 下午6:34:02 
* 类说明 :
*        
*/
public interface ICustomerConstituteService {
	/**
	 * 地区分类
	 * @return
	 */
	List<CustomerConstitute> regionAnalyze();
	
	/**
	 * 等级分类
	 * @return
	 */
	List<CustomerConstitute> levelAnalyze();
}
