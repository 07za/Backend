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