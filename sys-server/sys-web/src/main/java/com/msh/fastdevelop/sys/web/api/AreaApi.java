package com.msh.fastdevelop.sys.web.api;

import com.msh.frame.client.common.CommonResult;
import com.msh.frame.web.base.BaseController;
import com.msh.fastdevelop.sys.client.po.AreaPO;
import com.msh.fastdevelop.sys.client.qo.AreaQO;
import com.msh.fastdevelop.sys.client.vo.AreaVO;
import com.msh.fastdevelop.sys.service.service.AreaService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;


/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-24 20:24:20
 */
@Api(description = "行政区域规划码-api相关接口")
@Slf4j
@RestController
@RequestMapping("/api/sys/area")
public class AreaApi extends BaseController<AreaPO, AreaQO> {

    @Autowired
    private AreaService areaService;

    /**
     * 通用查询逻辑
     * @param q 查询对象
     * @return
     */
    @ApiOperation(value = "通用查询逻辑", httpMethod = "GET", notes = "通用查询逻辑")
    @RequestMapping("list")
    public CommonResult<List<AreaPO>> list(@ModelAttribute("pojo")AreaQO q) {
        CommonResult<List<AreaPO>> query = areaService.list(q);
        query.setCount(areaService.count(q).getResult());
        return query;
    }

    /**
     * 获取详情
     * @return
     */
    @ApiOperation(value = "获取详情", httpMethod = "GET", notes = "获取详情")
    @RequestMapping("get")
    public CommonResult<AreaPO> get(@RequestParam("id") Long id) {
        return areaService.get(id);
    }

    /**
     * 通用更新逻辑
     * @param t
     * @return
     */
    @ApiOperation(value = "通用更新逻辑", httpMethod = "POST", notes = "通用更新逻辑")
    @RequestMapping("update")
    public CommonResult<Boolean> update(@RequestBody AreaPO t) {
        return areaService.update(t);
    }

    /**
     * 通用删除逻辑
     * @param id
     * @return
     */
    @ApiOperation(value = "通用删除逻辑", httpMethod = "GET", notes = "通用删除逻辑")
    @RequestMapping("delete")
    public CommonResult<Boolean> delete(@RequestParam("id") Long id) {
        return areaService.delete(id);
    }

    /**
     * 通用插入逻辑
     * @param t
     * @return
     */
    @ApiOperation(value = "通用插入逻辑", httpMethod = "POST", notes = "通用插入逻辑")
    @RequestMapping("insert")
    public CommonResult<Boolean> insert(@RequestBody AreaPO t) {
        return areaService.insert(t);
    }



    @ApiOperation(value = "逻辑删除", httpMethod = "GET", notes = "逻辑删除")
    @RequestMapping("logicdelete")
    public CommonResult<Boolean> logicDelete(@RequestParam("id") Long id) {
        return areaService.logicDelete(id);
    }


    @ApiOperation(value = "vo列表查询", httpMethod = "GET", notes = "vo列表查询")
    @RequestMapping("listvo")
    public CommonResult<List<AreaVO>> listAreaVO(@ModelAttribute("pojo")AreaQO q) {
        q.setEgtStatus(0);
        CommonResult<List<AreaVO>> listCommonResult = areaService.listAreaVO(q);
        listCommonResult.setCount(areaService.count(q).getResult());
        return listCommonResult;
    }
}
