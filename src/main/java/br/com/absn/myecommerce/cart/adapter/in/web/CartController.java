package br.com.absn.myecommerce.cart.adapter.in.web;

import br.com.absn.myecommerce.cart.domain.model.Cart;
import br.com.absn.myecommerce.cart.domain.port.in.CartUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carts")
public class CartController {
    private final CartUseCase cartUseCase;

    public CartController(CartUseCase cartUseCase) {
        this.cartUseCase = cartUseCase;
    }


    @PostMapping
    public ResponseEntity<Cart> createCart() {
        Cart Cart = cartUseCase.create();
        return ResponseEntity.ok(Cart);
    }

    @PostMapping("/{cartId}/add/item")
    public ResponseEntity<Cart> addItemToCart(@PathVariable Long cartId, @RequestBody Long itemId) {
        Cart Cart = cartUseCase.addItem(cartId, itemId);
        return ResponseEntity.ok(Cart);
    }

    @PostMapping("/{cartId}/export/file/json")
    public ResponseEntity exportCartToJsonFile(@PathVariable Long cartId) {
        cartUseCase.exportCartToJsonFile(cartId);
        return ResponseEntity.ok().build();
    }

}
