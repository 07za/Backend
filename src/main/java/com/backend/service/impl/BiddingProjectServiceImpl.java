package com.backend.service.impl;

import com.backend.mapper.BiddingProjectMapper;
import com.backend.pojo.BiddingProject;
import com.backend.service.BiddingProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class BiddingProjectServiceImpl implements BiddingProjectService {
    
    @Autowired
    private BiddingProjectMapper biddingProjectMapper;
    
    private static final String SIGNATURE_PATH = "files/signature/";
    private static final String ID_CARD_PATH = "files/idcard/";
    private static final String BIDDING_FILE_PATH = "files/bidding/";
    
    @Override
    public List<BiddingProject> list() {
        return biddingProjectMapper.list();
    }
    
    @Override
    public BiddingProject getById(Integer id) {
        return biddingProjectMapper.getById(id);
    }
    
    @Override
    public void update(BiddingProject biddingProject, 
                      MultipartFile signatureFile, 
                      MultipartFile idCardFile, 
                      MultipartFile biddingFile) {
        // 处理签字图片
        if (signatureFile != null && !signatureFile.isEmpty()) {
            // 删除旧文件
            BiddingProject oldProject = biddingProjectMapper.getById(biddingProject.getId());
            if (oldProject != null && oldProject.getSignatureUrl() != null) {
                new File(oldProject.getSignatureUrl()).delete();
            }
            
            // 保存新文件
            String signatureUrl = saveFile(signatureFile, SIGNATURE_PATH);
            biddingProject.setSignatureUrl(signatureUrl);
        }
        
        // 处理身份证图片
        if (idCardFile != null && !idCardFile.isEmpty()) {
            // 删除旧文件
            BiddingProject oldProject = biddingProjectMapper.getById(biddingProject.getId());
            if (oldProject != null && oldProject.getIdCardUrl() != null) {
                new File(oldProject.getIdCardUrl()).delete();
            }
            
            // 保存新文件
            String idCardUrl = saveFile(idCardFile, ID_CARD_PATH);
            biddingProject.setIdCardUrl(idCardUrl);
        }
        
        // 处理投标文件
        if (biddingFile != null && !biddingFile.isEmpty()) {
            // 删除旧文件
            BiddingProject oldProject = biddingProjectMapper.getById(biddingProject.getId());
            if (oldProject != null && oldProject.getFileUrl() != null) {
                new File(oldProject.getFileUrl()).delete();
            }
            
            // 保存新文件
            String fileUrl = saveFile(biddingFile, BIDDING_FILE_PATH);
            biddingProject.setFileUrl(fileUrl);
            
            // 如果上传了投标文件，自动更新投标状态为"已投标"
            biddingProject.setBiddingStatus("已投标");
            biddingProject.setBiddingProgress("进行中");
        }
        
        // 更新数据库
        biddingProjectMapper.update(biddingProject);
    }
    
    private String saveFile(MultipartFile file, String path) {
        try {
            // 确保目录存在
            File dir = new File(path);
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
            
            return path + filename;
        } catch (IOException e) {
            throw new RuntimeException("文件保存失败", e);
        }
    }
} 