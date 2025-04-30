package com.eazybytes.accounts.dto;

import lombok.*;

@Data
public class ResponseDTO {

    public ResponseDTO(String statusCode, String statusMsg) {
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
    }

    private String statusCode;
    private String statusMsg;
}
