package com.backend.controller;

import com.backend.dto.MesProductCheckListDTO;
import com.backend.pojo.MesProductCheck;
import com.backend.pojo.Result;
import com.backend.service.MesProductCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/mesCheck/productCheck")
public class MesProductCheckController {

    @Autowired
    private MesProductCheckService mesProductCheckService;

    @GetMapping("/list")
    public Result<List<MesProductCheck>> list(@ModelAttribute MesProductCheckListDTO mesProductCheckListDTO) {
        List<MesProductCheck> list = mesProductCheckService.list(mesProductCheckListDTO);
        return Result.success(list);
    }

    @GetMapping("/{id}")
    public Result<MesProductCheck> getById(@PathVariable Long id) {
        MesProductCheck mesProductCheck = mesProductCheckService.getById(id);
        if (mesProductCheck != null){
            return Result.success(mesProductCheck);
        }else {
            return Result.error("id不存在");
        }
    }

    @PostMapping
    public Result add(@RequestBody MesProductCheck mesProductCheck) {
        mesProductCheckService.add(mesProductCheck);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody MesProductCheck mesProductCheck) {
        mesProductCheckService.update(mesProductCheck);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        mesProductCheckService.delete(id);
        return Result.success();
    }
}
