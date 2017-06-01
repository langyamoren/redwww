package com.red.service.imp;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;
import com.red.beans.Chapter;
import com.red.beans.Course;
import com.red.beans.CourseType;
import com.red.page.PageDiv;
import com.red.service.CourseService;
import com.red.service.base.ServiceTamlate;
import com.red.util.HtmlRegexpUtil;

public class CourseServiceImp extends ServiceTamlate implements CourseService {
	public static final Logger log=Logger.getLogger(CourseServiceImp.class);
	
	/*******************�γ������ط���******************************/
	@Override
	public boolean addCourseType(CourseType courseType) {
		boolean re=false;
		try {
			Assert.notNull(courseType);
			courseTypeDao.save(courseType);
			re=true;
			log.info("[CourseServiceImp]:addCourseType:�γ����:"+courseType.getName()+"��ӳɹ���");
		} catch (Exception e) {
		log.error("�γ����:"+courseType.getName()+"[CourseServiceImp]:addCourseType:���ʧ�ܣ�"+e.getMessage())	;
		e.printStackTrace();
		}
		return re;
	}

	@Override
	public boolean updateCourseType(CourseType courseType) {
		boolean re=false;
		 try {
			 if(null!=courseType&&null!=courseType.getId()&&courseType.getId()>0)
			 {
				 courseTypeDao.update(courseType);
				 re=true;
				 log.info("[CourseServiceImp]:updateCourseType:�޸Ŀγ����"+courseType.getName()+"�ɹ���");
			 }
		} catch (Exception e) 
		{
			 log.error("[CourseServiceImp]:updateCourseType:�޸Ŀγ����"+courseType.getName()+"ʧ�ܣ�"+e.getMessage());
			 e.printStackTrace();
		}	
		return re;
	}

	@Override
	public boolean deleteCoutseTypeById(Integer id) {
		boolean re=false;
		 try {
			 if(null!=id&&id>0)
			 {
				 courseTypeDao.delete(courseTypeDao.get(CourseType.class, id));
				 re=true;
				 log.info("[CourseServiceImp]:deleteCoutseTypeById:ɾ���γ����ɹ���"+id);
			 }
		} catch (Exception e) 
		{
			 log.error("[CourseServiceImp]:deleteCoutseTypeById:ɾ���γ����ʧ�ܣ�"+id+"\t"+e.getMessage());
			 e.printStackTrace();
		}	
		return re;
	}

	@Override
	public CourseType getCourseTypeById(Integer id) {
		// TODO Auto-generated method stub
		return courseTypeDao.get(CourseType.class, id);
	}

	@Override
	public boolean hasCourse(Integer courseTypeId) {
		// TODO Auto-generated method stub
		return courseTypeDao.hasCourse(courseTypeId);
	}
	
	@Override
	public List<CourseType> getCourseTypeAll() {
		// TODO Auto-generated method stub
		return courseTypeDao.getAllCourseType();
	}

	
	/***************************Course�γ���ط���************************************/
	@Override
	public boolean addCourse(Course course) 
	{
		boolean re=false;
		try {
			Assert.notNull(course);
			courseDao.save(course);
			re=true;
			log.info("[CourseServiceImp]:addCourse:�γ�:"+course.getTitle()+"��ӳɹ���");
		} catch (Exception e) {
		log.error("�γ�:"+course.getTitle()+"[CourseServiceImp]:addCourse:���ʧ�ܣ�"+e.getMessage())	;
		e.printStackTrace();
		}
		
		return re;
	}

	@Override
	public boolean deleteCourseById(Integer id) {
		
		boolean re=false;
		 try {
			 if(null!=id&&id>0)
			 {
				 courseDao.delete(courseDao.get(Course.class, id));
				 re=true;
				 log.info("[CourseServiceImp]:deleteCourseById:ɾ���γ̳ɹ���"+id);
			 }
		} catch (Exception e) 
		{
			 log.error("[CourseServiceImp]:deleteCourseById:ɾ���γ�ʧ�ܣ�"+id+"\t"+e.getMessage());
			 e.printStackTrace();
		}	
		return re;
	}

