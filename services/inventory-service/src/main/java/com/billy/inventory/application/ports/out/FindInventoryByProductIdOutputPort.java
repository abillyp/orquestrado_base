package com.billy.inventory.application.ports.out;

import com.billy.inventory.application.core.domain.Inventory;

import java.util.Optional;

public interface FindInventoryByProductIdOutputPort {

    Optional<Inventory> find(final Integer productId);
}
