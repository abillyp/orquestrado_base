package com.billy.orchestrator.adapters.out.message;

import com.billy.orchestrator.application.core.domain.Sale;
import com.billy.orchestrator.application.core.domain.enums.SaleEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleMessage {

    private Sale sale;

    private SaleEvent event;

}
