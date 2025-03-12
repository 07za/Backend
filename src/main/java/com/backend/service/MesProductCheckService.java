package com.backend.service;

import com.backend.dto.MesProductCheckListDTO;
import com.backend.pojo.MesProductCheck;
import com.backend.pojo.Result;

import java.util.List;

public interface MesProductCheckService {
    List<MesProductCheck> list(MesProductCheckListDTO mesProductCheckListDTO);

    MesProductCheck getById(Long id);

    void add(MesProductCheck mesProductCheck);

    void update(MesProductCheck mesProductCheck);

    void delete(String id);
}
