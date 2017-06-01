package com.red.dao;

import java.util.List;

import com.red.beans.Member;
import com.red.dao.base.RedCoreDao;
import com.red.page.PageDiv;

public interface MemberDao extends RedCoreDao<Member>{
		/**
		 * 查检用户名是否已经存在，在注册用户时用到
		 * @param email  
		 * @return  true存在false 不存在
		 */
	   public boolean checkMemberExist(String email);
	   /**
	    * 验证用户登陆，如果成果则返回用户对象，放入action的session中
	    * @param email
	    * @param pwd
	    * @return
	    */
	   public Member checkMember(String email,String pwd);
	   /**
	    * 获取所有用户
	    * @param offSet
	    * @param pageSize
	    * @return
	    */
	   public PageDiv<Member> getAllMember(int offSet,int pageSize);
	   /**
	    * 查找指定用户所推荐的所有会员
	    * @param whoId  会员id(推广荐者)
	    * @param offSet
	    * @param pageSize
	    * @return
	    */
	   public PageDiv<Member> getRecomeMembers(Integer whoId,int offSet,int pageSize);
	   /**
	    * 获取最新注册的用户
	    * @param count
	    * @return
	    */
	   public List<Member> getNewComer(int count);
	   /**
	    * 通过用户级别查找用户
	    * @param levelId  级别Id
	    * @param offSet
	    * @param pageSize
	    * @return
	    */
	   public PageDiv<Member> getMemberByLevel(Integer levelId,int offSet,int pageSize);
	   /**
	    * 找用户级别，指定要显示的用户数
	    * @param levelId
	    * @param count
	    * @return
	    */
	   public List<Member> getMemberByLevel(Integer levelId,int count);
	   /**
	    * 通过用户推荐码，查找用户
	    * @param recomeCode  推荐码
	    * @return
	    */
	//   public Member getIdByRecomeCode(String recomeCode);
	   /**
	    * 增加一个用户
	    * @param member
	    * @return
	    */
	   public boolean addMemeber(Member member);
	   /**
	    * 通过email搜索用户
	    * @param email
	    * @param offSet
	    * @param pageSize
	    * @return
	    */
	   public PageDiv<Member> searchMemberByEmail(String email,int offSet,int pageSize);
	   /**
	    * 查找用户为找回密码
	    * @param email
	    * @param name
	    * @param qq
	    * @param cell
	    * @return
	    */
	   public Member getMemberByforgotPassword(String email,String name,String qq,String cell);
       
	   /**
	    * 获得最后用户的请求算密
	    * @param offSet
	    * @param pageSize
	    * @return
	    */
	   public PageDiv<Member> getLastRequestPwd(int offSet,int pageSize);
}
