package br.com.exemplo.hexagonal.infrastructure.config;

import br.com.exemplo.hexagonal.application.ports.outbound.ProductRepositoryPort;
import br.com.exemplo.hexagonal.application.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ProductService productService(ProductRepositoryPort repositoryPort) {
        return new ProductService(repositoryPort);
    }

}
