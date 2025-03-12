package com.backend.service;

import com.backend.dto.MesMaterialCheckListDTO;
import com.backend.pojo.MesMaterialCheck;
import java.util.List;

public interface MesMaterialCheckService {
    List<MesMaterialCheck> list(MesMaterialCheckListDTO mesMaterialCheckListDTO);

    MesMaterialCheck getById(Long id);

    void add(MesMaterialCheck mesMaterialCheck);

    void update(MesMaterialCheck mesMaterialCheck);

    void delete(String id);
} 