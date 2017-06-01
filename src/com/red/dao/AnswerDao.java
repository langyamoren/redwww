package com.red.dao;

import java.util.List;

import com.red.beans.Answer;
import com.red.dao.base.RedCoreDao;

public interface AnswerDao extends RedCoreDao<Answer>
{
    /**
     * 通过questionId来获取相应的回答
     * @param questionId
     * @return 回答列表
     */
	   List<Answer> getByQuestion(Integer questionId);
	   
	 
}
