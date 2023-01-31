package com.rentas.rent.web;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.rentas.rent.domain.Item;
import com.rentas.rent.domain.OrderItem;
import com.rentas.rent.domain.RentItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/collect")
@SessionAttributes("orderItem")
public class ItemOrder {

    @ModelAttribute
    public void addItemToModel(Model model) {
    List<RentItem> items = Arrays.asList(
            new RentItem(12, "Hammer", RentItem.Type.TOOLS),
            new RentItem(2, "Traktor", RentItem.Type.BUSINESS),
            new RentItem(13, "Stairs", RentItem.Type.CONSTRUCTION),
            new RentItem(25, "Music center", RentItem.Type.ELECTRONIS),
            new RentItem(22, "Clone", RentItem.Type.EVENTS),
            new RentItem(23, "Cristmas tree", RentItem.Type.GARDEN),
            new RentItem(13, "Table stole", RentItem.Type.HOME)
    );
        RentItem.Type[] types = RentItem.Type.values();
        for (RentItem.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(items, type));
        }
    }

    @ModelAttribute(name = "itemOrder")
    public OrderItem order() {
        return new OrderItem();
    }

    @ModelAttribute(name = "item")
    public Item item() {
        return new Item();
    }

    @GetMapping
    public String showOrderForm() {
        return "order";
    }

    @PostMapping
    public String processTaco(Item item,
                              @ModelAttribute OrderItem itemOrder) {
        itemOrder.addItem(item);
        log.info("Processing item: {}", item);
        return "redirect:/order/current";
    }

    private Iterable<RentItem> filterByType(
            List<RentItem> items, RentItem.Type type) {
        return items
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

}
