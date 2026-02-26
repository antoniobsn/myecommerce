package br.com.absn.myecommerce.cart.adapter.out.file;

import br.com.absn.myecommerce.cart.domain.model.Cart;
import br.com.absn.myecommerce.cart.domain.port.out.CartStorage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class CartStorageFile implements CartStorage {

    private final ObjectMapper objectMapper;

    @Value("${FILES_PATH:/app/files}")
    private String filesPath;

    public CartStorageFile(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void write(Cart cart) {
        try {

            Path directory = Paths.get(filesPath);
            Files.createDirectories(directory);

            Path filePath = directory.resolve(
                    "cart-" + cart.getId() + ".json"
            );

            objectMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValue(filePath.toFile(), cart);

        } catch (IOException e) {
            throw new RuntimeException("Erro ao escrever arquivo JSON", e);
        }
    }
}

