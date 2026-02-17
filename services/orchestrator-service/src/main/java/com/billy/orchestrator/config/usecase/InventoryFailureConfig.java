package com.billy.orchestrator.config.usecase;

import com.billy.orchestrator.adapters.out.SendSaleToTopicAdapter;
import com.billy.orchestrator.application.core.usecase.InventoryFailureUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InventoryFailureConfig {

    @Bean
    public InventoryFailureUseCase inventoryFailureUseCase(SendSaleToTopicAdapter sendSaleToTopicAdapter){
        return new InventoryFailureUseCase(sendSaleToTopicAdapter);
    }
}
