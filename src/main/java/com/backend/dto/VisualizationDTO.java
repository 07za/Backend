package com.backend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class VisualizationDTO {

    private String dateMonth;

    private Double totalSales;

    private Double totalContract;

}
