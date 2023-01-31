package com.rentas.rent.service;
import java.util.HashMap;
import java.util.Map;

import com.rentas.rent.domain.RentItem;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ItemByIdConverter implements Converter<String, RentItem>{
    private Map<String, RentItem> itemMap = new HashMap<>();

    public ItemByIdConverter() {
        itemMap.put("Hammer", new RentItem(12, "Hammer", RentItem.Type.TOOLS));
        itemMap.put("Traktor", new RentItem(2, "Traktor", RentItem.Type.BUSINESS));
        itemMap.put("Stairs", new RentItem(13, "Stairs", RentItem.Type.CONSTRUCTION));
        itemMap.put("Music center", new RentItem(25, "Music center", RentItem.Type.ELECTRONIS));
        itemMap.put("Clone", new RentItem(22, "Clone", RentItem.Type.EVENTS));
        itemMap.put("Cristmas tree", new RentItem(23, "Cristmas tree", RentItem.Type.GARDEN));
        itemMap.put("Table stole", new RentItem(13, "Table stole", RentItem.Type.HOME));
    }
    @Override
    public RentItem convert(String id) {
        return itemMap.get(id);
    }
}
