package com.backend.controller;

import com.backend.dto.ProductFinishListDTO;
import com.backend.pojo.Result;
import com.backend.pojo.ProductFinish;
import com.backend.service.ProductFinishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesFinish/productFinish")
public class ProductFinishController {

    @Autowired
    private ProductFinishService productFinishService;

    @GetMapping("/list")
    public Result<List<ProductFinish>> list(@ModelAttribute ProductFinishListDTO productFinishListDTO) {
        List<ProductFinish> list = productFinishService.list(productFinishListDTO);
        return Result.success(list);
    }

    @GetMapping("/{id}")
    public Result<ProductFinish> getById(@PathVariable Long id) {
        ProductFinish productFinish = productFinishService.getById(id);
        return Result.success(productFinish);
    }

    @PostMapping
    public Result add(@RequestBody ProductFinish productFinish) {
        productFinishService.add(productFinish);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody ProductFinish productFinish) {
        productFinishService.update(productFinish);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        productFinishService.delete(id);
        return Result.success();
    }
}
