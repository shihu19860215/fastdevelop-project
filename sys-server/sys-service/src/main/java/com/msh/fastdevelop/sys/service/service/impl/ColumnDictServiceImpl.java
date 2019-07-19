package com.msh.fastdevelop.sys.service.service.impl;;

import com.msh.frame.client.base.BaseServiceImpl;
import com.msh.fastdevelop.sys.client.po.ColumnDictPO;
import com.msh.fastdevelop.sys.client.qo.ColumnDictQO;
import com.msh.fastdevelop.sys.client.vo.ColumnDictVO;
import com.msh.fastdevelop.sys.service.dao.ColumnDictDao;
import com.msh.fastdevelop.sys.service.service.ColumnDictService;
import com.msh.frame.client.common.CommonResult;
import com.msh.frame.client.common.CommonCode;
import com.msh.frame.common.util.CollectionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-19 20:58:20
 */
@Service
@Slf4j
public class ColumnDictServiceImpl extends BaseServiceImpl<ColumnDictPO,ColumnDictQO> implements ColumnDictService {
    @Autowired
    private ColumnDictDao columnDictDao;
    @Autowired
    private ColumnDictService columnDictService;

    @Override
    public CommonResult<List<ColumnDictPO>> list(ColumnDictQO param) {
        if(null == param.getStatus()){
            param.setEgtStatus(0);
        }
        return super.list(param);
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
            return CommonResult.successReturn(CollectionUtils.EMPTY_LIST);
        }
        List<ColumnDictVO> columnDictVOList = new ArrayList<>(columnDictPOList.size());
        for(ColumnDictPO columnDictPO: columnDictPOList){
            ColumnDictVO columnDictVO = new ColumnDictVO(columnDictPO);
            columnDictVOList.add(columnDictVO);
        }

        return CommonResult.successReturn(columnDictVOList);
    }
}
