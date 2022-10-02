package com.edurumluemrullah.northwind_backend.common.results;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({ "isSuccess", "message","data" })
public class DataResult<T> extends Result{

    @JsonProperty("data")
    T data;

    public DataResult(boolean isSuccess, String message, T data) {
        super(isSuccess, message);
        this.data = data;
    }
}
