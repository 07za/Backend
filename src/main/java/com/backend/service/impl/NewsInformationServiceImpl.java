package com.backend.service.impl;

import com.backend.dto.NewsInformationDTO;
import com.backend.mapper.NewsInformationMapper;
import com.backend.pojo.NewsInformation;
import com.backend.service.NewsInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsInformationServiceImpl implements NewsInformationService {
    
    @Autowired
    private NewsInformationMapper newsInformationMapper;
    
    @Override
    public List<NewsInformation> list(NewsInformationDTO newsInformationDTO) {
        return newsInformationMapper.list(newsInformationDTO);
    }
    
    @Override
    public NewsInformation getById(Integer id) {
        newsInformationMapper.incrementViewCount(id);
        return newsInformationMapper.getById(id);
    }
} 