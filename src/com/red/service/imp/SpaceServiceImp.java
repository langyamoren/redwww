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
				log.info("�ղؿγ̳ɹ�");
				}
			}
			
		} catch (Exception e) {
			log.info("�ղؿγ�ʧ��"+e.getMessage());
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
			//���û����Ͽ۳����
			//Member member=memberDao.get(Member.class, memberId);
			if(null!=member&&member.getBalance()>=vipPrice)
				{
					//���ʣ�����Ա 
					Member admin=memberDao.get(Member.class, 1);
					
					//�ӿͻ����ϼ�ȥVIP�۸�
					member.setBalance(member.getBalance()-vipPrice);//�ӿͻ��ʼ�ȥ
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
									//���Ƽ��˽�������
									recomeMember.setIntegal(recomeMember.getIntegal()+10);
									memberDao.update(recomeMember);
									sumprice-=pencetprice;
									//�Ƽ��˲����------------------------
									Finance fin2=new Finance();
									fin2.setMember(recomeMember);
									fin2.setFromId(member.getId());
									fin2.setDescs(member.getName()+"����VIP������ <b>"+pencetprice+"</b>���");
									fin2.setPayType((byte)3);//0����1����2��ֵ3���4����
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
										//�Ƽ��˲����------------------------
										Finance fin2=new Finance();
										fin2.setMember(recomeMember);
										fin2.setFromId(member.getId());
										fin2.setDescs(member.getName()+"����VIP������ <b>"+oneprice+"</b>���");
										fin2.setPayType((byte)3);//0����1����2��ֵ3���4����
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
					admin.setBalance(admin.getBalance()+sumprice);//������Ա��
					memberDao.update(admin);//��ӵĸ��Ĺ���Ա���ʻ����
					
					//���ӿͻ������
					Finance fin=new Finance();
					fin.setMember(member);
					fin.setDescs("����vip��ȥ<b>"+vipPrice+"</b>���");
					fin.setPayType((byte)0);//0����1����2��ֵ3���4����
					fin.setMoney(vipPrice*-1);
					financeDao.save(fin);
					
					//���ӹ���Ա�����
					Finance fin1=new Finance();
					fin1.setMember(admin);
					fin1.setFromId(member.getId());
					fin1.setDescs("���� "+member.getEmail()+"֧����<b>"+sumprice+"</b>���");
					fin1.setPayType((byte)4);//0����1����2��ֵ3���4����((byte)4);//0����1����2��ֵ3���4����
					fin1.setMoney(sumprice);
					financeDao.save(fin1);
					//���������
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
                    log.info("�޸��û���Ϣ�ɹ���"+member.getEmail());
					
				}
			}
		} catch (Exception e) {
		     log.error("�޸��û���Ϣʧ�ܣ�");
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
				log.info("��ֵ�ɹ�");
			}
			
			
		} catch (Exception e) {
			log.error("��ֵʧ��");
		}
		return re;
	}
   //��ֵ
	@Override
	public boolean chunZhi(Integer memberId,String fromAcount,String orderAcount,Integer payMoney,Integer payType)
	{
		//fromAcount ֧�������׺�
		//orderAcount  ������
        boolean re=false;
        try {
    		Member mm=memberDao.get(Member.class, memberId);
    		if(null!=mm&&mm.getId()>0)
    		{
    			Finance fin=new Finance();
				fin.setDescs("֧�������׺ţ�"+fromAcount+"��ֵ");
				fin.setOrderAccount(orderAcount);
				fin.setMember(mm);
				fin.setPayType((byte)2);//0����1����2��ֵ3���4����5�������
				fin.setMoney(payMoney);
				mm.setBalance((int)(mm.getBalance()+payMoney));
				memberDao.update(mm);
		        financeDao.save(fin);//�����û������
				//����email
		        re=true;
		        log.info("��ֵ�ɹ�");
    		}
			
		} catch (Exception e) {
			log.error("��ֵʧ��"+e.getMessage());
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
		//���ӿͻ������
		Finance fin=new Finance();
		fin.setMember(member);
		fin.setFromId(1);
		fin.setDescs("����");
		fin.setPayType((byte)5);//0����1����2��ֵ3���4����5���빺��
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
