package com.red.dao;

import java.util.List;

import com.red.beans.Finance;
import com.red.dao.base.RedCoreDao;
import com.red.page.PageDiv;

public interface FinanceDao extends RedCoreDao<Finance>{
	/**
	 * ָ����Աid����������صĲ�����ϸ
	 * @param memberId  ��Աid
	 * @param offSet
	 * @param pageSize
	 * @return
	 */
	   public PageDiv<Finance> getFinanceByMember(Integer memberId,int offSet,int pageSize);
	   /**
	    * ָ���û�id�������в�����ϸ
	    * @param memberId ��ԱId
	    * @param offSet
	    * @param pageSize
	    * @param payType   0����1����2��ֵ3���4����5�������
	    * @return
	    */
	   public PageDiv<Finance> getFinanceByMember(Integer memberId,int offSet,int pageSize,byte payType);
	   /**
	    * ����Ա�鿴���в�����ϸ
	    * @param offSet
	    * @param pageSize
	    * @param payType   0����1����2��ֵ3���4����5�������
	    * @return  
	    */
	   public PageDiv<Finance> getAllFinance(int offSet,int pageSize,byte payType);
	   /**
	    * ���ݶ����Ų�����
	    * @param orderNo
	    * @return
	    */
	   
	   public Finance getFinanceByOrderNo(String orderNo);
	   /**
	    * ��������б�
	    * @return
	    */
	   public List<Finance> getAskDuixian();
	   
}
