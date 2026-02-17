package com.billy.orchestrator.application.ports.out;

import com.billy.orchestrator.application.core.domain.Sale;
import com.billy.orchestrator.application.core.domain.enums.SaleEvent;

public interface SendSaleToTopicOutputPort {

    void send(Sale sale, SaleEvent saleEvent, String topic);
}
