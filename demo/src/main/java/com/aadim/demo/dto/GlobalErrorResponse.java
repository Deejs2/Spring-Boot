package com.aadim.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GlobalErrorResponse {
    private LocalDateTime timestamp;
    private String message;
    private List<String> error;
    private String status;

    public GlobalErrorResponse(HttpStatus status, List<String> errorList, String statusType){
        this.timestamp = LocalDateTime.now();
        this.message = status.name();
        this.error = errorList;
        this.status = statusType;
    }
}
