package com.billy.payment.application.ports.out;

import com.billy.payment.application.core.domain.Payment;

public interface SavePaymentOutputPort {

    void save(Payment payment);
}
