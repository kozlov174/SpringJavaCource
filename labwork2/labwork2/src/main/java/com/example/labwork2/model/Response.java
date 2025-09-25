package com.example.labwork2.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    @NotBlank
    private String uid;

    @NotBlank
    private String operationUid;

    @NotBlank
    private String systemTime;

    @NotBlank
    @Pattern(regexp = "success|failed")
    private String code;

    @NotBlank
    @Pattern(regexp = "UnsupportedCodeException|ValidationException|UnknownException")
    private String errorCode;

    @NotBlank
    private String errorMessage;
}
