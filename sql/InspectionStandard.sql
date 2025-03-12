CREATE TABLE InspectionStandard (
                                    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID',
                                    checkDate DATETIME NOT NULL COMMENT '检验时间',
                                    checkItemName VARCHAR(255) NOT NULL COMMENT '检验项',
                                    checkQuantity DOUBLE NOT NULL COMMENT '抽检数量',
                                    checkResult TINYINT(1) NOT NULL COMMENT '检验结果：0-不合格，1-合格',
                                    checkStandardId BIGINT NOT NULL COMMENT '检验标准编号',
                                    checkUser VARCHAR(255) NOT NULL COMMENT '检验人',
                                    checkValue DOUBLE NOT NULL COMMENT '检验值',
                                    materialBatchNo VARCHAR(255) NOT NULL COMMENT '检验批次',
                                    `maxValue` DOUBLE NOT NULL COMMENT '标准值上限',
                                    `minValue` DOUBLE NOT NULL COMMENT '标准值下限',
                                    createTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                    updateTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT='检验值标准表';

INSERT INTO InspectionStandard (
    checkDate, checkItemName, checkQuantity, checkResult, checkStandardId,
    checkUser, checkValue, materialBatchNo, `maxValue`, `minValue`
) VALUES
      ('2025-03-12 10:00:00', '蛋白质含量', 100, 1, 101, '张三', 18.5, 'BATCH2025031201', 20.0, 15.0),
      ('2025-03-12 10:30:00', '水分含量', 80, 0, 102, '李四', 12.0, 'BATCH2025031202', 10.0, 5.0),
      ('2025-03-12 11:00:00', '酸度值', 120, 1, 103, '王五', 7.2, 'BATCH2025031203', 8.0, 6.0);

