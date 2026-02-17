package com.billy.inventory.application.ports.out;

import com.billy.inventory.application.core.domain.Inventory;

public interface UpdateInventoryOutputPort {

    void update(Inventory inventory);
}
