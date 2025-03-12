package com.backend.mapper;

import com.backend.dto.VisualizationDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VisualizationMapper {
    List<VisualizationDTO> list();
}
