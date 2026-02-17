package com.billy.payment.adapters.out.repository.mapper;

import com.billy.payment.adapters.out.repository.entity.PaymentEntity;
import com.billy.payment.application.core.domain.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentEntityMapper {

    PaymentEntity toPaymentEntity(Payment payment);
}
