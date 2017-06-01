package com.red.dao.imp;

import java.util.List;
import com.red.beans.Question;
import com.red.dao.QuestionDao;
import com.red.dao.base.RedCoreImp;
import com.red.page.PageDiv;
public class QuestionDaoImp extends  RedCoreImp<Question> implements
QuestionDao{

	@Override
	public List<Question> getQuestionByPop(int count) {
		
		return this.getAll("from Question  as qu where qu.ispop=1  order by qu.id desc", count);
	}
	@Override
	public PageDiv<Question> getQuestionByPop(int offSet, int pageSize) {
		// TODO Auto-generated method stub
		return this.getAll("from Question  as qu where qu.ispop=1  order by qu.id desc", offSet, pageSize);
	}

	@Override
	public List<Question> getQuestionByTop(int count) {
		return this.getAll("from Question as qu order by qu.id desc ", count);
	}

	@Override
	public List<Question> getQuestionByType(Integer typeId, int count) {
		Object [] params=new Object[]{typeId};
		return this.getAll("from Question as qu where qu.questionType.id=?  order by qu.id desc",count, params);
	}

	@Override
	public PageDiv<Question> getQuestionByType(Integer typeId, int offSet, int pageSize) {
		return this.getAll("from Question as qu where qu.questionType.id=? order by qu.id desc", offSet, pageSize, new Object[]{typeId});
		
	}
	@Override
	public List<Question> getQuestionByLast(int count) {
		String hql="from Question  as qu  order by qu.id desc";
		return this.getAll(hql, count);
	}
	@Override
	public PageDiv<Question> getQuestionByLast(int offSet, int pageSize) {
		// TODO Auto-generated method stub
		String hql="from Question  as qu  order by qu.id desc";
		return this.getAll(hql,  offSet, pageSize);
	}
	@Override
	public PageDiv<Question> getQuestionByMemberId(Integer memberId, int offSet,
			int pageSize) {
		
		return this.getAll("from Question as q where q.member.id=? order by q.id desc", offSet, pageSize, new Object[]{memberId});
	}

}
