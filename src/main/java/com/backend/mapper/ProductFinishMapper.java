package com.backend.mapper;

import com.backend.dto.ProductFinishListDTO;
import com.backend.pojo.ProductFinish;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductFinishMapper {
    List<ProductFinish> list(ProductFinishListDTO productFinishListDTO);

    ProductFinish getById(Long id);

    void add(ProductFinish productFinish);

    void update(ProductFinish productFinish);

    void delete(Long id);
}
