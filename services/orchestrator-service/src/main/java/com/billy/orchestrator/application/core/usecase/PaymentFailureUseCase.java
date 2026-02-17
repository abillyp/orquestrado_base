package com.billy.orchestrator.application.core.usecase;

import com.billy.orchestrator.application.core.domain.Sale;
import com.billy.orchestrator.application.core.domain.enums.SaleEvent;
import com.billy.orchestrator.application.ports.in.WorkFlowInputPort;
import com.billy.orchestrator.application.ports.out.SendSaleToTopicOutputPort;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PaymentFailureUseCase implements WorkFlowInputPort {

    private SendSaleToTopicOutputPort sendSaleToTopicOutputPort;

    public PaymentFailureUseCase(SendSaleToTopicOutputPort sendSaleToTopicOutputPort) {
        this.sendSaleToTopicOutputPort = sendSaleToTopicOutputPort;
    }

    @Override
    public void execute(Sale sale) {
        log.info("Erro no pagamento");
        sendSaleToTopicOutputPort.send(sale, SaleEvent.EXECUTE_ROLLBACK, "tp-saga-inventory");
        sendSaleToTopicOutputPort.send(sale, SaleEvent.CANCEL_SALE, "tp-saga-sale");
        log.info("Rollback do estoque e cancelamento da venda postados na fila");

    }

    @Override
    public boolean isCalledByTheEvent(SaleEvent saleEvent) {
        return SaleEvent.PAYMENT_FAILED.equals(saleEvent);
    }
}
