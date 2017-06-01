package com.red.action.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.red.action.ActionBase;
import com.red.beans.Member;
import com.red.beans.Question;
import com.red.beans.QuestionType;
import com.red.util.DoubleSelectNode;
import com.red.util.HtmlRegexpUtil;

public class AskQuestionAction extends ActionBase 
{
	private static final long serialVersionUID = 7372869168798598875L;
	private Question question;
	private Member member;
	private List<DoubleSelectNode> doubleSelectNodes;	//����������Ŀ�б�

	public String askQuestion()throws Exception
	{
		member=(Member)ActionContext.getContext().getSession().get("redwww_user");
		if(null==question)question=new Question();
		if(null!=member)
		{
		question.setIntegral(0);
		createDoubleSelect();
		return "ask";
		}else
		{
			return "input";
		}
	}
	public String askSaveQuestion()throws Exception
	{
		createDoubleSelect();
		if(null!=question)
		{
			member=(Member)ActionContext.getContext().getSession().get("redwww_user");
			if(null==member&&null!=question.getQuestionType()&&null!=question.getQuestionType().getId()&&question.getQuestionType().getId()>0)
			{
				this.addActionError("ֻ�б�վ�û��ſ����ʣ�");
				return "input";
			}else
			{
				//��������
				member.setIntegal(member.getIntegal()+1);
				//memberService.updateSaveMember(member);
				memberService.updateMember(member);
				question.setMember(member);	
				//question.setIspop((byte)0);
				//question.setSort((byte)9);
				question.setIspop(false);
				question.setSorts((byte)9);
				
				question.setTitle(HtmlRegexpUtil.toHtml(question.getTitle()));
				question.setDescs(HtmlRegexpUtil.toHtml(question.getDescs()));
				if(questionService.addQuestion(question))
				{
/*					  String reapath=ServletActionContext.getServletContext().getRealPath("/");
					  HtmlGenerator h = new HtmlGenerator("");
					  File f=new File(reapath,"html/question/q"+question.getQuestionType().getId());
					  if(!f.exists())f.mkdir();
					  h.createRedHtml("questionDesc", new Object[]{question.getId().toString(),reapath,"q"+question.getQuestionType().getId()+File.separator+"que"+question.getId()+".html"});	
				      h.createRedHtml("questions", new Object[]{reapath});*/
				}else
				{
					this.addActionError("����ʧ�ܣ����Ժ����ԣ�");
					return "ask";
				}
			}
		}else
		{
			this.addActionError("����ʧ�ܣ�");
		}
		return Action.SUCCESS;
	}

	  /** ����������Ŀ�������� 	*/
	private void createDoubleSelect()
	{
		//����һ�����������б�����ݼ���
		doubleSelectNodes=new ArrayList<DoubleSelectNode>();
		DoubleSelectNode node = null;
		DoubleSelectNode tempnode = null;
		List<DoubleSelectNode> nodes = null;
		//����������Ŀҵ���߼����װ��һ��������Ŀ�б�
		List<QuestionType> columnsList = questionService.getParent();				
		List<QuestionType> childColumnsList = null;
		QuestionType column = null;
		QuestionType child_column = null;
		Iterator<QuestionType> it = columnsList.iterator();
		Iterator<QuestionType> it1 = null;
		while(it.hasNext()){
			column = it.next();
			node = new DoubleSelectNode();
			node.setName(column.getName());
			node.setValue(column.getId().toString());
			//����������Ŀҵ���߼����װ��ĳһ��������Ŀ������Ŀ�б�
			childColumnsList = questionService.getSons(column.getId());
			it1 = childColumnsList.iterator();
			nodes = new ArrayList<DoubleSelectNode>();
			while(it1.hasNext()){
				child_column = it1.next();
				tempnode = new DoubleSelectNode();
				tempnode.setName(child_column.getName().trim());
				tempnode.setValue(child_column.getId().toString());
				nodes.add(tempnode);
			}
			node.setSubNodes(nodes);
			doubleSelectNodes.add(node);
		}	
		
	}
	public List<DoubleSelectNode> getDoubleSelectNodes() {
		return doubleSelectNodes;
	}
	public void setDoubleSelectNodes(List<DoubleSelectNode> doubleSelectNodes) {
		this.doubleSelectNodes = doubleSelectNodes;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
}
