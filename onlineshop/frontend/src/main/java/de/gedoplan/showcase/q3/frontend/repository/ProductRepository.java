package de.gedoplan.showcase.q3.frontend.repository;

import de.gedoplan.showcase.q3.frontend.model.Product;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProductRepository {
  @Getter
  private List<Product> products;

  @PostConstruct
  void init() {
    products = List.of(
        Product.builder().number(1L).name("Socks").price(BigDecimal.valueOf(9)).build(),
        Product.builder().number(2L).name("Shirt").price(BigDecimal.valueOf(17)).build()
    );
  }

  public Optional<Product> findByNumber(Long number) {
    return products.stream().filter(product -> product.getNumber().equals(number)).findFirst();
  }
}
