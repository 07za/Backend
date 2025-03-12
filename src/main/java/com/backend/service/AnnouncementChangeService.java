package com.backend.service;

import com.backend.dto.AnnouncementChangeDTO;
import com.backend.pojo.AnnouncementChanges;
import java.util.List;

public interface AnnouncementChangeService {
    List<AnnouncementChanges> list(AnnouncementChangeDTO announcementChangeDTO);
    
    AnnouncementChanges getById(Integer id);
} 