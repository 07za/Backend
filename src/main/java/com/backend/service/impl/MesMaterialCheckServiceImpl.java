package com.backend.service.impl;

import com.backend.dto.MesMaterialCheckListDTO;
import com.backend.mapper.MesMaterialCheckMapper;
import com.backend.pojo.MesMaterialCheck;
import com.backend.service.MesMaterialCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesMaterialCheckServiceImpl implements MesMaterialCheckService {

    @Autowired
    private MesMaterialCheckMapper mesMaterialCheckMapper;

    @Override
    public List<MesMaterialCheck> list(MesMaterialCheckListDTO mesMaterialCheckListDTO) {
        return mesMaterialCheckMapper.list(mesMaterialCheckListDTO);
    }

    @Override
    public MesMaterialCheck getById(Long id) {
        return mesMaterialCheckMapper.getByID(id);
    }

    @Override
    public void add(MesMaterialCheck mesMaterialCheck) {
        mesMaterialCheckMapper.add(mesMaterialCheck);
    }

    @Override
    public void update(MesMaterialCheck mesMaterialCheck) {
        mesMaterialCheckMapper.update(mesMaterialCheck);
    }

    @Override
    public void delete(String id) {
        mesMaterialCheckMapper.delete(id);
    }
} 