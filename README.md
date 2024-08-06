# CDC Debezium and Kafka
This project demonstrates the integration of Kafka and Debezium with Spring Boot. It is designed to showcase how to capture changes from a PostgreSQL database and process them through Kafka.

## Overview
Debezium is a change data capture (CDC) tool that helps track and record changes in database tables in real-time. It allows applications to react to data changes as they happen, enabling real-time data processing and synchronization. In this project, Debezium is used to monitor changes in a PostgreSQL database, sending these changes to Kafka topics, which are then consumed by a Spring Boot application.


## Features

- Kafka and Zookeeper are managed using Docker containers.
- PostgreSQL database changes are captured and published using Debezium.
- Kafka UI tool is used to monitor Kafka topics and messages.
- Spring Boot application processes and logs Debezium events received from Kafka.


## Debezium Connector Configuration
To set up the Debezium PostgreSQL connector, you need to create a connector configuration. Use the following JSON payload and send it to the Debezium REST API:

````json
{
  "name": "order-debezium",
  "config": {
    "connector.class": "io.debezium.connector.postgresql.PostgresConnector",
    "tasks.max": "1",
    "database.history.kafka.bootstrap.servers": "kafka:29092",
    "database.server.name": "db",
    "database.hostname": "db",
    "database.port": "5432",
    "database.user": "root",
    "database.password": "123123123",
    "database.dbname": "order_service",
    "plugin.name": "pgoutput",
    "table.include.list": "public.orders",
    "heartbeat.interval.ms": "5000",
    "schema.history.internal.file.filename": "schema-history.dat",
    "key.converter": "org.apache.kafka.connect.json.JsonConverter",
    "key.converter.schemas.enable": "false",
    "value.converter": "org.apache.kafka.connect.json.JsonConverter",
    "value.converter.schemas.enable": "false",
    "offset.flush.interval.ms": "60000",
    "topic.prefix": "yunus",
    "tombstones.on.delete": "false",
    "skipped.operations": "t,d"
  }
}
````

## API Request

To create the connector, make a POST request to the Debezium Connect REST API endpoint:

```bash
curl -X POST \
  http://localhost:8083/connectors \
  -H "Content-Type: application/json" \
  -d @connector-config.json
```

Replace localhost with the address of your Debezium Connect server if it's different.


