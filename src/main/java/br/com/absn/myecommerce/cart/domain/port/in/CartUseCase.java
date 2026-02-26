package br.com.absn.myecommerce.cart.domain.port.in;

import br.com.absn.myecommerce.cart.domain.model.Cart;
import br.com.absn.myecommerce.cart.domain.model.Item;

import java.util.List;


public interface CartUseCase {

    Cart create();
    Cart addItem(Long cartId, Long itemId);

    List<Item> findAllItems();

    void exportCartToJsonFile(Long cartId);
}
