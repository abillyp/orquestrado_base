package com.billy.orchestrator.config.usecase;

import com.billy.orchestrator.adapters.out.SendSaleToTopicAdapter;
import com.billy.orchestrator.application.core.usecase.CreatedSaleUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreatedSaleConfig {

    @Bean
    public CreatedSaleUseCase createdSaleUseCase(SendSaleToTopicAdapter sendSaleToTopicAdapter){
        return new CreatedSaleUseCase(sendSaleToTopicAdapter);
    }
}
