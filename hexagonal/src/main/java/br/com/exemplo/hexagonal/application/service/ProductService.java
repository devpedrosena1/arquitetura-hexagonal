package br.com.exemplo.hexagonal.application.service;

import br.com.exemplo.hexagonal.application.ports.inbound.CreateProductUseCase;
import br.com.exemplo.hexagonal.application.ports.inbound.FindProductUseCase;
import br.com.exemplo.hexagonal.application.ports.outbound.ProductRepositoryPort;
import br.com.exemplo.hexagonal.domain.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class ProductService implements CreateProductUseCase, FindProductUseCase {

    private final ProductRepositoryPort repositoryPort;

    public ProductService(ProductRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public Product create(String name, BigDecimal price) {
       Product product = new Product(null, name, price);
       return repositoryPort.save(product);
    }

    @Override
    public Product findById(UUID id) {
        return repositoryPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado " + id));
    }

    @Override
    public List<Product> findAll() {
        return repositoryPort.findAll();
    }
}
