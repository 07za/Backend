package com.backend.service.impl;

import com.backend.mapper.InspectionStandardMapper;
import com.backend.pojo.InspectionStandard;
import com.backend.service.InspectionStandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InspectionStandardServiceImpl implements InspectionStandardService {
    
    @Autowired
    private InspectionStandardMapper inspectionStandardMapper;

    @Override
    public List<InspectionStandard> list() {
        return inspectionStandardMapper.list();
    }
}
