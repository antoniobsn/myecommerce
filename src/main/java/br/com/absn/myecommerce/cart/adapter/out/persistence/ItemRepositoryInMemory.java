package br.com.absn.myecommerce.cart.adapter.out.persistence;

import br.com.absn.myecommerce.cart.domain.model.Item;
import br.com.absn.myecommerce.cart.domain.port.out.ItemRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepositoryInMemory implements ItemRepository {

    private final Map<Long, Item> itemEntity = new HashMap<>();

    private Long sequence = 1L;

    public ItemRepositoryInMemory() {
        Item item1 = new Item("VANS", "Sapatilhas em nobuck","Old skool",95.0);
        item1.setId(sequence++);
        itemEntity.put(item1.getId(), item1);

        Item item2 = new Item("VANS", "Sapatilhas subidas em nobuck","SK8-Hi",110.0);
        item2.setId(sequence++);
        itemEntity.put(item2.getId(), item2);

        Item item3 = new Item("VANS", "Sapatilhas em couro","Old Skool",90.0);
        item3.setId(sequence++);
        itemEntity.put(item3.getId(), item3);

        Item item4 = new Item("VANS", "Sapatilhas com plataforma","Old Skool Stackform",10.0);
        item4.setId(sequence++);
        itemEntity.put(item4.getId(), item4);

        Item item5 = new Item("VANS", "Sapatilhas em couro","Knu Skool",100.0);
        item5.setId(sequence++);
        itemEntity.put(item5.getId(), item5);
    }

    @Override
    public Item findById(Long itemId) {
        return itemEntity.get(itemId);
    }

    @Override
    public List<Item> findAll() {
        return itemEntity.values().stream().toList();
    }
}
