package com.yunusemrenalbant.order.dto.debezium;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DebeziumEvent {

    @JsonProperty("before")
    private Before before;
    @JsonProperty("after")
    private After after;
    @JsonProperty("source")
    private Source source;
    @JsonProperty("op")
    private String op;
    @JsonProperty("ts_ms")
    private Long ts;
    @JsonProperty("transaction")
    private Object transaction;
}
