package com.itheima.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.entity.Result;
import com.itheima.service.PermissionService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 权限管理
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Reference
    private PermissionService permissionService;

    /**
     * 新增权限
     * @param map
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody Map map){
        try {
            permissionService.add(map);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"新增权限失败");
        }
        return new Result(true,"新增权限成功");

    }
}
