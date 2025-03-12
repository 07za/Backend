package com.backend.service;

import com.backend.dto.NewsInformationDTO;
import com.backend.pojo.NewsInformation;
import java.util.List;

public interface NewsInformationService {
    List<NewsInformation> list(NewsInformationDTO newsInformationDTO);
    
    NewsInformation getById(Integer id);
} 