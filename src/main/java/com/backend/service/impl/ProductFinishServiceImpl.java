package com.backend.service.impl;

import com.backend.pojo.ProductFinish;
import com.backend.service.ProductFinishService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductFinishServiceImpl implements ProductFinishService {
    @Override
    public List<ProductFinish> list() {
        return List.of();
    }
}
