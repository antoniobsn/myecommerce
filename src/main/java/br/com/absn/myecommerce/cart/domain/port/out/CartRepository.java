package br.com.absn.myecommerce.cart.domain.port.out;

import br.com.absn.myecommerce.cart.domain.model.Cart;
import br.com.absn.myecommerce.cart.domain.model.Item;

import java.util.Optional;

public interface CartRepository {
    Cart addItem(Long cartId, Item item);

    Cart create();

    Cart findById(Long cartId);

    Optional<Item> findItemById(Long cartId, Long itemId);
}
