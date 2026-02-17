package com.billy.payment.config.usecase;

import com.billy.payment.adapters.out.SavePaymentAdapter;
import com.billy.payment.adapters.out.SendToKafkaAdapter;
import com.billy.payment.adapters.out.UpdateUserAdapter;
import com.billy.payment.application.core.usecase.FindUserByIdUseCase;
import com.billy.payment.application.core.usecase.SalePaymentUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SalePaymentConfig {

    @Bean
    public SalePaymentUseCase salePaymentUseCase(
            FindUserByIdUseCase findUserByIdUseCase,
            UpdateUserAdapter updateUserAdapter,
            SavePaymentAdapter savePaymentAdapter,
            SendToKafkaAdapter sendToKafkaAdapter){
        return new SalePaymentUseCase(findUserByIdUseCase, updateUserAdapter, savePaymentAdapter, sendToKafkaAdapter);
    }
}
