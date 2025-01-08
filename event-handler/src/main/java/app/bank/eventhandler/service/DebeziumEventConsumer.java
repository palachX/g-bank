package app.bank.eventhandler.service;

import app.bank.eventhandler.handler.EventHandler;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class DebeziumEventConsumer implements CDCEventConsumer {

    private final Map<String, EventHandler> eventHandlers;

    @Override
    @KafkaListener(topics = "events")
    public void process(String payload, Acknowledgment acknowledgment) {
        try {
            log.info("Received message: {}", payload);
            JsonObject json = JsonParser.parseString(payload)
                    .getAsJsonObject()
                    .get("payload")
                    .getAsJsonObject();

            String type = json.get("type")
                    .getAsString();

            eventHandlers.get(type)
                    .handle(json, acknowledgment);
        } catch (Exception e) {
            log.error("Error message: {}", e.getMessage());
            e.printStackTrace();
        }
    }
}
