package com.billy.inventory.adapters.out;

import com.billy.inventory.adapters.out.repository.InventoryRepository;
import com.billy.inventory.adapters.out.repository.mapper.InventoryEntityMapper;
import com.billy.inventory.application.core.domain.Inventory;
import com.billy.inventory.application.ports.out.FindInventoryByProductIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindInventoryByProductIdAdapter implements FindInventoryByProductIdOutputPort {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private InventoryEntityMapper inventoryEntityMapper;

    @Override
    public Optional<Inventory> find(Integer productId) {
        var invetoryEntity = inventoryRepository.findByProductId(productId);
        return invetoryEntity.map(inventoryEntityMapper::toInventory);
    }
}
