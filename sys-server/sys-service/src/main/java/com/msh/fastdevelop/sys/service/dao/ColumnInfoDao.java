package com.msh.fastdevelop.sys.service.dao;

import com.msh.frame.client.base.BaseDao;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-11-14 16:17:56
 */
public interface ColumnInfoDao<ColumnInfoPO,ColumnInfoQO> extends BaseDao {
    long logicDelete(Long id);
}
