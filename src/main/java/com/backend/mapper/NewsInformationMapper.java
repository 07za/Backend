package com.backend.mapper;

import com.backend.dto.NewsInformationDTO;
import com.backend.pojo.NewsInformation;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface NewsInformationMapper {
    List<NewsInformation> list(NewsInformationDTO newsInformationDTO);
    
    NewsInformation getById(Integer id);
    
    void incrementViewCount(Integer id);
} 