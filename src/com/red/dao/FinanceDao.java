package com.red.dao;

import java.util.List;

import com.red.beans.Finance;
import com.red.dao.base.RedCoreDao;
import com.red.page.PageDiv;

public interface FinanceDao extends RedCoreDao<Finance>{
	/**
	 * 指定会员id查找所有相关的财务明细
	 * @param memberId  会员id
	 * @param offSet
	 * @param pageSize
	 * @return
	 */
	   public PageDiv<Finance> getFinanceByMember(Integer memberId,int offSet,int pageSize);
	   /**
	    * 指定用户id查找所有财务明细
	    * @param memberId 会员Id
	    * @param offSet
	    * @param pageSize
	    * @param payType   0购买1兑现2充值3提成4收入5申请兑现
	    * @return
	    */
	   public PageDiv<Finance> getFinanceByMember(Integer memberId,int offSet,int pageSize,byte payType);
	   /**
	    * 管理员查看所有财务明细
	    * @param offSet
	    * @param pageSize
	    * @param payType   0购买1兑现2充值3提成4收入5申请兑现
	    * @return  
	    */
	   public PageDiv<Finance> getAllFinance(int offSet,int pageSize,byte payType);
	   /**
	    * 根据订单号查财务表
	    * @param orderNo
	    * @return
	    */
	   
	   public Finance getFinanceByOrderNo(String orderNo);
	   /**
	    * 申请兑现列表
	    * @return
	    */
	   public List<Finance> getAskDuixian();
	   
}
