package br.com.absn.myecommerce.cart.domain.model;

import java.util.LinkedHashSet;
import java.util.List;

public class Cart {

    private Long id;
    private LinkedHashSet<Item> items;

    public Cart() {}

    private double calculateTotalPrice() {
        double total = 0.0;
        if (items != null) {
            for (Item item : items) {
                total += item.getPrice();
            }
        }
        return total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LinkedHashSet<Item> getItems() {
        return items;
    }

    public void setItems(LinkedHashSet<Item> items) {
        this.items = items;
    }

    public double getTotalPrice() {
        return calculateTotalPrice();
    }
}
