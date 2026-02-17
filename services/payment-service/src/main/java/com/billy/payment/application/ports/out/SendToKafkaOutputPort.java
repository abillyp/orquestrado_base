package com.billy.payment.application.ports.out;

import com.billy.payment.application.core.domain.Sale;
import com.billy.payment.application.core.domain.enums.SaleEvent;

public interface SendToKafkaOutputPort {

    void send(Sale sale, SaleEvent event);
}
