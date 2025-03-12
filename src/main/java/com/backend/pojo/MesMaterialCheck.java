package com.backend.pojo;

import lombok.Data;
import java.util.Date;

@Data
public class MesMaterialCheck {
    private Long id; // 编号（主键）
    private Date checkDate; // 检验时间
    private String checkItemName; // 检验项
    private Double checkQuantity; // 抽检数量
    private Integer checkResult; // 检验结果：0-不合格，1-合格
    private Long checkStandardId; // 检验标准编号
    private String checkUser; // 检验人
    private Double checkValue; // 检验值
    private String createBy; // 创建用户
    private String materialCode; // 物料编码
    private Long materialId; // 物料档案编号
    private String materialModel; // 物料型号
    private String materialName; // 物料名称
    private Long materialRequisitionId; // 领料单编号
    private String materialRequisitionNo; // 领料单流水
    private String materialSpecification; // 物料规格
    private String materialUnit; // 物料单位
    private Double maxValue; // 标准值上限
    private Double minValue; // 标准值下限
    private Double receiveQuantity; // 已领数量
    private Double requireQuantity; // 需求数量
    private String serialNo; // 流水号
    private String remark; // 备注
    private String updateBy; // 更新用户
    private Date updateTime; // 更新时间
}

