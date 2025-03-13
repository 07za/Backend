package com.backend.service;

import com.backend.dto.ProcurementAnnouncementDTO;
import com.backend.pojo.ProcurementAnnouncement;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

public interface ProcurementAnnouncementService {
    List<ProcurementAnnouncement> list(ProcurementAnnouncementDTO procurementAnnouncementDTO);
    
    void add(ProcurementAnnouncement procurementAnnouncement, MultipartFile file);
    
    boolean update(ProcurementAnnouncement procurementAnnouncement, MultipartFile file);
    
    void delete(Integer id);
    
    ProcurementAnnouncement getById(Integer id);
    
    void export(ProcurementAnnouncementDTO procurementAnnouncementDTO);
} 