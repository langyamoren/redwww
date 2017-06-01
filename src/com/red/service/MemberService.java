package com.red.service;

import java.util.List;
import com.red.beans.Finance;
import com.red.beans.Member;
import com.red.beans.Memberlevel;
import com.red.page.PageDiv;


public interface MemberService // extends ServiceBase
{
	/**
	 * 用户注册（增加一个用户）
	 * @param member
	 * @return
	 */
	public boolean registMemeber(Member member);

	
	/**
	 * 通过推荐人id加载推荐人
	 * @param recomId
	 * @return
	 */
    public Member getMemberByRecome(Integer recomId);
		/**
		 * 查检用户名是否已经存在，在注册用户时用到
		 * @param email  
		 * @return  true存在false 不存在
		 */
	   public boolean checkExist(String email);
	   /**
	    * 验证用户登陆，如果成果则返回用户对象，放入action的session中
	    * @param email
	    * @param pwd
	    * @return
	    */
	   public Member loginMember(String email,String pwd);
		/**
		 * 查询自已推荐的所有好友
		 * @param ownId
		 * @return
		 */
	   public PageDiv<Member> getRecommendMember(int  ownId,int offSet,int pageSize);
	   /**
	    * 查询指字用户的财务列表
	    * @param ownId
	    * @param offSet
	    * @param PageSize
	    * @return
	    */
	   public PageDiv<Finance> getMemberFiance(int ownId,int offSet,int PageSize);

	   /**
	    * 通过email查找用户
	    * @param email
	    * @param offSet
	    * @param pageSize
	    * @return
	    */
	   public PageDiv<Member> getSearchMember(String email,int offSet,int pageSize);
	   /**
	    * 查找所有用户
	    * @param offSet
	    * @param pageSize
	    * @return
	    */
	   public PageDiv<Member> getAllMember(int offSet,int pageSize);
	   /**
	    * 通过用户id查找用户
	    * @param id  用户id
	    * @return
	    */
	   public Member getMemberById(Integer id);
	   /**
	    * 查找所有用户级别
	    * @return
	    */
	   public List<Memberlevel> getAllMemberlevel();
	   /**
	    * 修改用户信息
	    * @param member
	    * @return
	    */
	   public boolean updateMember(Member member);
	   /**
	    * 找用户，为用户重设密码
	    * @param email
	    * @param name
	    * @param qq
	    * @param cell
	    * @return
	    */
	   public Member getMemberForResetPassword(String email,String name,String qq,String cell);
	   /**
	    * 获得最后用户的请求算密
	    * @param offSet
	    * @param pageSize
	    * @return
	    */
	   public PageDiv<Member> getLastRequestPwd(int offSet,int pageSize);
}
