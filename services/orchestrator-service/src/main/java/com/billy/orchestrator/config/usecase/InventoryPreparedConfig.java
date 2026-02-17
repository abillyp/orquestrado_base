package com.billy.orchestrator.config.usecase;

import com.billy.orchestrator.adapters.out.SendSaleToTopicAdapter;
import com.billy.orchestrator.application.core.usecase.InventoryPreparedUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InventoryPreparedConfig {

    @Bean
    public InventoryPreparedUseCase inventoryPreparedUseCase(SendSaleToTopicAdapter sendSaleToTopicAdapter){
        return new InventoryPreparedUseCase(sendSaleToTopicAdapter);
    }
}
