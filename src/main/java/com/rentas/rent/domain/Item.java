package com.rentas.rent.domain;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class Item {
    private Long id;
    private Date createdAt = new Date();
    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    private String name;
    private String category;
    private String description;
    private String imageUrl;
    private double pricePerDay;
    private List<Item> items;
}
