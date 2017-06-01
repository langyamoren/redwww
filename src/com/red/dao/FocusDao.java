package com.red.dao;

import java.util.List;

import com.red.beans.Focus;
import com.red.dao.base.RedCoreDao;

public interface FocusDao extends RedCoreDao<Focus>
{
 
   /**
    * 取出所有的焦点广告
    * @return
    */
   public List<Focus> getAllFocus();
   /**
    * 取最新的n条广显示在主页上
    * @param count 显示的条数
    * @return
    */
   public List<Focus> getFocusByTop(int count);
   
}
