package com.backend.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;

@Data
public class BiddingProject {
    private Integer id;                    // 序号
    private String biddingStatus;         // 投标状态(未投标/已投标/已截止)
    private String biddingName;           // 标的发布名称
    private String bidResult;             // 中标结果(未开标/已中标/未中标)
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date biddingEndTime;          // 投标结束时间
    
    private String registrationStatus;     // 报名状态(未报名/已报名/已截止)
    private String biddingProgress;       // 投标进度(未开始/进行中/已完成)
    private String projectTitle;          // 项目标题
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date publishTime;             // 发布时间
    
    private String publishEnterprise;     // 发布企业
    private String projectSummary;        // 内容简介
    private String idCard;                // 身份证号
    private String signatureUrl;          // 签字图片路径
    private String idCardUrl;             // 身份证图片路径
    private String fileUrl;               // 上传文件路径
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;              // 创建时间
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;              // 更新时间
} 