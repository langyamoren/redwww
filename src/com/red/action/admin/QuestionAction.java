package com.red.action.admin;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.opensymphony.xwork2.Action;
import com.red.action.ActionBase;
import com.red.beans.Question;
import com.red.beans.QuestionType;
import com.red.page.PageDiv;
import com.red.page.Pager;
import com.red.util.DoubleSelectNode;


public class QuestionAction extends ActionBase
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7011316994993057405L;
	//存放所有类别列表的list
    private Pager pager;       //分页的page
    private int pageSize=10;    //每页大小
    private int totalCount=0;  //总记录数
    private int pageNo;        //当前页数
    private List<Question> questionList=new ArrayList<Question>();
    private Integer []ids; //批量删除的id
  	private List<QuestionType> parents;
    private Question question; //封装表单的bean
	/** 新闻管理所有请求中常用的参数值	 */
	private String typesId;	//所属栏目ID
	private List<DoubleSelectNode> doubleSelectNodes;	//级联新闻栏目列表
	private String column1;	//当前选中的第一级新闻栏目
	private String column2;	//当前选中的第二级新闻栏目
	
	  public String browseQuestion()throws Exception
	  {
		  if(null==pager)
	      pager=new Pager();
		if(null==question||null==question.getQuestionType()||null==question.getQuestionType().getId()||question.getQuestionType().getId()<=0)
		  {
			  PageDiv<Question> pd=questionService.getLastQuestion(pager.getOffset(), pageSize);
			  if(null!=pd)
			  {
				  questionList=pd.getList();
				  totalCount=pd.getTotalCount();
			  }
		  }else
		  {
			  PageDiv<Question> pd=questionService.getQuestionByTypes(question.getQuestionType().getId(),pager.getOffset(), pageSize);
			  if(null!=pd)
			  {
				  questionList=pd.getList();
				  totalCount=pd.getTotalCount();
			  }
		  }
		  createDoubleSelect();  
		  //增加默认
		  DoubleSelectNode myColumn1=new DoubleSelectNode();
		  myColumn1.setName("请选择");
		  myColumn1.setValue("0");
		  DoubleSelectNode myColumn2=new DoubleSelectNode();
		  myColumn2.setName("所有分类");
		  myColumn2.setValue("0");
		  
		  List<DoubleSelectNode> secondColumn = new ArrayList<DoubleSelectNode>();
		  secondColumn.add(myColumn2);
		  myColumn1.setSubNodes(secondColumn);
		  doubleSelectNodes.add(0,myColumn1);
		  
		  for(DoubleSelectNode so:doubleSelectNodes)
		  {
			  DoubleSelectNode tem=new DoubleSelectNode();
			  tem.setName("请选择");
			  tem.setValue("0");
			  so.getSubNodes().add(0, tem);
		  }
		  
		  
		  return Action.SUCCESS;
	  }
	  public String updateQuestion()throws Exception
	  {
		  
		  if(null!=question&&null!=question.getId()&&question.getId()>0)
		  {
			   //加载对象
			  question=questionService.getQuestionById(question.getId()); 
			  
			  QuestionType son=question.getQuestionType();
			  QuestionType par=son.getQuestionType();
			  column1=par.getId().toString();
			  column2=son.getId().toString();
		  }
		  createDoubleSelect();  
		  return "edit";
	  }
	  
	  public String updateSaveQuestion()throws Exception
	  {
		  if(null!=question&&null!=question.getId()&&question.getId()>0&&null!=question.getQuestionType()&&null!=question.getQuestionType().getId()&&question.getQuestionType().getId()>0)
		  {
					
	        		if(questionService.updateQuestion(question))
	        		{
	        			this.addActionMessage("修改问题成功");
	        		}else
	        		{
	        			this.addActionError("修改问题失败");
	        		}
		    	
		    	
		  }else
		  {
			  this.addActionError("修改的对象不能为空！");
		  }
		  return browseQuestion();
	  } 
	  
	  public String deleteQuestion()throws Exception
	  {
		  if(null!=question&&null!=question.getId()&&question.getId()>0)
		  {
			  
			 if(questionService.deleteQuestionById(question.getId()))
			 {
		         this.addActionMessage("删除问题成功！");
			 }else
			 {
				 this.addActionError("删除问题失败！");
			 }
		  }
		  
		  return browseQuestion();
	  }
	  
	  public String deleteBatchQuestion()throws Exception
	  {
		  if(null!=ids&&ids.length>0)
	    	{ 
	 
	    		if(questionService.deleteBatchById(ids))
	    		{
	    			this.addActionMessage("批量删除成功");
	    		}
	    		else
	    		{
	    			this.addActionError("批量删除失败");
	    		}
	    	}
		  return browseQuestion();  
	  }
	  
	  
	  public String browseAnsewerQuestion()throws Exception
	  {
		  
		  return "browseAnswer";
	  }
	  
	  
	  /** 构造问题栏目级联数据 	*/
		private void createDoubleSelect()
		{
			//构造一个级联下拉列表的数据集合
			doubleSelectNodes=new ArrayList<DoubleSelectNode>();
			DoubleSelectNode node = null;
			DoubleSelectNode tempnode = null;
			List<DoubleSelectNode> nodes = null;
			//调用新闻栏目业务逻辑组件装载一级新闻栏目列表
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
				//调用新闻栏目业务逻辑组件装载某一级新闻栏目的子栏目列表
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


/*********************get and Set**************************/
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

		public List<Question> getQuestionList() {
			return questionList;
		}

		public void setQuestionList(List<Question> questionList) {
			this.questionList = questionList;
		}

		public Integer[] getIds() {
			return ids;
		}

		public void setIds(Integer[] ids) {
			this.ids = ids;
		}

		public List<QuestionType> getParents() {
			return parents;
		}

		public void setParents(List<QuestionType> parents) {
			this.parents = parents;
		}

		public Question getQuestion() {
			return question;
		}

		public void setQuestion(Question question) {
			this.question = question;
		}

		public String getTypesId() {
			return typesId;
		}

		public void setTypesId(String typesId) {
			this.typesId = typesId;
		}

		public List<DoubleSelectNode> getDoubleSelectNodes() {
			return doubleSelectNodes;
		}

		public void setDoubleSelectNodes(List<DoubleSelectNode> doubleSelectNodes) {
			this.doubleSelectNodes = doubleSelectNodes;
		}

		public String getColumn1() {
			return column1;
		}

		public void setColumn1(String column1) {
			this.column1 = column1;
		}

		public String getColumn2() {
			return column2;
		}

		public void setColumn2(String column2) {
			this.column2 = column2;
		}
			
					

}
