package com.Swaptem.InventoryManagement.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "userID")
    private User owner;
    private boolean active;


    public Item(String nameInput, String descriptionInput){
        this.name = nameInput;
        this.description = descriptionInput;
    }

    public Item(int idInput, String nameInput, String descriptionInput){
        this.itemId = idInput;
        this.name = nameInput;
        this.description = descriptionInput;
    }

    public Item(int idInput, String nameInput, String descriptionInput, boolean activeInput){
        this.itemId = idInput;
        this.name = nameInput;
        this.description = descriptionInput;
        this.active = activeInput;
    }

}
