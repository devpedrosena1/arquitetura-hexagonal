package br.com.exemplo.hexagonal.application.ports.inbound;

import br.com.exemplo.hexagonal.domain.Product;

import java.math.BigDecimal;

public interface CreateProductUseCase {

    Product create(String name, BigDecimal price);

}
