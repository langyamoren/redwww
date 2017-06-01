package com.red.dao;

import java.util.List;

import com.red.beans.Member;
import com.red.dao.base.RedCoreDao;
import com.red.page.PageDiv;

public interface MemberDao extends RedCoreDao<Member>{
		/**
		 * ����û����Ƿ��Ѿ����ڣ���ע���û�ʱ�õ�
		 * @param email  
		 * @return  true����false ������
		 */
	   public boolean checkMemberExist(String email);
	   /**
	    * ��֤�û���½������ɹ��򷵻��û����󣬷���action��session��
	    * @param email
	    * @param pwd
	    * @return
	    */
	   public Member checkMember(String email,String pwd);
	   /**
	    * ��ȡ�����û�
	    * @param offSet
	    * @param pageSize
	    * @return
	    */
	   public PageDiv<Member> getAllMember(int offSet,int pageSize);
	   /**
	    * ����ָ���û����Ƽ������л�Ա
	    * @param whoId  ��Աid(�ƹ����)
	    * @param offSet
	    * @param pageSize
	    * @return
	    */
	   public PageDiv<Member> getRecomeMembers(Integer whoId,int offSet,int pageSize);
	   /**
	    * ��ȡ����ע����û�
	    * @param count
	    * @return
	    */
	   public List<Member> getNewComer(int count);
	   /**
	    * ͨ���û���������û�
	    * @param levelId  ����Id
	    * @param offSet
	    * @param pageSize
	    * @return
	    */
	   public PageDiv<Member> getMemberByLevel(Integer levelId,int offSet,int pageSize);
	   /**
	    * ���û�����ָ��Ҫ��ʾ���û���
	    * @param levelId
	    * @param count
	    * @return
	    */
	   public List<Member> getMemberByLevel(Integer levelId,int count);
	   /**
	    * ͨ���û��Ƽ��룬�����û�
	    * @param recomeCode  �Ƽ���
	    * @return
	    */
	//   public Member getIdByRecomeCode(String recomeCode);
	   /**
	    * ����һ���û�
	    * @param member
	    * @return
	    */
	   public boolean addMemeber(Member member);
	   /**
	    * ͨ��email�����û�
	    * @param email
	    * @param offSet
	    * @param pageSize
	    * @return
	    */
	   public PageDiv<Member> searchMemberByEmail(String email,int offSet,int pageSize);
	   /**
	    * �����û�Ϊ�һ�����
	    * @param email
	    * @param name
	    * @param qq
	    * @param cell
	    * @return
	    */
	   public Member getMemberByforgotPassword(String email,String name,String qq,String cell);
       
	   /**
	    * �������û�����������
	    * @param offSet
	    * @param pageSize
	    * @return
	    */
	   public PageDiv<Member> getLastRequestPwd(int offSet,int pageSize);
}
