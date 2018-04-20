package com.zjr.swagger.controller;

import com.zjr.swagger.entity.SchoolDTO;
import com.zjr.swagger.entity.StudentVO;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author: Tony
 * @Description: TODO
 * @Date: 2018/4/20 15:32
 * @Version 1.0
 */
@Api(value = "Test", description = "测试用控制类")
@RestController
public class TestController {
    //@ApiResponses和@ApiImplicitParams这两个注解可以不写
    @ApiOperation(value = "我的测试方法")//value的值是对方法功能的描述
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 400, message = "error")})
    @ApiImplicitParams({@ApiImplicitParam(paramType = "body", dataType = "SchoolDTO", name = "schoolDTO", value = "学校DTO类", required = true)})//默认是true
    @RequestMapping(value = "/test", produces = {"application/json"}, method = RequestMethod.POST)
    public StudentVO myTest( @Valid @RequestBody SchoolDTO schoolDTO) {

        StudentVO studentVO = new StudentVO();
        studentVO.setName("张三");
        studentVO.setHobby("羽毛球");
        return studentVO;
    }

    //path参数：@ApiResponses和@ApiImplicitParams这两个注解不要写
    @ApiOperation(value = "我的测试方法02")//value的值是对方法功能的描述
    @RequestMapping(value = "/test02/{myId}", produces = {"application/json"}, method = RequestMethod.GET)
    public StudentVO myTest02(
            @ApiParam(value = "主键id",required = true) @PathVariable(value = "myId",required = true) Long id) {

        StudentVO studentVO = new StudentVO();
        studentVO.setName("张三");
        studentVO.setHobby("羽毛球");
        System.out.println(id);
        return studentVO;
    }

    @ApiOperation(value = "我的测试方法03")//value的值是对方法功能的描述
    @RequestMapping(value = "/test03", produces = {"application/json"}, method = RequestMethod.GET)
    public StudentVO myTest03(
            @ApiParam(value = "店铺id",required = false) @RequestParam(value = "shopId",required = false) String id
    ) {

        StudentVO studentVO = new StudentVO();
        studentVO.setName("张三");
        studentVO.setHobby("羽毛球");
        return studentVO;
    }
}
