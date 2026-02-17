package com.billy.inventory.application.ports.in;

import com.billy.inventory.application.core.domain.Sale;

public interface CreditInventoryInputPort {

    void credit(Sale sale);
}
