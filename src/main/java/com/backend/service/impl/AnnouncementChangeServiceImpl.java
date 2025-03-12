package com.backend.service.impl;

import com.backend.dto.AnnouncementChangeDTO;
import com.backend.mapper.AnnouncementChangeMapper;
import com.backend.pojo.AnnouncementChanges;
import com.backend.service.AnnouncementChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementChangeServiceImpl implements AnnouncementChangeService {
    
    @Autowired
    private AnnouncementChangeMapper announcementChangeMapper;
    
    @Override
    public List<AnnouncementChanges> list(AnnouncementChangeDTO announcementChangeDTO) {
        return announcementChangeMapper.list(announcementChangeDTO);
    }
    
    @Override
    public AnnouncementChanges getById(Integer id) {
        announcementChangeMapper.incrementViewCount(id);
        return announcementChangeMapper.getById(id);
    }
} 