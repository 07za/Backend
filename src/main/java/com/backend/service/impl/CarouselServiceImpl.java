package com.backend.service.impl;

import com.backend.mapper.CarouselMapper;
import com.backend.pojo.Carousel;
import com.backend.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarouselServiceImpl implements CarouselService {
    
    @Autowired
    private CarouselMapper carouselMapper;
    
    @Override
    public List<Carousel> list() {
        return carouselMapper.list();
    }
    
    @Override
    public void add(Carousel carousel) {
        carouselMapper.add(carousel);
    }
    
    @Override
    public void update(Carousel carousel) {
        carouselMapper.update(carousel);
    }
    
    @Override
    public void delete(Integer id) {
        carouselMapper.delete(id);
    }
    
    @Override
    public Carousel getById(Integer id) {
        return carouselMapper.getById(id);
    }
} 