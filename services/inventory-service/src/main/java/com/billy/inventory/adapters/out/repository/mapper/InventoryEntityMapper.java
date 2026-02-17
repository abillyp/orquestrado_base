package com.billy.inventory.adapters.out.repository.mapper;

import com.billy.inventory.adapters.out.repository.entity.InventoryEntity;
import com.billy.inventory.application.core.domain.Inventory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InventoryEntityMapper {

    Inventory toInventory(InventoryEntity inventoryEntity);

    InventoryEntity toInventoryEntity(Inventory inventory);
}
