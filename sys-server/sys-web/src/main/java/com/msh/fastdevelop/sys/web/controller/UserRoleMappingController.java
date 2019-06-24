package com.msh.fastdevelop.sys.web.controller;

import com.msh.frame.client.common.CommonResult;
import com.msh.frame.web.base.BaseController;
import com.msh.fastdevelop.sys.client.po.UserRoleMappingPO;
import com.msh.fastdevelop.sys.client.qo.UserRoleMappingQO;
import com.msh.fastdevelop.sys.service.service.UserRoleMappingService;
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
@Api(description = "-controller相关接口")
@RestController
@RequestMapping("/userrolemapping")
@Slf4j
public class UserRoleMappingController extends BaseController<UserRoleMappingPO, UserRoleMappingQO> {

    @Autowired
    private UserRoleMappingService userRoleMappingService;


    /**
     * 通用查询逻辑
     * @param q 查询对象
     * @return
     */
    @ApiOperation(value = "通用查询逻辑", httpMethod = "GET", notes = "通用查询逻辑")
    @RequestMapping("list")
    public CommonResult<List<UserRoleMappingPO>> list(@ModelAttribute("pojo")UserRoleMappingQO q) {
        CommonResult<List<UserRoleMappingPO>> query = userRoleMappingService.list(q);
        return query;
    }

    /**
     * 获取详情
     * @return
     */
    @ApiOperation(value = "获取详情", httpMethod = "GET", notes = "获取详情")
    @RequestMapping("get")
    public CommonResult<UserRoleMappingPO> get(@RequestParam("id") Long id) {
        return userRoleMappingService.get(id);
    }

    /**
     * 通用更新逻辑
     * @param t
     * @return
     */
    @ApiOperation(value = "通用更新逻辑", httpMethod = "POST", notes = "通用更新逻辑")
    @RequestMapping("update")
    public CommonResult<Boolean> update(@RequestBody UserRoleMappingPO t) {
        return userRoleMappingService.update(t);
    }

    /**
     * 通用删除逻辑
     * @param id
     * @return
     */
    @ApiOperation(value = "通用删除逻辑", httpMethod = "GET", notes = "通用删除逻辑")
    @RequestMapping("delete")
    public CommonResult<Boolean> delete(@RequestParam("id") Long id) {
        return userRoleMappingService.delete(id);
    }

    /**
     * 通用插入逻辑
     * @param t
     * @return
     */
    @ApiOperation(value = "通用插入逻辑", httpMethod = "POST", notes = "通用插入逻辑")
    @RequestMapping("insert")
    public CommonResult<Boolean> insert(@RequestBody UserRoleMappingPO t) {
        return userRoleMappingService.insert(t);
    }
}
