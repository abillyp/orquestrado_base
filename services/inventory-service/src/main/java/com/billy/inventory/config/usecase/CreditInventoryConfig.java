package com.billy.inventory.config.usecase;

import com.billy.inventory.adapters.out.UpdateInventoryAdapter;
import com.billy.inventory.application.core.usecase.CreditInventoryUseCase;
import com.billy.inventory.application.core.usecase.FindInventoryByProductIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreditInventoryConfig {

    @Bean
    public CreditInventoryUseCase creditInventoryUseCase(
            FindInventoryByProductIdUseCase findInventoryByProductIdUseCase,
            UpdateInventoryAdapter updateInventoryAdapter){
        return new CreditInventoryUseCase(findInventoryByProductIdUseCase, updateInventoryAdapter);

    }
}
