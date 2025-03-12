-- 创建 announcement_changes 表
CREATE TABLE announcement_changes (
                                      id INT PRIMARY KEY AUTO_INCREMENT,
                                      title VARCHAR(255) NOT NULL,
                                      publisher VARCHAR(255),
                                      publish_date DATE,
                                      view_count INT DEFAULT 0,
                                      content TEXT
);

-- 创建 news_information 表
CREATE TABLE news_information (
                                  id INT PRIMARY KEY AUTO_INCREMENT,
                                  title VARCHAR(255) NOT NULL,
                                  publisher VARCHAR(255),
                                  publish_date DATE,
                                  view_count INT DEFAULT 0,
                                  content TEXT
);

-- 向 announcement_changes 表插入数据
INSERT INTO announcement_changes (title, publisher, publish_date, view_count, content)
VALUES
    ('关于道路维护项目调整公告', '绍兴市交通局', '2023-09-01', 150, '因施工计划调整，原定施工时间将顺延一周，具体时间另行通知。'),
    ('政府采购信息系统升级公告', '浙江省财政厅', '2023-09-05', 200, '为提升采购管理效率，政府采购系统将于9月10日进行升级。'),
    ('学校食堂食品安全监督公告', '博兴县教育局', '2023-09-10', 130, '加强校园食品安全管理，落实每日检查制度，确保学生健康。'),
    ('医院新设备采购招标公告', '杭州市第一人民医院', '2023-09-15', 175, '本院计划采购一批先进医疗设备，欢迎符合资质的供应商投标。'),
    ('环保局关于空气质量监测设备升级的公告', '浙江省环保局', '2023-09-20', 210, '本次设备升级将提高监测精度，进一步优化空气质量管理。');

-- 向 news_information 表插入数据
INSERT INTO news_information (title, publisher, publish_date, view_count, content)
VALUES
    ('5G 技术加速产业变革', '中国通信协会', '2023-09-22', 600, '5G 商用化的推进正推动多个行业数字化升级。'),
    ('人工智能助力智慧城市建设', '智慧城市研究院', '2023-09-25', 550, 'AI 技术在交通管理、安防、环保等领域发挥重要作用。'),
    ('新能源汽车市场迎来政策红利', '国家发改委', '2023-09-28', 480, '政府出台新政策支持新能源车产业，促进绿色出行。'),
    ('国际油价持续波动对经济的影响', '经济观察报', '2023-10-02', 430, '全球油价走势受到地缘政治和市场需求变化的影响。'),
    ('无人驾驶技术取得突破性进展', '自动驾驶技术联盟', '2023-10-05', 510, '最新自动驾驶算法显著提升了车辆识别能力和行驶安全性。');
