package com.Swaptem.InventoryManagement.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    public int userId;
    public String username;
    public String password;
    private int currency;

}
