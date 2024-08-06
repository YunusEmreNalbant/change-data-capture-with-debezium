package com.yunusemrenalbant.order.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunusemrenalbant.order.dto.debezium.DebeziumEvent;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;

public class OrderCDCDeserializer implements Deserializer<DebeziumEvent> {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Deserializer.super.configure(configs, isKey);
    }

    @Override
    public DebeziumEvent deserialize(String s, byte[] bytes) {
        try {
            return objectMapper.readValue(bytes, DebeziumEvent.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public DebeziumEvent deserialize(String topic, Headers headers, byte[] data) {
        return Deserializer.super.deserialize(topic, headers, data);
    }

    @Override
    public DebeziumEvent deserialize(String topic, Headers headers, ByteBuffer data) {
        return Deserializer.super.deserialize(topic, headers, data);
    }

    @Override
    public void close() {
        Deserializer.super.close();
    }
}
