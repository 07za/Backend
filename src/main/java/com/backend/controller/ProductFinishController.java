package com.backend.controller;

import com.backend.dto.ProductFinishListDTO;
import com.backend.pojo.Result;
import com.backend.pojo.ProductFinish;
import com.backend.service.ProductFinishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mesFinish/productFinish")
public class ProductFinishController {

    @Autowired
    ProductFinishService productFinishService;

    @GetMapping("/list ")
    public Result<List<ProductFinish>> list(@ModelAttribute ProductFinishListDTO productFinishListDTO) {
        List<ProductFinish> list = productFinishService.list(productFinishListDTO);
        return Result.success(list);
    }
}
