package com.backend.service;

import com.backend.pojo.Enterprise;

import java.util.List;

public interface EnterpriseService {
    void update(Enterprise enterprise);

    List<Enterprise> list();

    void updateAuditStatus(Integer id);
}
