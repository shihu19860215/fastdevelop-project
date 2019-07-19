package com.msh.fastdevelop.sys.service.service.impl;;

import com.msh.frame.client.base.BaseServiceImpl;
import com.msh.fastdevelop.sys.client.po.AuditConfigurePO;
import com.msh.fastdevelop.sys.client.qo.AuditConfigureQO;
import com.msh.fastdevelop.sys.client.vo.AuditConfigureVO;
import com.msh.fastdevelop.sys.service.dao.AuditConfigureDao;
import com.msh.fastdevelop.sys.service.service.AuditConfigureService;
import com.msh.frame.client.common.CommonResult;
import com.msh.frame.client.common.CommonCode;
import com.msh.frame.common.common.IdGenerateable;
import com.msh.frame.common.util.CollectionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-29 14:15:29
 */
@Service
@Slf4j
public class AuditConfigureServiceImpl extends BaseServiceImpl<AuditConfigurePO,AuditConfigureQO> implements AuditConfigureService {
    @Autowired
    private AuditConfigureDao auditConfigureDao;
    @Autowired
    private AuditConfigureService auditConfigureService;
    @Autowired
    private IdGenerateable idGenerateable;

    @Override
    public CommonResult<List<AuditConfigurePO>> list(AuditConfigureQO param) {
        if(null == param.getStatus()){
            param.setEgtStatus(0);
        }
        return super.list(param);
    }

    @Override
    public CommonResult<Boolean> insert(AuditConfigurePO param) {
        param.setId(idGenerateable.getUniqueID());
        return super.insert(param);
    }

    @Override
    public CommonResult<Boolean> insertCollection(Collection<AuditConfigurePO> param) {
        Iterator<AuditConfigurePO> iterator = param.iterator();
        while(iterator.hasNext()){
            iterator.next().setId(idGenerateable.getUniqueID());
        }
        return super.insertCollection(param);
    }

    @Override
    public CommonResult<Boolean> logicDelete(Long param) {
        long result = auditConfigureDao.logicDelete(param);
        if (result == 0L) {
            return CommonResult.errorReturn(CommonCode.PARAM_EXPIRE);
        } else {
            return CommonResult.successReturn(true);
        }
    }

    @Override
    public CommonResult<List<AuditConfigureVO>> listAuditConfigureVO(AuditConfigureQO param) {
        List<AuditConfigurePO> auditConfigurePOList = auditConfigureService.list(param).getResult();
        if(null == auditConfigurePOList || auditConfigurePOList.size() == 0) {
            return CommonResult.successReturn(CollectionUtils.EMPTY_LIST);
        }
        List<AuditConfigureVO> auditConfigureVOList = new ArrayList<>(auditConfigurePOList.size());
        for(AuditConfigurePO auditConfigurePO: auditConfigurePOList){
            AuditConfigureVO auditConfigureVO = new AuditConfigureVO(auditConfigurePO);
            auditConfigureVOList.add(auditConfigureVO);
        }

        return CommonResult.successReturn(auditConfigureVOList);
    }
}
