package com.red.dao.imp;
import java.util.List;
import com.red.beans.Answer;
import com.red.dao.AnswerDao;
import com.red.dao.base.RedCoreImp;
public class AnswerDaoImp extends RedCoreImp<Answer> implements
		AnswerDao {
    /**
     * 通过questionId来获取相应的回答
     * @param questionId
     * @return
     */
	@Override
	public List<Answer> getByQuestion(Integer questionId) 
	{
		if(null!=questionId&&questionId>0)
	    return this.getAll("from Answer as an where an.question.id="+questionId+" order by an.id desc");
		else
		return null;
		//return new ArrayList<Answer>();
	}

	
}
