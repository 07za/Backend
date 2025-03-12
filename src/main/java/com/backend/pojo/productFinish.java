package com.backend.pojo;

import lombok.Data;

@Data
public class productFinish {
    private Long id;
    private String batchNo;
    private String createBy;
    private String finishDate;
    private Integer finishQuantity;
    private Integer jobID;
    private String jobName;
    private String materialCode;
    private Integer materialID;
    private String materialModel;
    private String materialName;
    private String materialSpecification;
    private String materialUnit;
    private Integer planID;
    private String planName;
    private String planNo;
    private String remark;
    private String scheduleID;
    private String serialNo;
    private String status;
    private String updateBy;
    private String updateTime;
}
