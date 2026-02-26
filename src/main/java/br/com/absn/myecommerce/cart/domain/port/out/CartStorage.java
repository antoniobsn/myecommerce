package br.com.absn.myecommerce.cart.domain.port.out;

import br.com.absn.myecommerce.cart.domain.model.Cart;

public interface CartStorage {
    void write(Cart cart);
}
