package com.backend.mapper;

import com.backend.dto.AnnouncementChangeDTO;
import com.backend.pojo.AnnouncementChanges;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface AnnouncementChangeMapper {
    List<AnnouncementChanges> list(AnnouncementChangeDTO announcementChangeDTO);
    
    AnnouncementChanges getById(Integer id);
    
    void incrementViewCount(Integer id);
} 