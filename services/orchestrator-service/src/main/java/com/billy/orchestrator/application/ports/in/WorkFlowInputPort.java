package com.billy.orchestrator.application.ports.in;

import com.billy.orchestrator.application.core.domain.Sale;
import com.billy.orchestrator.application.core.domain.enums.SaleEvent;

public interface WorkFlowInputPort {

    void execute(Sale sale);

    boolean isCalledByTheEvent(SaleEvent saleEvent);
}
