package com.msh.fastdevelop.sys.service.service;;

import com.msh.frame.client.base.BaseService;
import com.msh.fastdevelop.sys.client.po.AuthorityUrlPO;
import com.msh.fastdevelop.sys.client.qo.AuthorityUrlQO;
import com.msh.fastdevelop.sys.client.vo.AuthorityUrlVO;
import com.msh.frame.client.common.CommonResult;
import java.util.List;
import java.util.Map;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-18 20:51:33
 */
public interface AuthorityUrlService extends BaseService<AuthorityUrlPO,AuthorityUrlQO> {
        CommonResult<Boolean> logicDelete(Long id);
        CommonResult<List<AuthorityUrlVO>> listAuthorityUrlVO(AuthorityUrlQO param);
        CommonResult<Map<Long,List<AuthorityUrlVO>>> listAllAuthorityUrlVOMap();
        CommonResult<Map<String, Integer>> getUrlAuthIdMap();
}
