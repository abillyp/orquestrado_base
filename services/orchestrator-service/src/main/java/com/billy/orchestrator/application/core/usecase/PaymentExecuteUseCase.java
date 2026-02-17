package com.billy.orchestrator.application.core.usecase;

import com.billy.orchestrator.application.core.domain.Sale;
import com.billy.orchestrator.application.core.domain.enums.SaleEvent;
import com.billy.orchestrator.application.ports.in.WorkFlowInputPort;
import com.billy.orchestrator.application.ports.out.SendSaleToTopicOutputPort;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PaymentExecuteUseCase implements WorkFlowInputPort {

    private SendSaleToTopicOutputPort sendSaleToTopicOutputPort;

    public PaymentExecuteUseCase(SendSaleToTopicOutputPort sendSaleToTopicOutputPort) {
        this.sendSaleToTopicOutputPort = sendSaleToTopicOutputPort;
    }

    @Override
    public void execute(Sale sale) {
        log.info("Finalizado a venda");
        sendSaleToTopicOutputPort.send(sale, SaleEvent.FINALIZE_SALE, "tp-saga-sale");
        log.info("Finalizaçao da venda enviado para fila");

    }

    @Override
    public boolean isCalledByTheEvent(SaleEvent saleEvent) {
        return SaleEvent.PAYMENT_EXECUTED.equals(saleEvent);
    }
}
