package com.red.service.imp;

import org.apache.log4j.Logger;
import com.red.beans.Finance;
import com.red.beans.Member;
import com.red.beans.Memberlevel;
import com.red.beans.Password;
import com.red.beans.Question;
import com.red.dao.MemberDao;
import com.red.page.PageDiv;
import com.red.service.SpaceService;
import com.red.service.base.ServiceTamlate;
public class SpaceServiceImp extends ServiceTamlate implements SpaceService{
	public static final Logger log=Logger.getLogger(SpaceServiceImp.class);
	
	
	@Override
	public PageDiv<Finance> getFinaceByMemberId(Integer memberId, int offset,int pageSize) {
		
		return financeDao.getFinanceByMember(memberId, offset, pageSize);
	}
	@Override
	public PageDiv<Member> getRecomeMember(Integer memberId, int offset,int pageSize) {
		return memberDao.getRecomeMembers(memberId, offset, pageSize);
	}

/*	@Override
	public boolean recomeCourse(Integer memberId, Integer courseId) {
		boolean re=false;
		try {
		
			if(null!=memberId&&memberId>0&&null!=courseId&&courseId>0)
			{
				Member member=memberDao.get(Member.class, memberId);
				Course course=courseDao.get(Course.class, courseId);
				CourseMember old=courseMemberDao.getCourseMember(memberId,courseId);
				if(null==old&&null!=member&&null!=course)
				{
				CourseMember cm=new CourseMember();
				cm.setCourse(course);
				cm.setMember(member);
				cm.setFlag((byte)0);
				courseMemberDao.save(cm);
			
				course.setCollectCount(course.getCollectCount()+1);
				courseDao.update(course);
				re=true;
				log.info("收藏课程成功");
				}
			}
			
		} catch (Exception e) {
			log.info("收藏课程失败"+e.getMessage());
		}
		return re;
	}
*/
	@Override
	public boolean payMoney(Member member,Integer vipPrice,Password pwd) 
	{
		boolean re=false;
		if(null!=member&&member.getId()>0)
		{
			//从用户帐上扣除金币
			//Member member=memberDao.get(Member.class, memberId);
			if(null!=member&&member.getBalance()>=vipPrice)
				{
					//划帐，管理员 
					Member admin=memberDao.get(Member.class, 1);
					
					//从客户帐上减去VIP价格
					member.setBalance(member.getBalance()-vipPrice);//从客户帐减去
					member.setMemberlevel(memberlevelDao.get(Memberlevel.class, 2));
					memberDao.update(member);
					

					Integer recomeid=member.getMember().getId();
					int sumprice=vipPrice;
					for(int i=0;i<4;i++)
					{
						
						if(null!=recomeid&&recomeid>0)
						{
							Member recomeMember=memberDao.get(Member.class,recomeid);
							if(null!=recomeMember)
							{
								
								if(i==0)
								{
									int pencetprice=(int)(vipPrice*(recomeMember.getMemberlevel().getPercent()/100.0));	
									recomeMember.setBalance(recomeMember.getBalance()+pencetprice);
									//给推荐人奖励积分
									recomeMember.setIntegal(recomeMember.getIntegal()+10);
									memberDao.update(recomeMember);
									sumprice-=pencetprice;
									//推荐人财务表------------------------
									Finance fin2=new Finance();
									fin2.setMember(recomeMember);
									fin2.setFromId(member.getId());
									fin2.setDescs(member.getName()+"购买VIP，奖励 <b>"+pencetprice+"</b>金币");
									fin2.setPayType((byte)3);//0购买1兑现2充值3提成4收入
									fin2.setMoney(pencetprice);
									financeDao.save(fin2);
								}else
								{
									if(recomeMember.getMemberlevel().getId()>1)
									{
										int oneprice=(int)(vipPrice*0.1); 
										recomeMember.setBalance(recomeMember.getBalance()+oneprice);
										recomeMember.setIntegal(recomeMember.getIntegal()+5);
										memberDao.update(recomeMember);
										sumprice-=oneprice;
										//推荐人财务表------------------------
										Finance fin2=new Finance();
										fin2.setMember(recomeMember);
										fin2.setFromId(member.getId());
										fin2.setDescs(member.getName()+"购买VIP，奖励 <b>"+oneprice+"</b>金币");
										fin2.setPayType((byte)3);//0购买1兑现2充值3提成4收入
										fin2.setMoney(oneprice);
										financeDao.save(fin2);
										
									}
									 
								}
								if(null!=recomeMember.getMember()&&null!=recomeMember.getMember().getId()&&recomeMember.getMember().getId()>0)
							    recomeid=recomeMember.getMember().getId();
								else
								recomeid=0;
							}else
							{
								break;
							}
							
						}
	
					}//end for
					admin.setBalance(admin.getBalance()+sumprice);//给管理员加
					memberDao.update(admin);//后加的个改管理员的帐户余额
					
					//增加客户财务表
					Finance fin=new Finance();
					fin.setMember(member);
					fin.setDescs("加入vip花去<b>"+vipPrice+"</b>金币");
					fin.setPayType((byte)0);//0购买1兑现2充值3提成4收入
					fin.setMoney(vipPrice*-1);
					financeDao.save(fin);
					
					//增加管理员财务表
					Finance fin1=new Finance();
					fin1.setMember(admin);
					fin1.setFromId(member.getId());
					fin1.setDescs("收入 "+member.getEmail()+"支付的<b>"+sumprice+"</b>金币");
					fin1.setPayType((byte)4);//0购买1兑现2充值3提成4收入((byte)4);//0购买1兑现2充值3提成4收入
					fin1.setMoney(sumprice);
					financeDao.save(fin1);
					//增加密码表
					passwordDao.save(pwd);
					
					re=true;
				}
			}

		return re;
	}

