package com.billy.inventory.application.ports.out;

import com.billy.inventory.application.core.domain.Sale;
import com.billy.inventory.application.core.domain.enums.SaleEvent;

public interface SendToKafkaOutputPort {

    void send(Sale sale, SaleEvent event);
}
