package com.red.dao.imp;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.red.beans.Finance;
import com.red.dao.FinanceDao;
import com.red.page.PageDiv;

public class TestFinanceDaoImp 
{
   @Test
   public void testGetFinanceByMember()
   {
	   ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	  FinanceDao fd=(FinanceDao) ac.getBean("financeDao");
	  PageDiv<Finance> pd=fd.getFinanceByMember(2, 0, 10);
	  List<Finance> list=pd.getList();
	  for(Finance tem:list)
	  {
		  System.out.println(tem.getId()+"\t"+tem.getDescs()+"\t"+tem.getDates());
	  }
	  System.out.println(pd.getOffSet()+"\t"+pd.getTotalCount()+"\t"+pd.getPageSize());
   }
   @Test
   public void testGetFinanceByMember2()
   {
		  ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		  FinanceDao fd=(FinanceDao) ac.getBean("financeDao");
		  PageDiv<Finance> pd=fd.getFinanceByMember(2, 0, 10,(byte)3);
		  List<Finance> list=pd.getList();
		  for(Finance tem:list)
		  {
			  System.out.println(tem.getId()+"\t"+tem.getDescs()+"\t"+tem.getDates());
		  }
		  System.out.println(pd.getOffSet()+"\t"+pd.getTotalCount()+"\t"+pd.getPageSize());
   }
   
   @Test
   public void testGetAllFinance()
   {
		  ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		  FinanceDao fd=(FinanceDao) ac.getBean("financeDao");
		  PageDiv<Finance> pd=fd.getAllFinance(0, 10, (byte)2);
		  List<Finance> list=pd.getList();
		  for(Finance tem:list)
		  {
			  System.out.println(tem.getId()+"\t"+tem.getDescs()+"\t"+tem.getDates());
		  }
		  System.out.println(pd.getOffSet()+"\t"+pd.getTotalCount()+"\t"+pd.getPageSize());
   }
   @Test
   public void testGetFinanceByOrderNo()
   {
	     ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		  FinanceDao fd=(FinanceDao) ac.getBean("financeDao"); 
		  Finance fin=fd.getFinanceByOrderNo("redwww12234328432sdfdsf");
		  System.out.println(fin);
		  //System.out.println(fin.getId()+"\t"+fin.getDescs()+"\t"+fin.getDates());
		  
		  
   }
}
