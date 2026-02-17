package com.billy.payment.adapters.in.consumer;

import com.billy.payment.adapters.out.message.SaleMessage;
import com.billy.payment.application.core.domain.enums.SaleEvent;
import com.billy.payment.application.ports.in.SalePaymentIInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReceiverSaleToPaymentConsumer {

    @Autowired
    private SalePaymentIInputPort salePaymentIInputPort;

    @KafkaListener(topics = "tp-saga-payment", groupId = "payment")
    public void receive(SaleMessage saleMessage){
        try {
            if (SaleEvent.EXECUTE_PAYMENT.equals(saleMessage.getEvent())) {
                log.info(("Inicio do Pagamento"));
                salePaymentIInputPort.payment((saleMessage.getSale()));
                log.info(("Fim do Pagamento"));
            }
        }catch (Exception e){
            log.error("Exceção ao ler do kafka : {}", e.getMessage());
        }

    }
}
