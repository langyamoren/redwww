package com.red.service;

import java.util.List;

import com.red.beans.Article;
import com.red.beans.Chapter;
import com.red.beans.Course;
import com.red.beans.Download;
import com.red.beans.Focus;
import com.red.beans.Member;
import com.red.beans.Question;


/********************************1、首页********************************/
/**
 * 一个前台service用于为网页提供数据
 * @author Administrator
 *
 */
public interface GuestService // extends ServiceBase 
{
	/**
	 * 取出首页上要显示的新闻条数，最新新闻
	 * @param count
	 * @return
	 */
   public List<Article> getNewsIndex(Integer articleTypeId,Integer topCount);
   /**
    * 取出首页上显示的焦点广，根据排序字段
    * @param count
    * @return
    */
   public List<Focus> getFocusIndex(int count);
   /**
    * 取出首页上公告，最新根据id降序
    * 网站公告的类别请于global_variable.properties中取
    * @param count
    * @return
    */
   public List<Article> getNoticeIndex(int count);
   /**
    * 取出首页上显示的课程 信息,根据排序字段
    * @param count
    * @return
    */
   public List<Course> getCourseIndex(int count);
   /**
    * 取出首页上显示的最新问题
    * @param count
    * @return
    */
   public List<Question> getQuestionIndex(int count);
   /**
    * 得到最新课程 节,
    * @param count
    * @return
    */
   public List<Chapter> getChapterIndex(int count);
   /**
    * 首页显示的文章分类列表，
    * @param typeId  类别id
    * @param count   显示条数
    * @return
    */
   public List<Article> getArticleIndex(int typeId,int count);
   /**
    * 取最新开通的会员
    * @param topCount
    * @return
    */
   public List<Member> getMemberIndex(int topCount); 
   /**
    * 取指定数提的友情链接
    * 暂时不做
    * @param topCount
    * @return
    */
   /*
   public list<Links>  getIndexLinks(int topCount);
   */
   /**
    * 取得首页上显示的下载，以推荐优先，然后以id 降序排列
    */  
   public List<Download> getDownloadIndex(int topcCount);
   /**
    * 通过关键字搜索
    * @param keywords
    * @return
    */
   public List<Article> getArticleBySearche(String keywords,int offSet,int pageSize);
   /****************************************************************/
   
   
}
