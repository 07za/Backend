package com.backend.service.impl;

import com.backend.dto.MesProductCheckListDTO;
import com.backend.mapper.MesProductCheckMapper;
import com.backend.pojo.MesProductCheck;
import com.backend.service.MesProductCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesProductCheckServiceImpl implements MesProductCheckService{

    @Autowired
    private MesProductCheckMapper mesProductCheckMapper;
    @Override
    public List<MesProductCheck> list(MesProductCheckListDTO mesProductCheckListDTO) {
        return mesProductCheckMapper.list(mesProductCheckListDTO);
    }

    @Override
    public MesProductCheck getById(Long id) {
        return mesProductCheckMapper.getByID(id);
    }

    @Override
    public void add(MesProductCheck mesProductCheck) {
        mesProductCheckMapper.add(mesProductCheck);
    }

    @Override
    public void update(MesProductCheck mesProductCheck) {
        mesProductCheckMapper.update(mesProductCheck);
    }

    @Override
    public void delete(String id) {
        mesProductCheckMapper.delete(id);
    }

}
