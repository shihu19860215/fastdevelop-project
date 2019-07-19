package com.msh.fastdevelop.sys.service.service;;

import com.msh.fastdevelop.sys.client.vo.RoleVO;
import com.msh.frame.client.base.BaseService;
import com.msh.fastdevelop.sys.client.po.RoleAuthorityMappingPO;
import com.msh.fastdevelop.sys.client.qo.RoleAuthorityMappingQO;
import com.msh.fastdevelop.sys.client.vo.RoleAuthorityMappingVO;
import com.msh.frame.client.common.CommonResult;
import java.util.List;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-18 20:51:33
 */
public interface RoleAuthorityMappingService extends BaseService<RoleAuthorityMappingPO,RoleAuthorityMappingQO> {
        CommonResult<Boolean> logicDelete(Long id);
        CommonResult<List<RoleAuthorityMappingVO>> listRoleAuthorityMappingVO(RoleAuthorityMappingQO param);
        CommonResult<Boolean> updateRoleAuth(RoleVO roleVO);
        CommonResult<Boolean> deleteByUserId(long param);
}
