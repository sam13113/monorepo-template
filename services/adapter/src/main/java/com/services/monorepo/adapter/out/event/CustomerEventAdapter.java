package com.services.monorepo.adapter.out.event;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.services.monorepo.adapter.configuration.KafkaProducerConfiguration;
import com.services.monorepo.domain.application.port.spi.CustomerEventPort;
import com.services.monorepo.domain.model.Customer;
import io.cloudevents.CloudEvent;
import io.cloudevents.core.builder.CloudEventBuilder;
import io.cloudevents.core.data.PojoCloudEventData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomerEventAdapter implements CustomerEventPort {

    private final KafkaProducerConfiguration configuration;
    @Override
    public void sendCustomerEvent(Customer customer) {
        log.info("Publishing event to topic.");

        try(KafkaProducer<String, CloudEvent> producer = new KafkaProducer<>(configuration.getProducerConfig());){
            CloudEvent cloudEvent = CloudEventBuilder.v1()
                    .withDataContentType("application/json")
                    .withId(UUID.randomUUID().toString())
                    .withType(Customer.class.getName())
                    .withData(PojoCloudEventData.wrap(customer,
                            configuration.objectMapper()::writeValueAsBytes)).build();
            producer.send(new ProducerRecord<>(configuration.getProducerTopic(), cloudEvent));
        }
    }
}
