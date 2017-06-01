package com.red.service.imp;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;

import com.red.beans.Answer;
import com.red.beans.Question;
import com.red.beans.QuestionType;
import com.red.page.PageDiv;
import com.red.service.QuestionService;

import com.red.service.base.ServiceTamlate;

public class QuestionServiceImp extends ServiceTamlate implements QuestionService
{
	public static final Logger log=Logger.getLogger(QuestionServiceImp.class);
	/****************************�����ط���**********************************/
	@Override
	public List<QuestionType> getParent() {
		// TODO Auto-generated method stub
		return questionTypeDao.getParent();
	}

	@Override
	public List<QuestionType> getTypesAll() {
		// TODO Auto-generated method stub
		return questionTypeDao.getAll();
	}

	@Override
	public boolean addQuestionTypes(QuestionType types) {
		 boolean re=false;
		   try {
			      //�����Ϊ�������ʱ
				   if(null==types.getQuestionType()||types.getQuestionType().getId()<=0)
				   {
					   types.setQuestionType(null);
				   }else
				   {
					 //�����Ϊ�Ѵ������ʱ
					   QuestionType father =questionTypeDao.get(QuestionType.class, types.getQuestionType().getId());
					   types.setQuestionType(father);
				   }
				   if(null==types.getSorts()||types.getSorts()<0||types.getSorts()>9)
				   {
					   types.setSorts((byte)9);
				   }
				   questionTypeDao.save(types);
				  re=true;
				  log.info("������ɹ���");
			} catch (Exception e) 
			{
				re=false;
				  log.error("����������ʧ��!:"+e.getMessage());
				e.printStackTrace();
			}
			return re;
	}

