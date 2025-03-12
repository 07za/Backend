CREATE TABLE mesProductFinish (
                                  id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '编号',
                                  batchNo VARCHAR(255) COMMENT '生产批号',
                                  createBy VARCHAR(255) COMMENT '创建用户',
                                  finishDate DATETIME COMMENT '完工日期',
                                  finishQuantity DOUBLE COMMENT '生产数量',
                                  jobId BIGINT COMMENT '生产作业',
                                  jobName VARCHAR(255) COMMENT '作业名称',
                                  materialCode VARCHAR(255) COMMENT '物料编码',
                                  materialId BIGINT COMMENT '产品',
                                  materialModel VARCHAR(255) COMMENT '物料型号',
                                  materialName VARCHAR(255) COMMENT '物料名称',
                                  materialSpecification VARCHAR(255) COMMENT '物料规格',
                                  materialUnit VARCHAR(255) COMMENT '物料单位',
                                  planId BIGINT COMMENT '生产计划',
                                  planName VARCHAR(255) COMMENT '计划名称',
                                  planNo VARCHAR(255) COMMENT '计划号',
                                  remark TEXT COMMENT '备注',
                                  scheduleId BIGINT COMMENT '计划排产',
                                  serialNo VARCHAR(255) COMMENT '生产完工单号',
                                  status VARCHAR(255) COMMENT '状态   ',
                                  updateBy VARCHAR(255) COMMENT '更新用户',
                                  updateTime DATETIME COMMENT '更新时间'
) COMMENT='生产完工单';

INSERT INTO mesProductFinish (
    batchNo, createBy, finishDate, finishQuantity, jobId, jobName, materialCode, materialId,
    materialModel, materialName, materialSpecification, materialUnit, planId, planName, planNo,
    remark, scheduleId, serialNo, status, updateBy, updateTime
) VALUES (
             'PB20250312001', 'admin', '2025-03-12 08:00:00', 100.0, 1, 'Job1', 'M12345', 1,
             'ModelA', 'MaterialA', 'SpecA', 'UnitA', 1, 'Plan1', 'P001',
             'This is a remark for unfinished item', 1, 'SN20250312001', '未入库', 'admin', '2025-03-12 08:05:00'
         );

INSERT INTO mesProductFinish (
    batchNo, createBy, finishDate, finishQuantity, jobId, jobName, materialCode, materialId,
    materialModel, materialName, materialSpecification, materialUnit, planId, planName, planNo,
    remark, scheduleId, serialNo, status, updateBy, updateTime
) VALUES (
             'PB20250312002', 'admin', '2025-03-12 09:00:00', 150.5, 2, 'Job2', 'M54321', 2,
             'ModelB', 'MaterialB', 'SpecB', 'UnitB', 2, 'Plan2', 'P002',
             'This is a remark for item in storage process', 2, 'SN20250312002', '入库中', 'admin', '2025-03-12 09:05:00'
         );

INSERT INTO mesProductFinish (
    batchNo, createBy, finishDate, finishQuantity, jobId, jobName, materialCode, materialId,
    materialModel, materialName, materialSpecification, materialUnit, planId, planName, planNo,
    remark, scheduleId, serialNo, status, updateBy, updateTime
) VALUES (
             'PB20250312003', 'admin', '2025-03-12 10:00:00', 200.0, 3, 'Job3', 'M67890', 3,
             'ModelC', 'MaterialC', 'SpecC', 'UnitC', 3, 'Plan3', 'P003',
             'This is a remark for finished storage', 3, 'SN20250312003', '已入库', 'admin', '2025-03-12 10:05:00'
         );

INSERT INTO mesProductFinish (
    batchNo, createBy, finishDate, finishQuantity, jobId, jobName, materialCode, materialId,
    materialModel, materialName, materialSpecification, materialUnit, planId, planName, planNo,
    remark, scheduleId, serialNo, status, updateBy, updateTime
) VALUES (
             'PB20250312004', 'admin', '2025-03-12 11:00:00', 80.0, 4, 'Job4', 'M98765', 4,
             'ModelD', 'MaterialD', 'SpecD', 'UnitD', 4, 'Plan4', 'P004',
             'This is a remark for qualified inspection', 4, 'SN20250312004', '检验合格', 'admin', '2025-03-12 11:05:00'
         );

INSERT INTO mesProductFinish (
    batchNo, createBy, finishDate, finishQuantity, jobId, jobName, materialCode, materialId,
    materialModel, materialName, materialSpecification, materialUnit, planId, planName, planNo,
    remark, scheduleId, serialNo, status, updateBy, updateTime
) VALUES (
             'PB20250312005', 'admin', '2025-03-12 12:00:00', 90.5, 5, 'Job5', 'M56789', 5,
             'ModelE', 'MaterialE', 'SpecE', 'UnitE', 5, 'Plan5', 'P005',
             'This is a remark for unqualified inspection', 5, 'SN20250312005', '检验未合格', 'admin', '2025-03-12 12:05:00'
         );