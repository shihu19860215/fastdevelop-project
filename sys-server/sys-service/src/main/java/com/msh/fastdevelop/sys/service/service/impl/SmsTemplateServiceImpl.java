package com.msh.fastdevelop.sys.service.service.impl;;

import com.msh.frame.client.base.BaseServiceImpl;
import com.msh.fastdevelop.sys.client.po.SmsTemplatePO;
import com.msh.fastdevelop.sys.client.qo.SmsTemplateQO;
import com.msh.fastdevelop.sys.client.vo.SmsTemplateVO;
import com.msh.fastdevelop.sys.service.dao.SmsTemplateDao;
import com.msh.fastdevelop.sys.service.service.SmsTemplateService;
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
 * @date 2019-06-19 17:19:49
 */
@Service
@Slf4j
public class SmsTemplateServiceImpl extends BaseServiceImpl<SmsTemplatePO,SmsTemplateQO> implements SmsTemplateService {
    @Autowired
    private SmsTemplateDao smsTemplateDao;
    @Autowired
    private SmsTemplateService smsTemplateService;
    @Autowired
    private IdGenerateable idGenerateable;

    @Override
    public CommonResult<List<SmsTemplatePO>> list(SmsTemplateQO param) {
        param.setEgtStatus(0);
        return super.list(param);
    }

    @Override
    public CommonResult<Boolean> insert(SmsTemplatePO param) {
        param.setId(idGenerateable.getUniqueID());
        return super.insert(param);
    }

    @Override
    public CommonResult<Boolean> insertCollection(Collection<SmsTemplatePO> param) {
        Iterator<SmsTemplatePO> iterator = param.iterator();
        while(iterator.hasNext()){
            iterator.next().setId(idGenerateable.getUniqueID());
        }
        return super.insertCollection(param);
    }

    @Override
    public CommonResult<Boolean> logicDelete(Long param) {
        long result = smsTemplateDao.logicDelete(param);
        if (result == 0L) {
            return CommonResult.errorReturn(CommonCode.PARAM_EXPIRE);
        } else {
            return CommonResult.successReturn(true);
        }
    }

    @Override
    public CommonResult<List<SmsTemplateVO>> listSmsTemplateVO(SmsTemplateQO param) {
        List<SmsTemplatePO> smsTemplatePOList = smsTemplateService.list(param).getResult();
        if(null == smsTemplatePOList || smsTemplatePOList.size() == 0) {
            return CommonResult.successReturn(CollectionUtils.EMPTY_LIST);
        }
        List<SmsTemplateVO> smsTemplateVOList = new ArrayList<>(smsTemplatePOList.size());
        for(SmsTemplatePO smsTemplatePO: smsTemplatePOList){
            SmsTemplateVO smsTemplateVO = new SmsTemplateVO(smsTemplatePO);
            smsTemplateVOList.add(smsTemplateVO);
        }

        return CommonResult.successReturn(smsTemplateVOList);
    }
}
