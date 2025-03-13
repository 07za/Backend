package com.backend.service.impl;

import com.backend.dto.ProcurementAnnouncementDTO;
import com.backend.mapper.ProcurementAnnouncementMapper;
import com.backend.mapper.BiddingProjectMapper;
import com.backend.pojo.ProcurementAnnouncement;
import com.backend.pojo.BiddingProject;
import com.backend.service.ProcurementAnnouncementService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class ProcurementAnnouncementServiceImpl implements ProcurementAnnouncementService {
    
    @Autowired
    private ProcurementAnnouncementMapper procurementAnnouncementMapper;
    
    @Autowired
    private BiddingProjectMapper biddingProjectMapper;
    
    private static final String FILE_PATH = "files/procurement/";
    
    @Override
    public List<ProcurementAnnouncement> list(ProcurementAnnouncementDTO procurementAnnouncementDTO) {
        return procurementAnnouncementMapper.list(procurementAnnouncementDTO);
    }
    
    @Override
    public void add(ProcurementAnnouncement procurementAnnouncement, MultipartFile file) {
        if (file != null && !file.isEmpty()) {
            String fileUrl = saveFile(file);
            procurementAnnouncement.setFileUrl(fileUrl);
        }
        procurementAnnouncementMapper.add(procurementAnnouncement);
    }
    
    @Override
    @Transactional
    public boolean update(ProcurementAnnouncement procurementAnnouncement, MultipartFile file) {
        if (file != null && !file.isEmpty()) {
            // 删除旧文件
            ProcurementAnnouncement oldAnnouncement = procurementAnnouncementMapper.getById(procurementAnnouncement.getId());
            if (oldAnnouncement != null && oldAnnouncement.getFileUrl() != null) {
                new File(oldAnnouncement.getFileUrl()).delete();
            }
            
            // 保存新文件
            String fileUrl = saveFile(file);
            procurementAnnouncement.setFileUrl(fileUrl);
        }
        
        // 检查是否需要转移到参标项目表
        if ("已报名".equals(procurementAnnouncement.getRegistrationStatus())) {
            // 获取完整的公告信息，确保所有字段都有值
            ProcurementAnnouncement fullAnnouncement = procurementAnnouncementMapper.getById(procurementAnnouncement.getId());
            if (fullAnnouncement == null) {
                fullAnnouncement = procurementAnnouncement;
            }
            
            // 添加到参标项目表
            BiddingProject biddingProject = new BiddingProject();
            
            // 设置参标项目的基本信息
            biddingProject.setBiddingStatus("未投标");
            biddingProject.setBiddingName(fullAnnouncement.getBiddingName());
            biddingProject.setBidResult("未开标");
            biddingProject.setBiddingEndTime(fullAnnouncement.getBiddingEndTime());
            biddingProject.setRegistrationStatus(fullAnnouncement.getRegistrationStatus());
            biddingProject.setBiddingProgress("未开始");
            biddingProject.setProjectTitle(fullAnnouncement.getTitle());
            biddingProject.setPublishTime(fullAnnouncement.getPublishTime());
            biddingProject.setPublishEnterprise(fullAnnouncement.getPublisher());
            biddingProject.setProjectSummary(fullAnnouncement.getContent());
            
            // 如果有招标内容，也一并转移
            if (fullAnnouncement.getBiddingContent() != null && !fullAnnouncement.getBiddingContent().isEmpty()) {
                // 将招标内容添加到项目简介中
                String summary = biddingProject.getProjectSummary();
                if (summary == null) {
                    summary = "";
                }
                if (!summary.isEmpty()) {
                    summary += "\n\n";
                }
                summary += "招标内容：\n" + fullAnnouncement.getBiddingContent();
                biddingProject.setProjectSummary(summary);
            }
            
            // 如果有文件，也一并转移
            if (fullAnnouncement.getFileUrl() != null && !fullAnnouncement.getFileUrl().isEmpty()) {
                biddingProject.setFileUrl(fullAnnouncement.getFileUrl());
            }
            
            // 添加到参标项目表
            biddingProjectMapper.add(biddingProject);
            
            // 从采购公告表中删除
            procurementAnnouncementMapper.delete(procurementAnnouncement.getId());
            
            return true;
        } else {
            // 正常更新
            procurementAnnouncementMapper.update(procurementAnnouncement);
            return false;
        }
    }
    
    @Override
    public void delete(Integer id) {
        // 删除文件
        ProcurementAnnouncement announcement = procurementAnnouncementMapper.getById(id);
        if (announcement != null && announcement.getFileUrl() != null) {
            new File(announcement.getFileUrl()).delete();
        }
        procurementAnnouncementMapper.delete(id);
    }
    
    @Override
    public ProcurementAnnouncement getById(Integer id) {
        return procurementAnnouncementMapper.getById(id);
    }
    
    @Override
    public void export(ProcurementAnnouncementDTO procurementAnnouncementDTO) {
        List<ProcurementAnnouncement> list = procurementAnnouncementMapper.list(procurementAnnouncementDTO);
        
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("采购公告");
            
            // 创建标题行
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("编号");
            headerRow.createCell(1).setCellValue("标题");
            headerRow.createCell(2).setCellValue("发布者");
            headerRow.createCell(3).setCellValue("联系方式");
            headerRow.createCell(4).setCellValue("采购内容");
            headerRow.createCell(5).setCellValue("发布时间");
            headerRow.createCell(6).setCellValue("公告类型");
            headerRow.createCell(7).setCellValue("招标内容");
            headerRow.createCell(8).setCellValue("报名状态");
            headerRow.createCell(9).setCellValue("标的发布名称");
            headerRow.createCell(10).setCellValue("投标结束时间");
            
            // 填充数据
            int rowNum = 1;
            for (ProcurementAnnouncement announcement : list) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(announcement.getId());
                row.createCell(1).setCellValue(announcement.getTitle());
                row.createCell(2).setCellValue(announcement.getPublisher());
                row.createCell(3).setCellValue(announcement.getContact());
                row.createCell(4).setCellValue(announcement.getContent());
                row.createCell(5).setCellValue(announcement.getPublishTime() != null ? announcement.getPublishTime().toString() : "");
                row.createCell(6).setCellValue(announcement.getAnnouncementType());
                row.createCell(7).setCellValue(announcement.getBiddingContent());
                row.createCell(8).setCellValue(announcement.getRegistrationStatus());
                row.createCell(9).setCellValue(announcement.getBiddingName());
                row.createCell(10).setCellValue(announcement.getBiddingEndTime() != null ? announcement.getBiddingEndTime().toString() : "");
            }
            
            // 保存文件
            File dir = new File("export");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            FileOutputStream fileOut = new FileOutputStream("export/采购公告.xlsx");
            workbook.write(fileOut);
            fileOut.close();
            
        } catch (IOException e) {
            throw new RuntimeException("导出失败", e);
        }
    }
    
    private String saveFile(MultipartFile file) {
        try {
            // 确保目录存在
            File dir = new File(FILE_PATH);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            
            // 生成唯一文件名
            String originalFilename = file.getOriginalFilename();
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            String filename = UUID.randomUUID().toString() + suffix;
            
            // 保存文件
            File dest = new File(dir, filename);
            file.transferTo(dest);
            
            return FILE_PATH + filename;
        } catch (IOException e) {
            throw new RuntimeException("文件保存失败", e);
        }
    }
} 