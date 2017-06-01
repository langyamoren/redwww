package com.red.dao;

import java.util.List;

import com.red.beans.Focus;
import com.red.dao.base.RedCoreDao;

public interface FocusDao extends RedCoreDao<Focus>
{
 
   /**
    * ȡ�����еĽ�����
    * @return
    */
   public List<Focus> getAllFocus();
   /**
    * ȡ���µ�n������ʾ����ҳ��
    * @param count ��ʾ������
    * @return
    */
   public List<Focus> getFocusByTop(int count);
   
}
