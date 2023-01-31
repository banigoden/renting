package com.rentas.rent.domain;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Date placedAt;
    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;
    private List<Item> equipments = new ArrayList<>();

    public void addItem(Item item){
        equipments.add(item);
    }
}
