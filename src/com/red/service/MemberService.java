package com.red.service;

import java.util.List;
import com.red.beans.Finance;
import com.red.beans.Member;
import com.red.beans.Memberlevel;
import com.red.page.PageDiv;


public interface MemberService // extends ServiceBase
{
	/**
	 * �û�ע�ᣨ����һ���û���
	 * @param member
	 * @return
	 */
	public boolean registMemeber(Member member);

	
	/**
	 * ͨ���Ƽ���id�����Ƽ���
	 * @param recomId
	 * @return
	 */
    public Member getMemberByRecome(Integer recomId);
		/**
		 * ����û����Ƿ��Ѿ����ڣ���ע���û�ʱ�õ�
		 * @param email  
		 * @return  true����false ������
		 */
	   public boolean checkExist(String email);
	   /**
	    * ��֤�û���½������ɹ��򷵻��û����󣬷���action��session��
	    * @param email
	    * @param pwd
	    * @return
	    */
	   public Member loginMember(String email,String pwd);
		/**
		 * ��ѯ�����Ƽ������к���
		 * @param ownId
		 * @return
		 */
	   public PageDiv<Member> getRecommendMember(int  ownId,int offSet,int pageSize);
	   /**
	    * ��ѯָ���û��Ĳ����б�
	    * @param ownId
	    * @param offSet
	    * @param PageSize
	    * @return
	    */
	   public PageDiv<Finance> getMemberFiance(int ownId,int offSet,int PageSize);

	   /**
	    * ͨ��email�����û�
	    * @param email
	    * @param offSet
	    * @param pageSize
	    * @return
	    */
	   public PageDiv<Member> getSearchMember(String email,int offSet,int pageSize);
	   /**
	    * ���������û�
	    * @param offSet
	    * @param pageSize
	    * @return
	    */
	   public PageDiv<Member> getAllMember(int offSet,int pageSize);
	   /**
	    * ͨ���û�id�����û�
	    * @param id  �û�id
	    * @return
	    */
	   public Member getMemberById(Integer id);
	   /**
	    * ���������û�����
	    * @return
	    */
	   public List<Memberlevel> getAllMemberlevel();
	   /**
	    * �޸��û���Ϣ
	    * @param member
	    * @return
	    */
	   public boolean updateMember(Member member);
	   /**
	    * ���û���Ϊ�û���������
	    * @param email
	    * @param name
	    * @param qq
	    * @param cell
	    * @return
	    */
	   public Member getMemberForResetPassword(String email,String name,String qq,String cell);
	   /**
	    * �������û�����������
	    * @param offSet
	    * @param pageSize
	    * @return
	    */
	   public PageDiv<Member> getLastRequestPwd(int offSet,int pageSize);
}
