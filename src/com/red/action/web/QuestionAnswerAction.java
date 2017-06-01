package com.red.action.web;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.red.action.ActionBase;
import com.red.beans.Answer;
import com.red.beans.Member;
import com.red.beans.Question;
import com.red.util.HtmlRegexpUtil;

public class QuestionAnswerAction extends ActionBase {

	private static final long serialVersionUID = 8363293811048435760L;
	private Question question;
	private Answer answer;
	
	@Override
	public String execute() throws Exception 
	{
		Member member =(Member)ActionContext.getContext().getSession().get("redwww_user");
		Question old=null;
	    String re=Action.SUCCESS;
		if(null!=answer&&null!=question&&question.getId()>0&&null!=member)
		{
			//奖励积分
			member.setIntegal(member.getIntegal()+1);
			memberService.updateMember(member);
			
			answer.setMember(member);
			answer.setQuestion(questionService.getQuestionById(question.getId()));
			answer.setDescs(HtmlRegexpUtil.toHtml(answer.getDescs()));
			if(questionService.addAnswer(answer))
			{
				  re=Action.SUCCESS;
				  this.addActionMessage("回答问题成功！");
			}
			
		}else{
			
			this.addActionError("回答问题失败，如果是本站会员请先登陆！");
			re=Action.INPUT;
		}
		return re;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public Answer getAnswer() {
		return answer;
	}
	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
	
	

}
