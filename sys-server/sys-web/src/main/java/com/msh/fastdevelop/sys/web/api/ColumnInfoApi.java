package com.msh.fastdevelop.sys.web.api;

import com.msh.frame.client.common.CommonResult;
import com.msh.frame.web.base.BaseController;
import com.msh.fastdevelop.sys.client.po.ColumnInfoPO;
import com.msh.fastdevelop.sys.client.qo.ColumnInfoQO;
import com.msh.fastdevelop.sys.client.vo.ColumnInfoVO;
import com.msh.fastdevelop.sys.service.service.ColumnInfoService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;


/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-11-14 18:05:59
 */
@Api(description = "字段详情-api相关接口")
@Slf4j
@RestController
@RequestMapping("/api/sys/columninfo")
public class ColumnInfoApi extends BaseController<ColumnInfoPO, ColumnInfoQO> {

    @Autowired
    private ColumnInfoService columnInfoService;

    /**
     * 通用查询逻辑
     * @param q 查询对象
     * @return
     */
    @ApiOperation(value = "通用查询逻辑", httpMethod = "GET", notes = "通用查询逻辑")
    @RequestMapping("list")
    public CommonResult<List<ColumnInfoPO>> list(@ModelAttribute("pojo")ColumnInfoQO q) {
        CommonResult<List<ColumnInfoPO>> query = columnInfoService.list(q);
        return query;
    }

    @ApiOperation(value = "通用查询逻辑", httpMethod = "GET", notes = "通用查询逻辑")
    @RequestMapping("getbytablecolumnname")
    public CommonResult<ColumnInfoVO> getColumnInfoVOByTableNameColumnName(@ModelAttribute("pojo")ColumnInfoQO q) {
        CommonResult<ColumnInfoVO> query = columnInfoService.getColumnInfoVO(q.getTableName(),q.getColumnName());
        return query;
    }

    /**
     * 获取详情
     * @return
     */
    @ApiOperation(value = "获取详情", httpMethod = "GET", notes = "获取详情")
    @RequestMapping("get")
    public CommonResult<ColumnInfoPO> get(@RequestParam("id") Long id) {
        return columnInfoService.get(id);
    }

    /**
     * 通用更新逻辑
     * @param t
     * @return
     */
    @ApiOperation(value = "通用更新逻辑", httpMethod = "POST", notes = "通用更新逻辑")
    @RequestMapping("update")
    public CommonResult<Boolean> update(@RequestBody ColumnInfoPO t) {
        return columnInfoService.update(t);
    }

    /**
     * 通用删除逻辑
     * @param id
     * @return
     */
    @ApiOperation(value = "通用删除逻辑", httpMethod = "GET", notes = "通用删除逻辑")
    @RequestMapping("delete")
    public CommonResult<Boolean> delete(@RequestParam("id") Long id) {
        return columnInfoService.delete(id);
    }

    /**
     * 通用插入逻辑
     * @param t
     * @return
     */
    @ApiOperation(value = "通用插入逻辑", httpMethod = "POST", notes = "通用插入逻辑")
    @RequestMapping("insert")
    public CommonResult<Boolean> insert(@RequestBody ColumnInfoPO t) {
        return columnInfoService.insert(t);
    }



    @ApiOperation(value = "逻辑删除", httpMethod = "GET", notes = "逻辑删除")
    @RequestMapping("logicdelete")
    public CommonResult<Boolean> logicDelete(@RequestParam("id") Long id) {
        return columnInfoService.logicDelete(id);
    }


    @ApiOperation(value = "vo列表查询", httpMethod = "GET", notes = "vo列表查询")
    @RequestMapping("listvo")
    public CommonResult<List<ColumnInfoVO>> listColumnInfoVO(@ModelAttribute("pojo")ColumnInfoQO q) {
        return columnInfoService.listColumnInfoVO(q);
    }
}
