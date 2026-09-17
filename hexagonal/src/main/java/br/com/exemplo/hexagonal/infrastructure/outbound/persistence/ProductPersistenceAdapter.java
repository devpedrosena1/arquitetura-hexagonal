package br.com.exemplo.hexagonal.infrastructure.outbound.persistence;

import br.com.exemplo.hexagonal.application.ports.outbound.ProductRepositoryPort;
import br.com.exemplo.hexagonal.domain.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class ProductPersistenceAdapter implements ProductRepositoryPort {

    private final SpringDataProductRepository repository;

    public ProductPersistenceAdapter(SpringDataProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product save(Product product) {
        ProductJpaEntity entity = new ProductJpaEntity(product.getId(), product.getName(), product.getPrice());
        ProductJpaEntity saved = repository.save(entity);
        return new Product(saved.getId(), saved.getName(), saved.getPrice());
    }

    @Override
    public Optional<Product> findById(UUID id) {
        return repository.findById(id)
                .map(entity -> new Product(entity.getId(), entity.getName(), entity.getPrice()));
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream()
                .map(entity -> new Product(entity.getId(), entity.getName(), entity.getPrice()))
                .toList();
    }
}
