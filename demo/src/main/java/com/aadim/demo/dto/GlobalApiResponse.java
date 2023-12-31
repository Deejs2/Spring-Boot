package com.aadim.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GlobalApiResponse {
    private LocalDateTime timestamp;
    private String message;
    private Object data;
    private String status;
}
