package com.msh.fastdevelop.sys.web.api;

import com.msh.frame.client.common.CommonResult;
import com.msh.frame.web.base.BaseController;
import com.msh.fastdevelop.sys.client.po.AuthorityUrlPO;
import com.msh.fastdevelop.sys.client.qo.AuthorityUrlQO;
import com.msh.fastdevelop.sys.client.vo.AuthorityUrlVO;
import com.msh.fastdevelop.sys.service.service.AuthorityUrlService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.Map;


/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-18 20:51:33
 */
@Api(description = "-api相关接口")
@Slf4j
@RestController
@RequestMapping("/api/sys/authorityurl")
public class AuthorityUrlApi extends BaseController<AuthorityUrlPO, AuthorityUrlQO> {

    @Autowired
    private AuthorityUrlService authorityUrlService;

    /**
     * 通用查询逻辑
     * @param q 查询对象
     * @return
     */
    @ApiOperation(value = "通用查询逻辑", httpMethod = "GET", notes = "通用查询逻辑")
    @RequestMapping("list")
    public CommonResult<List<AuthorityUrlPO>> list(@ModelAttribute("pojo")AuthorityUrlQO q) {
        CommonResult<List<AuthorityUrlPO>> query = authorityUrlService.list(q);
        return query;
    }

    /**
     * 获取详情
     * @return
     */
    @ApiOperation(value = "获取详情", httpMethod = "GET", notes = "获取详情")
    @RequestMapping("get")
    public CommonResult<AuthorityUrlPO> get(@RequestParam("id") Long id) {
        return authorityUrlService.get(id);
    }

    /**
     * 通用更新逻辑
     * @param t
     * @return
     */
    @ApiOperation(value = "通用更新逻辑", httpMethod = "POST", notes = "通用更新逻辑")
    @RequestMapping("update")
    public CommonResult<Boolean> update(@RequestBody AuthorityUrlPO t) {
        return authorityUrlService.update(t);
    }

    /**
     * 通用删除逻辑
     * @param id
     * @return
     */
    @ApiOperation(value = "通用删除逻辑", httpMethod = "GET", notes = "通用删除逻辑")
    @RequestMapping("delete")
    public CommonResult<Boolean> delete(@RequestParam("id") Long id) {
        return authorityUrlService.delete(id);
    }

    /**
     * 通用插入逻辑
     * @param t
     * @return
     */
    @ApiOperation(value = "通用插入逻辑", httpMethod = "POST", notes = "通用插入逻辑")
    @RequestMapping("insert")
    public CommonResult<Boolean> insert(@RequestBody AuthorityUrlPO t) {
        return authorityUrlService.insert(t);
    }



    @ApiOperation(value = "逻辑删除", httpMethod = "GET", notes = "逻辑删除")
    @RequestMapping("logicdelete")
    public CommonResult<Boolean> logicDelete(@RequestParam("id") Long id) {
        return authorityUrlService.logicDelete(id);
    }


    @ApiOperation(value = "vo列表查询", httpMethod = "GET", notes = "vo列表查询")
    @RequestMapping("listvo")
    public CommonResult<List<AuthorityUrlVO>> listAuthorityUrlVO(@ModelAttribute("pojo")AuthorityUrlQO q) {
        return authorityUrlService.listAuthorityUrlVO(q);
    }

    @ApiOperation(value = "vo列表map查询", httpMethod = "GET", notes = "vo列表map查询")
    @RequestMapping("listallmap")
    public CommonResult<Map<Long,List<AuthorityUrlVO>>> listAllAuthorityUrlVOMap() {
        return authorityUrlService.listAllAuthorityUrlVOMap();
    }
}
