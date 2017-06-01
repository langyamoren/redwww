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
	
	/*******************课程类别相关方法******************************/
	@Override
	public boolean addCourseType(CourseType courseType) {
		boolean re=false;
		try {
			Assert.notNull(courseType);
			courseTypeDao.save(courseType);
			re=true;
			log.info("[CourseServiceImp]:addCourseType:课程类别:"+courseType.getName()+"添加成功！");
		} catch (Exception e) {
		log.error("课程类别:"+courseType.getName()+"[CourseServiceImp]:addCourseType:添加失败！"+e.getMessage())	;
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
				 log.info("[CourseServiceImp]:updateCourseType:修改课程类别"+courseType.getName()+"成功！");
			 }
		} catch (Exception e) 
		{
			 log.error("[CourseServiceImp]:updateCourseType:修改课程类别"+courseType.getName()+"失败！"+e.getMessage());
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
				 log.info("[CourseServiceImp]:deleteCoutseTypeById:删除课程类别成功！"+id);
			 }
		} catch (Exception e) 
		{
			 log.error("[CourseServiceImp]:deleteCoutseTypeById:删除课程类别失败！"+id+"\t"+e.getMessage());
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

	
	/***************************Course课程相关方法************************************/
	@Override
	public boolean addCourse(Course course) 
	{
		boolean re=false;
		try {
			Assert.notNull(course);
			courseDao.save(course);
			re=true;
			log.info("[CourseServiceImp]:addCourse:课程:"+course.getTitle()+"添加成功！");
		} catch (Exception e) {
		log.error("课程:"+course.getTitle()+"[CourseServiceImp]:addCourse:添加失败！"+e.getMessage())	;
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
				 log.info("[CourseServiceImp]:deleteCourseById:删除课程成功！"+id);
			 }
		} catch (Exception e) 
		{
			 log.error("[CourseServiceImp]:deleteCourseById:删除课程失败！"+id+"\t"+e.getMessage());
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
				 log.info("[CourseServiceImp]:updateCourse:修改课程"+course.getTitle()+"成功！");
			 }
		} catch (Exception e) 
		{
			 log.error("[CourseServiceImp]:updateCourse:修改课程"+course.getTitle()+"失败！"+e.getMessage());
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


/***************************chapter节相关方法************************************/
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
					log.info("[CourseServiceImp]：addChapter：增加小节成功;"+chapter.getId());
				}else
				{
					log.info("[CourseServiceImp]：addChapter：课程内容一定要属于课程，请选择正确的课程");
				}
			} catch (Exception e) {
				log.error("[CourseServiceImp]：addChapter：增加小节失败!"+e.getMessage());
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
			log.info("[CourseServiceImp]:deleteChapterById:删除小节成功;"+id);
		} catch (Exception e) {
			log.error("[CourseServiceImp]:deleteChapterById:删除小节失败!"+e.getMessage());
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
				log.info("[CourseServiceImp:updateChapter:修改小节成功;"+chapter.getId());
			} catch (Exception e) {
				log.error("[CourseServiceImp:updateChapter:修改小节失败!"+e.getMessage());
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
