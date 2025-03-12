package com.backend.controller;

import com.backend.pojo.Result;
import com.backend.service.VisualizationService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/visualization")
public class VisualizationController {

    @Resource
    private VisualizationService service;

    @GetMapping("/getVisualization")
    public Result<?> getVisualization(){
        return Result.success(service.getVisualization());
    }


}
