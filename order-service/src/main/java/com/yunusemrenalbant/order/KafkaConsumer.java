package com.yunusemrenalbant.order;

import com.yunusemrenalbant.order.dto.debezium.DebeziumEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
public class KafkaConsumer {

    private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(
            topics = "yunus.public.orders",
            groupId = "order-group"
    )
    public void debeziumListener(DebeziumEvent event) {
        if (event.getOp().equals("c")) {
            log.info("Order created: " + event.getAfter());
        }

        if (event.getOp().equals("u")) {
            log.info("Order updated before: " + event.getBefore());
            log.info("Order updated after: " + event.getAfter());
        }
    }
}
