package com.billy.payment.config.kafka;

import com.billy.payment.adapters.out.message.SaleMessage;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import tools.jackson.databind.ObjectMapper;

public class CustomDeserializer implements Deserializer<SaleMessage> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public SaleMessage deserialize(String topic, byte[] data) {
        try {
            if (data == null){
                return null;
            }
            return objectMapper.readValue(new String(data, "UTF-8"), SaleMessage.class);
        } catch (Exception e) {
            throw new SerializationException("Error when deserializing byte[] to SaleMessage");
        }
    }

}