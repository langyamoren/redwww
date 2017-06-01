package com.red.action.admin;

import java.util.List;

import com.opensymphony.xwork2.Action;
import com.red.action.ActionBase;
import com.red.beans.QuestionType;
public class QuestionTypesAction extends ActionBase
{

	   private static final long serialVersionUID = 6016383273565852550L;
	   private List<QuestionType> allTypes;//��������б�
	   private List<QuestionType> parents;//��������б�
	   private QuestionType questionTypes;//���ʵ����
	   
	   public void init()
	   {
		  parents=questionService.getParent();
		  allTypes=questionService.getTypesAll(); 
	   }
	   public String initQuestionTypes()throws Exception
	   {
		   init();  
		   return Action.SUCCESS;
	   }
	   
	   public String addQuestionTypes()throws Exception
	   {
		 if(questionService.addQuestionTypes(questionTypes))
		 {
			   this.addActionMessage("�������ɹ�!") ;
		 }else
		 {
			  this.addActionError("�������ʧ��!");
		 }
		   return this.initQuestionTypes();
	   }
	   public String editQuestionTypes()throws Exception
	   {
		   init(); 
		   questionTypes=(QuestionType)questionService.getQuestionTypes(questionTypes.getId());
		   
		   QuestionType t=new QuestionType();
		   t.setName("���ϼ����");
		   t.setId(-1);
		  
		   if(null==questionTypes.getQuestionType()||null==questionTypes.getQuestionType().getId()||0>=questionTypes.getQuestionType().getId())
		   {
			   parents.clear();
			   parents.add(0,t);
		   }
	       else
		   {
		   parents.add(t);
		   }
		   return "edite";
	   }
	   public String updateQuestionTypes()throws Exception
	   {
			  if(questionService.updateQuestionTypes(questionTypes))
			  {
				  this.addActionMessage("�޸����ɹ�");
			  }
			  else
			  {
				  this.addActionError("�޸����ʧ�ܣ�");
			  }
			  return this.initQuestionTypes();
	   }
	   public String deleteQuestionTypes()throws Exception
	   {
		   QuestionType tem=questionService.getQuestionTypes(questionTypes.getId());
		   List<QuestionType>list=questionService.getSons(tem.getId());
		   if(null!=list&&list.size()>0)
		   {
			   this.addActionMessage("����ɾ�����������ĸ����!");
		   }else
		   {   //�������������£�������ɾ��
			   
			   if(!questionService.hasQuestion(questionTypes.getId()))
			   {
			   if(null!=questionTypes.getId()&&questionTypes.getId()>0&&questionService.deleteQuestionTypesById(questionTypes.getId()))
			   {
				   this.addActionMessage("ɾ���ɹ���"); 
			   }else
			   {
				   this.addActionError("ɾ�����ʧ�ܣ�") ; 
			   }
			   }else
			   {
				   this.addActionError("����������£�����ɾ ����");
			   }
		   }
		   return this.initQuestionTypes();
	   }
	   /**********************************************************************/
	public List<QuestionType> getAllTypes() {
		return allTypes;
	}
	public void setAllTypes(List<QuestionType> allTypes) {
		this.allTypes = allTypes;
	}
	public List<QuestionType> getParents() {
		return parents;
	}
	public void setParents(List<QuestionType> parents) {
		this.parents = parents;
	}
	public QuestionType getQuestionTypes() {
		return questionTypes;
	}
	public void setQuestionTypes(QuestionType questionTypes) {
		this.questionTypes = questionTypes;
	}
	   
	   
	   
}
