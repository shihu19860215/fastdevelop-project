package com.msh.fastdevelop.sys.web.api;

import com.msh.fastdevelop.sys.client.model.UserInfo;
import com.msh.fastdevelop.sys.client.vo.UserInfoVO;
import com.msh.fastdevelop.sys.web.util.SessionUtil;
import com.msh.frame.client.common.CommonResult;
import com.msh.frame.web.base.BaseController;
import com.msh.fastdevelop.sys.client.po.UserPO;
import com.msh.fastdevelop.sys.client.qo.UserQO;
import com.msh.fastdevelop.sys.client.vo.UserVO;
import com.msh.fastdevelop.sys.service.service.UserService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2019-06-18 20:51:33
 */
@Api(description = "-api相关接口")
@Slf4j
@RestController
@RequestMapping("/api/sys/user")
public class UserApi extends BaseController<UserPO, UserQO> {

    @Autowired
    private UserService userService;

    /**
     * 通用查询逻辑
     * @param q 查询对象
     * @return
     */
    @ApiOperation(value = "通用查询逻辑", httpMethod = "GET", notes = "通用查询逻辑")
    @RequestMapping("list")
    public CommonResult<List<UserPO>> list(@ModelAttribute("pojo")UserQO q) {
        CommonResult<List<UserPO>> query = userService.list(q);
        return query;
    }

    /**
     * 获取详情
     * @return
     */
    @ApiOperation(value = "获取详情", httpMethod = "GET", notes = "获取详情")
    @RequestMapping("get")
    public CommonResult<UserPO> get(@RequestParam("id") Long id) {
        return userService.get(id);
    }

    /**
     * 通用更新逻辑
     * @param t
     * @return
     */
    @ApiOperation(value = "通用更新逻辑", httpMethod = "POST", notes = "通用更新逻辑")
    @RequestMapping("update")
    public CommonResult<Boolean> update(@RequestBody UserPO t) {
        return userService.update(t);
    }

    /**
     * 通用删除逻辑
     * @param id
     * @return
     */
    @ApiOperation(value = "通用删除逻辑", httpMethod = "GET", notes = "通用删除逻辑")
    @RequestMapping("delete")
    public CommonResult<Boolean> delete(@RequestParam("id") Long id) {
        return userService.delete(id);
    }

    /**
     * 通用插入逻辑
     * @param t
     * @return
     */
    @ApiOperation(value = "通用插入逻辑", httpMethod = "POST", notes = "通用插入逻辑")
    @RequestMapping("insert")
    public CommonResult<Boolean> insert(@RequestBody UserPO t) {
        return userService.insert(t);
    }



    @ApiOperation(value = "逻辑删除", httpMethod = "GET", notes = "逻辑删除")
    @RequestMapping("logicdelete")
    public CommonResult<Boolean> logicDelete(@RequestParam("id") Long id) {
        return userService.logicDelete(id);
    }


    @ApiOperation(value = "vo列表查询", httpMethod = "GET", notes = "vo列表查询")
    @RequestMapping("listvo")
    public CommonResult<List<UserVO>> listUserVO(@ModelAttribute("pojo")UserQO q) {
        return userService.listUserVO(q);
    }


    @ApiOperation(value = "更新用户信息", httpMethod = "POST", notes = "更新用户信息")
    @RequestMapping("updateuservo")
    public CommonResult<Boolean> updateSysUserVO(@RequestBody UserVO t) {
        return userService.updateSysUserVO(t);
    }

    @ApiOperation(value = "新增用户信息", httpMethod = "POST", notes = "新增用户信息")
    @RequestMapping("insertuservo")
    public CommonResult<Boolean> insertSysUserVO(@RequestBody UserVO t) {
        return userService.insertSysUserVO(t);
    }

    @ApiOperation(value = "获取用户信息", httpMethod = "GET", notes = "获取用户信息")
    @RequestMapping("getUserInfo")
    public CommonResult<UserInfoVO> getUserInfo(HttpSession session) {
        UserInfo userInfo = SessionUtil.getUserInfo(session);
        if(null == userInfo){
            return CommonResult.successReturn(null);
        }
        return CommonResult.successReturn(new UserInfoVO(userInfo));
    }

}
