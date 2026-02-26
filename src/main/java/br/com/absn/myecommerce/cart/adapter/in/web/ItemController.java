package br.com.absn.myecommerce.cart.adapter.in.web;

import br.com.absn.myecommerce.cart.domain.model.Item;
import br.com.absn.myecommerce.cart.domain.port.in.CartUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final CartUseCase cartUseCase;

    public ItemController(CartUseCase cartUseCase) {
        this.cartUseCase = cartUseCase;
    }

    @GetMapping
    public ResponseEntity<List<Item>> findAllItems() {
        return ResponseEntity.ok(cartUseCase.findAllItems());
    }
}
