package com.backend.service.impl;

import com.backend.mapper.EnterpriseMapper;
import com.backend.pojo.Enterprise;
import com.backend.service.EnterpriseService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {

    @Resource
    private EnterpriseMapper mapper;

    @Override
    public void update(Enterprise enterprise) {
        mapper.update(enterprise);
    }

    @Override
    public List<Enterprise> list() {
        return mapper.list();
    }

    @Override
    public void updateAuditStatus(Integer id) {
        mapper.updateAuditStatus(id);
    }


}
