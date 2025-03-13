-- 投标企业表
CREATE TABLE bidding_enterprise (
                                    id INT PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
                                    announcement_id INT COMMENT '公告ID',
                                    enterprise_name VARCHAR(255) COMMENT '企业名称',
                                    status VARCHAR(50) COMMENT '状态(已提交/未提交)',
                                    bidding_file VARCHAR(255) COMMENT '投标文件路径',
                                    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
);

-- 插入投标企业测试数据
INSERT INTO bidding_enterprise (announcement_id, enterprise_name, status, bidding_file) VALUES
                                                                                            (1, '优质办公用品有限公司', '已提交', 'files/bidding/bid1.pdf'),
                                                                                            (1, '文具批发有限公司', '未提交', null),
                                                                                            (2, '设备维护服务公司', '已提交', 'files/bidding/bid2.pdf'),
                                                                                            (2, '专业维修有限公司', '已提交', 'files/bidding/bid3.pdf'),
                                                                                            (3, '新能源科技有限公司', '已提交', 'files/bidding/bid4.pdf'),
                                                                                            (3, '绿色能源设备公司', '未提交', null);