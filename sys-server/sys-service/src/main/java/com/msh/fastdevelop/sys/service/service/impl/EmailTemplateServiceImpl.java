package com.msh.fastdevelop.sys.service.service.impl;;

import com.msh.frame.client.base.BaseServiceImpl;
import com.msh.fastdevelop.sys.client.po.EmailTemplatePO;
import com.msh.fastdevelop.sys.client.qo.EmailTemplateQO;
import com.msh.fastdevelop.sys.client.vo.EmailTemplateVO;
import com.msh.fastdevelop.sys.service.dao.EmailTemplateDao;
import com.msh.fastdevelop.sys.service.service.EmailTemplateService;
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
public class EmailTemplateServiceImpl extends BaseServiceImpl<EmailTemplatePO,EmailTemplateQO> implements EmailTemplateService {
    @Autowired
    private EmailTemplateDao emailTemplateDao;
    @Autowired
    private EmailTemplateService emailTemplateService;
    @Autowired
    private IdGenerateable idGenerateable;

    @Override
    public CommonResult<List<EmailTemplatePO>> list(EmailTemplateQO param) {
        param.setEgtStatus(0);
        return super.list(param);
    }

    @Override
    public CommonResult<Boolean> insert(EmailTemplatePO param) {
        param.setId(idGenerateable.getUniqueID());
        return super.insert(param);
    }

    @Override
    public CommonResult<Boolean> insertCollection(Collection<EmailTemplatePO> param) {
        Iterator<EmailTemplatePO> iterator = param.iterator();
        while(iterator.hasNext()){
            iterator.next().setId(idGenerateable.getUniqueID());
        }
        return super.insertCollection(param);
    }

    @Override
    public CommonResult<Boolean> logicDelete(Long param) {
        long result = emailTemplateDao.logicDelete(param);
        if (result == 0L) {
            return CommonResult.errorReturn(CommonCode.PARAM_EXPIRE);
        } else {
            return CommonResult.successReturn(true);
        }
    }

    @Override
    public CommonResult<List<EmailTemplateVO>> listEmailTemplateVO(EmailTemplateQO param) {
        List<EmailTemplatePO> emailTemplatePOList = emailTemplateService.list(param).getResult();
        if(null == emailTemplatePOList || emailTemplatePOList.size() == 0) {
            return CommonResult.successReturn(CollectionUtils.EMPTY_LIST);
        }
        List<EmailTemplateVO> emailTemplateVOList = new ArrayList<>(emailTemplatePOList.size());
        for(EmailTemplatePO emailTemplatePO: emailTemplatePOList){
            EmailTemplateVO emailTemplateVO = new EmailTemplateVO(emailTemplatePO);
            emailTemplateVOList.add(emailTemplateVO);
        }

        return CommonResult.successReturn(emailTemplateVOList);
    }
}
