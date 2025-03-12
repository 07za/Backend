CREATE TABLE carousel (
                          id INT PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
                          image_url VARCHAR(255) COMMENT '图片地址',
                          remark VARCHAR(255) COMMENT '备注',
                          create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                          update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
);

INSERT INTO carousel (image_url, remark) VALUES
                                             ('img/carousel/1.png', '轮播图1'),
                                             ('img/carousel/2.png', '轮播图2'),
                                             ('img/carousel/3.png', '轮播图3');