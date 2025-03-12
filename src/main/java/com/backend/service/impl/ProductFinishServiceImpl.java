package com.backend.service.impl;

import com.backend.dto.ProductFinishListDTO;
import com.backend.mapper.ProductFinishMapper;
import com.backend.pojo.ProductFinish;
import com.backend.service.ProductFinishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductFinishServiceImpl implements ProductFinishService {

    @Autowired
    private ProductFinishMapper productFinishMapper;

    @Override
    public List<ProductFinish> list(ProductFinishListDTO productFinishListDTO) {
        return productFinishMapper.list(productFinishListDTO);
    }

    @Override
    public ProductFinish getById(Long id) {
        return productFinishMapper.getById(id);
    }

    @Override
    public void add(ProductFinish productFinish) {
        productFinishMapper.add(productFinish);
    }

    @Override
    public void update(ProductFinish productFinish) {
        productFinishMapper.update(productFinish);
    }

    @Override
    public void delete(Long id) {
        productFinishMapper.delete(id);
    }
}
