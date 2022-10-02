package com.edurumluemrullah.northwind_backend.common.results;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({ "isSuccess", "message" })
public class Result {

    @JsonProperty("isSuccess")
    private boolean isSuccess;

    @JsonProperty("message")
    private String message;

    public Result() {
    }

    public Result(boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }
}
