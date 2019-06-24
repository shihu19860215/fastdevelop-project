package com.msh.fastdevelop.sys.service.service;;

import com.msh.frame.client.base.BaseService;
import com.msh.fastdevelop.sys.client.po.AuthorityPO;
import com.msh.fastdevelop.sys.client.qo.AuthorityQO;
import com.msh.fastdevelop.sys.client.vo.AuthorityVO;
import com.msh.frame.client.common.CommonResult;
import java.util.List;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-18 20:51:33
 */
public interface AuthorityService extends BaseService<AuthorityPO,AuthorityQO> {
        CommonResult<Boolean> logicDelete(Long id);
        CommonResult<List<AuthorityVO>> listAuthorityVO(AuthorityQO param);
}
