package com.red.dao.base;

import java.io.Serializable;
import java.util.List;

import com.red.page.PageDiv;

public interface BaseDao<T extends Serializable> 
{
	/*****************************1、查询数据***********************************/
	/**
	 * 通过ID查找对象,不锁定对象
	 * @param id 记录的ID
	 * @return 实体对象
	 */
	public T load(Class<?> clazz ,Serializable id);
	/**
	 * 通过ID查找对象
	 * @param id 记录的ID
	 * @param lock是否锁定对象
	 * @return 实体对象
	 */
	public T load(Class<?> clazz ,Serializable id, boolean lock);

	public T get(Class<?> clazz ,Serializable id);
	
	/**
	 * 查询唯一结果数据
	 */
	public T getUnique(String hql);
	public T getUnique(String hql,Object[]params);
	/**
	 * 查找所有对象
	 * @return 对象列表
	 */
	public List<T> getAll(String hql);
	public List<T> getAll(String hql,Object[] params);
	public PageDiv<T> getAll(String hql,int offSet, int pageSize);
	/**
	 * 取符合条件的关topCount个元素
	 * @param hql
	 * @param topCount
	 * @return
	 */
	public List<T> getAll(String hql,int topCount);
	public List<T> getAll(String hql,int topCount,Object[] params);
	public PageDiv<T> getAll(String hql,int offSet, int pageSize,Object[]param);
	

	/**
	 *  统计指定类的查询结果
	 * @param hql
	 * @return
	 */
	public int getCountQuery(String hql);
	public int getCountQuery(String hql,Object[]params);
	
	/**
	 * 根据示例对象查找
	 * @param exampleEntity
	 * @return
	 */
	 List<T> 	getByExample(T exampleEntity);
	 List<T>    getByExample(T exampleEntity, int offSet, int pageSize);
	 List<T>    getByExample(String entityName, T exampleEntity);
	 List<T> 	getByExample(String entityName, T exampleEntity,  int offSet, int pageSize);
	
/***************************************2、更新数据****************************************/
	/**
	 * 保存对象
	 * @param entity 实体对象
	 * @return 实体对象
	 */
	public T save(T entity);
	/**
	 * 更新对象
	 * @param entity 实体对象
	 * @return 实体对象
	 */
	public T update(T entity);

	/**
	 * 保存或更新对象
	 * @param entity 实体对象
	 * @return 实体对象
	 */
	public T saveOrUpdate(T entity);

	/**
	 * 保存或更新对象拷贝
	 * @param entity
	 * @return 已更新的持久化对象
	 */
	public T merge(T entity);

	/**
	 * 删除对象
	 * @param entity  实体对象
	 */
	public T delete(T entity);

	/**
	 * 根据ID删除记录
	 * @param id 记录ID
	 */
	public T deleteById(Class<?> clazz,Serializable id);
	/**
	 * 刷新对象
	 * @param entity
	 */
	public void refresh(T entity);
	/**
	 *  条件更新数据
	 * @param hql
	 * @return
	 */
	public int update(String hql);
	/**
	 * 批量执行更新修改操作，
	 * @param sql 用于PreparedStatement的SQL语句
	 * @param params 二维对象数组，每行是一条SQL语句的参数。
	 * @return 执行完影响的记录数
	 */
	public int[] executeBatch(String sql,Object[]...params);


}
