package com.billy.inventory.application.ports.in;

import com.billy.inventory.application.core.domain.Sale;

public interface DebitInventoryInputPort {

    void debit(Sale sale);
}
