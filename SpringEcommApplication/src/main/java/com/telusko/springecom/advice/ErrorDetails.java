package com.telusko.springecom.advice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
    private String message;
    private Integer statusCode;
    private LocalDateTime timestamp;
    private String productImage;
}
