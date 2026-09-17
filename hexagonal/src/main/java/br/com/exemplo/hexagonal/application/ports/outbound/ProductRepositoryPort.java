package br.com.exemplo.hexagonal.application.ports.outbound;

import br.com.exemplo.hexagonal.domain.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepositoryPort {

    Product save(Product product);
    Optional<Product> findById(UUID id);
    List<Product> findAll();

}