	@Override
	public boolean updateMemberInfo(Member member) 
	{
		boolean re=false;
		try {
			if(null!=member&&null!=member.getId()&&member.getId()>0)
			{
				Member old=memberDao.get(Member.class, member.getId());
				if(null!=old)
				{
					old.setAcount(member.getAcount());
					old.setAcountType(member.getAcountType());
					old.setCellphone(member.getCellphone());
					old.setQq(member.getQq());
                    old.setPassword(member.getPassword());
                    memberDao.update(old);
                    re=true;
                    log.info("修改用户信息成功！"+member.getEmail());
					
				}
			}
		} catch (Exception e) {
		     log.error("修改用户信息失败！");
		}
		return re;
	}

	@Override
	public Member getMemberById(Integer memberId) {
		// TODO Auto-generated method stub
		return memberDao.get(Member.class, memberId);
	}

	@Override
	public boolean addFinance(Finance finance) {
		boolean re=false;
		try {
			if(null!=finance&&null!=finance.getPayType()&&null!=finance.getMoney()&&finance.getMoney()>0)
			{
				financeDao.save(finance);
				re=true;
				log.info("充值成功");
			}
			
			
		} catch (Exception e) {
			log.error("充值失败");
		}
		return re;
	}
   //充值
	@Override
	public boolean chunZhi(Integer memberId,String fromAcount,String orderAcount,Integer payMoney,Integer payType)
	{
		//fromAcount 支付宝交易号
		//orderAcount  订单号
        boolean re=false;
        try {
    		Member mm=memberDao.get(Member.class, memberId);
    		if(null!=mm&&mm.getId()>0)
    		{
    			Finance fin=new Finance();
				fin.setDescs("支付宝交易号："+fromAcount+"充值");
				fin.setOrderAccount(orderAcount);
				fin.setMember(mm);
				fin.setPayType((byte)2);//0购买1兑现2充值3提成4收入5申请兑现
				fin.setMoney(payMoney);
				mm.setBalance((int)(mm.getBalance()+payMoney));
				memberDao.update(mm);
		        financeDao.save(fin);//增加用户财务表
				//发送email
		        re=true;
		        log.info("充值成功");
    		}
			
		} catch (Exception e) {
			log.error("充值失败"+e.getMessage());
		}
		return re;
	}

	@Override
	public boolean orderExsit(String orderNo) {
		boolean re=false;
		try {
			Finance fin=financeDao.getFinanceByOrderNo(orderNo);
			if(null!=fin&&null!=fin.getId()&&fin.getId()>0)
			{
				re=true;
			}
		} catch (Exception e) {
			
		}
		return re;
	}
	@Override
	public PageDiv<Question> getQuestions(Integer memberId, int offSet,
			int pageSize) {
		return this.getQuestionDao().getQuestionByMemberId(memberId, offSet, pageSize);
	}
	@Override
	public boolean duixian(Member member) 
	{
		boolean re=false;
		
		try{
			int bb=member.getBalance();
		member.setBalance(0);
		memberDao.update(member);
		//增加客户财务表
		Finance fin=new Finance();
		fin.setMember(member);
		fin.setFromId(1);
		fin.setDescs("兑现");
		fin.setPayType((byte)5);//0购买1兑现2充值3提成4收入5申请购买
		fin.setMoney(bb);
		financeDao.save(fin);
		re=true;
		}catch(Exception ex)
		{
			re=false;
		}
		return re;
	}


}
