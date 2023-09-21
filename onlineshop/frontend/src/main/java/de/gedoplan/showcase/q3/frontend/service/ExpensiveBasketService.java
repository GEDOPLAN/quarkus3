package de.gedoplan.showcase.q3.frontend.service;

import de.gedoplan.showcase.q3.frontend.repository.ProductRepository;
import io.quarkus.arc.properties.IfBuildProperty;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.math.BigDecimal;

@ApplicationScoped
@IfBuildProperty(name = "app.tenant", stringValue = "apple")
public class ExpensiveBasketService implements BasketService {
  @Inject
  ProductRepository productRepository;

  private static final double MULTIPLIER = 1.5;

  @Override
  public BigDecimal calculate(Long articleNumber, Integer amount) {
    return productRepository.findByNumber(articleNumber).orElseThrow().getPrice().multiply(BigDecimal.valueOf(MULTIPLIER));
  }

  @Override
  public String getInfo() {
    return this.getClass().getSimpleName();
  }
}
