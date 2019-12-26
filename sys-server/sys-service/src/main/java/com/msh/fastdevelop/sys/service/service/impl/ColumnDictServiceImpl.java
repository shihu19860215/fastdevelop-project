package com.msh.fastdevelop.sys.service.service.impl;;

import com.msh.frame.client.base.BaseServiceImpl;
import com.msh.fastdevelop.sys.client.po.ColumnDictPO;
import com.msh.fastdevelop.sys.client.qo.ColumnDictQO;
import com.msh.fastdevelop.sys.client.vo.ColumnDictVO;
import com.msh.fastdevelop.sys.service.dao.ColumnDictDao;
import com.msh.fastdevelop.sys.service.service.ColumnDictService;
import com.msh.fastdevelop.sys.service.service.*;
import com.msh.frame.client.common.CommonResult;
import com.msh.frame.client.common.CommonCode;
import com.msh.frame.interfaces.IdGenerateable;
import com.msh.frame.common.util.CollectionUtils;
import com.msh.frame.interfaces.IdGenerateable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-07-22 14:50:38
 */
@Service
@Slf4j
public class ColumnDictServiceImpl extends BaseServiceImpl<ColumnDictPO,ColumnDictQO> implements ColumnDictService {
    @Autowired
    private ColumnDictDao columnDictDao;
    @Autowired
    private ColumnDictService columnDictService;
    @Autowired
    private IdGenerateable idGenerateable;
    @Autowired
    private AuditService auditService;

    @Override
    public CommonResult<Boolean> update(ColumnDictPO param) {
        ColumnDictPO parmDB = columnDictService.get(param.getId()).getResult();
        auditService.audit(param, parmDB);
        return super.update(param);
    }

    @Override
    public CommonResult<List<ColumnDictPO>> list(ColumnDictQO param) {
        if(null != param.getStatus()){
            param.setEgtStatus(0);
        }
        return super.list(param);
    }

    @Override
    public CommonResult<Boolean> insert(ColumnDictPO param) {
        param.setId(idGenerateable.getUniqueID());
        return super.insert(param);
    }

    @Override
    public CommonResult<Boolean> insertCollection(Collection<ColumnDictPO> param) {
        Iterator<ColumnDictPO> iterator = param.iterator();
        while(iterator.hasNext()){
            iterator.next().setId(idGenerateable.getUniqueID());
        }
        return super.insertCollection(param);
    }

    @Override
    public CommonResult<Boolean> logicDelete(Long param) {
        long result = columnDictDao.logicDelete(param);
        if (result == 0L) {
            return CommonResult.errorReturn(CommonCode.PARAM_EXPIRE);
        } else {
            return CommonResult.successReturn(true);
        }
    }

    @Override
    public CommonResult<List<ColumnDictVO>> listColumnDictVO(ColumnDictQO param) {
        List<ColumnDictPO> columnDictPOList = columnDictService.list(param).getResult();
        if(null == columnDictPOList || columnDictPOList.size() == 0) {
            return CommonResult.successReturn(Collections.emptyList());
        }
        List<ColumnDictVO> columnDictVOList = new ArrayList<>(columnDictPOList.size());
        for(ColumnDictPO columnDictPO: columnDictPOList){
            ColumnDictVO columnDictVO = new ColumnDictVO(columnDictPO);
            columnDictVOList.add(columnDictVO);
        }

        return CommonResult.successReturn(columnDictVOList);
    }
}
