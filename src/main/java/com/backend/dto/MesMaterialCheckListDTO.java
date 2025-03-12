package com.backend.dto;

import lombok.Data;
import java.util.Date;

@Data
public class MesMaterialCheckListDTO {
    private Date checkDateStart;    // 检验开始时间
    private Date checkDateEnd;      // 检验结束时间
    private String checkUser;       // 检验人
    private String materialName;    // 物料名称
    private String materialRequisitionNo;  // 领料单号
    private String serialNo;        // 流水号
    private String checkResult;     // 检验结果
} 