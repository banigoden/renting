package com.rentas.rent.domain;

import lombok.Data;

@Data
public class RentItem {
    private final int id;
    private final String name;
    private final Type type;

    public enum Type{
        TOOLS, ELECTRONIS, MOTORS, BUSINESS, SPORTS, HOME, GARDEN, PARTY, EVENTS, CONSTRUCTION
    }
}
