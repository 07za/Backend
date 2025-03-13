-- 采购公告表
CREATE TABLE procurement_announcement (
                                          id INT PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
                                          title VARCHAR(255) COMMENT '标题',
                                          publisher VARCHAR(100) COMMENT '发布者',
                                          contact VARCHAR(50) COMMENT '联系方式',
                                          content TEXT COMMENT '采购内容',
                                          publish_time DATETIME COMMENT '发布时间',
                                          file_url VARCHAR(255) COMMENT '附件路径',
                                          announcement_type VARCHAR(50) COMMENT '公告类型',
                                          create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                          update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
);

-- 插入采购公告测试数据
INSERT INTO procurement_announcement (title, publisher, contact, content, publish_time, file_url, announcement_type) VALUES
                                                                                                                         ('2024年度办公用品采购项目', '采购部', '张三 13800138000', '采购办公用品，包括打印纸、文具等', '2024-03-12 10:00:00', 'files/procurement/doc1.pdf', '物资采购'),
                                                                                                                         ('设备维护服务采购', '技术部', '李四 13900139000', '采购设备年度维护服务', '2024-03-11 14:30:00', 'files/procurement/doc2.pdf', '服务采购'),
                                                                                                                         ('新能源设备采购项目', '工程部', '王五 13700137000', '采购太阳能发电设备', '2024-03-10 09:15:00', 'files/procurement/doc3.pdf', '设备采购');

-- 修改采购公告表，添加新字段
ALTER TABLE procurement_announcement
    ADD COLUMN bidding_content TEXT COMMENT '招标内容',
    ADD COLUMN registration_status VARCHAR(50) DEFAULT '开放报名' COMMENT '报名状态(开放报名/截止报名)',
    ADD COLUMN bidding_name VARCHAR(255) COMMENT '标的发布名称',
    ADD COLUMN bidding_end_time DATETIME COMMENT '投标结束时间';

-- 更新现有数据，添加新字段值
UPDATE procurement_announcement SET
                                    bidding_content = '详细招标要求和技术规格说明',
                                    registration_status = '开放报名',
                                    bidding_name = CONCAT(title, '标的'),
                                    bidding_end_time = DATE_ADD(publish_time, INTERVAL 15 DAY);

-- 插入新的测试数据
INSERT INTO procurement_announcement (
    title, publisher, contact, content, publish_time,
    file_url, announcement_type, bidding_content,
    registration_status, bidding_name, bidding_end_time
) VALUES (
             '2024年度环保设备采购项目', '环保部', '赵六 13600136000',
             '采购环保监测设备', '2024-03-15 11:30:00',
             'files/procurement/doc4.pdf', '设备采购',
             '本次招标采购环保监测设备，包括空气质量监测仪、水质监测仪等设备',
             '开放报名', '环保设备采购标的', '2024-04-15 11:30:00'
         );