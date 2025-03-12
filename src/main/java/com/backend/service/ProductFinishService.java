package com.backend.service;

import com.backend.dto.ProductFinishListDTO;
import com.backend.pojo.ProductFinish;

import java.util.List;

public interface ProductFinishService {
    List<ProductFinish> list(ProductFinishListDTO productFinishListDTO);
}
