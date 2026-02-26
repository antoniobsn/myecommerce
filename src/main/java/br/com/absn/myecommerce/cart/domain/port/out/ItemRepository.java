package br.com.absn.myecommerce.cart.domain.port.out;

import br.com.absn.myecommerce.cart.domain.model.Item;

import java.util.List;

public interface ItemRepository {
    Item findById(Long itemId);

    List<Item> findAll();
}
