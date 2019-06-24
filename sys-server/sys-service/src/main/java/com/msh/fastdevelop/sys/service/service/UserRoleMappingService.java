package com.msh.fastdevelop.sys.service.service;;

import com.msh.frame.client.base.BaseService;
import com.msh.fastdevelop.sys.client.po.UserRoleMappingPO;
import com.msh.fastdevelop.sys.client.qo.UserRoleMappingQO;
import com.msh.fastdevelop.sys.client.vo.UserRoleMappingVO;
import com.msh.frame.client.common.CommonResult;
import java.util.List;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-18 20:51:33
 */
public interface UserRoleMappingService extends BaseService<UserRoleMappingPO,UserRoleMappingQO> {
        CommonResult<Boolean> logicDelete(Long id);
        CommonResult<List<UserRoleMappingVO>> listUserRoleMappingVO(UserRoleMappingQO param);
        CommonResult<Boolean> deleteByUserId(long param);
}
