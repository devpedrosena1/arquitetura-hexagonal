package br.com.exemplo.hexagonal.infrastructure.inbound.web;

import br.com.exemplo.hexagonal.application.ports.inbound.CreateProductUseCase;
import br.com.exemplo.hexagonal.application.ports.inbound.FindProductUseCase;
import br.com.exemplo.hexagonal.domain.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final CreateProductUseCase createProductUseCase;
    private final FindProductUseCase findProductUseCase;

    public ProductController(CreateProductUseCase createProductUseCase, FindProductUseCase findProductUseCase) {
        this.createProductUseCase = createProductUseCase;
        this.findProductUseCase = findProductUseCase;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(@RequestBody CreateProductRequest request) {
        Product product = createProductUseCase.create(request.name(), request.price());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ProductResponse(product.getId(), product.getName(), product.getPrice()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable UUID id) {
        Product product = findProductUseCase.findById(id);
        return ResponseEntity.ok(new ProductResponse(product.getId(), product.getName(), product.getPrice()));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll() {
        List<ProductResponse> list = findProductUseCase.findAll().stream()
                .map(p -> new ProductResponse(p.getId(), p.getName(), p.getPrice()))
                .toList();
        return ResponseEntity.ok(list);
    }

}
