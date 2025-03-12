package com.backend.mapper;

import com.backend.dto.MesProductCheckListDTO;
import com.backend.pojo.MesProductCheck;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MesProductCheckMapper {
    List<MesProductCheck> list(MesProductCheckListDTO mesProductCheckListDTO);

    MesProductCheck getByID(Long id);

    void add(MesProductCheck mesProductCheck);

    void update(MesProductCheck mesProductCheck);

    void delete(String id);
}
