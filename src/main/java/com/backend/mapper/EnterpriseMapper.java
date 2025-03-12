package com.backend.mapper;

import com.backend.pojo.Enterprise;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EnterpriseMapper {
    void update(Enterprise enterprise);

    List<Enterprise> list();

    void updateAuditStatus(Integer id);
}
