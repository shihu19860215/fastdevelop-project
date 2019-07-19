package com.msh.fastdevelop.sys.service.dao;

import com.msh.frame.client.base.BaseDao;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-29 14:15:29
 */
public interface AuditConfigureDao<AuditConfigurePO,AuditConfigureQO> extends BaseDao {
    long logicDelete(Long id);
}
