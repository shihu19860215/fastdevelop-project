package com.msh.fastdevelop.sys.service.dao;

import com.msh.frame.client.base.BaseDao;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-07-22 14:50:38
 */
public interface ColumnDictDao<ColumnDictPO,ColumnDictQO> extends BaseDao {
    long logicDelete(Long id);
}
