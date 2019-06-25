package com.msh.fastdevelop.sys.service.dao;

import com.msh.frame.client.base.BaseDao;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-24 20:24:20
 */
public interface AreaDao<AreaPO,AreaQO> extends BaseDao {
    long logicDelete(Long id);
}
