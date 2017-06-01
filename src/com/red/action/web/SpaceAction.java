package com.red.action.web;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.red.action.ActionBase;
import com.red.beans.Finance;
import com.red.beans.Member;
import com.red.beans.Password;
import com.red.beans.Question;
import com.red.page.PageDiv;
import com.red.page.Pager;
import com.red.util.MD5;

public class SpaceAction extends ActionBase 
{
	private static final long serialVersionUID = 814567297405546525L;
	private Member member=(Member)ActionContext.getContext().getSession().get("redwww_user");
	private String updateuser; //原始密码
	private String rew;     //重复密码
	private String reacount;//重复帐户
	private Password pwd;
	private List<Member> recomeMembers=new ArrayList<Member>();
	private List<Finance> financeList=new ArrayList<Finance>();
	private List<Question> quesitonList=new ArrayList<Question>();
	private List<Password> pwdList=new ArrayList<Password>();
	private boolean flagPassword;//标识用户是否可以申请密码
	
	//存放所有类别列表的list
    private Pager pager;       //分页的page
    private int pageSize=30;    //每页大小
    private int totalCount=0;  //总记录数
    private int pageNo=1;        //当前页数
	
	
	//查看所有推荐好友
	public String recomeFriendsSpace()throws Exception
	{
		if(null==pager)pager=new Pager();
	    PageDiv<Member> pd=null;
		pd=spaceService.getRecomeMember(member.getId(), pager.getOffset(), pageSize);
		if(null!=pd)
		{
			recomeMembers=pd.getList();   
			totalCount=pd.getTotalCount();
		}
		return "friends";
	}
	//查看提问的问题
	public String myquestionSpace()throws Exception
	{
		if(null==pager)pager=new Pager();
	    PageDiv<Question> pd=null;
		pd=spaceService.getQuestions(member.getId(), pager.getOffset(), pageSize);
		if(null!=pd)
		{
			quesitonList=pd.getList();   
			totalCount=pd.getTotalCount();
		}
		return "questions";
	}
	//查询财务明细
	public String financeSpace()throws Exception
	{
	    if(null==pager)pager=new Pager();
	    PageDiv<Finance> pd=null;
		pd=spaceService.getFinaceByMemberId(member.getId(), pager.getOffset(), pageSize);
		if(null!=pd)
		{
			financeList=pd.getList();
			totalCount=pd.getTotalCount();
		}
		return "finaces";
	}
	
	
	//购买 课程
	/*public String payingSpace()throws Exception
	{
		if(null!=courseId&&courseId>0&&null!=member&&null!=member.getId()&&member.getId()>0)
		{
			CourseMember old=spaceService.getCourseMember(member.getId(), courseId);
			if(null!=old&&old.getFlag()==1)
			{
				this.addActionMessage("您已购买此课程");
			}else
			{
				if(spaceService.payCourse(member.getId(), courseId))
				{
				     Member tm=memberService.getMemberById(member.getId());
				     Course tc=courseService.getCourseById(courseId);
					
					//发送email
				    SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String [] mailParam=new String[]{tm.getName(),sf.format(new Date()),tc.getTitle()};
					this.getRedMailUtil().sendMail(tm.getEmail(), "红萌网_购买课程确认信", "buy_course.html",mailParam);
					this.addActionMessage("订购课程成功");
				}else
				{
					this.addActionError("订购课程失败");
				}	
				
			}
	   }
	  return payCourseSpace();
	}*/
	
	
   //跳转到申请密码页面
	public String askPasswordSpace()throws Exception
	{
		//取配置文件中会员的价格
		String strprice=this.getText("red.vip.price");
	    if(null!=strprice&&strprice.matches("\\d*"))
	    {
	    	int price=Integer.parseInt(strprice);
	    	if(member.getBalance()<price)
	    	{
	    		this.addActionError("您的金币不足，请充值！");
	    		flagPassword=false;
	    	}else if(member.getBalance()>=price)
	    	{
	    		flagPassword=true;
	    		//String [] mailParam=new String[]{tem.getName(),sb.toString()};
				//this.getRedMailUtil().sendMail(tem.getEmail(), "红萌网_找回密码", "member_password.html",mailParam);
				//this.addActionMessage("系统已重设了您的密码，请在你注册的邮箱内收取新密码！");
	    	}
	    }
		pwdList=adminService.getPasswordByMember(member.getId());
		
		return "askpassword";
	}
	//申请密码
	public String savePasswordSpace()throws Exception
	{
		
		if(null!=member)
		{
			if(null==pwd||null==pwd.getPwdType()||"".equals(pwd.getPwdType()))
			{
				this.addActionError("密码类型不能为空");
			}else if(null==pwd.getComCode()||"".equals(pwd.getComCode()))
			{
				this.addActionError("密码类型不能为空");
			}else
			{
				pwd.setMember(member);
				String strprice=this.getText("red.vip.price");
			    if(null!=strprice&&strprice.matches("\\d*"))
			    {
			    	int price=Integer.parseInt(strprice);
				    spaceService.payMoney(member, price, pwd);
			    }
				//adminService.addPassword(pwd);	
			}
		}
		return  this.askPasswordSpace();
	}
	//修改个人信息
	public String editMemberInfoSpace()throws Exception
	{
		return "editeMember";
	}
	//更新个人信息
	public String updateMemberInfoSpace()throws Exception
	{
	    if(null!=member&&null!=member.getPassword()&&!"".equals(member.getPassword())&&member.getPassword().equals(rew))
	    {
	    	member.setPassword(MD5.EncoderByMd5(member.getPassword()));
	    }else
	    {
	    	member.setPassword(updateuser);
	    }
	    if(spaceService.updateMemberInfo(member))
	    {
	    	this.addActionMessage("修改用户信息成功");
	    }else
	    {
	    	this.addActionError("修改用户信息失败");
	    }
		return "editeMember";
	}
	//登出
	public String logoutSpace()throws Exception
	{
		ServletActionContext.getRequest().getSession().invalidate();
		return "index";
	}
	public String duixianSpace()throws Exception
	{
		if(null!=member&&member.getId()>0)
		{
			spaceService.duixian(member);
		}
		return financeSpace();
	}
  //去充值
	public String gopaySpace()throws Exception
	{
		return "gopay";
	}
// 忘了密码
	public String forgotPasswd()throws Exception
	{
		//跳至找回密码窗口
		return "forgot";
	}
	public String resetPasswd()throws Exception
	{
		
		if(null!=member&&null!=member.getEmail()&&null!=member.getName()&&null!=member.getCellphone()&&null!=member.getQq())
		{

			//判断用户是否存在
			Member tem=memberService.getMemberForResetPassword(member.getEmail(), member.getName(), member.getQq(), member.getCellphone());
			if(null!=tem)
			{
				//生成随机密码
				StringBuilder sb=new StringBuilder();
				Random ran=new Random();
				for(int i=0;i<8;i++)
				{
					if(i%2==0)
					{
						sb.append((char)(ran.nextInt(25)+97));
					}else if(i%3==0)
					{
						sb.append(ran.nextInt(10));
					}else
					{
						sb.append((char)(ran.nextInt(25)+65));
					}
				}
				tem.setPassword(MD5.EncoderByMd5(sb.toString()));
				if(memberService.updateMember(tem))
				{
					//发送email
					  //  SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String [] mailParam=new String[]{tem.getName(),sb.toString()};
						this.getRedMailUtil().sendMail(tem.getEmail(), "红萌网_找回密码", "get_password.html",mailParam);
						this.addActionMessage("系统已重设了您的密码，请在你注册的邮箱内收取新密码！");
				}else
				{
					this.addActionError("重设密码失败，请稍后再试！");
				}
				
			}else
			{
				this.addActionError("您填写的资料有误，请重新找回密码！");	
			}
			
			
		}
		return Action.SUCCESS;
	}
/************************************************************/	
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

	public List<Question> getQuesitonList() {
		return quesitonList;
	}
	public void setQuesitonList(List<Question> quesitonList) {
		this.quesitonList = quesitonList;
	}
	public String getUpdateuser() {
		return updateuser;
	}
	public void setUpdateuser(String updateuser) {
		this.updateuser = updateuser;
	}
	public String getRew() {
		return rew;
	}
	public void setRew(String rew) {
		this.rew = rew;
	}
	public String getReacount() {
		return reacount;
	}
	public void setReacount(String reacount) {
		this.reacount = reacount;
	}
	public List<Password> getPwdList() {
		return pwdList;
	}
	public void setPwdList(List<Password> pwdList) {
		this.pwdList = pwdList;
	}
	public Password getPwd() {
		return pwd;
	}
	public void setPwd(Password pwd) {
		this.pwd = pwd;
	}
	public boolean isFlagPassword() {
		return flagPassword;
	}
	public void setFlagPassword(boolean flagPassword) {
		this.flagPassword = flagPassword;
	}
	
}
