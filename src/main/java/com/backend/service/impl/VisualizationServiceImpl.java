package com.backend.service.impl;

import com.backend.dto.VisualizationDTO;
import com.backend.mapper.VisualizationMapper;
import com.backend.service.VisualizationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisualizationServiceImpl implements VisualizationService {
    @Resource
    private VisualizationMapper mapper;

    @Override
    public List<VisualizationDTO> getVisualization() {
        return mapper.list();
    }
}
