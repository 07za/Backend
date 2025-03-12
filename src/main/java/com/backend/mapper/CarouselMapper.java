package com.backend.mapper;

import com.backend.pojo.Carousel;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface CarouselMapper {
    List<Carousel> list();
    
    void add(Carousel carousel);
    
    void update(Carousel carousel);
    
    void delete(Integer id);
    
    Carousel getById(Integer id);
} 