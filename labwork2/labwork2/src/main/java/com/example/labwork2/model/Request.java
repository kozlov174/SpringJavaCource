package com.example.labwork2.model;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.NotBlank;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {

    @NotBlank
    private String uid;

    private String operationUid;
    private String systemName;
    private String systemTime;
    private String source;
    private int communicationId;
    private int templateId;
    private int productCode;
    private int smsCode;
}