package com.backend.mapper;

import com.backend.dto.ProcurementAnnouncementDTO;
import com.backend.pojo.ProcurementAnnouncement;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ProcurementAnnouncementMapper {
    List<ProcurementAnnouncement> list(ProcurementAnnouncementDTO procurementAnnouncementDTO);
    
    void add(ProcurementAnnouncement procurementAnnouncement);
    
    void update(ProcurementAnnouncement procurementAnnouncement);
    
    void delete(Integer id);
    
    ProcurementAnnouncement getById(Integer id);
} 