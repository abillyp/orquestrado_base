package com.billy.orchestrator.application.core.usecase;

import com.billy.orchestrator.application.core.domain.Sale;
import com.billy.orchestrator.application.core.domain.enums.SaleEvent;
import com.billy.orchestrator.application.ports.in.WorkFlowInputPort;
import com.billy.orchestrator.application.ports.out.SendSaleToTopicOutputPort;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InventoryFailureUseCase implements WorkFlowInputPort {

    private SendSaleToTopicOutputPort sendSaleToTopicOutputPort;

    public InventoryFailureUseCase(SendSaleToTopicOutputPort sendSaleToTopicOutputPort) {
        this.sendSaleToTopicOutputPort = sendSaleToTopicOutputPort;
    }

    @Override
    public void execute(Sale sale) {
        log.info("Erro ao debitar estoque");
        sendSaleToTopicOutputPort.send(sale, SaleEvent.CANCEL_SALE, "tp-saga-sale");
        log.info("Cancelamento da venda postados na fila");

    }

    @Override
    public boolean isCalledByTheEvent(SaleEvent saleEvent) {
        return SaleEvent.INVENTORY_ERROR.equals(saleEvent);
    }
}
