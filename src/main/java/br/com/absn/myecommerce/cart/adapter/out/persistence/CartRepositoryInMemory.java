package br.com.absn.myecommerce.cart.adapter.out.persistence;

import br.com.absn.myecommerce.cart.domain.model.Cart;
import br.com.absn.myecommerce.cart.domain.model.Item;
import br.com.absn.myecommerce.cart.domain.port.out.CartRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Optional;

@Repository
public class CartRepositoryInMemory implements CartRepository {

    private final Map<Long, Cart> cartEntity = new HashMap<>();
    private Long sequence = 1L;

    @Override
    public Cart addItem(Long cartId, Item item) {
            Cart cart = cartEntity.get(cartId);
            if (cart != null) {
                cart.getItems().add(item);
                return cart;
            }
        return null;
    }

    @Override
    public Cart create() {
        Cart cart = new Cart();
        cart.setItems(new LinkedHashSet<>());
        cart.setId(sequence++);
        cartEntity.put(cart.getId(), cart);
        return cart;
    }

    @Override
    public Cart findById(Long cartId) {
        return cartEntity.get(cartId);
    }

    @Override
    public Optional<Item> findItemById(Long cartId, Long itemId) {
        return cartEntity.get(cartId)
                .getItems()
                .stream()
                .filter(item -> item.getId().equals(itemId))
                .findFirst();
    }
}
