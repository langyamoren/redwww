package com.red.service.imp;

import java.util.List;
import org.apache.log4j.Logger;
import com.red.beans.Finance;
import com.red.beans.Member;
import com.red.beans.Memberlevel;
import com.red.page.PageDiv;
import com.red.service.MemberService;
import com.red.service.base.ServiceTamlate;
import com.red.util.MD5;
public class MemberServiceImp extends ServiceTamlate implements MemberService {
	public static final Logger log=Logger.getLogger(MemberServiceImp.class);

	@Override
	public boolean checkExist(String email) {
		
		return this.getMemberDao().checkMemberExist(email);
	}

	@Override
	public Member loginMember(String email, String pwd) {
		return this.getMemberDao().checkMember(email, pwd);
	}
	
	@Override
	public PageDiv<Member> getRecommendMember(int ownId, int offSet, int pageSize) {
		// TODO Auto-generated method stub
		return this.getMemberDao().getRecomeMembers(ownId, offSet, pageSize);
	}

	@Override
	public PageDiv<Finance> getMemberFiance(int ownId, int offSet, int PageSize) {
		// TODO Auto-generated method stub
		return this.getMemberFiance(ownId, offSet, PageSize);
	}

	@Override
	public boolean registMemeber(Member member) {
		boolean re=false;
		try {
			if(null!=member&&!memberDao.checkMemberExist(member.getEmail()))
			{
				Memberlevel memlev=memberlevelDao.get(Memberlevel.class, 1);
				member.setMemberlevel(memlev);
				member.setIntegal(memlev.getIntegral());//设置积分
				member.setBalance(0);
				member.setIslock((byte)0);
				member.setPassword(MD5.EncoderByMd5(member.getPassword()));
				//Member recome=this.getMemberByRecome(member.getRecommendCode().trim());
				Member recome=this.getMemberDao().get(Member.class, member.getMember().getId());
				if(null!=recome)
				{
					//推荐好友加10分
					recome.setIntegal(recome.getIntegal()+10);
					memberDao.update(recome);
					member.setMember(recome);//介绍人
					if(!memberDao.addMemeber(member))re=false;
				}
				re=true;
				log.info("[MemberServiceImp]:registMemeber:用户注册成功"+member.getId());
			}
		} catch (Exception e) {
			log.error("[MemberServiceImp]:registMemeber:用户注册失败"+e.getMessage());
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public PageDiv<Member> getAllMember(int offSet, int pageSize) {
		
		return memberDao.getAllMember(offSet, pageSize);
	}

	@Override
	public PageDiv<Member> getSearchMember(String email,int offSet, int pageSize) {	
		return memberDao.searchMemberByEmail(email, offSet, pageSize);
	}

	@Override
	public Member getMemberById(Integer id) {
		return memberDao.get(Member.class, id);
	}

	@Override
	public List<Memberlevel> getAllMemberlevel() {
		return memberlevelDao.getAllLevel();
	}

	@Override
	public boolean updateMember(Member member) {
		boolean re=false;
		try {
					if(null!=member&&null!=member.getId()&&member.getId()>0)
					{
						//Member old=memberDao.get(Member.class, member.getId());
						//if(null!=old)
						//{
							//old.setAcount(member.getAcount());
							//old.setBalance(member.getBalance());
							//old.setCellphone(member.getCellphone());
							//old.setEmail(member.getEmail());
							//old.setIntegal(member.getIntegal());
							//old.setLocks(member.getLocks());
							//old.setName(member.getName());
							//old.setQq(member.getQq());
							//old.setRecommendCode(member.getRecommendCode());
							/*if(null!=member.getMemberlevel()&&null!=member.getMemberlevel().getId()&&member.getMemberlevel().getId()>0)
							{
								Memberlevel ml=memberlevelDao.get(Memberlevel.class, member.getMemberlevel().getId());
								if(null!=ml)
							    {old.setMemberlevel(ml);}
							}
							
                            if(null!=member.getPassword()&&!"".equals(member.getPassword())&&member.getPassword().trim().length()>5)
                            {
							old.setPassword(MD5.EncoderByMd5(member.getPassword()));
                            }*/
                            
						//}
					memberDao.update(member);
                    re=true;
                    log.info("[MemberServiceImp]:updateMember:修改用户成功"+member.getId());
					}
			
		} catch (Exception e) {
			log.error("[MemberServiceImp]:updateMember:修改用户失败"+e.getMessage());
		}
		return re;
	}
	@Override
	public Member getMemberForResetPassword(String email, String name,
			String qq, String cell) {
		return memberDao.getMemberByforgotPassword(email, name, qq, cell);
	}

	@Override
	public Member getMemberByRecome(Integer recomId) {
		// TODO Auto-generated method stub
		return this.getMemberDao().get(Member.class, recomId);
	}

	@Override
	public PageDiv<Member> getLastRequestPwd(int offSet, int pageSize) {
		// TODO Auto-generated method stub
		return memberDao.getLastRequestPwd(offSet, pageSize);
	}
}
