package com.backend.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;

@Data
public class ProcurementAnnouncement {
    private Integer id;
    private String title;
    private String publisher;
    private String contact;
    private String content;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date publishTime;
    
    private String fileUrl;
    private String announcementType;
    
    private String biddingContent;
    private String registrationStatus;
    private String biddingName;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date biddingEndTime;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
} 