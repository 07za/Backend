package com.backend.controller;

import com.backend.pojo.BiddingProject;
import com.backend.pojo.Result;
import com.backend.service.BiddingProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/bidding/project")
public class BiddingProjectController {
    
    @Autowired
    private BiddingProjectService biddingProjectService;
    
    @GetMapping("/list")
    public Result<List<BiddingProject>> list() {
        List<BiddingProject> list = biddingProjectService.list();
        return Result.success(list);
    }
    
    @GetMapping("/{id}")
    public Result<BiddingProject> getById(@PathVariable Integer id) {
        BiddingProject biddingProject = biddingProjectService.getById(id);
        return Result.success(biddingProject);
    }
    
    @PutMapping
    public Result update(
            BiddingProject biddingProject,
            @RequestParam(value = "signatureFile", required = false) MultipartFile signatureFile,
            @RequestParam(value = "idCardFile", required = false) MultipartFile idCardFile,
            @RequestParam(value = "biddingFile", required = false) MultipartFile biddingFile) {
        
        biddingProjectService.update(biddingProject, signatureFile, idCardFile, biddingFile);
        return Result.success("更新成功");
    }
} 