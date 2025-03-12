package com.backend.pojo;

import com.backend.enums.CheckResultEnum;
import lombok.Data;
import java.util.Date;

@Data
public class InspectionStandard {
    private Long id; // 主键ID
    private Date checkDate; // 检验时间
    private String checkItemName; // 检验项
    private Double checkQuantity; // 抽检数量
    private CheckResultEnum checkResult; // 检验结果：0-不合格，1-合格
    private Long checkStandardId; // 检验标准编号
    private String checkUser; // 检验人
    private Double checkValue; // 检验值
    private String materialBatchNo; // 检验批次
    private Double maxValue; // 标准值上限
    private Double minValue; // 标准值下限
    private Date createTime; // 创建时间
    private Date updateTime; // 更新时间
}

