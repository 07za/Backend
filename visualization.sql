CREATE TABLE sale_order (
                            id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
                            order_no VARCHAR(50) NOT NULL COMMENT '订单编号',
                            customer_id BIGINT NOT NULL COMMENT '客户id',
                            order_amount DECIMAL(20,2) NOT NULL COMMENT '金额合计',
                            delivery_date DATETIME NOT NULL COMMENT '交货日期',
                            apply_user VARCHAR(50) NOT NULL COMMENT '申请人',
                            apply_time DATETIME NOT NULL COMMENT '申请时间',
                            apply_status VARCHAR(10) NOT NULL COMMENT '申请状态：0未提交1待审核',
                            audit_user VARCHAR(50) DEFAULT NULL COMMENT '审核人',
                            audit_time DATETIME DEFAULT NULL COMMENT '审核时间',
                            audit_status VARCHAR(10) DEFAULT NULL COMMENT '审核状态：0审核未通过1审核通过',
                            audit_comment VARCHAR(200) DEFAULT NULL COMMENT '审核意见',
                            remark VARCHAR(200) DEFAULT NULL COMMENT '备注'
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='销售订单表';