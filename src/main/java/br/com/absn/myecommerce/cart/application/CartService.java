package br.com.absn.myecommerce.cart.application;

import br.com.absn.myecommerce.cart.domain.model.Cart;
import br.com.absn.myecommerce.cart.domain.model.Item;
import br.com.absn.myecommerce.cart.domain.port.in.CartUseCase;
import br.com.absn.myecommerce.cart.domain.port.out.CartRepository;
import br.com.absn.myecommerce.cart.domain.port.out.CartStorage;
import br.com.absn.myecommerce.cart.domain.port.out.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService implements CartUseCase {

    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;
    private final CartStorage cartStorage;

    public CartService(CartRepository cartRepository, ItemRepository itemRepository, CartStorage cartStorage) {
        this.cartRepository = cartRepository;
        this.itemRepository = itemRepository;
        this.cartStorage = cartStorage;
    }

    @Override
    public Cart create() {
        return cartRepository.create();
    }

    @Override
    public Cart addItem(Long cartId, Long itemId) {
        Item item = itemRepository.findById(itemId);
        Optional<Item> itemAlreadyAdded = cartRepository.findItemById(cartId, itemId);
        itemAlreadyAdded.ifPresent(i -> {
            throw new RuntimeException("Item already added to cart");
        });
        return cartRepository.addItem(cartId, item);
    }

    @Override
    public List<Item> findAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public void exportCartToJsonFile(Long cartId) {
        Cart cart = cartRepository.findById(cartId);
        cartStorage.write(cart);
    }
}
