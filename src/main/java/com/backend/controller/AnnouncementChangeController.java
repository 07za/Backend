package com.backend.controller;

import com.backend.dto.AnnouncementChangeDTO;
import com.backend.pojo.AnnouncementChanges;
import com.backend.pojo.Result;
import com.backend.service.AnnouncementChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bid/bidding/announcementChange")
public class AnnouncementChangeController {
    
    @Autowired
    private AnnouncementChangeService announcementChangeService;
    
    @GetMapping("/list")
    public Result<List<AnnouncementChanges>> list(AnnouncementChangeDTO announcementChangeDTO) {
        List<AnnouncementChanges> list = announcementChangeService.list(announcementChangeDTO);
        return Result.success(list);
    }
    
    @GetMapping("/{id}")
    public Result<AnnouncementChanges> getById(@PathVariable Integer id) {
        AnnouncementChanges announcementChanges = announcementChangeService.getById(id);
        return Result.success(announcementChanges);
    }
} 