package com.Swaptem.InventoryManagement.Validation;

import org.springframework.stereotype.Service;

@Service
public class UserValidation {


    public boolean UsernameIsValid(String username){
        boolean valid = false;
        if(username.length() > 0 && username.length() < 25){
            valid = true;
        }
        return valid;
    }

    public boolean UserPasswordIsValid(String password){
        boolean valid = false;
        if(password.length() > 0 && password.length() < 25){
            valid = true;
        }
        return valid;
    }

    public boolean UserCurrencyIsValid(int currency){
        boolean valid = false;
        if (currency > 0){
            valid = true;
        }
        return valid;
    }
}
