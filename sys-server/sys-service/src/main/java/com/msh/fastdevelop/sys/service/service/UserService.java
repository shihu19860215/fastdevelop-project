package com.msh.fastdevelop.sys.service.service;;

import com.msh.fastdevelop.sys.client.model.UserInfo;
import com.msh.frame.client.base.BaseService;
import com.msh.fastdevelop.sys.client.po.UserPO;
import com.msh.fastdevelop.sys.client.qo.UserQO;
import com.msh.fastdevelop.sys.client.vo.UserVO;
import com.msh.frame.client.common.CommonResult;
import java.util.List;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-18 20:51:33
 */
public interface UserService extends BaseService<UserPO,UserQO> {
        CommonResult<Boolean> logicDelete(Long id);
        CommonResult<List<UserVO>> listUserVO(UserQO param);
        CommonResult<Boolean> updateSysUserVO(UserVO userVO);
        CommonResult<Boolean> insertSysUserVO(UserVO userVO);
        CommonResult<UserInfo> getUserInfo(String username, String password);

}
