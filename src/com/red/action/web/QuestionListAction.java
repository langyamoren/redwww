package com.red.action.web;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.red.action.ActionBase;
import com.red.beans.Question;
import com.red.beans.QuestionType;
import com.red.page.PageDiv;
import com.red.page.Pager;

public class QuestionListAction extends ActionBase
{
	private static final long serialVersionUID = -2584583939218052100L;
	private Integer typeId;
	private QuestionType questionType;
	private List<Question> questionList=new ArrayList<Question>();
	
	//存放所有类别列表的list
    private Pager pager;       //分页的page
    private int pageSize=30;    //每页大小
    private int totalCount=0;  //总记录数
    private int pageNo=1;        //当前页数
    
    
    
	@Override
	public String execute() throws Exception 
	{

		if(null==pager) pager=new Pager();
		PageDiv<Question> pd=null;
		if(null!=typeId&&typeId>0)
		{
			questionType=questionService.getQuestionTypes(typeId);
		  pd=questionService.getQuestionByTypes(typeId, pager.getOffset(), pageSize);
		}
		  if(null!=pd&&null!=pd.getList()&&pd.getList().size()>0)
		  {
			  questionList=pd.getList();
			  totalCount=pd.getTotalCount();
		  }
		  
		return Action.SUCCESS;
	}
	
	
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public QuestionType getQuestionType() {
		return questionType;
	}


	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}


	public List<Question> getQuestionList() {
		return questionList;
	}


	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
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
}
