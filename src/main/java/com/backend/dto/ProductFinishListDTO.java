package com.backend.dto;

import lombok.Data;

@Data
public class ProductFinishListDTO {
    private String batchNo;//生产批号
    private String finishDateStart;//完工日期开始
    private String finishDateEnd;//完工日期结束
    private Integer jobID;//生产作业
    private Integer materialID;//产品
    private Integer planID;//生产计划
    private String status;//状态
}
