package com.msh.fastdevelop.sys.service.service;;

import com.msh.frame.client.base.BaseService;
import com.msh.fastdevelop.sys.client.po.RolePO;
import com.msh.fastdevelop.sys.client.qo.RoleQO;
import com.msh.fastdevelop.sys.client.vo.RoleVO;
import com.msh.frame.client.common.CommonResult;
import java.util.List;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-18 20:51:33
 */
public interface RoleService extends BaseService<RolePO,RoleQO> {
        CommonResult<Boolean> logicDelete(Long id);
        CommonResult<List<RoleVO>> listRoleVO(RoleQO param);
}
