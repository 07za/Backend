CREATE TABLE mesMaterialCheck (
                                  id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
                                  checkDate DATETIME COMMENT '检验时间',
                                  checkItemName VARCHAR(255) COMMENT '检验项',
                                  checkQuantity DOUBLE COMMENT '抽检数量',
                                  checkResult TINYINT(1) COMMENT '检验结果：0-不合格，1-合格',
                                  checkStandardId BIGINT COMMENT '检验标准编号',
                                  checkUser VARCHAR(255) COMMENT '检验人',
                                  checkValue DOUBLE COMMENT '检验值',
                                  createBy VARCHAR(255) COMMENT '创建用户',
                                  materialCode VARCHAR(255) COMMENT '物料编码',
                                  materialId BIGINT COMMENT '物料档案编号',
                                  materialModel VARCHAR(255) COMMENT '物料型号',
                                  materialName VARCHAR(255) COMMENT '物料名称',
                                  materialRequisitionId BIGINT COMMENT '领料单编号',
                                  materialRequisitionNo VARCHAR(255) COMMENT '领料单流水',
                                  materialSpecification VARCHAR(255) COMMENT '物料规格',
                                  materialUnit VARCHAR(50) COMMENT '物料单位',
                                  `maxValue` DOUBLE COMMENT '标准值上限',
                                  `minValue` DOUBLE COMMENT '标准值下限',
                                  receiveQuantity DOUBLE COMMENT '已领数量',
                                  requireQuantity DOUBLE COMMENT '需求数量',
                                  serialNo VARCHAR(255) COMMENT '流水号',
                                  remark TEXT COMMENT '备注',
                                  updateBy VARCHAR(255) COMMENT '更新用户',
                                  updateTime DATETIME COMMENT '更新时间',
                                  createTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                  updateTimestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间戳'
) COMMENT='来料检验表';

INSERT INTO mesMaterialCheck (
    checkDate, checkItemName, checkQuantity, checkResult, checkStandardId,
    checkUser, checkValue, createBy, materialCode, materialId,
    materialModel, materialName, materialRequisitionId, materialRequisitionNo,
    materialSpecification, materialUnit, `maxValue`, `minValue`,
    receiveQuantity, requireQuantity, serialNo, remark, updateBy, updateTime
) VALUES
      ('2025-03-12 09:30:00', '硬度测试', 50, 1, 1001, '张三', 7.5, 'admin', 'MAT2025031201', 2001,
       'XJ-100', '铝合金板', 3001, 'REQ2025031201',
       '10mm厚', '张', 10.0, 5.0,
       48.0, 50.0, 'SN2025031201', '符合标准', '李四', '2025-03-12 10:00:00'),

      ('2025-03-12 10:00:00', '耐高温测试', 30, 0, 1002, '李四', 600.0, 'admin', 'MAT2025031202', 2002,
       'HG-500', '耐火砖', 3002, 'REQ2025031202',
       '耐温1000℃', '块', 800.0, 500.0,
       30.0, 35.0, 'SN2025031202', '耐温未达标', '王五', '2025-03-12 10:30:00'),

      ('2025-03-12 11:00:00', '密度测定', 20, 1, 1003, '王五', 2.7, 'admin', 'MAT2025031203', 2003,
       'DM-300', '工业塑料', 3003, 'REQ2025031203',
       '高密度聚乙烯', '千克', 3.0, 2.5,
       20.0, 25.0, 'SN2025031203', '符合标准', '赵六', '2025-03-12 11:30:00');

