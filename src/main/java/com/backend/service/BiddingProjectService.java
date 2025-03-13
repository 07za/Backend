package com.backend.service;

import com.backend.pojo.BiddingProject;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

public interface BiddingProjectService {
    List<BiddingProject> list();
    
    BiddingProject getById(Integer id);
    
    void update(BiddingProject biddingProject, 
                MultipartFile signatureFile, 
                MultipartFile idCardFile, 
                MultipartFile biddingFile);
} 