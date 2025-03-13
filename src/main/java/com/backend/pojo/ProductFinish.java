package com.backend.pojo;

import lombok.Data;

@Data
public class ProductFinish {
    private Long id;
    private String batchNo;
    private String createBy;
    private String finishDate;
    private Integer finishQuantity;
    private Integer jobId;
    private String jobName;
    private String materialCode;
    private Integer materialId;
    private String materialModel;
    private String materialName;
    private String materialSpecification;
    private String materialUnit;
    private Integer planId;
    private String planName;
    private String planNo;
    private String remark;
    private Integer scheduleId;
    private String serialNo;
    private String status;
    private String updateBy;
    private String updateTime;
}
