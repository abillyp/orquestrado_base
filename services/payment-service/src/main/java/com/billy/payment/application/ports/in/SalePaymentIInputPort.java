package com.billy.payment.application.ports.in;

import com.billy.payment.application.core.domain.Sale;

public interface SalePaymentIInputPort {

    void payment(Sale sale);
}
