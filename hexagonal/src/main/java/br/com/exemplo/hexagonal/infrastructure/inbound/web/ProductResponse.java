package br.com.exemplo.hexagonal.infrastructure.inbound.web;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductResponse(UUID id, String name, BigDecimal price) {
}
