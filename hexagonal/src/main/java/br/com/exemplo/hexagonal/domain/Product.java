package br.com.exemplo.hexagonal.domain;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {

    private final UUID id;
    private final String name;
    private final BigDecimal price;

    public Product(UUID id, String name, BigDecimal price) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Nome do produto não pode ser vazio.");
        }
        if (price == null || price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Preço deve ser maior que zero.");
        }
        this.id = id != null ? id : UUID.randomUUID();
        this.name = name;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
