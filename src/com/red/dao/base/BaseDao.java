package com.red.dao.base;

import java.io.Serializable;
import java.util.List;

import com.red.page.PageDiv;

public interface BaseDao<T extends Serializable> 
{
	/*****************************1����ѯ����***********************************/
	/**
	 * ͨ��ID���Ҷ���,����������
	 * @param id ��¼��ID
	 * @return ʵ�����
	 */
	public T load(Class<?> clazz ,Serializable id);
	/**
	 * ͨ��ID���Ҷ���
	 * @param id ��¼��ID
	 * @param lock�Ƿ���������
	 * @return ʵ�����
	 */
	public T load(Class<?> clazz ,Serializable id, boolean lock);

	public T get(Class<?> clazz ,Serializable id);
	
	/**
	 * ��ѯΨһ�������
	 */
	public T getUnique(String hql);
	public T getUnique(String hql,Object[]params);
	/**
	 * �������ж���
	 * @return �����б�
	 */
	public List<T> getAll(String hql);
	public List<T> getAll(String hql,Object[] params);
	public PageDiv<T> getAll(String hql,int offSet, int pageSize);
	/**
	 * ȡ���������Ĺ�topCount��Ԫ��
	 * @param hql
	 * @param topCount
	 * @return
	 */
	public List<T> getAll(String hql,int topCount);
	public List<T> getAll(String hql,int topCount,Object[] params);
	public PageDiv<T> getAll(String hql,int offSet, int pageSize,Object[]param);
	

	/**
	 *  ͳ��ָ����Ĳ�ѯ���
	 * @param hql
	 * @return
	 */
	public int getCountQuery(String hql);
	public int getCountQuery(String hql,Object[]params);
	
	/**
	 * ����ʾ���������
	 * @param exampleEntity
	 * @return
	 */
	 List<T> 	getByExample(T exampleEntity);
	 List<T>    getByExample(T exampleEntity, int offSet, int pageSize);
	 List<T>    getByExample(String entityName, T exampleEntity);
	 List<T> 	getByExample(String entityName, T exampleEntity,  int offSet, int pageSize);
	
/***************************************2����������****************************************/
	/**
	 * �������
	 * @param entity ʵ�����
	 * @return ʵ�����
	 */
	public T save(T entity);
	/**
	 * ���¶���
	 * @param entity ʵ�����
	 * @return ʵ�����
	 */
	public T update(T entity);

	/**
	 * �������¶���
	 * @param entity ʵ�����
	 * @return ʵ�����
	 */
	public T saveOrUpdate(T entity);

	/**
	 * �������¶��󿽱�
	 * @param entity
	 * @return �Ѹ��µĳ־û�����
	 */
	public T merge(T entity);

	/**
	 * ɾ������
	 * @param entity  ʵ�����
	 */
	public T delete(T entity);

	/**
	 * ����IDɾ����¼
	 * @param id ��¼ID
	 */
	public T deleteById(Class<?> clazz,Serializable id);
	/**
	 * ˢ�¶���
	 * @param entity
	 */
	public void refresh(T entity);
	/**
	 *  ������������
	 * @param hql
	 * @return
	 */
	public int update(String hql);
	/**
	 * ����ִ�и����޸Ĳ�����
	 * @param sql ����PreparedStatement��SQL���
	 * @param params ��ά�������飬ÿ����һ��SQL���Ĳ�����
	 * @return ִ����Ӱ��ļ�¼��
	 */
	public int[] executeBatch(String sql,Object[]...params);


}
