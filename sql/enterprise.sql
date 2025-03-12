CREATE TABLE enterprise (
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            logo VARCHAR(255),
                            businessLicense VARCHAR(255),
                            name VARCHAR(255),
                            creditCode VARCHAR(18),
                            registeredAddress VARCHAR(255),
                            registeredCapital DECIMAL(15,2),
                            enterpriseType VARCHAR(50),
                            establishmentDate DATE,
                            legalRepresentative VARCHAR(100),
                            legalRepresentativeIdCard VARCHAR(18),
                            legalRepresentativeIdCardScan VARCHAR(255),
                            businessLicenseValidity DATE,
                            businessScope TEXT,
                            contactPhone VARCHAR(20),
                            accountLicenseScan VARCHAR(255),
                            bankName VARCHAR(255),
                            bankAccount VARCHAR(50),
                            bankAddress VARCHAR(255)
) COMMENT='企业信息表';
ALTER TABLE enterprise
    ADD COLUMN auditStatus varchar(32) DEFAULT '待审核' COMMENT '审核状态';
