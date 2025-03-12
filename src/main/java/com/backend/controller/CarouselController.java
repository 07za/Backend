package com.backend.controller;

import com.backend.pojo.Carousel;
import com.backend.pojo.Result;
import com.backend.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/carousel")
public class CarouselController {
    
    @Autowired
    private CarouselService carouselService;
    
    // 图片保存路径
    private static final String IMAGE_PATH = "img/carousel/";
    
    @GetMapping("/list")
    public Result<List<Carousel>> list() {
        List<Carousel> list = carouselService.list();
        return Result.success(list);
    }
    
    @GetMapping("/{id}")
    public Result<Carousel> getById(@PathVariable Integer id) {
        Carousel carousel = carouselService.getById(id);
        return Result.success(carousel);
    }
    
    @PostMapping
    public Result add(@RequestParam("file") MultipartFile file, String remark) {
        try {
            // 确保目录存在
            File dir = new File(IMAGE_PATH);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            
            // 生成唯一文件名
            String originalFilename = file.getOriginalFilename();
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            String filename = UUID.randomUUID().toString() + suffix;
            
            // 保存文件
            file.transferTo(new File(dir, filename));
            
            // 保存数据库记录
            Carousel carousel = new Carousel();
            carousel.setImageUrl(IMAGE_PATH + filename);
            carousel.setRemark(remark);
            carouselService.add(carousel);
            
            return Result.success();
        } catch (IOException e) {
            return Result.error("文件上传失败");
        }
    }
    
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, 
                        @RequestParam(value = "file", required = false) MultipartFile file,
                        String remark) {
        try {
            Carousel carousel = carouselService.getById(id);
            if (carousel == null) {
                return Result.error("轮播图不存在");
            }
            
            // 如果上传了新图片
            if (file != null && !file.isEmpty()) {
                // 删除旧图片
                File oldFile = new File(carousel.getImageUrl());
                if (oldFile.exists()) {
                    oldFile.delete();
                }
                
                // 确保目录存在
                File dir = new File(IMAGE_PATH);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                
                // 生成唯一文件名
                String originalFilename = file.getOriginalFilename();
                String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
                String filename = UUID.randomUUID().toString() + suffix;
                
                // 保存新文件
                file.transferTo(new File(dir, filename));
                carousel.setImageUrl(IMAGE_PATH + filename);
            }
            
            // 更新备注
            carousel.setRemark(remark);
            carouselService.update(carousel);
            
            return Result.success();
        } catch (IOException e) {
            return Result.error("文件上传失败");
        }
    }
    
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        // 删除图片文件
        Carousel carousel = carouselService.getById(id);
        if (carousel != null) {
            File file = new File(carousel.getImageUrl());
            if (file.exists()) {
                file.delete();
            }
        }
        
        // 删除数据库记录
        carouselService.delete(id);
        return Result.success("删除成功");
    }
} 