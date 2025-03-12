package com.backend.service;

import com.backend.dto.ProductFinishListDTO;
import com.backend.pojo.ProductFinish;

import java.util.List;

public interface ProductFinishService {
    List<ProductFinish> list(ProductFinishListDTO productFinishListDTO);

    ProductFinish getById(Long id);

    void add(ProductFinish productFinish);

    void update(ProductFinish productFinish);

    void delete(Long id);
}