	@Override
	public boolean updateCourse(Course course) 
	{
		boolean re=false;
		 try {
			 if(null!=course&&null!=course.getId()&&course.getId()>0)
			 {
				 courseDao.update(course);
				 re=true;
				 log.info("[CourseServiceImp]:updateCourse:�޸Ŀγ�"+course.getTitle()+"�ɹ���");
			 }
		} catch (Exception e) 
		{
			 log.error("[CourseServiceImp]:updateCourse:�޸Ŀγ�"+course.getTitle()+"ʧ�ܣ�"+e.getMessage());
			 e.printStackTrace();
		}	
		return re;
	}

	@Override
	public Course getCourseById(Integer id) {
		// TODO Auto-generated method stub
		return courseDao.get(Course.class, id);
	}

	@Override
	public List<Course> getCourseByTop(Integer topCount) {
		// TODO Auto-generated method stub
		return courseDao.getCourseByTop(topCount);
	}

	@Override
	public List<Course> getCourseByRecom(int topCount) {
		// TODO Auto-generated method stub
		return this.getCourseByRecom(topCount);
	}

	@Override
	public List<Course> getCourseByKeyword(String keyword, int topCount) {
		// TODO Auto-generated method stub
		return this.getCourseByKeyword(keyword, topCount);
	}


/***************************chapter����ط���************************************/
	@Override
	public boolean hasChapter(Integer courseId) {
		// TODO Auto-generated method stub
		return chapterDao.hasChapter(courseId);
	}
	
	@Override
	public boolean addChapter(Chapter chapter) {
		 boolean re=false;
		    try {
		    	if(null!=chapter&&null!=chapter.getCourse()&&null!=chapter.getCourse().getId()&&chapter.getCourse().getId()>0)
				{
					
					chapter.setContentPic(HtmlRegexpUtil.getAllPics(chapter.getContent()));
					chapterDao.save(chapter);
					re=true;	
					log.info("[CourseServiceImp]��addChapter������С�ڳɹ�;"+chapter.getId());
				}else
				{
					log.info("[CourseServiceImp]��addChapter���γ�����һ��Ҫ���ڿγ̣���ѡ����ȷ�Ŀγ�");
				}
			} catch (Exception e) {
				log.error("[CourseServiceImp]��addChapter������С��ʧ��!"+e.getMessage());
				e.printStackTrace();
			}
			return re;
	}

	@Override
	public boolean deleteChapterById(Integer id) {
		boolean re=false;
		try {
			if(null!=id&&id>0)
			{
				chapterDao.delete(chapterDao.get(Chapter.class, id));
				re=true;
			}
			log.info("[CourseServiceImp]:deleteChapterById:ɾ��С�ڳɹ�;"+id);
		} catch (Exception e) {
			log.error("[CourseServiceImp]:deleteChapterById:ɾ��С��ʧ��!"+e.getMessage());
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public boolean updateChapter(Chapter chapter) {
		 boolean re=false;
		    try {
				if(null!=chapter&&null!=chapter.getId()&&chapter.getId()>0)
				{
					chapter.setContentPic(HtmlRegexpUtil.getAllPics(chapter.getContent()));
					chapterDao.update(chapter);
					re=true;
				}
				log.info("[CourseServiceImp:updateChapter:�޸�С�ڳɹ�;"+chapter.getId());
			} catch (Exception e) {
				log.error("[CourseServiceImp:updateChapter:�޸�С��ʧ��!"+e.getMessage());
				e.printStackTrace();
			}
			return re;
	}
	@Override
	public Chapter getChapterById(Integer id) 
	{
		if(null!=id&&id>0)
		{
			return chapterDao.get(Chapter.class, id);
		}else
		{
			return null;
		}
	}

	@Override
	public List<Chapter> getChapterByCourseId(Integer courseId) {
		// TODO Auto-generated method stub
		return chapterDao.getChapterByCourseId(courseId);
	}
	@Override
	public PageDiv<Chapter> getChapterByCourseId(Integer courseId,int offSet,int pageSize) {
		// TODO Auto-generated method stub
		return chapterDao.getChapterByCourseId(courseId, offSet, pageSize);
	}

	@Override
	public List<Chapter> getTopChapter(Integer topCount) {
		return chapterDao.getLastChapter(topCount);
	}

	@Override
	public PageDiv<Course> getAllCourse(int offSet, int pageSize) {
		// TODO Auto-generated method stub
		return courseDao.getCourseByPage(offSet, pageSize);
	}

	@Override
	public List<Chapter> getChapterByCourseTopCount(Integer courseId,
			Integer topCount) {
		// TODO Auto-generated method stub
		return this.getChapterByCourseTopCount(courseId, topCount);
	}



}
