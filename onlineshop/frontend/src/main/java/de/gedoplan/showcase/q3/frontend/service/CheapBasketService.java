package de.gedoplan.showcase.q3.frontend.service;

import de.gedoplan.showcase.q3.frontend.repository.ProductRepository;
import io.quarkus.arc.properties.IfBuildProperty;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.math.BigDecimal;

@ApplicationScoped
@IfBuildProperty(name = "app.tenant", stringValue = "pear")
public class CheapBasketService implements BasketService {
  @Inject
  ProductRepository productRepository;

  private static final double MULTIPLIER = 0.8;

  @Override
  public BigDecimal calculate(Long articleNumber, Integer amount) {
    return productRepository.findByNumber(articleNumber).orElseThrow().getPrice().multiply(BigDecimal.valueOf(MULTIPLIER));
  }

  @Override
  public String getInfo() {
    return this.getClass().getSimpleName();
  }
}
