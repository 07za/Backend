package com.backend.controller;

import com.backend.pojo.Enterprise;
import com.backend.pojo.Result;
import com.backend.service.EnterpriseService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {

    @Resource
    private EnterpriseService service;

    @PutMapping("/update")
    public Result<?> update(@RequestBody Enterprise enterprise){

        service.update(enterprise);

        return Result.success();
    }

    @GetMapping("/list")
    public Result<?> list(){
        return Result.success(service.list());
    }

    @PutMapping("/updateAuditStatus/{id}")
    public Result<?> updateAuditStatus(@PathVariable("id") Integer id){
        service.updateAuditStatus(id);
        return Result.success();
    }

}
