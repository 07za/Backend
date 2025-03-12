package com.backend.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;

@Data
public class NewsInformation {
    private int id;
    private String title;
    private String publisher;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publishDate;
    private int viewCount;
    private String content;
}

