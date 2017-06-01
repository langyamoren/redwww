package com.red.dao;

import java.util.List;

import com.red.beans.Answer;
import com.red.dao.base.RedCoreDao;

public interface AnswerDao extends RedCoreDao<Answer>
{
    /**
     * ͨ��questionId����ȡ��Ӧ�Ļش�
     * @param questionId
     * @return �ش��б�
     */
	   List<Answer> getByQuestion(Integer questionId);
	   
	 
}
