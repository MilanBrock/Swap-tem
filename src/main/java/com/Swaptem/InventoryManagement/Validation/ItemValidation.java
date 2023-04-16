package com.Swaptem.InventoryManagement.Validation;

import org.springframework.stereotype.Service;

@Service
public class ItemValidation {

    public boolean ItemNameIsValid(String itemName){
        boolean valid = false;
        if(itemName.length() > 0 && itemName.length() < 25){
            valid = true;
        }
        return valid;
    }

    public boolean ItemDescriptionIsValid(String itemDescription){
        boolean valid = false;
        if(itemDescription.length() > 0 && itemDescription.length() < 100){
            valid = true;
        }
        return valid;
    }
}
