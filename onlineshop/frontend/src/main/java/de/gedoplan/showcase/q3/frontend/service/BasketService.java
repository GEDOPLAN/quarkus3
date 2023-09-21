package de.gedoplan.showcase.q3.frontend.service;

import java.math.BigDecimal;

public interface BasketService {
  public BigDecimal calculate(Long articleNumber, Integer amount);
  public String getInfo();
}
