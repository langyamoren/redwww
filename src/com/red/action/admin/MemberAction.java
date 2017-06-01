/**
 * 
 */
package com.red.action.admin;

import java.util.ArrayList;
import java.util.List;

import com.red.action.ActionBase;
import com.red.beans.Finance;
import com.red.beans.Member;
import com.red.beans.Memberlevel;
import com.red.beans.Password;
import com.red.page.PageDiv;
import com.red.page.Pager;
import com.red.util.MD5;

public class MemberAction extends ActionBase 
{
	private static final long serialVersionUID = -1620547928789455882L;
	private List<Member> memberList=new ArrayList<Member>();//��Ա�б�
	private List<Password> passwordList=new ArrayList<Password>();
	private Member member;//��Ա
	private Password password;
	private List<Member> recomeMembers=new ArrayList<Member>();//�Ƽ��ĺ���
	private List<Finance> financeList=new ArrayList<Finance>();//����
	private List<Memberlevel> levelList=new ArrayList<Memberlevel>();//��Ա����
	
	private Pager pager;       //��ҳ��page
    private int pageSize=30;    //ÿҳ��С
    private int totalCount=0;  //�ܼ�¼��
    private int pageNo;        //��ǰҳ��
	public String browseAllMember()throws Exception
	{
		if(null==pager)pager=new Pager();
		PageDiv<Member> pd=null;
		pd=memberService.getAllMember(pager.getOffset(), pageSize);
		if(null!=pd)
		{
			memberList=pd.getList();
			totalCount=pd.getTotalCount();
		}
		return "browse";
	}
	public String searchMember()throws Exception
	{
		if(null!=member&&null!=member.getEmail()&&!"".equals(member.getEmail()))
		{
		if(null==pager)pager=new Pager();
		PageDiv<Member> pd=null;
		pd=memberService.getSearchMember(member.getEmail(), pager.getOffset(), pageSize);
		if(null!=pd)
		{
			memberList=pd.getList();
			totalCount=pd.getTotalCount();
		}
		}else
		{
			 this.addActionError("email����Ϊ��");
			 return browseAllMember();
		}
		return "browse";
	}
	public String viewMember()throws Exception
	{
		if(null!=member&&null!=member.getId()&&member.getId()>0)
		{
		   member=memberService.getMemberById(member.getId());
		}
		return "view";
	}
	public String editMember()throws Exception
	{
		if(null!=member&&null!=member.getId()&&member.getId()>0)
		{
		   levelList=memberService.getAllMemberlevel();
		   member=memberService.getMemberById(member.getId());
		}
		return "edit";
	}
	public String updateMember()throws Exception
	{
		if(null!=member&&null!=member.getId()&&member.getId()>0)
		{
			Member old=memberService.getMemberById(member.getId());
           
            old.setIntegal(member.getIntegal());
            old.setBalance(member.getBalance());
            old.setMemberlevel(member.getMemberlevel());

            old.setPrivileges(member.getPrivileges());
            old.setIslock(member.getIslock());
            if(null!=member.getPassword()&&!"".equals(member.getPassword())&&member.getPassword().trim().length()>5)
            {
			old.setPassword(MD5.EncoderByMd5(member.getPassword()));
            }
			if(memberService.updateMember(old))
			{
				this.addActionMessage("�޸Ļ�Ա�ɹ�!");
			}else
			{
				this.addActionError("�޸Ļ�Աʧ��");
			}
		}else
		{
			this.addActionError("�޸Ļ�Աʧ��");
		}
		return viewMember();
	}
	public String recomeMember()throws Exception
	{
		if(null==pager)pager=new Pager();
	    PageDiv<Member> pd=null;
	 
		pd=spaceService.getRecomeMember(member.getId(), pager.getOffset(), pageSize);
		if(null!=pd)
		{
			recomeMembers=pd.getList();   
			totalCount=pd.getTotalCount();
		}
		return "recome";
	}
	public String financeMember()throws Exception
	{

		if(null==pager)pager=new Pager();
	    PageDiv<Finance> pd=null;
		pd=spaceService.getFinaceByMemberId(member.getId(), pager.getOffset(), pageSize);
		if(null!=pd)
		{
			financeList=pd.getList();
			totalCount=pd.getTotalCount();
		}
		return "finace";
	}
	public String updatecmMember()throws Exception
	{
		/*if(null!=cm&&null!=cm.getId()&&cm.getId()>0)
		{
			CourseMember old=memberService.getCourseMemberById(cm.getId());
			if(null!=old)
			{
				old.setUniqueCode(cm.getUniqueCode());				
				old.setPassword(cm.getPassword());				
				old.setFlag(cm.getFlag());
				if(memberService.updateCourseMember(old))
				{
					this.addActionMessage("�޸Ļ�Ա�γ̳ɹ�");
				}else
				{
					this.addActionError("�޸Ļ�Ա�γ�ʧ��");
				}
			}
			member=old.getMember();
		}*/
		return viewMember();
	}

	public String coursesMember()throws Exception
	{
		if(null!=member&&null!=member.getId()&&member.getId()>0)
		{
			
				//memberCourseList=spaceService.getRecomeCourserByMemberId(member.getId());   
		}
		return "courses";
	}
/**************************�������****************************/
  public String browseAllPassword()throws Exception
  {
	  
	  PageDiv<Password> pd=null;
	  if(null==pager)pager=new Pager();
	  pd=adminService.getAllNotPassPassword(pager.getOffset(), pageSize);
	  if(null!=pd)
	  {
		  passwordList=pd.getList();
		  totalCount=pd.getTotalCount();
	  }
	  return "browsepassword";
  }
  
  public String setsPassword()throws Exception
  {
	  if(null!=password&&null!=password.getId()&&password.getId()>0)
	  {
		 if(adminService.publishPassword(password))
		 {
			 this.addActionMessage("������ɹ�");
		 }
	  }else
	  {
			this.addActionError("����ʧ��!"); 
	  }
	  return  browseAllPassword();
  }
	
	
	
/*************************geter and seter*****************************/	
	public List<Member> getMemberList() {
		return memberList;
	}
	public void setMemberList(List<Member> memberList) {
		this.memberList = memberList;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}

	public List<Member> getRecomeMembers() {
		return recomeMembers;
	}
	public void setRecomeMembers(List<Member> recomeMembers) {
		this.recomeMembers = recomeMembers;
	}
	public List<Finance> getFinanceList() {
		return financeList;
	}
	public void setFinanceList(List<Finance> financeList) {
		this.financeList = financeList;
	}
	
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public List<Memberlevel> getLevelList() {
		return levelList;
	}
	public void setLevelList(List<Memberlevel> levelList) {
		this.levelList = levelList;
	}
	public List<Password> getPasswordList() {
		return passwordList;
	}
	public void setPasswordList(List<Password> passwordList) {
		this.passwordList = passwordList;
	}
	public Password getPassword() {
		return password;
	}
	public void setPassword(Password password) {
		this.password = password;
	}

	
}