	@Override
	public boolean deleteQuestionTypesById(Integer id) {
		boolean re=false;
		try {
			if(0<id){questionTypeDao.deleteById(QuestionType.class, id);}
			re=true;
			log.info("ɾ �����ɹ�!");
		} catch (Exception e) {
			log.error("ɾ���������ʧ��!:"+e.getMessage());
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public boolean updateQuestionTypes(QuestionType types) {
		 boolean re=false;
		    try {
				Assert.notNull(types);
				QuestionType tem=this.getQuestionTypes(types.getId());
				
			    if(types.getId()>0) //ֻ��id����0ʱ�ſɸ���
			    {
			    	//���Ҫ�޸ĵ������һ�������ô��ֻ���޸����ֺ�����
			    	if(null!=tem.getQuestionType()&&null!=tem.getQuestionType().getId()&&tem.getQuestionType().getId()>0)
			    	{
			    	
				    	if(null==types.getQuestionType()||null==types.getQuestionType().getId()||types.getQuestionType().getId()<=0)//û�и����
				    	{
				    		tem.setQuestionType(null);
				    	}else 
				    	{
				    		  //�����Ϊ�Ѵ������ʱ
				    		QuestionType father =questionTypeDao.get(QuestionType.class, types.getQuestionType().getId());
							   tem.setQuestionType(father);
				    	}
			    	}
			    	tem.setName(types.getName());
			    	tem.setSorts(types.getSorts());
			    	questionTypeDao.update(tem);
			    	re=true;
			    	log.info("�����������"+types.getId()+"�ɹ���");
			    }
				
			} catch (Exception e) {
			    log.error("�����������ʧ�ܣ�"+e.getMessage());
			    e.printStackTrace();
			}
			return re;
	}

	@Override
	public QuestionType getQuestionTypes(Integer id) {
		QuestionType tem=null;
		if(id>0)
		{
			tem=questionTypeDao.get(QuestionType.class, id);
		}
		return tem;
	}

	@Override
	public boolean hasQuestion(Integer typeId) {
		// TODO Auto-generated method stub
		return questionTypeDao.hashQuestion(typeId);
	}

	@Override
	public List<QuestionType> getSons(Integer id) {
		// TODO Auto-generated method stub
		return questionTypeDao.getSons(id);
	}
 /****************************������ط���**********************************/
	@Override
	public List<Question> getPopsQuestion(int topCount) {
		// TODO Auto-generated method stub
		return this.getQuestionDao().getQuestionByPop(topCount);
	}

	@Override
	public PageDiv<Question> getPopsQuestion(int offSet, int pageSize) {
		// TODO Auto-generated method stub
		return this.getQuestionDao().getQuestionByPop(offSet, pageSize);
	}

	@Override
	public List<Question> getLastQuestion(int topCount) {
		// TODO Auto-generated method stub
		return this.getQuestionDao().getQuestionByLast(topCount);
	}

	@Override
	public PageDiv<Question> getLastQuestion(int offSet, int pageSize) {
		// TODO Auto-generated method stub
		return this.getQuestionDao().getQuestionByLast(offSet, pageSize);
	}

	@Override
	public List<Question> getSearchQuestion(Question example) {
		
		return null;
	}

	@Override
	public boolean addQuestion(Question question) {
		boolean re=false;
		try {
			if(null!=question&&null!=question.getQuestionType()&&null!=question.getQuestionType().getId()&&question.getQuestionType().getId()>0)
			{
				QuestionType qt=this.getQuestionTypes(question.getQuestionType().getId());
				if(null!=qt)
				{
					question.setQuestionType(qt);
					question.setSorts((byte)9);
					questionDao.save(question);
					re=true;
					log.info("���ʳɹ���"+question.getTitle());
				}else
				{
					log.error("���� һ��Ҫ�������!");
					
				}
			}
		} catch (Exception e) {
		log.error("����ʧ��!"+e.getMessage());
		}
		return re;
	}

	@Override
	public boolean deleteQuestionById(Integer id) {
		boolean re=false;
		try {
			if(null!=id&&id>0)
			{
				//����ɾ����������������
				questionDao.deleteById(Question.class, id);
				re=true;
				log.info("ɾ������ɹ���");
			}
		} catch (Exception e) 
		{
		    log.error("ɾ������ ʧ��!"+e.getMessage());
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public boolean updateQuestion(Question question) {
		boolean re=false;
		try 
		{
			if(null!=question&&null!=question.getId()&&question.getId()>0&&null!=question.getQuestionType()&&null!=question.getQuestionType().getId()&&question.getQuestionType().getId()>0)
			{
				Question old=this.getQuestionById(question.getId());
				QuestionType qt=this.getQuestionTypes(question.getQuestionType().getId());
				if(null!=qt&&null!=old)
				{
					question.setQuestionType(qt);		
					try {
						//���ٸ���Դ�����е��������Ե�Ŀ�������
		    			//��article��ֵ��old,��Ϊ old��session��
						BeanUtils.copyProperties(old,question);
					} catch (Exception e) {
						e.printStackTrace();
					}
					questionDao.update(old);
					re=true;
					log.info("��������ɹ�");
				}
			}
		} catch (Exception e) 
		{
		    log.error("�޸����� ʧ��!"+e.getMessage());
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public Question getQuestionById(Integer id) {
		// TODO Auto-generated method stub
		return questionDao.get(Question.class, id);
	}

	@Override
	public PageDiv<Question> getQuestionByTypes(Integer id, int offset,
			int pageSize) {
		
		return questionDao.getQuestionByType(id, offset, pageSize);
	}

	@Override
	public boolean deleteBatchById(Integer[] ids) {
		   boolean re=false;
		    try {
		    	for(Integer id:ids)
		    	this.deleteQuestionById(id);
		    	re=true;
		    	log.info("����ɾ�����³ɹ���");
			} catch (Exception e) {
				log.error("����ɾ������ʧ�ܣ�"+e.getMessage());
				e.printStackTrace();
			}
			return re;
	}


/************************����ط���**************************************/
	@Override
	public List<Answer> getAnswersByQuestionId(Integer id) {
		// TODO Auto-generated method stub
		return answerDao.getByQuestion(id);
	}
	@Override
	public boolean addAnswer(Answer answer) {
		boolean re=false;
		try {
			if(null!=answer&&null!=answer.getMember()&&null!=answer.getQuestion())
			{
				answerDao.save(answer);
				re=true;
				log.info("�ش�����ɹ�");
			}
		} catch (Exception e) {
		     log.error("�ش�����ʧ��"+e.getMessage());
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public boolean deleteAnswerById(Integer id) {
		boolean re=false;
		try {
			if(null!=id&&id>0)
			{
			    answerDao.deleteById(Answer.class, id);
				re=true;	
				log.info("ɾ���𰸳ɹ�");
			}
			
		} catch (Exception e) {
			log.error("ɾ����ʧ��");
		}
		return re;
	}

	@Override
	public boolean updateAnswer(Answer answer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Answer getAnswerById(Integer id) {
		if(null!=id&&id>0)
		{
			return answerDao.get(Answer.class, id);
		}else
		{
		return null;
		}
	}
	
	

}
