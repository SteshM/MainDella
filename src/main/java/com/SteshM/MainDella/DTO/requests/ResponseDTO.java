package com.SteshM.MainDella.DTO.requests;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ResponseDTO {
    private int statusCode;
    private String statusDescription;
    private List<?> data;
}
