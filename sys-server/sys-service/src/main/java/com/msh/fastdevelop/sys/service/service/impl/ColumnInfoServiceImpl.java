package com.msh.fastdevelop.sys.service.service.impl;;

import com.msh.fastdevelop.sys.client.po.ColumnDictPO;
import com.msh.fastdevelop.sys.client.qo.ColumnDictQO;
import com.msh.fastdevelop.sys.client.vo.ColumnDictVO;
import com.msh.frame.client.base.BaseServiceImpl;
import com.msh.fastdevelop.sys.client.po.ColumnInfoPO;
import com.msh.fastdevelop.sys.client.qo.ColumnInfoQO;
import com.msh.fastdevelop.sys.client.vo.ColumnInfoVO;
import com.msh.fastdevelop.sys.service.dao.ColumnInfoDao;
import com.msh.fastdevelop.sys.service.service.ColumnInfoService;
import com.msh.fastdevelop.sys.service.service.*;
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
 * @date 2019-11-14 16:17:56
 */
@Service
@Slf4j
public class ColumnInfoServiceImpl extends BaseServiceImpl<ColumnInfoPO,ColumnInfoQO> implements ColumnInfoService {
    @Autowired
    private ColumnInfoDao columnInfoDao;
    @Autowired
    private ColumnInfoService columnInfoService;
    @Autowired
    private ColumnDictService columnDictService;
    @Autowired
    private IdGenerateable idGenerateable;
    @Autowired
    private AuditService auditService;

    @Override
    public CommonResult<Boolean> update(ColumnInfoPO param) {
        ColumnInfoPO parmDB = columnInfoService.get(param.getId()).getResult();
        auditService.audit(param, parmDB);
        return super.update(param);
    }

    @Override
    public CommonResult<List<ColumnInfoPO>> list(ColumnInfoQO param) {
        if(null == param.getStatus()){
            param.setEgtStatus(0);
        }
        return super.list(param);
    }

    @Override
    public CommonResult<Boolean> insert(ColumnInfoPO param) {
        param.setId(idGenerateable.getUniqueID());
        return super.insert(param);
    }

    @Override
    public CommonResult<Boolean> insertCollection(Collection<ColumnInfoPO> param) {
        Iterator<ColumnInfoPO> iterator = param.iterator();
        while(iterator.hasNext()){
            iterator.next().setId(idGenerateable.getUniqueID());
        }
        return super.insertCollection(param);
    }

    @Override
    public CommonResult<Boolean> logicDelete(Long param) {
        long result = columnInfoDao.logicDelete(param);
        if (result == 0L) {
            return CommonResult.errorReturn(CommonCode.PARAM_EXPIRE);
        } else {
            return CommonResult.successReturn(true);
        }
    }

    @Override
    public CommonResult<List<ColumnInfoVO>> listColumnInfoVO(ColumnInfoQO param) {
        List<ColumnInfoPO> columnInfoPOList = columnInfoService.list(param).getResult();
        if(null == columnInfoPOList || columnInfoPOList.size() == 0) {
            return CommonResult.successReturn(CollectionUtils.EMPTY_LIST);
        }
        List<ColumnInfoVO> columnInfoVOList = new ArrayList<>(columnInfoPOList.size());
        for(ColumnInfoPO columnInfoPO: columnInfoPOList){
            ColumnInfoVO columnInfoVO = new ColumnInfoVO(columnInfoPO);
            columnInfoVOList.add(columnInfoVO);
        }

        return CommonResult.successReturn(columnInfoVOList);
    }

    @Override
    public CommonResult<ColumnInfoVO> getColumnInfoVO(String tableName, String columnName) {
        ColumnInfoQO columnInfoQO = new ColumnInfoQO();
        columnInfoQO.setTableName(tableName);
        columnInfoQO.setColumnName(columnName);
        CommonResult<ColumnInfoPO> columnInfoPOCommonResult = columnInfoService.listOne(columnInfoQO);
        ColumnInfoPO columnInfoPO = columnInfoPOCommonResult.getResult();
        if(null == columnInfoPO){
            return null;
        }
        ColumnInfoVO columnInfoVO = new ColumnInfoVO(columnInfoPO);
        this.setColumnInfoVOColumnDictPOList(columnInfoVO);
        return CommonResult.successReturn(columnInfoVO);
    }
    private void setColumnInfoVOColumnDictPOList(ColumnInfoVO columnInfoVO){
        Long columnInfoId = columnInfoVO.getId();
        ColumnDictQO columnDictQO = new ColumnDictQO();
        columnDictQO.setColumnId(columnInfoId);
        columnDictQO.setStatus(1);
        CommonResult<List<ColumnDictPO>> listCommonResult = columnDictService.list(columnDictQO);
        columnInfoVO.setColumnDictPOList(listCommonResult.getResult());
    }
}
