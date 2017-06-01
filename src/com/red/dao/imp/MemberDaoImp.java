package com.red.dao.imp;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import com.red.beans.Member;
import com.red.dao.MemberDao;
import com.red.dao.base.RedCoreImp;
import com.red.page.PageDiv;
import com.red.util.MD5;
public class MemberDaoImp extends RedCoreImp<Member> implements MemberDao
{
	@Override
	public PageDiv<Member> getAllMember(final int offSet, final int pageSize)
	{
			return this.getAll("from Member as m order by m.id desc", offSet, pageSize);
	}

	@Override
	public PageDiv<Member> getMemberByLevel(final Integer levelId, final int offSet, final int pageSize) 
	{
		return this.getAll("from Member as m where m.memberlevel.id=? order by m.id desc", offSet, pageSize,new Object[]{ levelId});
	}

	@Override
	public List<Member> getMemberByLevel(final Integer levelId, final int count)
	{
      //return this.getAll("from Member as m where m.memberlevel.id=?", count, levelId);
      return this.getAll("from Member as m where m.memberlevel.id=? order by m.id desc", count, new Object[]{levelId});
	}

	@Override
	public List<Member> getNewComer(final int count)
	{//根据注册时的用户Id，取id值最大的count个数据，即作为新会员的标识
		return this.getAll("from Member as m order by m.id desc", count);
	}

	@Override
	public PageDiv<Member> getRecomeMembers(final Integer whoId, final int offSet, final int pageSize)
	{
		return this.getAll("from Member as m where m.member.id=? order by m.id desc", offSet, pageSize, new Object[]{whoId});
	}

	@Override
	public boolean checkMemberExist(String email) 
	{
		boolean re=false;
		if(null!=this.getUnique("from Member as m where m.email=?", new Object[]{email.trim()}))
		{
			re=true;
		}
		return re;
	}

	@Override
	public Member checkMember(String email, String pwd)
	{
		boolean re=false;
		pwd=MD5.EncoderByMd5(pwd);
		boolean r1=this.checkMemberExist(email);
		Member m=this.getUnique("from Member as m where m.email=? and m.password=? and m.islock=?",new Object[]{ email,pwd,(byte)0});
	    if(r1&&(null!=m)) re=true;
	    if(re)
		return m;
	    else
	    return null;
	}

	/*@Override
	public Member getIdByRecomeCode(String recomeCode) {
		Member member=null;
	    List<Member> list=this.getAll("from Member as m where m.recommendCode=?", new Object[]{recomeCode});
	    if(null!=list&&list.size()>0&&list.size()==1)
	    {
	    	member=list.get(0);
	    }
		return member;
	}*/

	@Override
	public boolean addMemeber(final Member member) {
	   boolean rel=false;
	   if(null!=member)
	   {
		 rel=  this.getHibernateTemplate().execute(new HibernateCallback<Boolean>(){

			@Override
			public Boolean doInHibernate(Session session)
					throws HibernateException, SQLException {
				boolean re=false;
			  
			    try {
				     session.save(member);
				     session.flush();
				    // member.setRecommendCode(RandCode.parseToString(member.getId()));
                     session.update(member);
                  
                   re=true;
				} catch (Exception e) {
					
				}
			   
				return re;
			}
			   
		   });
		   
	   }
		return rel;
	}

	@Override
	public PageDiv<Member> searchMemberByEmail(String email,int offSet,int pageSize)
	{
		return this.getAll("from Member as m where m.email like '%"+email+"%'" , offSet, pageSize);
	}

	@Override
	public Member getMemberByforgotPassword(String email, String name,
			String qq, String cell) {
		
		return this.getUnique("from Member as m where m.email=? and m.name=? and m.cellphone=? and m.qq=?",
				new Object[]{email,name,cell,qq});
	}

	@Override
	public PageDiv<Member> getLastRequestPwd(int offSet, int pageSize) {
		// TODO Auto-generated method stub
		return this.getAll("from Member as m where (m.computerCode is not null and m.computerCode!='') and (m.uniqueCode is null or m.uniqueCode='')", offSet, pageSize);
	}

}
