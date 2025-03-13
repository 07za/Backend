package com.backend.controller;

import com.backend.dto.ProcurementAnnouncementDTO;
import com.backend.pojo.ProcurementAnnouncement;
import com.backend.pojo.Result;
import com.backend.service.ProcurementAnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/procurement/announcement")
public class ProcurementAnnouncementController {
    
    @Autowired
    private ProcurementAnnouncementService procurementAnnouncementService;
    
    @GetMapping("/list")
    public Result<List<ProcurementAnnouncement>> list(ProcurementAnnouncementDTO procurementAnnouncementDTO) {
        List<ProcurementAnnouncement> list = procurementAnnouncementService.list(procurementAnnouncementDTO);
        return Result.success(list);
    }
    
    @GetMapping("/{id}")
    public Result<ProcurementAnnouncement> getById(@PathVariable Integer id) {
        ProcurementAnnouncement announcement = procurementAnnouncementService.getById(id);
        return Result.success(announcement);
    }
    
    @PostMapping
    public Result add(@RequestParam("file") MultipartFile file,
                     ProcurementAnnouncement procurementAnnouncement) {
        procurementAnnouncementService.add(procurementAnnouncement, file);
        return Result.success();
    }
    
    @PutMapping
    public Result update(@RequestParam(value = "file", required = false) MultipartFile file,
                        ProcurementAnnouncement procurementAnnouncement) {
        procurementAnnouncementService.update(procurementAnnouncement, file);
        return Result.success();
    }
    
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        procurementAnnouncementService.delete(id);
        return Result.success();
    }
    
    @GetMapping("/export")
    public Result export(ProcurementAnnouncementDTO procurementAnnouncementDTO) {
        procurementAnnouncementService.export(procurementAnnouncementDTO);
        return Result.success();
    }
} 