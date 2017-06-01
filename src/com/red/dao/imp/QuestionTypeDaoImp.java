package com.red.dao.imp;
import java.util.ArrayList;
import java.util.List;
import com.red.beans.QuestionType;
import com.red.dao.QuestionTypeDao;
import com.red.dao.base.RedCoreImp;


public class QuestionTypeDaoImp extends RedCoreImp<QuestionType> implements
		QuestionTypeDao {

	@Override
	public List<QuestionType> getParent() {
		// TODO Auto-generated method stub
		return this.getAll("from QuestionType as q where  q.questionType.id is null order by q.sorts");
	}

	@Override
	public List<QuestionType> getSons(Integer fatherid) {
		// TODO Auto-generated method stub
		return this.getAll("from QuestionType as q where q.questionType.id=? order by q.sorts", new Object[]{fatherid});
	}

	@Override
	public List<QuestionType> getAll() {
		List<QuestionType> list=new ArrayList<QuestionType>();
		List<QuestionType> parent=this.getParent();
		for(QuestionType pa:parent)
		{
			list.add(pa);
			for(QuestionType tem:this.getSons(pa.getId()))
			{
				list.add(tem);
			}
		}
		return list;
	}

	@Override
	public boolean hashQuestion(Integer typeId) 
	{
		int count=0;
		count=this.getCountQuery("from Question as q where q.questionType.id=?",new Object[]{typeId});
		if(count>0)
	    return true;
		else
		return false;
	}


}
