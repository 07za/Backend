package com.backend.mapper;

import com.backend.pojo.InspectionStandard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InspectionStandardMapper {
    List<InspectionStandard> list();
}
