package com.backend.controller;

import com.backend.pojo.InspectionStandard;
import com.backend.pojo.Result;
import com.backend.service.InspectionStandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/inspectionStandard")
public class InspectionStandardController {

    @Autowired
    private InspectionStandardService inspectionStandardService;

    @GetMapping("/list")
    public Result<List<InspectionStandard>> list() {
        List<InspectionStandard> list = inspectionStandardService.list();
        return Result.success(list);
    }
}
