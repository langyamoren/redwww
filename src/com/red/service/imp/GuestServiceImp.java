package com.red.service.imp;


import java.util.List;
import org.apache.log4j.Logger;
import com.red.beans.Article;
import com.red.beans.Chapter;
import com.red.beans.Course;
import com.red.beans.Download;
import com.red.beans.Focus;
import com.red.beans.Member;
import com.red.beans.Question;
import com.red.service.GuestService;
import com.red.service.base.ServiceTamlate;

public class GuestServiceImp extends ServiceTamlate implements GuestService {
	public static final Logger log=Logger.getLogger(GuestServiceImp.class);
  
	@Override
	public List<Article> getNewsIndex(Integer articleTypeId,Integer topCount) {
		// TODO Auto-generated method stub
		return this.getArticleDao().getArticleByType(articleTypeId, topCount);
	}

	@Override
	public List<Focus> getFocusIndex(int count) {
		// TODO Auto-generated method stub
		return this.getFocusDao().getFocusByTop(count);
	}

	@Override
	public List<Article> getNoticeIndex(int count) {
		// TODO Auto-generated method stub
		int noticeId=2;
		return this.getArticleDao().getArticleByType(noticeId, count);
	}

	@Override
	public List<Course> getCourseIndex(int count) {
		// TODO Auto-generated method stub
		return this.getCourseDao().getCourseByTop(count);
	}

	@Override
	public List<Question> getQuestionIndex(int count) {
		// TODO Auto-generated method stub
		return this.getQuestionDao().getQuestionByTop(count);
	}

	@Override
	public List<Chapter> getChapterIndex(int count) {
		// TODO Auto-generated method stub
		return this.getChapterDao().getLastChapter(count);
	}

	@Override
	public List<Article> getArticleIndex(int typeId, int count) {
		// TODO Auto-generated method stub
		return this.getArticleDao().getArticleByType(typeId,count);
	}

	@Override
	public List<Member> getMemberIndex(int topCount) {
		// TODO Auto-generated method stub
		return this.getMemberDao().getNewComer(topCount);
	}

	@Override
	public List<Download> getDownloadIndex(int topCount) {
		// TODO Auto-generated method stub
		return this.getDownloadDao().getDownByCount(topCount);
	}

	@Override
	public List<Article> getArticleBySearche(String keywords,int offSet,int pageSize)
	{
		Article article=new Article();
		article.setKeyword(keywords);
		return this.getArticleDao().getByExample(article, offSet, pageSize);
		// TODO Auto-generated method stub
		//return this.getArticleDao().getAll("from Article as a where a.keywords like %"+keywords+"%");
	}
	

}
