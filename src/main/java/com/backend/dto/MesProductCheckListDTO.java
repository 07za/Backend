package com.backend.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MesProductCheckListDTO {
    private Date checkDateStart; // 检验时间

    private Date checkDateEnd; // 检验时间

    private String checkItemName; // 检验项

    private String checkResult; // 检验结果：0不合格，1合格

    private String checkUser; // 检验人

    private Date productDateStart; // 生产日期

    private Date productDateEnd; // 生产日期

    private String productFinishNo; // 完工单号

    private String productJobName; // 作业名称

    private String productPlanNo; // 计划编号

    private String serialNo; // 流水号

    private String materialName; // 产品名称

    private String materialBatchNo; // 检验批次
}
