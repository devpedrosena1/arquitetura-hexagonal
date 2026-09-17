package br.com.exemplo.hexagonal.application.ports.inbound;

import br.com.exemplo.hexagonal.domain.Product;

import java.util.List;
import java.util.UUID;

public interface FindProductUseCase {

    Product findById(UUID id);
    List<Product> findAll();

}
