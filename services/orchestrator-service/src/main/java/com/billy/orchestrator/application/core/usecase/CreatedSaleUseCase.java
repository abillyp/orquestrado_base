package com.billy.orchestrator.application.core.usecase;

import com.billy.orchestrator.application.core.domain.Sale;
import com.billy.orchestrator.application.core.domain.enums.SaleEvent;
import com.billy.orchestrator.application.ports.in.WorkFlowInputPort;
import com.billy.orchestrator.application.ports.out.SendSaleToTopicOutputPort;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreatedSaleUseCase implements WorkFlowInputPort {

    private SendSaleToTopicOutputPort sendSaleToTopicOutputPort;

    public CreatedSaleUseCase(SendSaleToTopicOutputPort sendSaleToTopicOutputPort) {
        this.sendSaleToTopicOutputPort = sendSaleToTopicOutputPort;
    }

    @Override
    public void execute(Sale sale) {

        log.info("Inicio da separação do estoque");
        sendSaleToTopicOutputPort.send(sale, SaleEvent.PREPARE_INVENTORY, "tp-saga-inventory");
        log.info("Enviado para fila da separação do estoque");
    }

    @Override
    public boolean isCalledByTheEvent(SaleEvent saleEvent) {
        return SaleEvent.CREATED_SALE.equals(saleEvent);
    }
}
