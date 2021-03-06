package com.msh.fastdevelop.sys.service.service.impl;;

import com.msh.fastdevelop.sys.client.po.AuthorityPO;
import com.msh.fastdevelop.sys.client.po.ColumnDictPO;
import com.msh.fastdevelop.sys.client.qo.AuthorityQO;
import com.msh.fastdevelop.sys.client.qo.ColumnDictQO;
import com.msh.fastdevelop.sys.client.qo.ColumnInfoQO;
import com.msh.fastdevelop.sys.client.vo.ColumnInfoVO;
import com.msh.fastdevelop.sys.service.service.AuthorityService;
import com.msh.fastdevelop.sys.service.service.ColumnDictService;
import com.msh.fastdevelop.sys.service.service.ColumnInfoService;
import com.msh.frame.client.base.BaseServiceImpl;
import com.msh.fastdevelop.sys.client.po.AuthorityUrlPO;
import com.msh.fastdevelop.sys.client.qo.AuthorityUrlQO;
import com.msh.fastdevelop.sys.client.vo.AuthorityUrlVO;
import com.msh.fastdevelop.sys.service.dao.AuthorityUrlDao;
import com.msh.fastdevelop.sys.service.service.AuthorityUrlService;
import com.msh.frame.client.common.CommonResult;
import com.msh.frame.client.common.CommonCode;
import com.msh.frame.common.util.CollectionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-19 17:19:49
 */
@Service
@Slf4j
public class AuthorityUrlServiceImpl extends BaseServiceImpl<AuthorityUrlPO,AuthorityUrlQO> implements AuthorityUrlService {
    @Autowired
    private AuthorityUrlDao authorityUrlDao;
    @Autowired
    private AuthorityUrlService authorityUrlService;
    @Autowired
    private AuthorityService authorityService;
    @Autowired
    private ColumnInfoService columnInfoService;

    @Override
    public CommonResult<List<AuthorityUrlPO>> list(AuthorityUrlQO param) {
        if(null != param.getStatus()){
            param.setEgtStatus(0);
        }
        return super.list(param);
    }

    @Override
    public CommonResult<Boolean> logicDelete(Long param) {
        long result = authorityUrlDao.logicDelete(param);
        if (result == 0L) {
            return CommonResult.errorReturn(CommonCode.PARAM_EXPIRE);
        } else {
            return CommonResult.successReturn(true);
        }
    }


    @Override
    public CommonResult<List<AuthorityUrlVO>> listAuthorityUrlVO(AuthorityUrlQO param) {
        List<AuthorityUrlPO> authorityUrlPOList = authorityUrlService.list(param).getResult();
        if(null == authorityUrlPOList || authorityUrlPOList.size() == 0) {
            return CommonResult.successReturn(Collections.emptyList());
        }
        List<AuthorityUrlVO> authorityUrlVOList = new ArrayList<>(authorityUrlPOList.size());
        for(AuthorityUrlPO authorityUrlPO: authorityUrlPOList){
            AuthorityUrlVO authorityUrlVO = new AuthorityUrlVO(authorityUrlPO);
            authorityUrlVOList.add(authorityUrlVO);
        }
        this.setLinkAuth(authorityUrlVOList);
        this.setAuthorityName(authorityUrlVOList);

        return CommonResult.successReturn(authorityUrlVOList);
    }

    private void setAuthorityName(List<AuthorityUrlVO> authorityUrlVOList){
        List<AuthorityPO> authorityPOList = authorityService.list(new AuthorityQO()).getResult();
        AuthorityPO a = new AuthorityPO();
        a.setId(0L);
        a.setName("内置权限");
        authorityPOList.add(a);
        Map<Long, AuthorityPO> map = new HashMap<>();
        for(AuthorityPO authorityPO: authorityPOList){
            map.put(authorityPO.getId(), authorityPO);
        }
        for(AuthorityUrlVO authorityUrlVO: authorityUrlVOList){
            authorityUrlVO.setAuthorityName(map.get(authorityUrlVO.getAuthorityId()).getName());
        }
    }

    private void setLinkAuth(List<AuthorityUrlVO> authorityUrlVOList){
        ColumnInfoVO columnInfoVO = columnInfoService.getColumnInfoVO("sys_authority_url","link_auth").getResult();
        Map<Integer,String> dictMap = new HashMap<>();
        for(ColumnDictPO columnDictPO: columnInfoVO.getColumnDictPOList()){
            dictMap.put(columnDictPO.getValue(),columnDictPO.getMeaning());
        }
        for(AuthorityUrlVO authorityUrlVO: authorityUrlVOList){
            authorityUrlVO.setLinkAuthMeaning(dictMap.get(authorityUrlVO.getLinkAuth()));
        }
    }

    @Override
    public CommonResult<Map<Long,List<AuthorityUrlVO>>> listAllAuthorityUrlVOMap(){
        List<AuthorityUrlVO> authorityUrlVOList = authorityUrlService.listAuthorityUrlVO(new AuthorityUrlQO()).getResult();
        Map<Long,List<AuthorityUrlVO>> map = new HashMap<>();
        for(AuthorityUrlVO authorityUrlVO: authorityUrlVOList){
            Long authorityId = authorityUrlVO.getAuthorityId();
            List<AuthorityUrlVO> list = map.get(authorityId);
            if(null == list){
                list = new LinkedList<>();
                map.put(authorityId, list);
            }
            list.add(authorityUrlVO);
        }
        return CommonResult.successReturn(map);
    }

    @Override
    public CommonResult<Map<String, Integer>> getUrlAuthIdMap() {
        Map<String, Integer> map ;
        List<AuthorityUrlPO> authorityUrlPOList = authorityUrlService.list(new AuthorityUrlQO()).getResult();
        if(null == authorityUrlPOList){
            map = Collections.emptyMap();
        }else {
            map = new HashMap<>(authorityUrlPOList.size()*2);
            for(AuthorityUrlPO authorityUrlPO: authorityUrlPOList){
                map.put(authorityUrlPO.getUrl(),authorityUrlPO.getLinkAuth());
            }
        }
        return CommonResult.successReturn(map);
    }
}
