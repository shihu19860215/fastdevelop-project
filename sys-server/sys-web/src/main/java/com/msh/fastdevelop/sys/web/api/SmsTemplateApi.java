package com.msh.fastdevelop.sys.web.api;

import com.msh.frame.client.common.CommonResult;
import com.msh.frame.web.base.BaseController;
import com.msh.fastdevelop.sys.client.po.SmsTemplatePO;
import com.msh.fastdevelop.sys.client.qo.SmsTemplateQO;
import com.msh.fastdevelop.sys.client.vo.SmsTemplateVO;
import com.msh.fastdevelop.sys.service.service.SmsTemplateService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;


/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-18 20:51:33
 */
@Api(description = "短信模板-api相关接口")
@Slf4j
@RestController
@RequestMapping("/api/sys/smstemplate")
public class SmsTemplateApi extends BaseController<SmsTemplatePO, SmsTemplateQO> {

    @Autowired
    private SmsTemplateService smsTemplateService;

    /**
     * 通用查询逻辑
     * @param q 查询对象
     * @return
     */
    @ApiOperation(value = "通用查询逻辑", httpMethod = "GET", notes = "通用查询逻辑")
    @RequestMapping("list")
    public CommonResult<List<SmsTemplatePO>> list(@ModelAttribute("pojo")SmsTemplateQO q) {
        CommonResult<List<SmsTemplatePO>> query = smsTemplateService.list(q);
        return query;
    }

    /**
     * 获取详情
     * @return
     */
    @ApiOperation(value = "获取详情", httpMethod = "GET", notes = "获取详情")
    @RequestMapping("get")
    public CommonResult<SmsTemplatePO> get(@RequestParam("id") Long id) {
        return smsTemplateService.get(id);
    }

    /**
     * 通用更新逻辑
     * @param t
     * @return
     */
    @ApiOperation(value = "通用更新逻辑", httpMethod = "POST", notes = "通用更新逻辑")
    @RequestMapping("update")
    public CommonResult<Boolean> update(@RequestBody SmsTemplatePO t) {
        return smsTemplateService.update(t);
    }

    /**
     * 通用删除逻辑
     * @param id
     * @return
     */
    @ApiOperation(value = "通用删除逻辑", httpMethod = "GET", notes = "通用删除逻辑")
    @RequestMapping("delete")
    public CommonResult<Boolean> delete(@RequestParam("id") Long id) {
        return smsTemplateService.delete(id);
    }

    /**
     * 通用插入逻辑
     * @param t
     * @return
     */
    @ApiOperation(value = "通用插入逻辑", httpMethod = "POST", notes = "通用插入逻辑")
    @RequestMapping("insert")
    public CommonResult<Boolean> insert(@RequestBody SmsTemplatePO t) {
        return smsTemplateService.insert(t);
    }



    @ApiOperation(value = "逻辑删除", httpMethod = "GET", notes = "逻辑删除")
    @RequestMapping("logicdelete")
    public CommonResult<Boolean> logicDelete(@RequestParam("id") Long id) {
        return smsTemplateService.logicDelete(id);
    }


    @ApiOperation(value = "vo列表查询", httpMethod = "GET", notes = "vo列表查询")
    @RequestMapping("listvo")
    public CommonResult<List<SmsTemplateVO>> listSmsTemplateVO(@ModelAttribute("pojo")SmsTemplateQO q) {
        return smsTemplateService.listSmsTemplateVO(q);
    }
}
