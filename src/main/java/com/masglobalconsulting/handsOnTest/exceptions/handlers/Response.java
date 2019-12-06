package com.masglobalconsulting.handsOnTest.exceptions.handlers;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
    private Integer status;
    private String message;
}
