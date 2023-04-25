package com.Swaptem.InventoryManagement.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String username;
    private String password;
    private int currency;
    private boolean active;


    public User (String usernameInput, String passwordInput, int currencyInput){
        this.username = usernameInput;
        this.password = passwordInput;
        this.currency = currencyInput;
    }

    public User (int userIdInput, String usernameInput, String passwordInput, int currencyInput){
        this.userId = userIdInput;
        this.username = usernameInput;
        this.password = passwordInput;
        this.currency = currencyInput;
    }

    public User (String usernameInput, String passwordInput, int currencyInput, boolean activeInput){
        this.username = usernameInput;
        this.password = passwordInput;
        this.currency = currencyInput;
        this.active = activeInput;
    }


}
