package br.com.exemplo.hexagonal.infrastructure.inbound.web;

import java.math.BigDecimal;

public record CreateProductRequest(String name, BigDecimal price) {
}
