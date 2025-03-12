package com.backend.service;

import com.backend.pojo.Carousel;
import java.util.List;

public interface CarouselService {
    List<Carousel> list();
    
    void add(Carousel carousel);
    
    void update(Carousel carousel);
    
    void delete(Integer id);
    
    Carousel getById(Integer id);
} 