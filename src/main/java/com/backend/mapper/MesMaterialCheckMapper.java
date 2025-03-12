package com.backend.mapper;

import com.backend.dto.MesMaterialCheckListDTO;
import com.backend.pojo.MesMaterialCheck;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MesMaterialCheckMapper {
    List<MesMaterialCheck> list(MesMaterialCheckListDTO mesMaterialCheckListDTO);

    MesMaterialCheck getByID(Long id);

    void add(MesMaterialCheck mesMaterialCheck);

    void update(MesMaterialCheck mesMaterialCheck);

    void delete(String id);
} 