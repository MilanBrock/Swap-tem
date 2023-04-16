package com.Swaptem.InventoryManagement.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int UserId;
    private String username;
    private String password;
    private int currency;


    public User (String usernameInput, String passwordInput, int currencyInput){
        this.username = usernameInput;
        this.password = passwordInput;
        this.currency = currencyInput;
    }
}
