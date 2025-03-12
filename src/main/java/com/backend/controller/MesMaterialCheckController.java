package com.backend.controller;

import com.backend.dto.MesMaterialCheckListDTO;
import com.backend.pojo.MesMaterialCheck;
import com.backend.pojo.Result;
import com.backend.service.MesMaterialCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesCheck/materialCheck")
public class MesMaterialCheckController {

    @Autowired
    private MesMaterialCheckService mesMaterialCheckService;

    @GetMapping("/list")
    public Result<List<MesMaterialCheck>> list(MesMaterialCheckListDTO mesMaterialCheckListDTO) {
        List<MesMaterialCheck> list = mesMaterialCheckService.list(mesMaterialCheckListDTO);
        return Result.success(list);
    }

    @GetMapping("/{id}")
    public Result<MesMaterialCheck> getById(@PathVariable Long id) {
        MesMaterialCheck mesMaterialCheck = mesMaterialCheckService.getById(id);
        return Result.success(mesMaterialCheck);
    }

    @PostMapping
    public Result add(@RequestBody MesMaterialCheck mesMaterialCheck) {
        mesMaterialCheckService.add(mesMaterialCheck);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody MesMaterialCheck mesMaterialCheck) {
        mesMaterialCheckService.update(mesMaterialCheck);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        mesMaterialCheckService.delete(id);
        return Result.success();
    }
} 