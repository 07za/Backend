package com.backend.pojo;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class Enterprise {
    private Integer id;
    private String logo;
    private String businessLicense;
    private String name;
    private String creditCode;
    private String registeredAddress;
    private Double registeredCapital;
    private String enterpriseType;
    private Date establishmentDate;
    private String legalRepresentative;
    private String legalRepresentativeIdCard;
    private String legalRepresentativeIdCardScan;
    private Date businessLicenseValidity;
    private String businessScope;
    private String contactPhone;
    private String accountLicenseScan;
    private String bankName;
    private String bankAccount;
    private String bankAddress;
    private String auditStatus;
}
