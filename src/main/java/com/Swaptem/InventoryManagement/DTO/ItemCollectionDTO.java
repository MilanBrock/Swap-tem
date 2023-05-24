package com.Swaptem.InventoryManagement.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemCollectionDTO {
    public int [] itemIds;
    public ItemDTO[] items;
}
