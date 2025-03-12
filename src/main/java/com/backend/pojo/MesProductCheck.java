package com.backend.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;

@Data
public class MesProductCheck {

    private Long id; // 编号

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date checkDate; // 检验时间

    private String checkItemName; // 检验项

    private Double checkQuantity; // 抽检数量

    private String checkResult; // 检验结果：0不合格，1合格

    private Long checkStandardId; // 检验标准编号

    private String checkUser; // 检验人

    private Double checkValue; // 检验值

    private String createBy; // 创建用户

    private String materialBatchNo; // 检验批次

    private String materialCode; // 物料编码

    private Long materialId; // 物料档案编号

    private String materialModel; // 物料型号

    private String materialName; // 产品名称

    private String materialSpecification; // 物料规格

    private String materialUnit; // 物料单位

    private Double maxValue; // 标准值上限

    private Double minValue; // 标准值下限

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date productDate; // 生产日期

    private Long productFinishId; // 完工单id

    private String productFinishNo; // 完工单号

    private Long productJobId; // 生产作业编号

    private String productJobName; // 作业名称

    private Long productLineId; // 生产线编号

    private String productLineName; // 生产线名称

    private Long productPlanId; // 生产计划编号

    private String productPlanNo; // 计划编号

    private Double productQuantity; // 生产数量

    private Long productScheduleId; // 计划排产编号

    private Double qualifiedRate; // 合格率

    private String remark; // 备注

    private String searchValue; // 搜索值

    private String serialNo; // 流水号

    private String updateBy; // 更新用户

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime; // 更新时间

    private String params; // 其他参数（JSON 字符串）
}
