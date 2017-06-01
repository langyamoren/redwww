package com.red.dao;

import java.util.List;

import com.red.beans.Memberlevel;
import com.red.dao.base.RedCoreDao;

public interface MemberlevelDao extends RedCoreDao<Memberlevel>
{
 /**
  * 查找所有用户级别
  * @return
  */
   public List<Memberlevel> getAllLevel();	 

}
