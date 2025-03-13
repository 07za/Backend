package com.backend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;

@Data
public class ProcurementAnnouncementDTO {
    private String title;
    private String publisher;
    private String announcementType;
    private String registrationStatus;
    private String biddingName;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startTime;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endTime;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date biddingEndTimeStart;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date biddingEndTimeEnd;
} 