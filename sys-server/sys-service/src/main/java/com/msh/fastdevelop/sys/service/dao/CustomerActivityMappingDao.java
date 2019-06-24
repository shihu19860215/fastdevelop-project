package com.msh.fastdevelop.sys.service.dao;

import com.msh.frame.client.base.BaseDao;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-18 20:51:33
 */
public interface CustomerActivityMappingDao<CustomerActivityMappingPO,CustomerActivityMappingQO> extends BaseDao {
    long logicDelete(Long id);
}
