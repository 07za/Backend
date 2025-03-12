package com.backend.controller;

import com.backend.dto.NewsInformationDTO;
import com.backend.pojo.NewsInformation;
import com.backend.pojo.Result;
import com.backend.service.NewsInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bid/bidding/newsInformation")
public class NewsInformationController {
    
    @Autowired
    private NewsInformationService newsInformationService;
    
    @GetMapping("/list")
    public Result<List<NewsInformation>> list(NewsInformationDTO newsInformationDTO) {
        List<NewsInformation> list = newsInformationService.list(newsInformationDTO);
        return Result.success(list);
    }
    
    @GetMapping("/{id}")
    public Result<NewsInformation> getById(@PathVariable Integer id) {
        NewsInformation newsInformation = newsInformationService.getById(id);
        return Result.success(newsInformation);
    }
} 