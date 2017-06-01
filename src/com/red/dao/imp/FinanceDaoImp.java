package com.red.dao.imp;

import java.util.List;

import com.red.beans.Finance;
import com.red.dao.FinanceDao;
import com.red.dao.base.RedCoreImp;
import com.red.page.PageDiv;
/**
 * 财务相关方法实现
 * @author 孟庆坤
 */
public class FinanceDaoImp extends RedCoreImp<Finance> implements
		FinanceDao
{

	@Override
	public PageDiv<Finance> getFinanceByMember(Integer memberId, int offSet, int pageSize) {
		PageDiv<Finance> re=this.getAll("from Finance as f where f.member.id=? order by f.id desc", offSet, pageSize, new Object[]{memberId});		
		return re;		
	}

	@Override
	public PageDiv<Finance> getFinanceByMember(Integer memberId, int offSet,
			int pageSize, byte payType) {
		PageDiv<Finance> re=this.getAll("from Finance as f where f.member.id=? and f.payType=?", offSet, pageSize, new Object[]{memberId,payType});		
		return re;
	}

	@Override
	public PageDiv<Finance> getAllFinance(int offSet, int pageSize, byte payType) {
		PageDiv<Finance> re=this.getAll("from Finance as f where f.payType=?", offSet, pageSize,new Object[]{payType});		
		return re;
	}

	@Override
	public Finance getFinanceByOrderNo(String orderNo) {
		// TODO Auto-generated method stub
		return this.getUnique("from Finance as f where f.orderAccount=?", new Object[]{orderNo.trim()});
	}

	@Override
	public List<Finance> getAskDuixian() {
		// TODO Auto-generated method stub
		return this.getAll("from Finance as f where f.payType=5 order by id desc");
	}


}
