package com.msh.fastdevelop.sys.service.service.impl;;

import com.msh.fastdevelop.sys.client.po.ColumnDictPO;
import com.msh.fastdevelop.sys.service.wrapper.CacheWrapper;
import com.msh.frame.client.base.BaseServiceImpl;
import com.msh.fastdevelop.sys.client.po.AuthorityPO;
import com.msh.fastdevelop.sys.client.qo.AuthorityQO;
import com.msh.fastdevelop.sys.client.vo.AuthorityVO;
import com.msh.fastdevelop.sys.service.dao.AuthorityDao;
import com.msh.fastdevelop.sys.service.service.AuthorityService;
import com.msh.frame.client.common.CommonResult;
import com.msh.frame.client.common.CommonCode;
import com.msh.frame.common.common.IdGenerateable;
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
public class AuthorityServiceImpl extends BaseServiceImpl<AuthorityPO,AuthorityQO> implements AuthorityService {
    @Autowired
    private AuthorityDao authorityDao;
    @Autowired
    private AuthorityService authorityService;
    @Autowired
    private IdGenerateable idGenerateable;
    @Autowired
    private CacheWrapper cacheWrapper;

    @Override
    public CommonResult<List<AuthorityPO>> list(AuthorityQO param) {
        param.setEgtStatus(0);
        return super.list(param);
    }

    @Override
    public CommonResult<Boolean> insert(AuthorityPO param) {
        Long parentId = param.getParentId();
        if(parentId > 0){
            AuthorityPO authorityPO = authorityService.get(parentId).getResult();
            if(null == authorityPO){
                return CommonResult.errorReturn(CommonCode.PARAM_ERROR);
            }
            param.setLayer(authorityPO.getLayer()+1);
        }else {
            param.setLayer(1);
        }
        param.setId(idGenerateable.getUniqueID());
        return super.insert(param);
    }

    @Override
    public CommonResult<Boolean> insertCollection(Collection<AuthorityPO> authorityPOCollection) {
        Iterator<AuthorityPO> iterator = authorityPOCollection.iterator();
        while(iterator.hasNext()){
            AuthorityPO param = iterator.next();
            param.setId(idGenerateable.getUniqueID());
            Long parentId = param.getParentId();
            if(parentId > 0){
                AuthorityPO authorityPO = authorityService.get(parentId).getResult();
                if(null == authorityPO){
                    return CommonResult.errorReturn(CommonCode.PARAM_ERROR);
                }
                param.setLayer(authorityPO.getLayer()+1);
            }else {
                param.setLayer(1);
            }
        }
        return super.insertCollection(authorityPOCollection);
    }

    @Override
    public CommonResult<Boolean> logicDelete(Long param) {
        long result = authorityDao.logicDelete(param);
        if (result == 0L) {
            return CommonResult.errorReturn(CommonCode.PARAM_EXPIRE);
        } else {
            return CommonResult.successReturn(true);
        }
    }

    @Override
    public CommonResult<Boolean> update(AuthorityPO param) {
        Long parentId = param.getParentId();
        if(null != parentId){
            if(parentId > 0){
                AuthorityPO authorityPO = authorityService.get(parentId).getResult();
                if(null == authorityPO){
                    return CommonResult.errorReturn(CommonCode.PARAM_ERROR);
                }
                param.setLayer(authorityPO.getLayer()+1);
            }else {
                param.setLayer(1);
            }

        }
        return super.update(param);
    }

    @Override
    public CommonResult<List<AuthorityVO>> listAuthorityVO(AuthorityQO param) {
        List<AuthorityPO> authorityPOList = authorityService.list(param).getResult();
        if(null == authorityPOList || authorityPOList.size() == 0) {
            return CommonResult.successReturn(CollectionUtils.EMPTY_LIST);
        }
        List<AuthorityVO> authorityVOList = new ArrayList<>(authorityPOList.size());
        for(AuthorityPO authorityPO: authorityPOList){
            AuthorityVO authorityVO = new AuthorityVO(authorityPO);
            authorityVOList.add(authorityVO);
        }
        this.setTypeMeaning(authorityVOList);
        //只获取顶级列表
        authorityVOList = this.getLayer1ListAndSetChildren(authorityVOList);

        return CommonResult.successReturn(authorityVOList);
    }

    private void setTypeMeaning(List<AuthorityVO> authorityVOList){
        List<ColumnDictPO> columnDictPOList = cacheWrapper.getDictList("sys_authority", "type");
        Map<Integer, String> map = new HashMap<>();
        for(ColumnDictPO columnDictPO: columnDictPOList){
            map.put(columnDictPO.getDatabaseValue(), columnDictPO.getMeaning());
        }
        for(AuthorityVO authorityVO: authorityVOList){
            String str = map.get(authorityVO.getType());
            authorityVO.setTypeMeaning(str);
        }
    }

    /**
     * 获取一级列表并设置Children
     * @param authorityVOList
     * @return
     */
    private List<AuthorityVO> getLayer1ListAndSetChildren(List<AuthorityVO> authorityVOList){
        Map<Long,List<AuthorityVO>> map = new HashMap<>();
        Map<Long, AuthorityVO> idMap = new HashMap<>();
        for(AuthorityVO authorityVO: authorityVOList){
            idMap.put(authorityVO.getId(), authorityVO);
            List<AuthorityVO> list = map.get(authorityVO.getParentId());
            if(null == list){
                list = new LinkedList<>();
                map.put(authorityVO.getParentId(), list);
            }
            list.add(authorityVO);
        }
        List<AuthorityVO> list = map.get(0L);
        if(null != list){
            for(AuthorityVO authorityVO: authorityVOList){
                childrenRecursion(authorityVO, map, idMap);
            }
        }
        return list;
    }

    private void childrenRecursion(AuthorityVO authorityVO, Map<Long,List<AuthorityVO>> map, Map<Long, AuthorityVO> idMap){
        AuthorityVO parentAuthorityVO = idMap.get(authorityVO.getParentId());
        if(null != parentAuthorityVO){
            authorityVO.setParentName(parentAuthorityVO.getName());
        }
        List<AuthorityVO> authorityVOList = map.get(authorityVO.getId());
        if(null == authorityVOList || authorityVOList.size() == 0){
            return;
        }
        authorityVO.setChildren(authorityVOList);
        for(AuthorityVO a: authorityVOList){
            childrenRecursion(a, map, idMap);
        }
    }
}
