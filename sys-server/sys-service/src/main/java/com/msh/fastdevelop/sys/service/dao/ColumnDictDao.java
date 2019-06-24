package com.msh.fastdevelop.sys.service.dao;

import com.msh.frame.client.base.BaseDao;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-19 20:58:20
 */
public interface ColumnDictDao<ColumnDictPO,ColumnDictQO> extends BaseDao {
    long logicDelete(Long id);
}
