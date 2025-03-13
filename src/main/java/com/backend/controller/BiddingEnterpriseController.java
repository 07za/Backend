package com.backend.controller;

import com.backend.pojo.BiddingEnterprise;
import com.backend.pojo.Result;
import com.backend.service.BiddingEnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bidding/enterprise")
public class BiddingEnterpriseController {
    
    @Autowired
    private BiddingEnterpriseService biddingEnterpriseService;
    
    @GetMapping("/list/{announcementId}")
    public Result<List<BiddingEnterprise>> listByAnnouncementId(@PathVariable Integer announcementId) {
        List<BiddingEnterprise> list = biddingEnterpriseService.listByAnnouncementId(announcementId);
        return Result.success(list);
    }
    
    @PostMapping
    public Result add(@RequestBody BiddingEnterprise biddingEnterprise) {
        biddingEnterpriseService.add(biddingEnterprise);
        return Result.success();
    }
} 