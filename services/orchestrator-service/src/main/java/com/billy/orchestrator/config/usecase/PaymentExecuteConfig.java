package com.billy.orchestrator.config.usecase;

import com.billy.orchestrator.adapters.out.SendSaleToTopicAdapter;
import com.billy.orchestrator.application.core.usecase.PaymentExecuteUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentExecuteConfig {

    @Bean
    public PaymentExecuteUseCase paymentExecuteUseCase(SendSaleToTopicAdapter sendSaleToTopicAdapter){
        return  new PaymentExecuteUseCase(sendSaleToTopicAdapter);
    }
}
