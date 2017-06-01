package com.red.dao.base;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.util.Assert;

import com.red.page.PageDiv;


/**
 * DAO基类。
 * 提供hql分页查询，example分页查询，拷贝更新等功能。
 * @param <T>
 */
public  class BaseDaoImp<T extends Serializable>  extends  HibernateDaoSupport  implements BaseDao<T> {

	@SuppressWarnings("unchecked")
	@Override
	public T load(Class<?> clazz, Serializable id) 
	{
		Assert.notNull(id);
		return (T)this.getHibernateTemplate().load(clazz, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T load(Class<?> clazz, Serializable id, boolean lock) {
		Assert.notNull(id);
       if(lock)
       {
		//return (T) this.getHibernateTemplate().getSessionFactory().openSession().load(clazz, id, LockOptions.UPGRADE);
    	   return (T) this.getSession().load(clazz, id, LockOptions.UPGRADE);
       }
		else
		{
		return (T) this.getHibernateTemplate().load(clazz, id);
		}
	 
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public T get(Class<?> clazz, Serializable id) {
		Assert.notNull(id);
		// TODO Auto-generated method stub
		return (T) this.getHibernateTemplate().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getUnique(final String hql)
	{
	    Assert.hasText(hql);  
		return (T) this.getHibernateTemplate().execute(new HibernateCallback<T>(){
			@Override
			public T doInHibernate(Session session)
					throws HibernateException, SQLException 
			{		
				return (T)session.createQuery(hql).setMaxResults(1).uniqueResult();
			}});
	}
	
	@Override
	public T getUnique(final String hql, final Object[] params) {
		Assert.hasText(hql);
		  
		return (T) this.getHibernateTemplate().execute(new HibernateCallback<T>(){

			@SuppressWarnings("unchecked")
			@Override
			public T doInHibernate(Session session)
					throws HibernateException, SQLException 
			{
				Query q=session.createQuery(hql);
				if(null!=params&&params.length>0)
				{
					for(int i=0;i<params.length;i++)
					q.setParameter(i, params[i]);
				}
				
				return (T) q.setMaxResults(1).uniqueResult();
			}});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(String hql) {
		 Assert.hasText(hql);
		return this.getHibernateTemplate().find(hql);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(String hql, Object[]params) {
		// TODO Auto-generated method stub
		
		List<T> find = this.getHibernateTemplate().find(hql, params);
		return find;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(final String hql, final int topCount) {
	   return this.getHibernateTemplate().executeFind(new HibernateCallback<List<T>>(){

			@Override
			public List<T> doInHibernate(Session session)
					throws HibernateException, SQLException {
			    Query q=session.createQuery(hql);
			    q.setMaxResults(topCount);
				return q.list();
			}
	    });

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(final String hql, final int topCount, final Object[] params) {
		 return this.getHibernateTemplate().executeFind(new HibernateCallback<List<T>>(){

				@Override
				public List<T> doInHibernate(Session session)
						throws HibernateException, SQLException {
				    Query q=session.createQuery(hql);
				    if(null!=params&&params.length>0)
		            {
		            	for(int i=0;i<params.length;i++)
		            	{
		            		q.setParameter(i, params[i]);
		            	}
		            }
				    q.setMaxResults(topCount);
					return q.list();
				}
		    });
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageDiv<T> getAll(final String hql,final int offSet,final int pageSize) {
		 Assert.hasText(hql);
		 int totalCount=0;
		 List<T> list= this.getHibernateTemplate().executeFind(new HibernateCallback<List<T>>(){

			@Override
			public List<T> doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query q=session.createQuery(hql);
				q.setMaxResults(pageSize);
				q.setFirstResult(offSet);
				List<T> list=q.list();
				return list;
			}

			});
		 totalCount=this.getCountQuery(hql);
		 return new PageDiv<T>(offSet,pageSize,totalCount,list);
	}
	@SuppressWarnings("unchecked")
	@Override
	public PageDiv<T> getAll(final String hql,final int offSet,final int pageSize,final Object[]param)
	{
		 Assert.hasText(hql);
		 int totalCount=0;
		List<T> list= this.getHibernateTemplate().executeFind(new HibernateCallback<List<T>>(){

			@Override
			public List<T> doInHibernate(Session session)
					throws HibernateException, SQLException 
				{
				Query q=session.createQuery(hql);
	            if(null!=param&&param.length>0)
	            {
	            	for(int i=0;i<param.length;i++)
	            	{
	            		q.setParameter(i, param[i]);
	            	}
	            }
				q.setMaxResults(pageSize);
				q.setFirstResult(offSet);
				List<T> list=q.list();
				return list;
			}

			});
		 totalCount=this.getCountQuery(hql,param);
		 return new PageDiv<T>(offSet,pageSize,totalCount,list);
		
	}
	@Override
	public int getCountQuery(final String hql)
	{
		 Assert.hasText(hql);
		Long count = (Long)getHibernateTemplate().execute(new HibernateCallback<Long>(){
			public Long doInHibernate(Session session) throws HibernateException{
				Query query = session.createQuery("select count(*) "+hql);
				query.setMaxResults(1);
				return (Long)query.uniqueResult();
			}
		});
		return count.intValue();
	}
	@Override
	public int getCountQuery(final String hql,final Object[]params) {
		 Assert.hasText(hql);
			Long count = (Long)getHibernateTemplate().execute(new HibernateCallback<Long>(){
				public Long doInHibernate(Session session) throws HibernateException{
					Query query = session.createQuery("select count(*) "+hql);
			           if(null!=params&&params.length>0)
			           {
			            	for(int i=0;i<params.length;i++)
			            	{
			            		query.setParameter(i, params[i]);
			            	}   
			           }
					query.setMaxResults(1);
					return (Long)query.uniqueResult();
				}
			});
			return count.intValue();
	}

	@Override
	public T save(T entity) {
		
		 Assert.notNull(entity);
		 this.getHibernateTemplate().save(entity);
		return entity;
	
	}
	@Override
	public T update(T entity) {
		 Assert.notNull(entity);
		 this.getHibernateTemplate().update(entity);
		return entity;
	}
	@Override
	public T saveOrUpdate(T entity)
	{
		 Assert.notNull(entity);
		 this.getHibernateTemplate().saveOrUpdate(entity);
		return entity;
	}
	@Override
	public T merge(T entity) {
		Assert.notNull(entity);
		 this.getHibernateTemplate().merge(entity);
		return entity;
	}
	@Override
	public T delete(T entity) {
		Assert.notNull(entity);
		this.getHibernateTemplate().delete(entity);
		return entity;
	
		
	}
	
	@Override
	public T deleteById(Class<?> clazz,Serializable id) 
	{
		Assert.notNull(id);
		this.getHibernateTemplate().delete(this.getHibernateTemplate().get(clazz, id));
		return null;
	}
	@Override
	public void refresh(T entity) 
	{
		Assert.notNull(entity);
		this.getHibernateTemplate().refresh(entity);

	}
	@Override
	public int update(final String hql)
	{
		Assert.hasText(hql);
		return ((Integer)getHibernateTemplate().execute(new HibernateCallback<Integer>(){
			public Integer doInHibernate(Session session) throws HibernateException{
				Query query = session.createQuery(hql);
				return query.executeUpdate();
			}
		})).intValue();	
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getByExample(T exampleEntity) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().findByExample(exampleEntity);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getByExample(T exampleEntity, int offSet, int pageSize) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().findByExample(exampleEntity, offSet, pageSize);

	}
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getByExample(String entityName, T exampleEntity) {
		
		return this.getHibernateTemplate().findByExample(entityName, exampleEntity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getByExample(String entityName, T exampleEntity,
			int offSet, int pageSize) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().findByExample(entityName, exampleEntity, offSet, pageSize);
	}

	

	@Override
	public int[] executeBatch(final String sql,final Object[]... params) {
		
		return this.getHibernateTemplate().execute(new HibernateCallback<int[]>(){
			 int[] ret=new int[0];
			@Override
			public int[] doInHibernate(Session session) throws HibernateException,
					SQLException {
				 
							session.doWork(new Work()
							{
										@Override
										public void execute(Connection con) throws SQLException 
										{
														
														PreparedStatement ps=null;
														try
														{
															ps=con.prepareStatement(sql);
															for(int j=0;j<params.length;j++)
															{
																for(int i=0;i<params[j].length;i++)
																{
																	ps.setObject(i+1, params[j][i]);
																}
																ps.addBatch();
															}
															ret=ps.executeBatch();
														} catch (SQLException e)
														{
															System.out.println("ERROR_010");
															e.printStackTrace();
														}finally
														{
															try
															{
																if(null!=ps)ps.close();
																if(null!=con)con.close();
															} catch (SQLException e)
															{
															   System.out.println("ERROR_004_关闭数据库异常");
																e.printStackTrace();
															}
														}
										   
										}
								
							});
				return ret;
			}});
	}

}
