package com.billy.inventory.application.ports.in;

import com.billy.inventory.application.core.domain.Inventory;

public interface FindInventoryByProductIdInputPort {

    Inventory find(Integer productId);
}
