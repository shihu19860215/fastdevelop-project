package com.msh.fastdevelop.sys.web.api;

import com.msh.fastdevelop.sys.client.vo.RoleVO;
import com.msh.frame.client.common.CommonResult;
import com.msh.frame.web.base.BaseController;
import com.msh.fastdevelop.sys.client.po.RoleAuthorityMappingPO;
import com.msh.fastdevelop.sys.client.qo.RoleAuthorityMappingQO;
import com.msh.fastdevelop.sys.client.vo.RoleAuthorityMappingVO;
import com.msh.fastdevelop.sys.service.service.RoleAuthorityMappingService;
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
@Api(description = "-api相关接口")
@Slf4j
@RestController
@RequestMapping("/api/sys/roleauthoritymapping")
public class RoleAuthorityMappingApi extends BaseController<RoleAuthorityMappingPO, RoleAuthorityMappingQO> {

    @Autowired
    private RoleAuthorityMappingService roleAuthorityMappingService;

    /**
     * 通用查询逻辑
     * @param q 查询对象
     * @return
     */
    @ApiOperation(value = "通用查询逻辑", httpMethod = "GET", notes = "通用查询逻辑")
    @RequestMapping("list")
    public CommonResult<List<RoleAuthorityMappingPO>> list(@ModelAttribute("pojo")RoleAuthorityMappingQO q) {
        CommonResult<List<RoleAuthorityMappingPO>> query = roleAuthorityMappingService.list(q);
        return query;
    }

    /**
     * 获取详情
     * @return
     */
    @ApiOperation(value = "获取详情", httpMethod = "GET", notes = "获取详情")
    @RequestMapping("get")
    public CommonResult<RoleAuthorityMappingPO> get(@RequestParam("id") Long id) {
        return roleAuthorityMappingService.get(id);
    }

    /**
     * 通用更新逻辑
     * @param t
     * @return
     */
    @ApiOperation(value = "通用更新逻辑", httpMethod = "POST", notes = "通用更新逻辑")
    @RequestMapping("update")
    public CommonResult<Boolean> update(@RequestBody RoleAuthorityMappingPO t) {
        return roleAuthorityMappingService.update(t);
    }

    /**
     * 通用删除逻辑
     * @param id
     * @return
     */
    @ApiOperation(value = "通用删除逻辑", httpMethod = "GET", notes = "通用删除逻辑")
    @RequestMapping("delete")
    public CommonResult<Boolean> delete(@RequestParam("id") Long id) {
        return roleAuthorityMappingService.delete(id);
    }

    /**
     * 通用插入逻辑
     * @param t
     * @return
     */
    @ApiOperation(value = "通用插入逻辑", httpMethod = "POST", notes = "通用插入逻辑")
    @RequestMapping("insert")
    public CommonResult<Boolean> insert(@RequestBody RoleAuthorityMappingPO t) {
        return roleAuthorityMappingService.insert(t);
    }



    @ApiOperation(value = "逻辑删除", httpMethod = "GET", notes = "逻辑删除")
    @RequestMapping("logicdelete")
    public CommonResult<Boolean> logicDelete(@RequestParam("id") Long id) {
        return roleAuthorityMappingService.logicDelete(id);
    }


    @ApiOperation(value = "vo列表查询", httpMethod = "GET", notes = "vo列表查询")
    @RequestMapping("listvo")
    public CommonResult<List<RoleAuthorityMappingVO>> listRoleAuthorityMappingVO(@ModelAttribute("pojo")RoleAuthorityMappingQO q) {
        return roleAuthorityMappingService.listRoleAuthorityMappingVO(q);
    }


    @ApiOperation(value = "更新角色权限关系", httpMethod = "POST", notes = "更新角色权限关系")
    @RequestMapping("updateroleauth")
    public CommonResult<Boolean> updateRoleAuth(@RequestBody RoleVO roleVO){
        return roleAuthorityMappingService.updateRoleAuth(roleVO);
    }
}
