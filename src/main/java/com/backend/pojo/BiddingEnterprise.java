package com.backend.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;

@Data
public class BiddingEnterprise {
    private Integer id;
    private Integer announcementId;
    private String enterpriseName;
    private String status;
    private String biddingFile;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
} 