package com.red.action.admin;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.red.action.ActionBase;
import com.red.beans.Finance;
import com.red.beans.Member;

public class DuixianAction extends ActionBase 
{
	private static final long serialVersionUID = 1258476206595625950L;
    private Member member;
    private Finance finance;
    private List<Finance> list=new ArrayList<Finance>();
	public String browseFinance()throws Exception
	{
		list=adminService.getAskDuixian();
		return Action.SUCCESS;
	}
	public String updateFinance()throws Exception
	{
		if(null!=finance&&finance.getId()>0&&adminService.duixian(finance))
		{
			this.addActionMessage("兑现成功");
		}else
		{
			this.addActionMessage("兑现失败");
		}
		return this.browseFinance();
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Finance getFinance() {
		return finance;
	}
	public void setFinance(Finance finance) {
		this.finance = finance;
	}
	public List<Finance> getList() {
		return list;
	}
	public void setList(List<Finance> list) {
		this.list = list;
	}
    
}
