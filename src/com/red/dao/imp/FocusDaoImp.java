package com.red.dao.imp;

import java.util.List;

import com.red.beans.Focus;
import com.red.dao.FocusDao;
import com.red.dao.base.RedCoreImp;


public class FocusDaoImp extends RedCoreImp<Focus> implements FocusDao {

	@Override
	public List<Focus> getAllFocus() {
		return this.getAll("from Focus");
	}

	@Override
	public List<Focus> getFocusByTop(int count) {
    return this.getAll("from Focus  as f order by f.sorts asc",count);
	}
}
