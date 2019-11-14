package com.msh.fastdevelop.sys.service.service.impl;;

import com.msh.fastdevelop.sys.client.po.AuditConfigurePO;
import com.msh.fastdevelop.sys.client.qo.AuditConfigureQO;
import com.msh.fastdevelop.sys.client.vo.AuditConfigureVO;
import com.msh.fastdevelop.sys.service.service.AuditConfigureService;
import com.msh.frame.client.base.BasePO;
import com.msh.frame.client.base.BaseServiceImpl;
import com.msh.fastdevelop.sys.client.po.AuditPO;
import com.msh.fastdevelop.sys.client.qo.AuditQO;
import com.msh.fastdevelop.sys.client.vo.AuditVO;
import com.msh.fastdevelop.sys.service.dao.AuditDao;
import com.msh.fastdevelop.sys.service.service.AuditService;
import com.msh.frame.client.common.CommonResult;
import com.msh.frame.client.common.CommonCode;
import com.msh.frame.client.exception.ServiceRuntimeException;
import com.msh.frame.common.common.IdGenerateable;
import com.msh.frame.common.util.CollectionUtils;
import com.msh.frame.common.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-29 14:15:29
 */
@Service
@Slf4j
public class AuditServiceImpl extends BaseServiceImpl<AuditPO,AuditQO> implements AuditService {
    @Autowired
    private AuditDao auditDao;
    @Autowired
    private AuditService auditService;
    @Autowired
    private IdGenerateable idGenerateable;
    @Autowired
    private AuditConfigureService auditConfigureService;

    @Override
    public CommonResult<List<AuditPO>> list(AuditQO param) {
        if(null == param.getStatus()){
            param.setEgtStatus(0);
        }
        return super.list(param);
    }

    @Override
    public CommonResult<Boolean> insert(AuditPO param) {
        param.setId(idGenerateable.getUniqueID());
        return super.insert(param);
    }

    @Override
    public CommonResult<Boolean> insertCollection(Collection<AuditPO> param) {
        Iterator<AuditPO> iterator = param.iterator();
        while(iterator.hasNext()){
            iterator.next().setId(idGenerateable.getUniqueID());
        }
        return super.insertCollection(param);
    }

    @Override
    public CommonResult<Boolean> logicDelete(Long param) {
        long result = auditDao.logicDelete(param);
        if (result == 0L) {
            return CommonResult.errorReturn(CommonCode.PARAM_EXPIRE);
        } else {
            return CommonResult.successReturn(true);
        }
    }

    @Override
    public CommonResult<List<AuditVO>> listAuditVO(AuditQO param) {
        List<AuditPO> auditPOList = auditService.list(param).getResult();
        if(auditPOList.isEmpty()) {
            return CommonResult.successReturn(CollectionUtils.EMPTY_LIST);
        }
        List<AuditVO> auditVOList = new ArrayList<>(auditPOList.size());
        for(AuditPO auditPO: auditPOList){
            AuditVO auditVO = new AuditVO(auditPO);
            auditVOList.add(auditVO);
        }
        this.setMeaning(auditVOList);

        return CommonResult.successReturn(auditVOList);
    }

    private void setMeaning(List<AuditVO> auditVOList){
        AuditConfigureQO auditConfigureQO = new AuditConfigureQO();
        List<AuditConfigurePO> auditConfigurePOList = auditConfigureService.list(auditConfigureQO).getResult();
        final Map<String, AuditConfigurePO> map = new HashMap<>();
        auditConfigurePOList.forEach(auditConfigurePO -> {
            map.put(auditConfigurePO.getClassName()+auditConfigurePO.getFieldName(), auditConfigurePO);
        });
        auditVOList.forEach(auditVO -> {
            AuditConfigurePO auditConfigurePO = map.get(auditVO.getClassName() + auditVO.getFieldName());
            if(null != auditConfigurePO){
                auditVO.setMeaning(auditConfigurePO.getMeaning());
            }
        });
    }

    @Override
    public CommonResult<BasePO> audit(BasePO newPO, BasePO oldPO){
        BasePO basePO = null;
        String simpleName = oldPO.getClass().getSimpleName();
        AuditConfigureQO auditConfigureQO = new AuditConfigureQO();
        auditConfigureQO.setClassName(simpleName);
        List<AuditConfigurePO> auditConfigurePOList = auditConfigureService.list(auditConfigureQO).getResult();
        if(null != auditConfigurePOList && auditConfigurePOList.size()>0){
            List<AuditPO> auditPOList = new LinkedList<>();
            for(AuditConfigurePO auditConfigurePO: auditConfigurePOList){
                try {
                    String upperCaseFieldName = StringUtil.toUpperCaseFirstOne(auditConfigurePO.getFieldName());
                    Method getMethod = newPO.getClass().getMethod("get" + upperCaseFieldName);
                    Object newO = getMethod.invoke(newPO);
                    Object oldO = getMethod.invoke(oldPO);
                    if(
                            (null == newO && null != oldO)
                            || (null != newO && !newO.equals(oldO))
                            ){
                        if(null == newO){
                            newO = "";
                        }
                        if(null == oldO){
                            oldO = "";
                        }
                        AuditPO auditPO = new AuditPO();
                        auditPO.setBeforeValue(oldO.toString());
                        auditPO.setAfterValue(newO.toString());
                        auditPO.setClassName(auditConfigurePO.getClassName());
                        auditPO.setFieldName(auditConfigurePO.getFieldName());
                        auditPO.setPrimaryKeyId(newPO.getId());
                        auditPO.setOperatorId(newPO.getOperatorId());
                        auditPO.setComment(StringUtil.EMPTY);
                        auditPO.setStatus(1);
                        auditPOList.add(auditPO);
                        if(null == basePO){
                            basePO = oldPO.getClass().newInstance();
                        }

                        Method setMethod = oldPO.getClass().getMethod("set" + upperCaseFieldName,getMethod.getReturnType());
                        setMethod.invoke(basePO, newO);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    throw new ServiceRuntimeException(new CommonResult(CommonCode.SYSTEM_ERROR));
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                    throw new ServiceRuntimeException(new CommonResult(CommonCode.SYSTEM_ERROR));
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                    throw new ServiceRuntimeException(new CommonResult(CommonCode.SYSTEM_ERROR));
                } catch (InstantiationException e) {
                    e.printStackTrace();
                    throw new ServiceRuntimeException(new CommonResult(CommonCode.SYSTEM_ERROR));
                }
            }
            if(auditPOList.size() > 0){
                auditService.insertCollection(auditPOList);
            }
        }

        if(null != basePO){
            basePO.setId(newPO.getId());
            basePO.setUpdateVersion(newPO.getUpdateVersion());
        }

        return CommonResult.successReturn(basePO);
    }
}
